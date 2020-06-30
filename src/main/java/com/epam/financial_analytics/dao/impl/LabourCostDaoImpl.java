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

public class LabourCostDaoImpl implements ReportWithOrganizationDao<ReportWithOrganizationAndCurrency> {
    private ConnectionPool connectionPool;
    private Connection connection;
    private static final Logger LOGGER = Logger.getLogger(LabourCostDaoImpl.class);

    private static final String INNER_JOIN = "AS LC INNER JOIN ORGANIZATION_UNIT AS OU ON LC.ORGANIZATION_UNIT_ID=OU.ID " +
            "INNER JOIN CURRENCY AS C ON LC.CURRENCY_ID=C.ID";
    private static final String ADD_LABOUR_COST = "INSERT INTO LABOUR_COST (AMOUNT, DATE, ORGANIZATION_UNIT_ID, CURRENCY_ID) VALUES (?,?,?,?)";
    private static final String GET_ALL = "SELECT * FROM LABOUR_COST " + INNER_JOIN;
    private static final String GET_BY_DATE = "SELECT * FROM LABOUR_COST " + INNER_JOIN + " WHERE DATE BETWEEN ? AND ?";
    private static final String GET_BY_ORGANIZATION_UNIT = "SELECT * FROM LABOUR_COST " + INNER_JOIN + " WHERE OU.NAME = ?";
    private static final String GET_BY_DATE_AND_ORGANIZATION_UNIT = "SELECT * FROM LABOUR_COST " + INNER_JOIN +
            " WHERE OU.NAME = ? AND DATE BETWEEN ? AND ?";
    private static final String UPDATE_LABOUR_COST = "UPDATE LABOUR_COST SET AMOUNT = ? " +
            "WHERE DATE =? AND ORGANIZATION_UNIT_ID=? AND CURRENCY_ID = ?";
    private static final String DELETE_LABOUR_COST ="DELETE FROM LABOUR_COST " +
            "WHERE DATE = ? AND ORGANIZATION_UNIT_ID = ?";
    private static final String GET_BY_NAME = "SELECT * FROM LABOUR_COST " + INNER_JOIN + " WHERE LC.NAME = ?";

    @Override
    public List<ReportWithOrganizationAndCurrency> getByOrganizationUnit(String organizationUnit) {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        List<ReportWithOrganizationAndCurrency> labourCostList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ORGANIZATION_UNIT)){
            preparedStatement.setString(1, organizationUnit);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                resultSet(labourCostList, resultSet);
            }
        } catch (SQLException e) {
            LOGGER.error("SQLException in LabourCostDaoIml getByOrganizationUnit", e);
        } finally {
            connectionPool.returnConnection(connection);
        }
        return labourCostList;
    }

    @Override
    public List<ReportWithOrganizationAndCurrency> getByDateAndOrganizationUnit(Date startDate, Date finishDate, String organizationUnit) {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        List<ReportWithOrganizationAndCurrency> labourCostList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_DATE_AND_ORGANIZATION_UNIT)){
            preparedStatement.setString(1, organizationUnit);
            preparedStatement.setDate(2, startDate);
            preparedStatement.setDate(3, finishDate);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                resultSet(labourCostList, resultSet);
            }
        } catch (SQLException e) {
            LOGGER.error("SQLException in LabourCostDaoImpl getByDateAndOrganizationUnit", e);
        } finally {
            connectionPool.returnConnection(connection);
        }
        return labourCostList;
    }

    @Override
    public List<ReportWithOrganizationAndCurrency> getByDate(Date startDate, Date finishDate) {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        List<ReportWithOrganizationAndCurrency> labourCostList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_DATE)){
            preparedStatement.setDate(1, startDate);
            preparedStatement.setDate(2, finishDate);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                resultSet(labourCostList, resultSet);
            }
        } catch (SQLException e) {
            LOGGER.error("SQLException in LabourCostDaoImpl getByDate", e);
        } finally {
            connectionPool.returnConnection(connection);
        }
        return labourCostList;
    }

    @Override
    public void resultSet(List<ReportWithOrganizationAndCurrency> labourCostList, ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            ReportWithOrganizationAndCurrency labourCost = new ReportWithOrganizationAndCurrency();

            labourCost.setId(resultSet.getInt("ID"));
            labourCost.setDate(resultSet.getDate("DATE"));
            labourCost.setOrganizationUnit(new OrganizationUnit(resultSet.getInt("ORGANIZATION_UNIT_ID"), resultSet.getString("OU.NAME")));
            labourCost.setCurrency(new Currency(resultSet.getInt("CURRENCY_ID"), resultSet.getString("C.NAME")));
            labourCost.setAmount(resultSet.getLong("AMOUNT"));

            labourCostList.add(labourCost);
        }
    }

    @Override
    public List<ReportWithOrganizationAndCurrency> getAll() {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        List<ReportWithOrganizationAndCurrency> labourCostList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL);
             ResultSet resultSet = preparedStatement.executeQuery()){
            resultSet(labourCostList, resultSet);
        } catch (SQLException e) {
            LOGGER.error("SQLException in LabourCostDaoImpl getAll", e);
        } finally {
            connectionPool.returnConnection(connection);
        }
        return labourCostList;
    }

    @Override
    public ReportWithOrganizationAndCurrency getByName(String name) {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        ReportWithOrganizationAndCurrency labourCost = new ReportWithOrganizationAndCurrency();
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_NAME)){
            preparedStatement.setString(1, name);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    labourCost.setId(resultSet.getLong("ID"));
                    labourCost.setDate(resultSet.getDate("DATE"));
                    labourCost.setOrganizationUnit(new OrganizationUnit(resultSet.getLong("ORGANIZATION_UNIT_ID"), resultSet.getString("OU.NAME")));
                    labourCost.setCurrency(new Currency(resultSet.getLong("CURRENCY_ID"), resultSet.getString("C.NAME")));
                    labourCost.setAmount(resultSet.getLong("AMOUNT"));
                }
            }
        } catch (SQLException e) {
            LOGGER.error("SQLException in LabourCostDaoImpl getById", e);
        } finally {
            connectionPool.returnConnection(connection);
        }
        return labourCost;
    }

    @Override
    public void create(ReportWithOrganizationAndCurrency labourCost) {
        updateOrCreate(labourCost, ADD_LABOUR_COST);
    }

    @Override
    public void update(ReportWithOrganizationAndCurrency labourCost) {
        updateOrCreate(labourCost, UPDATE_LABOUR_COST);
    }

    @Override
    public void delete(ReportWithOrganizationAndCurrency labourCost) {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        try(PreparedStatement preparedStatement = connection.prepareStatement(DELETE_LABOUR_COST)){
            preparedStatement.setDate(1,labourCost.getDate());
            preparedStatement.setLong(2, labourCost.getOrganizationUnit().getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("SQLException in LabourCostDaoImpl delete", e);
        } finally {
            connectionPool.returnConnection(connection);
        }
    }

    @Override
    public void updateOrCreate(ReportWithOrganizationAndCurrency labourCost, String sql) {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setLong(1, labourCost.getAmount());
            preparedStatement.setDate(2, labourCost.getDate());
            preparedStatement.setLong(3, labourCost.getOrganizationUnit().getId());
            preparedStatement.setLong(4, labourCost.getCurrency().getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("SQLException in LabourCostDaoImpl updateOrCreate", e);
        } finally {
            connectionPool.returnConnection(connection);
        }
    }
}
