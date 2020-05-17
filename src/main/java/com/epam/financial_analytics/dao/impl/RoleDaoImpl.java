package com.epam.financial_analytics.dao.impl;

import com.epam.financial_analytics.connection.ConnectionPool;
import com.epam.financial_analytics.dao.BaseDao;
import com.epam.financial_analytics.entity.dictionary.Role;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoleDaoImpl implements BaseDao<Role> {
    private ConnectionPool connectionPool;
    private Connection connection;
    private static final Logger LOGGER = Logger.getLogger(RoleDaoImpl.class);

    private static final String ADD_ROLE = "INSERT INTO ROLE (NAME, ID) VALUES (?,?)";
    private static final String GET_ALL = "SELECT * FROM ROLE";
    private static final String GET_BY_NAME = "SELECT ID, NAME FROM ROLE WHERE NAME=?";
    private static final String UPDATE_ROLE = "UPDATE ROLE SET NAME = ? WHERE ID = ?";
    private static final String DELETE_ROLE ="DELETE FROM ROLE WHERE ID = ?";

    @Override
    public List<Role> getAll(){
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        List<Role> roleList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL);
             ResultSet resultSet = preparedStatement.executeQuery()){
            while (resultSet.next()) {
                Role role = new Role();
                role.setId(resultSet.getLong("ID"));
                role.setName(resultSet.getString("NAME"));

                roleList.add(role);
            }
        } catch (SQLException e) {
            LOGGER.error("SQLException in RoleDaoImpl getAll", e);
        } finally {
            connectionPool.returnConnection(connection);
        }
        return roleList;
    }

    @Override
    public Role getByName(String name){
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        Role role = new Role();

        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_NAME)){
            preparedStatement.setString(1, name);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    role.setId(resultSet.getLong("ID"));
                    role.setName(resultSet.getString("NAME"));
                }
            }
        } catch (SQLException e) {
            LOGGER.error("SQLException in RoleDaoImpl getById", e);
        } finally {
            connectionPool.returnConnection(connection);
        }
        return role;
    }

    @Override
    public void create(Role role){
        updateOrCreate(role, ADD_ROLE);
    }

    @Override
    public void update(Role role){
        updateOrCreate(role, UPDATE_ROLE);
    }

    @Override
    public void delete(Role role){
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        try(PreparedStatement preparedStatement = connection.prepareStatement(DELETE_ROLE)){
            preparedStatement.setLong(1, role.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("SQLException in RoleDaoImpl delete", e);
        } finally {
            connectionPool.returnConnection(connection);
        }
    }

    @Override
    public void updateOrCreate(Role role, String sql){
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, role.getName());
            preparedStatement.setLong(2, role.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("SQLException in RoleDaoImpl updateOrCreate", e);
        } finally {
            connectionPool.returnConnection(connection);
        }
    }
}
