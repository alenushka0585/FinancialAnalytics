package com.epam.financial_analytics.dao.impl;

import com.epam.financial_analytics.connection.ConnectionPool;
import com.epam.financial_analytics.dao.BaseDao;
import com.epam.financial_analytics.entity.dictionary.Language;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LanguageDaoImpl implements BaseDao<Language> {
    private ConnectionPool connectionPool;
    private Connection connection;
    private static final Logger LOGGER = Logger.getLogger(LanguageDaoImpl.class);

    private static final String ADD_LANGUAGE = "INSERT INTO LANGUAGE (NAME, ID) VALUES (?,?)";
    private static final String GET_ALL = "SELECT * FROM LANGUAGE";
    private static final String GET_BY_NAME = "SELECT ID, NAME FROM LANGUAGE WHERE NAME=?";
    private static final String UPDATE_LANGUAGE = "UPDATE LANGUAGE SET NAME = ? WHERE ID = ?";
    private static final String DELETE_LANGUAGE ="DELETE FROM LANGUAGE WHERE ID = ?";

    @Override
    public List<Language> getAll(){
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        List<Language> languageList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL);
             ResultSet resultSet = preparedStatement.executeQuery()){
            while (resultSet.next()) {
                Language language = new Language();
                language.setId(resultSet.getInt("ID"));
                language.setName(resultSet.getString("NAME"));

                languageList.add(language);
            }
        } catch (SQLException e) {
            LOGGER.error("SQLException in LanguageDaoImpl getAll", e);
        } finally {
            connectionPool.returnConnection(connection);
        }
        return languageList;
    }

    @Override
    public Language getByName(String name){
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        Language language = new Language();

        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_NAME)){
            preparedStatement.setString(1, name);
            try(ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    language.setId(resultSet.getLong("ID"));
                    language.setName(resultSet.getString("NAME"));
                }
            }
        } catch (SQLException e) {
            LOGGER.error("SQLException in LanguageDaoImpl getById", e);
        } finally {
            connectionPool.returnConnection(connection);
        }
        return language;
    }

    @Override
    public void create(Language language){
        updateOrCreate(language, ADD_LANGUAGE);
    }

    @Override
    public void update(Language language){
        updateOrCreate(language, UPDATE_LANGUAGE);
    }

    @Override
    public void delete(Language language){
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        try(PreparedStatement preparedStatement = connection.prepareStatement(DELETE_LANGUAGE)){
            preparedStatement.setLong(1, language.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("SQLException in LanguageDaoImpl delete", e);
        } finally {
            connectionPool.returnConnection(connection);
        }
    }

    @Override
    public void updateOrCreate(Language language, String sql){
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, language.getName());
            preparedStatement.setLong(2, language.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("SQLException in LanguageDaoImpl updateOrCreate", e);
        } finally {
            connectionPool.returnConnection(connection);
        }
    }
}
