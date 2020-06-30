package com.epam.financial_analytics.dao.impl;

import com.epam.financial_analytics.connection.ConnectionPool;
import com.epam.financial_analytics.dao.ReportWithOrganizationDao;
import com.epam.financial_analytics.entity.report_classes.ReportWithOrganization;
import com.epam.financial_analytics.entity.dictionary.OrganizationUnit;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NumberOfStuffDaoImpl implements ReportWithOrganizationDao<ReportWithOrganization> {
    private ConnectionPool connectionPool;
    private Connection connection;
    private static final Logger LOGGER = Logger.getLogger(NumberOfStuffDaoImpl.class);

    private static final String INNER_JOIN = "AS NS INNER JOIN ORGANIZATION_UNIT AS OU ON NS.ORGANIZATION_UNIT_ID=OU.ID";
    private static final String ADD_NUMBER_OF_STUFF = "INSERT INTO NUMBER_OF_STUFF " +
            "(AMOUNT, DATE, ORGANIZATION_UNIT_ID) VALUES (?,?,?)";
    private static final String GET_ALL = "SELECT * FROM NUMBER_OF_STUFF " + INNER_JOIN;
    private static final String GET_BY_DATE = "SELECT * FROM NUMBER_OF_STUFF "+ INNER_JOIN + " WHERE DATE BETWEEN ? AND ?";
    private static final String GET_BY_ORGANIZATION_UNIT = "SELECT * FROM NUMBER_OF_STUFF " + INNER_JOIN + " WHERE OU.NAME = ?";
    private static final String GET_BY_DATE_AND_ORGANIZATION_UNIT = "SELECT * FROM " +
            "NUMBER_OF_STUFF " + INNER_JOIN + " WHERE OU.NAME = ? AND DATE BETWEEN ? AND ?";
    private static final String UPDATE_NUMBER_OF_STUFF = "UPDATE NUMBER_OF_STUFF " +
            "SET AMOUNT = ? WHERE DATE = ? AND ORGANIZATION_UNIT_ID=?";
    private static final String DELETE_NUMBER_OF_STUFF ="DELETE FROM NUMBER_OF_STUFF " +
            "WHERE DATE =? AND ORGANIZATION_UNIT_ID=?";
    private static final String GET_BY_NAME = "SELECT * FROM NUMBER_OF_STUFF " + INNER_JOIN + " WHERE NS.NAME = ?";

    @Override
    public List<ReportWithOrganization> getByOrganizationUnit(String organizationUnit) {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        List<ReportWithOrganization> numberOfStuffList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ORGANIZATION_UNIT)){
            preparedStatement.setString(1, organizationUnit);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                resultSet(numberOfStuffList, resultSet);
            }
        } catch (SQLException e) {
            LOGGER.error("SQLException in NumberOfStuffDaoIml getByOrganizationUnit", e);
        } finally {
            connectionPool.returnConnection(connection);
        }
        return numberOfStuffList;
    }

    @Override
    public List<ReportWithOrganization> getByDateAndOrganizationUnit(Date startDate, Date finishDate, String organizationUnit) {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        List<ReportWithOrganization> numberOfStuffList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_DATE_AND_ORGANIZATION_UNIT)){
            preparedStatement.setString(1, organizationUnit);
            preparedStatement.setDate(2, startDate);
            preparedStatement.setDate(3, finishDate);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                resultSet(numberOfStuffList, resultSet);
            }
        } catch (SQLException e) {
            LOGGER.error("SQLException in NumberOfStuffDaoImpl getByDateAndOrganizationUnit", e);
        } finally {
            connectionPool.returnConnection(connection);
        }
        return numberOfStuffList;
    }

    @Override
    public List<ReportWithOrganization> getByDate(Date startDate, Date finishDate) {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        List<ReportWithOrganization> numberOfStuffList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_DATE)){
            preparedStatement.setDate(1, startDate);
            preparedStatement.setDate(2, finishDate);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                resultSet(numberOfStuffList, resultSet);
            }
        } catch (SQLException e) {
            LOGGER.error("SQLException in NumberOfStuffDaoImpl getByDate", e);
        } finally {
            connectionPool.returnConnection(connection);
        }
        return numberOfStuffList;
    }

    @Override
    public void resultSet(List<ReportWithOrganization> numberOfStuffList, ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            ReportWithOrganization numberOfStuff = new ReportWithOrganization();

            numberOfStuff.setId(resultSet.getInt("ID"));
            numberOfStuff.setDate(resultSet.getDate("DATE"));
            numberOfStuff.setOrganizationUnit(new OrganizationUnit(resultSet.getInt("ORGANIZATION_UNIT_ID"), resultSet.getString("OU.NAME")));
            numberOfStuff.setAmount(resultSet.getLong("AMOUNT"));

            numberOfStuffList.add(numberOfStuff);
        }
    }

    @Override
    public List<ReportWithOrganization> getAll() {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        List<ReportWithOrganization> numberOfStuffList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL);
             ResultSet resultSet = preparedStatement.executeQuery()){
            resultSet(numberOfStuffList, resultSet);
        } catch (SQLException e) {
            LOGGER.error("SQLException in NumberOfStuffDaoImpl getAll", e);
        } finally {
            connectionPool.returnConnection(connection);
        }
        return numberOfStuffList;
    }

    @Override
    public ReportWithOrganization getByName(String name) {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        ReportWithOrganization numberOfStuff = new ReportWithOrganization();
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_NAME)){
            preparedStatement.setString(1, name);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    numberOfStuff.setId(resultSet.getLong("ID"));
                    numberOfStuff.setDate(resultSet.getDate("DATE"));
                    numberOfStuff.setOrganizationUnit(new OrganizationUnit(resultSet.getLong("ORGANIZATION_UNIT_ID"), resultSet.getString("OU.NAME")));
                    numberOfStuff.setAmount(resultSet.getLong("AMOUNT"));
                }
            }
        } catch (SQLException e) {
            LOGGER.error("SQLException in NumberOfStuffDaoImpl getByDate", e);
        } finally {
            connectionPool.returnConnection(connection);
        }
        return numberOfStuff;
    }

    @Override
    public void create(ReportWithOrganization numberOfStuff) {
        updateOrCreate(numberOfStuff, ADD_NUMBER_OF_STUFF);
    }

    @Override
    public void update(ReportWithOrganization numberOfStuff) {
        updateOrCreate(numberOfStuff, UPDATE_NUMBER_OF_STUFF);
    }

    @Override
    public void delete(ReportWithOrganization numberOfStuff) {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        try(PreparedStatement preparedStatement = connection.prepareStatement(DELETE_NUMBER_OF_STUFF)){
            preparedStatement.setDate(1, numberOfStuff.getDate());
            preparedStatement.setLong(2, numberOfStuff.getOrganizationUnit().getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("SQLException in NumberOfStuffDaoImpl delete", e);
        } finally {
            connectionPool.returnConnection(connection);
        }
    }

    @Override
    public void updateOrCreate(ReportWithOrganization numberOfStuff, String sql) {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setLong(1, numberOfStuff.getAmount());
            preparedStatement.setDate(2, numberOfStuff.getDate());
            preparedStatement.setLong(3, numberOfStuff.getOrganizationUnit().getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("SQLException in NumberOfStuffDaoImpl updateOrCreate", e);
        } finally {
            connectionPool.returnConnection(connection);
        }
    }
}
