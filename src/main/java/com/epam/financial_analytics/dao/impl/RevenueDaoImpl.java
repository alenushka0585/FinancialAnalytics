package com.epam.financial_analytics.dao.impl;

import com.epam.financial_analytics.connection.ConnectionPool;
import com.epam.financial_analytics.dao.ReportWithOrganizationDao;
import com.epam.financial_analytics.entity.report_classes.ReportWithOrganizationAndCurrency;
import com.epam.financial_analytics.entity.dictionary.Currency;
import com.epam.financial_analytics.entity.dictionary.OrganizationUnit;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RevenueDaoImpl implements ReportWithOrganizationDao<ReportWithOrganizationAndCurrency> {
    private ConnectionPool connectionPool;
    private Connection connection;
    private static final Logger LOGGER = Logger.getLogger(RevenueDaoImpl.class);

    private static final String INNER_JOIN = "AS R INNER JOIN ORGANIZATION_UNIT AS OU ON R.ORGANIZATION_UNIT_ID=OU.ID " +
            "INNER JOIN CURRENCY AS C ON R.CURRENCY_ID=C.ID";
    private static final String ADD_REVENUE = "INSERT INTO REVENUE " +
            "(AMOUNT, DATE, ORGANIZATION_UNIT_ID, CURRENCY_ID) VALUES (?,?,?,?)";
    private static final String GET_ALL = "SELECT * FROM REVENUE " + INNER_JOIN;
    private static final String GET_BY_DATE = "SELECT * FROM REVENUE " + INNER_JOIN + " WHERE DATE BETWEEN ? AND ?";
    private static final String GET_BY_ORGANIZATION_UNIT = "SELECT * FROM REVENUE " + INNER_JOIN + " WHERE OU.NAME=?";
    private static final String GET_BY_DATE_AND_ORGANIZATION_UNIT = "SELECT * FROM REVENUE " + INNER_JOIN +
            " WHERE OU.NAME = ? AND DATE BETWEEN ? AND ?";
    private static final String UPDATE_REVENUE = "UPDATE REVENUE SET AMOUNT = ? " +
            "WHERE DATE = ? AND ORGANIZATION_UNIT_ID = ? AND CURRENCY_ID = ?";
    private static final String DELETE_REVENUE ="DELETE FROM REVENUE WHERE DATE = ? AND ORGANIZATION_UNIT_ID = ?";
    private static final String GET_BY_NAME = "SELECT * FROM REVENUE " + INNER_JOIN + " WHERE R.NAME = ?";

    @Override
    public List<ReportWithOrganizationAndCurrency> getByOrganizationUnit(String organizationUnit) {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        List<ReportWithOrganizationAndCurrency> revenueList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ORGANIZATION_UNIT)){
            preparedStatement.setString(1, organizationUnit);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                resultSet(revenueList, resultSet);
            }
        } catch (SQLException e) {
            LOGGER.error("SQLException in RevenueDaoIml getByOrganizationUnit", e);
        } finally {
            connectionPool.returnConnection(connection);
        }
        return revenueList;
    }

    @Override
    public List<ReportWithOrganizationAndCurrency> getByDateAndOrganizationUnit(Date startDate, Date finishDate, String organizationUnit) {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        List<ReportWithOrganizationAndCurrency> revenueList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_DATE_AND_ORGANIZATION_UNIT)){
            preparedStatement.setString(1, organizationUnit);
            preparedStatement.setDate(2, startDate);
            preparedStatement.setDate(3, finishDate);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                resultSet(revenueList, resultSet);
            }
        } catch (SQLException e) {
            LOGGER.error("SQLException in RevenueDaoImpl getByDateAndOrganizationUnit", e);
        } finally {
            connectionPool.returnConnection(connection);
        }
        return revenueList;
    }

    @Override
    public List<ReportWithOrganizationAndCurrency> getByDate(Date startDate, Date finishDate) {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        List<ReportWithOrganizationAndCurrency> revenueList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_DATE)){
            preparedStatement.setDate(1, startDate);
            preparedStatement.setDate(2, finishDate);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                resultSet(revenueList, resultSet);
            }
        } catch (SQLException e) {
            LOGGER.error("SQLException in RevenueDaoImpl getByDate", e);
        } finally {
            connectionPool.returnConnection(connection);
        }
        return revenueList;
    }

    @Override
    public void resultSet(List<ReportWithOrganizationAndCurrency> revenueList, ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            ReportWithOrganizationAndCurrency revenue = new ReportWithOrganizationAndCurrency();

            revenue.setId(resultSet.getLong("ID"));
            revenue.setDate(resultSet.getDate("DATE"));
            revenue.setOrganizationUnit(new OrganizationUnit(resultSet.getLong("ORGANIZATION_UNIT_ID"), resultSet.getString("OU.NAME")));
            revenue.setCurrency(new Currency(resultSet.getLong("CURRENCY_ID"), resultSet.getString("C.NAME")));
            revenue.setAmount(resultSet.getLong("AMOUNT"));

            revenueList.add(revenue);
        }
    }

    @Override
    public List<ReportWithOrganizationAndCurrency> getAll() {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        List<ReportWithOrganizationAndCurrency> revenueList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL);
             ResultSet resultSet = preparedStatement.executeQuery()){
            resultSet(revenueList, resultSet);
        } catch (SQLException e) {
            LOGGER.error("SQLException in RevenueDaoImpl getAll", e);
        } finally {
            connectionPool.returnConnection(connection);
        }
        return revenueList;
    }

    @Override
    public ReportWithOrganizationAndCurrency getByName(String name) {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        ReportWithOrganizationAndCurrency revenue = new ReportWithOrganizationAndCurrency();
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_NAME)){
            preparedStatement.setString(1, name);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    revenue.setId(resultSet.getLong("ID"));
                    revenue.setDate(resultSet.getDate("DATE"));
                    revenue.setOrganizationUnit(new OrganizationUnit(resultSet.getLong("ORGANIZATION_UNIT_ID"), resultSet.getString("OU.NAME")));
                    revenue.setCurrency(new Currency(resultSet.getLong("CURRENCY_ID"), resultSet.getString("C.NAME")));
                    revenue.setAmount(resultSet.getLong("AMOUNT"));
                }
            }
        } catch (SQLException e) {
            LOGGER.error("SQLException in RevenueDaoImpl getByID", e);
        } finally {
            connectionPool.returnConnection(connection);
        }
        return revenue;
    }

    @Override
    public void create(ReportWithOrganizationAndCurrency revenue) {
        updateOrCreate(revenue, ADD_REVENUE);
    }

    @Override
    public void update(ReportWithOrganizationAndCurrency revenue) {
        updateOrCreate(revenue, UPDATE_REVENUE);
    }

    @Override
    public void delete(ReportWithOrganizationAndCurrency revenue) {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        try(PreparedStatement preparedStatement = connection.prepareStatement(DELETE_REVENUE)){
            preparedStatement.setDate(1, revenue.getDate());
            preparedStatement.setLong(2, revenue.getOrganizationUnit().getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("SQLException in RevenueDaoImpl delete", e);
        } finally {
            connectionPool.returnConnection(connection);
        }
    }

    @Override
    public void updateOrCreate(ReportWithOrganizationAndCurrency revenue, String sql) {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setLong(1, revenue.getAmount());
            preparedStatement.setDate(2, revenue.getDate());
            preparedStatement.setLong(3, revenue.getOrganizationUnit().getId());
            preparedStatement.setLong(4, revenue.getCurrency().getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("SQLException in RevenueDaoImpl updateOrCreate", e);
        } finally {
            connectionPool.returnConnection(connection);
        }
    }
}
