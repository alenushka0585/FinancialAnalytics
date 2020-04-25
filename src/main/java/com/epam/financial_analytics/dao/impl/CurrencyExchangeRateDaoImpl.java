package com.epam.financial_analytics.dao.impl;

import com.epam.financial_analytics.connection.ConnectionPool;
import com.epam.financial_analytics.dao.CurrencyExchangeRateDao;
import com.epam.financial_analytics.entity.dictionary.Currency;
import com.epam.financial_analytics.entity.report_classes.CurrencyExchangeRate;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CurrencyExchangeRateDaoImpl implements CurrencyExchangeRateDao {
    private ConnectionPool connectionPool;
    private Connection connection;
    private static final Logger LOGGER = Logger.getLogger(CurrencyExchangeRateDaoImpl.class);

    private static final String ADD_CURRENCY_EXCHANGE_RATE = "INSERT INTO CURRENCY_EXCHANGE_RATE " +
            "(EXCHANGE_RATE, DATE, CURRENCY_ID, ID) VALUES (?,?,?,?)";
    private static final String GET_ALL = "SELECT * FROM CURRENCY_EXCHANGE_RATE AS CE " +
            "INNER JOIN CURRENCY AS C ON CE.CURRENCY_ID=C.ID";
    private static final String GET_BY_DATE = "SELECT * FROM CURRENCY_EXCHANGE_RATE AS CE " +
            "INNER JOIN CURRENCY AS C ON CE.CURRENCY_ID=C.ID WHERE DATE BETWEEN ? AND ?";
    private static final String GET_BY_ID = "SELECT * FROM CURRENCY_EXCHANGE_RATE AS CE " +
            "INNER JOIN CURRENCY AS C ON CE.CURRENCY_ID=C.ID WHERE CE.ID = ?";
    private static final String GET_BY_CURRENCY = "SELECT * FROM CURRENCY_EXCHANGE_RATE AS CE " +
            "INNER JOIN CURRENCY AS C ON CE.CURRENCY_ID=C.ID WHERE C.NAME = ?";
    private static final String GET_BY_CURRENCY_AND_DATE = "SELECT * FROM CURRENCY_EXCHANGE_RATE AS CE " +
            "INNER JOIN CURRENCY AS C ON CE.CURRENCY_ID=C.ID WHERE C.NAME = ? AND DATE BETWEEN ? AND ?";
    private static final String UPDATE_CURRENCY_EXCHANGE_RATE = "UPDATE CURRENCY_EXCHANGE_RATE " +
            "SET EXCHANGE_RATE = ? WHERE DATE = ? AND CURRENCY_ID = ? AND ID = ?";
    private static final String DELETE_CURRENCY_EXCHANGE_RATE ="DELETE FROM CURRENCY_EXCHANGE_RATE " +
            "WHERE DATE = ? AND CURRENCY_ID = ?";

    @Override
    public List<CurrencyExchangeRate> getByDate(Date startDate, Date finishDate ){
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        List<CurrencyExchangeRate> currencyExchangeRateList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_DATE)){
            preparedStatement.setDate(1, startDate);
            preparedStatement.setDate(2, finishDate);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                resultSet(currencyExchangeRateList, resultSet);
            }
        } catch (SQLException e) {
            LOGGER.error("SQLException in CurrencyExchangeRateDaoImpl getByDate", e);
        } finally {
            connectionPool.returnConnection(connection);
        }
        return currencyExchangeRateList;
    }

    @Override
    public void resultSet(List<CurrencyExchangeRate> currencyExchangeRateList, ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            CurrencyExchangeRate currencyExchangeRate = new CurrencyExchangeRate();


            currencyExchangeRate.setId(resultSet.getLong("ID"));
            currencyExchangeRate.setDate(resultSet.getDate("DATE"));
            currencyExchangeRate.setCurrency(new Currency(resultSet.getLong("CURRENCY_ID"),resultSet.getString("C.NAME")));
            currencyExchangeRate.setExchangeRate(resultSet.getDouble("EXCHANGE_RATE"));

            currencyExchangeRateList.add(currencyExchangeRate);
        }
    }

    @Override
    public List<CurrencyExchangeRate> getAll(){
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        List<CurrencyExchangeRate> currencyExchangeRateList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL);
             ResultSet resultSet = preparedStatement.executeQuery()){
            resultSet(currencyExchangeRateList, resultSet);
        } catch (SQLException e) {
            LOGGER.error("SQLException in CurrencyExchangeRateDaoImpl getAll", e);
        } finally {
            connectionPool.returnConnection(connection);
        }
        return currencyExchangeRateList;
    }

    @Override
    public CurrencyExchangeRate getById(long id) {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        CurrencyExchangeRate currencyExchangeRate = new CurrencyExchangeRate();
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID)){
            preparedStatement.setLong(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    currencyExchangeRate.setId(resultSet.getLong("ID"));
                    currencyExchangeRate.setDate(resultSet.getDate("DATE"));
                    currencyExchangeRate.setCurrency(new Currency(resultSet.getInt("CURRENCY_ID"),resultSet.getString("C.NAME")));
                    currencyExchangeRate.setExchangeRate(resultSet.getDouble("EXCHANGE_RATE"));
                }
            }
        } catch (SQLException e) {
            LOGGER.error("SQLException in CurrencyExchangeRateDaoImpl getById", e);
        } finally {
            connectionPool.returnConnection(connection);
        }
        return currencyExchangeRate;
    }

    @Override
    public void create(CurrencyExchangeRate currencyExchangeRate){
        updateOrCreate(currencyExchangeRate, ADD_CURRENCY_EXCHANGE_RATE);
    }

    @Override
    public void update(CurrencyExchangeRate currencyExchangeRate){
        updateOrCreate(currencyExchangeRate, UPDATE_CURRENCY_EXCHANGE_RATE);
    }

    @Override
    public void delete(CurrencyExchangeRate currencyExchangeRate){
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        try(PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CURRENCY_EXCHANGE_RATE)){
            preparedStatement.setDate(1, currencyExchangeRate.getDate());
            preparedStatement.setLong(2, currencyExchangeRate.getCurrency().getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("SQLException in CurrencyExchangeRateDaoImpl delete", e);
        } finally {
            connectionPool.returnConnection(connection);
        }
    }

    @Override
    public void updateOrCreate(CurrencyExchangeRate currencyExchangeRate, String sql){
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setDouble(1, currencyExchangeRate.getExchangeRate());
            preparedStatement.setDate(2, currencyExchangeRate.getDate());
            preparedStatement.setLong(3, currencyExchangeRate.getCurrency().getId());
            preparedStatement.setLong(4, currencyExchangeRate.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("SQLException in CurrencyExchangeRateDaoImpl updateOrCreate", e);
        } finally {
            connectionPool.returnConnection(connection);
        }
    }

    @Override
    public List<CurrencyExchangeRate> getByCurrency(String name) {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        List<CurrencyExchangeRate> currencyExchangeRateList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_CURRENCY)){
            preparedStatement.setString(1, name);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                resultSet(currencyExchangeRateList, resultSet);
            }
        } catch (SQLException e) {
            LOGGER.error("SQLException in CurrencyExchangeRateDaoImpl getByCurrency", e);
        } finally {
            connectionPool.returnConnection(connection);
        }
        return currencyExchangeRateList;
    }

    @Override
    public List<CurrencyExchangeRate> getByCurrencyAndDate(String name, Date startDate, Date finishDate) {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        List<CurrencyExchangeRate> currencyExchangeRateList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_CURRENCY_AND_DATE)){
            preparedStatement.setString(1, name);
            preparedStatement.setDate(2, startDate);
            preparedStatement.setDate(3, finishDate);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                resultSet(currencyExchangeRateList, resultSet);
            }
        } catch (SQLException e) {
            LOGGER.error("SQLException in CurrencyExchangeRateDaoImpl getByCurrencyAndDate", e);
        } finally {
            connectionPool.returnConnection(connection);
        }
        return currencyExchangeRateList;
    }
}
