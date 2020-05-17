package com.epam.financial_analytics.dao.impl;

import com.epam.financial_analytics.connection.ConnectionPool;
import com.epam.financial_analytics.dao.ReportWithOrganizationDao;
import com.epam.financial_analytics.entity.dictionary.OrganizationUnit;
import com.epam.financial_analytics.entity.report_classes.ReportWithOrganization;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SalesOfTonsDaoImpl implements ReportWithOrganizationDao<ReportWithOrganization> {
    private ConnectionPool connectionPool;
    private Connection connection;
    private static final Logger LOGGER = Logger.getLogger(SalesOfTonsDaoImpl.class);

    private static final String INNERJOIN = "AS NS INNER JOIN ORGANIZATION_UNIT AS OU ON NS.ORGANIZATION_UNIT_ID=OU.ID";
    private static final String ADD_SALES_OF_TONS = "INSERT INTO SALES_OF_TONS " +
            "(AMOUNT, DATE, ORGANIZATION_UNIT_ID) VALUES (?,?,?)";
    private static final String GET_ALL = "SELECT * FROM SALES_OF_TONS " + INNERJOIN;
    private static final String GET_BY_DATE = "SELECT * FROM SALES_OF_TONS "+ INNERJOIN + " WHERE DATE BETWEEN ? AND ?";
    private static final String GET_BY_ORGANIZATION_UNIT = "SELECT * FROM SALES_OF_TONS " + INNERJOIN + " WHERE OU.NAME = ?";
    private static final String GET_BY_DATE_AND_ORGANIZATION_UNIT = "SELECT * FROM " +
            "SALES_OF_TONS " + INNERJOIN + " WHERE OU.NAME = ? AND DATE BETWEEN ? AND ?";
    private static final String UPDATE_SALES_OF_TONS = "UPDATE SALES_OF_TONS " +
            "SET AMOUNT = ? WHERE DATE = ? AND ORGANIZATION_UNIT_ID=?";
    private static final String DELETE_SALES_OF_TONS ="DELETE FROM SALES_OF_TONS " +
            "WHERE DATE =? AND ORGANIZATION_UNIT_ID=?";
    private static final String GET_BY_NAME = "SELECT * FROM SALES_OF_TONS " + INNERJOIN + " WHERE NS.NAME = ?";

    @Override
    public List<ReportWithOrganization> getByOrganizationUnit(String organizationUnit) {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        List<ReportWithOrganization> salesOfTonsList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ORGANIZATION_UNIT)){
            preparedStatement.setString(1, organizationUnit);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                resultSet(salesOfTonsList, resultSet);
            }
        } catch (SQLException e) {
            LOGGER.error("SQLException in SalesOfTonsDaoIml getByOrganizationUnit", e);
        } finally {
            connectionPool.returnConnection(connection);
        }
        return salesOfTonsList;
    }

    @Override
    public List<ReportWithOrganization> getByDateAndOrganizationUnit(Date startDate, Date finishDate, String organizationUnit) {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        List<ReportWithOrganization> salesOfTonsList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_DATE_AND_ORGANIZATION_UNIT)){
            preparedStatement.setString(1, organizationUnit);
            preparedStatement.setDate(2, startDate);
            preparedStatement.setDate(3, finishDate);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                resultSet(salesOfTonsList, resultSet);
            }
        } catch (SQLException e) {
            LOGGER.error("SQLException in SalesOfTonsDaoImpl getByDateAndOrganizationUnit", e);
        } finally {
            connectionPool.returnConnection(connection);
        }
        return salesOfTonsList;
    }

    @Override
    public List<ReportWithOrganization> getByDate(Date startDate, Date finishDate) {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        List<ReportWithOrganization> salesOfTonsList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_DATE)){
            preparedStatement.setDate(1, startDate);
            preparedStatement.setDate(2, finishDate);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                resultSet(salesOfTonsList, resultSet);
            }
        } catch (SQLException e) {
            LOGGER.error("SQLException in SalesOfTonsDaoImpl getByDate", e);
        } finally {
            connectionPool.returnConnection(connection);
        }
        return salesOfTonsList;
    }

    @Override
    public void resultSet(List<ReportWithOrganization> salesOfTonsList, ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            ReportWithOrganization salesOfTons = new ReportWithOrganization();

            salesOfTons.setId(resultSet.getInt("ID"));
            salesOfTons.setDate(resultSet.getDate("DATE"));
            salesOfTons.setOrganizationUnit(new OrganizationUnit(resultSet.getInt("ORGANIZATION_UNIT_ID"), resultSet.getString("OU.NAME")));
            salesOfTons.setAmount(resultSet.getLong("AMOUNT"));

            salesOfTonsList.add(salesOfTons);
        }
    }

    @Override
    public List<ReportWithOrganization> getAll() {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        List<ReportWithOrganization> salesOfTonsList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL);
             ResultSet resultSet = preparedStatement.executeQuery()){
            resultSet(salesOfTonsList, resultSet);
        } catch (SQLException e) {
            LOGGER.error("SQLException in SalesOfTonsDaoImpl getAll", e);
        } finally {
            connectionPool.returnConnection(connection);
        }
        return salesOfTonsList;
    }

    @Override
    public ReportWithOrganization getByName(String name) {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        ReportWithOrganization salesOfTons = new ReportWithOrganization();
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_NAME)){
            preparedStatement.setString(1, name);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    salesOfTons.setId(resultSet.getLong("ID"));
                    salesOfTons.setDate(resultSet.getDate("DATE"));
                    salesOfTons.setOrganizationUnit(new OrganizationUnit(resultSet.getLong("ORGANIZATION_UNIT_ID"), resultSet.getString("OU.NAME")));
                    salesOfTons.setAmount(resultSet.getLong("AMOUNT"));
                }
            }
        } catch (SQLException e) {
            LOGGER.error("SQLException in SalesOfTonsDaoImpl getByDate", e);
        } finally {
            connectionPool.returnConnection(connection);
        }
        return salesOfTons;
    }

    @Override
    public void create(ReportWithOrganization salesOfTons) {
        updateOrCreate(salesOfTons, ADD_SALES_OF_TONS);
    }

    @Override
    public void update(ReportWithOrganization salesOfTons) {
        updateOrCreate(salesOfTons, UPDATE_SALES_OF_TONS);
    }

    @Override
    public void delete(ReportWithOrganization salesOfTons) {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        try(PreparedStatement preparedStatement = connection.prepareStatement(DELETE_SALES_OF_TONS)){
            preparedStatement.setDate(1, salesOfTons.getDate());
            preparedStatement.setLong(2, salesOfTons.getOrganizationUnit().getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("SQLException in SalesOfTonsDaoImpl delete", e);
        } finally {
            connectionPool.returnConnection(connection);
        }
    }

    @Override
    public void updateOrCreate(ReportWithOrganization salesOfTons, String sql) {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setLong(1, salesOfTons.getAmount());
            preparedStatement.setDate(2, salesOfTons.getDate());
            preparedStatement.setLong(3, salesOfTons.getOrganizationUnit().getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("SQLException in SalesOfTonsDaoImpl updateOrCreate", e);
        } finally {
            connectionPool.returnConnection(connection);
        }
    }
}
