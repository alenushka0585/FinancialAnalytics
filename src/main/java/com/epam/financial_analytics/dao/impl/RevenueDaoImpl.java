package com.epam.financial_analytics.dao.impl;

import com.epam.financial_analytics.connection.ConnectionPool;
import com.epam.financial_analytics.dao.ReportWithOrganizationDao;
import com.epam.financial_analytics.entity.dictionary.Currency;
import com.epam.financial_analytics.entity.dictionary.OrganizationUnit;
import com.epam.financial_analytics.entity.report_classes.Revenue;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RevenueDaoImpl implements ReportWithOrganizationDao<Revenue> {
    private ConnectionPool connectionPool;
    private Connection connection;
    private static final Logger LOGGER = Logger.getLogger(RevenueDaoImpl.class);

    private static final String INNERJOIN = "AS R INNER JOIN ORGANIZATION_UNIT AS OU ON R.ORGANIZATION_UNIT_ID=OU.ID " +
            "INNER JOIN CURRENCY AS C ON R.CURRENCY_ID=C.ID";
    private static final String ADD_REVENUE = "INSERT INTO REVENUE " +
            "(SUM, ID, DATE, ORGANIZATION_UNIT_ID, CURRENCY_ID) VALUES (?,?,?,?,?)";
    private static final String GET_ALL = "SELECT * FROM REVENUE " + INNERJOIN;
    private static final String GET_BY_DATE = "SELECT * FROM REVENUE " + INNERJOIN + " WHERE DATE BETWEEN ? AND ?";
    private static final String GET_BY_ORGANIZATION_UNIT = "SELECT * FROM REVENUE " + INNERJOIN + " WHERE OU.NAME=?";
    private static final String GET_BY_DATE_AND_ORGANIZATION_UNIT = "SELECT * FROM REVENUE " + INNERJOIN +
            " WHERE OU.NAME = ? AND DATE BETWEEN ? AND ?";
    private static final String UPDATE_REVENUE = "UPDATE REVENUE SET SUM = ? " +
            "WHERE ID = ? AND DATE = ? AND ORGANIZATION_UNIT_ID = ? AND CURRENCY_ID = ?";
    private static final String DELETE_REVENUE ="DELETE FROM REVENUE WHERE DATE = ? AND ORGANIZATION_UNIT_ID = ?";
    private static final String GET_BY_ID = "SELECT * FROM REVENUE " + INNERJOIN + " WHERE R.ID = ?";

    @Override
    public List<Revenue> getByOrganizationUnit(String organizationUnit) {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        List<Revenue> revenueList = new ArrayList<>();
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
    public List<Revenue> getByDateAndOrganizationUnit(Date startDate, Date finishDate, String organizationUnit) {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        List<Revenue> revenueList = new ArrayList<>();
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
    public List<Revenue> getByDate(Date startDate, Date finishDate) {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        List<Revenue> revenueList = new ArrayList<>();
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
    public void resultSet(List<Revenue> revenueList, ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            Revenue revenue = new Revenue();

            revenue.setId(resultSet.getLong("ID"));
            revenue.setDate(resultSet.getDate("DATE"));
            revenue.setOrganizationUnit(new OrganizationUnit(resultSet.getLong("ORGANIZATION_UNIT_ID"), resultSet.getString("OU.NAME")));
            revenue.setCurrency(new Currency(resultSet.getLong("CURRENCY_ID"), resultSet.getString("C.NAME")));
            revenue.setSum(resultSet.getLong("SUM"));

            revenueList.add(revenue);
        }
    }

    @Override
    public List<Revenue> getAll() {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        List<Revenue> revenueList = new ArrayList<>();
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
    public Revenue getById(long id) {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        Revenue revenue = new Revenue();
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID)){
            preparedStatement.setLong(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    revenue.setId(resultSet.getLong("ID"));
                    revenue.setDate(resultSet.getDate("DATE"));
                    revenue.setOrganizationUnit(new OrganizationUnit(resultSet.getLong("ORGANIZATION_UNIT_ID"), resultSet.getString("OU.NAME")));
                    revenue.setCurrency(new Currency(resultSet.getLong("CURRENCY_ID"), resultSet.getString("C.NAME")));
                    revenue.setSum(resultSet.getLong("SUM"));
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
    public void create(Revenue revenue) {
        updateOrCreate(revenue, ADD_REVENUE);
    }

    @Override
    public void update(Revenue revenue) {
        updateOrCreate(revenue, UPDATE_REVENUE);
    }

    @Override
    public void delete(Revenue revenue) {
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
    public void updateOrCreate(Revenue revenue, String sql) {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setLong(1, revenue.getSum());
            preparedStatement.setLong(2, revenue.getId());
            preparedStatement.setDate(3, revenue.getDate());
            preparedStatement.setLong(4, revenue.getOrganizationUnit().getId());
            preparedStatement.setLong(5, revenue.getCurrency().getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("SQLException in RevenueDaoImpl updateOrCreate", e);
        } finally {
            connectionPool.returnConnection(connection);
        }
    }
}
