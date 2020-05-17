package com.epam.financial_analytics.dao.impl;

import com.epam.financial_analytics.connection.ConnectionPool;
import com.epam.financial_analytics.dao.BaseDao;
import com.epam.financial_analytics.dao.UserDao;
import com.epam.financial_analytics.entity.dictionary.Role;
import com.epam.financial_analytics.entity.dictionary.User;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao<User> {
    private ConnectionPool connectionPool;
    private Connection connection;
    private static final Logger LOGGER = Logger.getLogger(UserDaoImpl.class);

    private static final String ADD_USER = "INSERT INTO USER (NAME, LOGIN, PASSWORD, EMAIL, ROLE_ID, ID) " +
            "VALUES (?,?,?,?,?,?)";
    private static final String GET_ALL = "SELECT * FROM USER AS U INNER JOIN ROLE AS R ON U.ROLE_ID=R.ID";
    private static final String GET_BY_NAME = "SELECT * FROM USER AS U INNER JOIN ROLE AS R ON U.ROLE_ID=R.ID WHERE U.NAME=?";
    private static final String UPDATE_USER = "UPDATE USER SET NAME = ?, LOGIN = ?, PASSWORD = ?, EMAIL = ?, ROLE_ID = ? WHERE ID = ?";
    private static final String DELETE_USER ="DELETE FROM USER WHERE ID = ?";
    private static final String GET_BY_LOGIN = "SELECT * FROM USER AS U INNER JOIN ROLE AS R ON U.ROLE_ID=R.ID WHERE LOGIN =?";
    private static final String GET_BY_LOGIN_AND_PASSWORD = "SELECT * FROM USER AS U INNER JOIN ROLE AS R ON U.ROLE_ID=R.ID WHERE LOGIN =? AND PASSWORD=?";

    @Override
    public List<User> getAll(){
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        List<User> userList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL);
             ResultSet resultSet = preparedStatement.executeQuery()){
            while (resultSet.next()){
                User user = new User();
                user.setId(resultSet.getInt("ID"));
                user.setName(resultSet.getString("NAME"));
                user.setLogin(resultSet.getNString("LOGIN"));
                user.setPassword(resultSet.getNString("PASSWORD"));
                user.setEMail(resultSet.getString("EMAIL"));
                user.setRole(new Role(resultSet.getLong("ROLE_ID"), resultSet.getString("R.NAME")));

                userList.add(user);
            }

        } catch (SQLException e) {
            LOGGER.error("SQLException in UserDaoImpl getAll", e);
        } finally {
            connectionPool.returnConnection(connection);
        }
        return userList;
    }

    @Override
    public User getByName(String name){
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        User user = new User();
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_NAME)){

            preparedStatement.setString(1, name);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    user.setId(resultSet.getInt("ID"));
                    user.setName(resultSet.getString("NAME"));
                    user.setLogin(resultSet.getString("LOGIN"));
                    user.setPassword(resultSet.getString("PASSWORD"));
                    user.setEMail(resultSet.getString("EMAIL"));
                    user.setRole(new Role(resultSet.getLong("ROLE_ID"), resultSet.getString("R.NAME")));
                }
            }
        } catch (SQLException e) {
            LOGGER.error("SQLException in UserDaoImpl getAll", e);
        } finally {
            connectionPool.returnConnection(connection);
        }
        return user;
    }

    @Override
    public void create(User user){
        updateOrCreate(user, ADD_USER);
    }

    @Override
    public void update(User user){
        updateOrCreate(user, UPDATE_USER);
    }

    @Override
    public void delete(User user){
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        try(PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USER)){
            preparedStatement.setLong(1, user.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("SQLException in UserDaoImpl delete", e);
        } finally {
            connectionPool.returnConnection(connection);
        }
    }

    @Override
    public void updateOrCreate(User user, String sql){
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getLogin());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, user.getEMail());
            preparedStatement.setLong(5, user.getRole().getId());
            preparedStatement.setLong(6, user.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("SQLException in UserDaoImpl updateOrCreate", e);
        } finally {
            connectionPool.returnConnection(connection);
        }
    }

    @Override
    public User getByLoginAndPassword(String login, String password) {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        User user = new User();
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_LOGIN_AND_PASSWORD)){

            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    user.setId(resultSet.getLong("ID"));
                    user.setName(resultSet.getString("NAME"));
                    user.setLogin(resultSet.getString("LOGIN"));
                    user.setPassword(resultSet.getString("PASSWORD"));
                    user.setEMail(resultSet.getString("EMAIL"));
                    user.setRole(new Role(resultSet.getLong("ROLE_ID"), resultSet.getString("R.NAME")));
                }
            }
        } catch (SQLException e) {
            LOGGER.error("SQLException in UserDaoImpl getAll", e);
        } finally {
            connectionPool.returnConnection(connection);
        }
        return user;
    }

    @Override
    public User getByLogin(String login) {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        User user = new User();
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_LOGIN)){

            preparedStatement.setString(1, login);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    user.setId(resultSet.getLong("ID"));
                    user.setName(resultSet.getString("NAME"));
                    user.setLogin(resultSet.getString("LOGIN"));
                    user.setPassword(resultSet.getString("PASSWORD"));
                    user.setEMail(resultSet.getString("EMAIL"));
                    user.setRole(new Role(resultSet.getLong("ROLE_ID"), resultSet.getString("R.NAME")));
                }
            }
        } catch (SQLException e) {
            LOGGER.error("SQLException in UserDaoImpl getAll", e);
        } finally {
            connectionPool.returnConnection(connection);
        }
        return user;
    }
}
