package com.epam.financial_analytics.dao.impl;

import com.epam.financial_analytics.connection.ConnectionPool;
import com.epam.financial_analytics.dao.ReportWithOrganizationDao;
import com.epam.financial_analytics.entity.dictionary.OrganizationUnit;
import com.epam.financial_analytics.entity.report_classes.MetallProcessing;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MetallProcessingDaoImpl implements ReportWithOrganizationDao<MetallProcessing> {
    private ConnectionPool connectionPool;
    private Connection connection;
    private static final Logger LOGGER = Logger.getLogger(MetallProcessingDaoImpl.class);

    private static final String INNERJOIN = "AS MP INNER JOIN ORGANIZATION_UNIT AS OU ON MP.ORGANIZATION_UNIT_ID=OU.ID";
    private static final String ADD_METALL_PROCESSING = "INSERT INTO METALL_PROCESSING " +
            "(AMOUNT, ID, DATE, ORGANIZATION_UNIT_ID) VALUES (?,?,?,?)";
    private static final String GET_ALL = "SELECT * FROM METALL_PROCESSING " + INNERJOIN;
    private static final String GET_BY_DATE = "SELECT * FROM METALL_PROCESSING " + INNERJOIN + " WHERE DATE BETWEEN ? AND ?";
    private static final String GET_BY_ORGANIZATION_UNIT = "SELECT * FROM METALL_PROCESSING " + INNERJOIN + " WHERE OU.NAME = ?";
    private static final String GET_BY_DATE_AND_ORGANIZATION_UNIT = "SELECT * FROM METALL_PROCESSING " + INNERJOIN +
            " WHERE OU.NAME = ? AND DATE BETWEEN ? AND ?";
    private static final String UPDATE_METALL_PROCESSING = "UPDATE METALL_PROCESSING SET AMOUNT = ? " +
            "WHERE ID = ? AND DATE = ? AND ORGANIZATION_UNIT_ID =?";
    private static final String DELETE_METALL_PROCESSING ="DELETE FROM METALL_PROCESSING " +
            "WHERE DATE = ? AND ORGANIZATION_UNIT_ID = ?";
    private static final String GET_BY_ID = "SELECT * FROM METALL_PROCESSING " + INNERJOIN + " WHERE MP.ID = ?";

    @Override
    public List<MetallProcessing> getByOrganizationUnit(String organizationUnit) {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        List<MetallProcessing> metallProcessingList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ORGANIZATION_UNIT)){
            preparedStatement.setString(1, organizationUnit);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                resultSet(metallProcessingList, resultSet);
            }
        } catch (SQLException e) {
            LOGGER.error("SQLException in MetallProcessingDaoIml getByOrganizationUnit", e);
        } finally {
            connectionPool.returnConnection(connection);
        }
        return metallProcessingList;
    }

    @Override
    public List<MetallProcessing> getByDateAndOrganizationUnit(Date startDate, Date finishDate, String organizationUnit) {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        List<MetallProcessing> metallProcessingList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_DATE_AND_ORGANIZATION_UNIT)){
            preparedStatement.setString(1, organizationUnit);
            preparedStatement.setDate(2, startDate);
            preparedStatement.setDate(3, finishDate);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                resultSet(metallProcessingList, resultSet);
            }
        } catch (SQLException e) {
            LOGGER.error("SQLException in MetallProcessingDaoImpl getByDateAndOrganizationUnit", e);
        } finally {
            connectionPool.returnConnection(connection);
        }
        return metallProcessingList;
    }

    @Override
    public List<MetallProcessing> getByDate(Date startDate, Date finishDate) {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        List<MetallProcessing> metallProcessingList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_DATE)){
            preparedStatement.setDate(1, startDate);
            preparedStatement.setDate(2, finishDate);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                resultSet(metallProcessingList, resultSet);
            }
        } catch (SQLException e) {
            LOGGER.error("SQLException in MetallProcessingDaoImpl getByDate", e);
        } finally {
            connectionPool.returnConnection(connection);
        }
        return metallProcessingList;
    }

    @Override
    public void resultSet(List<MetallProcessing> metallProcessingList, ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            MetallProcessing metallProcessing = new MetallProcessing();

            metallProcessing.setId(resultSet.getInt("ID"));
            metallProcessing.setDate(resultSet.getDate("DATE"));
            metallProcessing.setOrganizationUnit(new OrganizationUnit(resultSet.getInt("ORGANIZATION_UNIT_ID"), resultSet.getString("OU.NAME")));
            metallProcessing.setAmount(resultSet.getLong("AMOUNT"));

            metallProcessingList.add(metallProcessing);
        }
    }

    @Override
    public List<MetallProcessing> getAll() {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        List<MetallProcessing> metallProcessingList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL);
             ResultSet resultSet = preparedStatement.executeQuery()){
            resultSet(metallProcessingList, resultSet);
        } catch (SQLException e) {
            LOGGER.error("SQLException in MetallProcessingDaoImpl getAll", e);
        } finally {
            connectionPool.returnConnection(connection);
        }
        return metallProcessingList;
    }

    @Override
    public MetallProcessing getById(long id) {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        MetallProcessing metallProcessing = new MetallProcessing();
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID)){
            preparedStatement.setLong(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    metallProcessing.setId(resultSet.getLong("ID"));
                    metallProcessing.setDate(resultSet.getDate("DATE"));
                    metallProcessing.setOrganizationUnit(new OrganizationUnit(resultSet.getLong("ORGANIZATION_UNIT_ID"), resultSet.getString("OU.NAME")));
                    metallProcessing.setAmount(resultSet.getLong("AMOUNT"));
                }
            }
        } catch (SQLException e) {
            LOGGER.error("SQLException in MetallProcessingDaoImpl getByDate", e);
        } finally {
            connectionPool.returnConnection(connection);
        }
        return metallProcessing;
    }

    @Override
    public void create(MetallProcessing metallProcessing) {
        updateOrCreate(metallProcessing, ADD_METALL_PROCESSING);
    }

    @Override
    public void update(MetallProcessing metallProcessing) {
        updateOrCreate(metallProcessing, UPDATE_METALL_PROCESSING);
    }

    @Override
    public void delete(MetallProcessing metallProcessing) {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        try(PreparedStatement preparedStatement = connection.prepareStatement(DELETE_METALL_PROCESSING)){
            preparedStatement.setDate(1,metallProcessing.getDate());
            preparedStatement.setLong(2, metallProcessing.getOrganizationUnit().getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("SQLException in MetallProcessingDaoImpl delete", e);
        } finally {
            connectionPool.returnConnection(connection);
        }
    }

    @Override
    public void updateOrCreate(MetallProcessing metallProcessing, String sql) {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setLong(1, metallProcessing.getAmount());
            preparedStatement.setLong(2, metallProcessing.getId());
            preparedStatement.setDate(3, metallProcessing.getDate());
            preparedStatement.setLong(4, metallProcessing.getOrganizationUnit().getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("SQLException in MetallProcessingDaoImpl updateOrCreate", e);
        } finally {
            connectionPool.returnConnection(connection);
        }
    }
}
