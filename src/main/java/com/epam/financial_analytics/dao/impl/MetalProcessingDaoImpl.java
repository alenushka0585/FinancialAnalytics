package com.epam.financial_analytics.dao.impl;

import com.epam.financial_analytics.connection.ConnectionPool;
import com.epam.financial_analytics.dao.ReportWithOrganizationDao;
import com.epam.financial_analytics.entity.report_classes.ReportWithOrganization;
import com.epam.financial_analytics.entity.dictionary.OrganizationUnit;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MetalProcessingDaoImpl implements ReportWithOrganizationDao<ReportWithOrganization> {
    private ConnectionPool connectionPool;
    private Connection connection;
    private static final Logger LOGGER = Logger.getLogger(MetalProcessingDaoImpl.class);

    private static final String INNER_JOIN = "AS MP INNER JOIN ORGANIZATION_UNIT AS OU ON MP.ORGANIZATION_UNIT_ID=OU.ID";
    private static final String ADD_METAL_PROCESSING = "INSERT INTO METAL_PROCESSING " +
            "(AMOUNT, DATE, ORGANIZATION_UNIT_ID) VALUES (?,?,?)";
    private static final String GET_ALL = "SELECT * FROM METAL_PROCESSING " + INNER_JOIN;
    private static final String GET_BY_DATE = "SELECT * FROM METAL_PROCESSING " + INNER_JOIN + " WHERE DATE BETWEEN ? AND ?";
    private static final String GET_BY_ORGANIZATION_UNIT = "SELECT * FROM METAL_PROCESSING " + INNER_JOIN + " WHERE OU.NAME = ?";
    private static final String GET_BY_DATE_AND_ORGANIZATION_UNIT = "SELECT * FROM METAL_PROCESSING " + INNER_JOIN +
            " WHERE OU.NAME = ? AND DATE BETWEEN ? AND ?";
    private static final String UPDATE_METAL_PROCESSING = "UPDATE _PROCESSING SET AMOUNT = ? " +
            "WHERE DATE = ? AND ORGANIZATION_UNIT_ID =?";
    private static final String DELETE_METAL_PROCESSING ="DELETE FROM METAL_PROCESSING " +
            "WHERE DATE = ? AND ORGANIZATION_UNIT_ID = ?";
    private static final String GET_BY_NAME = "SELECT * FROM METAL_PROCESSING " + INNER_JOIN + " WHERE MP.NAME = ?";

    @Override
    public List<ReportWithOrganization> getByOrganizationUnit(String organizationUnit) {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        List<ReportWithOrganization> metalProcessingList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ORGANIZATION_UNIT)){
            preparedStatement.setString(1, organizationUnit);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                resultSet(metalProcessingList, resultSet);
            }
        } catch (SQLException e) {
            LOGGER.error("SQLException in MetalProcessingDaoIml getByOrganizationUnit", e);
        } finally {
            connectionPool.returnConnection(connection);
        }
        return metalProcessingList;
    }

    @Override
    public List<ReportWithOrganization> getByDateAndOrganizationUnit(Date startDate, Date finishDate, String organizationUnit) {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        List<ReportWithOrganization> metalProcessingList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_DATE_AND_ORGANIZATION_UNIT)){
            preparedStatement.setString(1, organizationUnit);
            preparedStatement.setDate(2, startDate);
            preparedStatement.setDate(3, finishDate);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                resultSet(metalProcessingList, resultSet);
            }
        } catch (SQLException e) {
            LOGGER.error("SQLException in MetalProcessingDaoImpl getByDateAndOrganizationUnit", e);
        } finally {
            connectionPool.returnConnection(connection);
        }
        return metalProcessingList;
    }

    @Override
    public List<ReportWithOrganization> getByDate(Date startDate, Date finishDate) {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        List<ReportWithOrganization> metalProcessingList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_DATE)){
            preparedStatement.setDate(1, startDate);
            preparedStatement.setDate(2, finishDate);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                resultSet(metalProcessingList, resultSet);
            }
        } catch (SQLException e) {
            LOGGER.error("SQLException in MetalProcessingDaoImpl getByDate", e);
        } finally {
            connectionPool.returnConnection(connection);
        }
        return metalProcessingList;
    }

    @Override
    public void resultSet(List<ReportWithOrganization> metalProcessingList, ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            ReportWithOrganization metalProcessing = new ReportWithOrganization();

            metalProcessing.setId(resultSet.getInt("ID"));
            metalProcessing.setDate(resultSet.getDate("DATE"));
            metalProcessing.setOrganizationUnit(new OrganizationUnit(resultSet.getInt("ORGANIZATION_UNIT_ID"), resultSet.getString("OU.NAME")));
            metalProcessing.setAmount(resultSet.getLong("AMOUNT"));

            metalProcessingList.add(metalProcessing);
        }
    }

    @Override
    public List<ReportWithOrganization> getAll() {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        List<ReportWithOrganization> metalProcessingList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL);
             ResultSet resultSet = preparedStatement.executeQuery()){
            resultSet(metalProcessingList, resultSet);
        } catch (SQLException e) {
            LOGGER.error("SQLException in MetalProcessingDaoImpl getAll", e);
        } finally {
            connectionPool.returnConnection(connection);
        }
        return metalProcessingList;
    }

    @Override
    public ReportWithOrganization getByName(String name) {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        ReportWithOrganization metalProcessing = new ReportWithOrganization();
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_NAME)){
            preparedStatement.setString(1, name);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    metalProcessing.setId(resultSet.getLong("ID"));
                    metalProcessing.setDate(resultSet.getDate("DATE"));
                    metalProcessing.setOrganizationUnit(new OrganizationUnit(resultSet.getLong("ORGANIZATION_UNIT_ID"), resultSet.getString("OU.NAME")));
                    metalProcessing.setAmount(resultSet.getLong("AMOUNT"));
                }
            }
        } catch (SQLException e) {
            LOGGER.error("SQLException in MetalProcessingDaoImpl getByDate", e);
        } finally {
            connectionPool.returnConnection(connection);
        }
        return metalProcessing;
    }

    @Override
    public void create(ReportWithOrganization metalProcessing) {
        updateOrCreate(metalProcessing, ADD_METAL_PROCESSING);
    }

    @Override
    public void update(ReportWithOrganization metalProcessing) {
        updateOrCreate(metalProcessing, UPDATE_METAL_PROCESSING);
    }

    @Override
    public void delete(ReportWithOrganization metalProcessing) {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        try(PreparedStatement preparedStatement = connection.prepareStatement(DELETE_METAL_PROCESSING)){
            preparedStatement.setDate(1,metalProcessing.getDate());
            preparedStatement.setLong(2, metalProcessing.getOrganizationUnit().getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("SQLException in MetalProcessingDaoImpl delete", e);
        } finally {
            connectionPool.returnConnection(connection);
        }
    }

    @Override
    public void updateOrCreate(ReportWithOrganization metalProcessing, String sql) {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setLong(1, metalProcessing.getAmount());
            preparedStatement.setDate(2, metalProcessing.getDate());
            preparedStatement.setLong(3, metalProcessing.getOrganizationUnit().getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("SQLException in MetalProcessingDaoImpl updateOrCreate", e);
        } finally {
            connectionPool.returnConnection(connection);
        }
    }
}
