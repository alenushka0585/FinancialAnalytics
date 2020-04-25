package com.epam.financial_analytics.dao.impl;

import com.epam.financial_analytics.connection.ConnectionPool;
import com.epam.financial_analytics.dao.BaseDao;
import com.epam.financial_analytics.entity.dictionary.Currency;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CurrencyDaoImpl implements BaseDao<Currency> {
    private ConnectionPool connectionPool;
    private Connection connection;
    private static final Logger LOGGER = Logger.getLogger(CurrencyDaoImpl.class);

    private static final String ADD_CURRENCY = "INSERT INTO CURRENCY (NAME, ID) VALUES (?,?)";
    private static final String GET_ALL = "SELECT * FROM CURRENCY";
    private static final String GET_BY_ID = "SELECT ID, NAME FROM CURRENCY WHERE ID=?";
    private static final String UPDATE_CURRENCY = "UPDATE CURRENCY SET NAME = ? WHERE ID = ?";
    private static final String DELETE_CURRENCY ="DELETE FROM CURRENCY WHERE ID = ?";

    @Override
    public List<Currency> getAll(){
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        List<Currency> currencyList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL);
             ResultSet resultSet = preparedStatement.executeQuery()){
            while (resultSet.next()) {
                Currency currency = new Currency();
                currency.setId(resultSet.getLong("ID"));
                currency.setName(resultSet.getString("NAME"));

                currencyList.add(currency);
            }
        } catch (SQLException e) {
            LOGGER.error("SQLException in CurrencyDaoImpl getAll", e);
        } finally {
            connectionPool.returnConnection(connection);
        }
        return currencyList;
    }

    @Override
    public Currency getById(long id){
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        Currency currency = new Currency();

        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID)){
            preparedStatement.setLong(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    currency.setId(resultSet.getLong("ID"));
                    currency.setName(resultSet.getString("NAME"));
                }
            }
        } catch (SQLException e) {
            LOGGER.error("SQLException in CurrencyDaoImpl getById", e);
        } finally {
            connectionPool.returnConnection(connection);
        }
        return currency;
    }

    @Override
    public void create(Currency currency){
        updateOrCreate(currency, ADD_CURRENCY);
    }

    @Override
    public void update(Currency currency){
        updateOrCreate(currency, UPDATE_CURRENCY);
    }

    @Override
    public void delete(Currency currency){
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        try(PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CURRENCY)){
            preparedStatement.setLong(1, currency.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("SQLException in CurrencyDaoImpl delete", e);
        } finally {
            connectionPool.returnConnection(connection);
        }
    }

    @Override
    public void updateOrCreate(Currency currency, String sql){
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, currency.getName());
            preparedStatement.setLong(2, currency.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("SQLException in CurrencyDaoImpl updateOrCreate", e);
        } finally {
            connectionPool.returnConnection(connection);
        }
    }
}
