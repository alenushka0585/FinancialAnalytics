package com.epam.financial_analytics.dao.impl;

import com.epam.financial_analytics.connection.ConnectionPool;
import com.epam.financial_analytics.dao.ReportWithOrganizationDao;
import com.epam.financial_analytics.entity.dictionary.OrganizationUnit;
import com.epam.financial_analytics.entity.report_classes.ReportWithOrganization;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SalesOfSquareMetresDaoImpl implements ReportWithOrganizationDao<ReportWithOrganization> {
    private ConnectionPool connectionPool;
    private Connection connection;
    private static final Logger LOGGER = Logger.getLogger(SalesOfSquareMetresDaoImpl.class);

    private static final String INNER_JOIN = "AS NS INNER JOIN ORGANIZATION_UNIT AS OU ON NS.ORGANIZATION_UNIT_ID=OU.ID";
    private static final String ADD_SALES_OF_SQUARE_METRES = "INSERT INTO SALES_OF_SQUARE_METRES " +
            "(AMOUNT, DATE, ORGANIZATION_UNIT_ID) VALUES (?,?,?)";
    private static final String GET_ALL = "SELECT * FROM SALES_OF_SQUARE_METRES " + INNER_JOIN;
    private static final String GET_BY_DATE = "SELECT * FROM SALES_OF_SQUARE_METRES "+ INNER_JOIN + " WHERE DATE BETWEEN ? AND ?";
    private static final String GET_BY_ORGANIZATION_UNIT = "SELECT * FROM SALES_OF_SQUARE_METRES " + INNER_JOIN + " WHERE OU.NAME = ?";
    private static final String GET_BY_DATE_AND_ORGANIZATION_UNIT = "SELECT * FROM " +
            "SALES_OF_SQUARE_METRES " + INNER_JOIN + " WHERE OU.NAME = ? AND DATE BETWEEN ? AND ?";
    private static final String UPDATE_SALES_OF_SQUARE_METRES = "UPDATE SALES_OF_SQUARE_METRES " +
            "SET AMOUNT = ? WHERE DATE = ? AND ORGANIZATION_UNIT_ID=?";
    private static final String DELETE_SALES_OF_SQUARE_METRES ="DELETE FROM SALES_OF_SQUARE_METRES " +
            "WHERE DATE =? AND ORGANIZATION_UNIT_ID=?";
    private static final String GET_BY_NAME = "SELECT * FROM SALES_OF_SQUARE_METRES " + INNER_JOIN + " WHERE NS.NAME = ?";

    @Override
    public List<ReportWithOrganization> getByOrganizationUnit(String organizationUnit) {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        List<ReportWithOrganization> salesOfSquareMetresList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ORGANIZATION_UNIT)){
            preparedStatement.setString(1, organizationUnit);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                resultSet(salesOfSquareMetresList, resultSet);
            }
        } catch (SQLException e) {
            LOGGER.error("SQLException in SalesOfSquareMetresDaoIml getByOrganizationUnit", e);
        } finally {
            connectionPool.returnConnection(connection);
        }
        return salesOfSquareMetresList;
    }

    @Override
    public List<ReportWithOrganization> getByDateAndOrganizationUnit(Date startDate, Date finishDate, String organizationUnit) {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        List<ReportWithOrganization> salesOfSquareMetresList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_DATE_AND_ORGANIZATION_UNIT)){
            preparedStatement.setString(1, organizationUnit);
            preparedStatement.setDate(2, startDate);
            preparedStatement.setDate(3, finishDate);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                resultSet(salesOfSquareMetresList, resultSet);
            }
        } catch (SQLException e) {
            LOGGER.error("SQLException in SalesOfSquareMetresDaoImpl getByDateAndOrganizationUnit", e);
        } finally {
            connectionPool.returnConnection(connection);
        }
        return salesOfSquareMetresList;
    }

    @Override
    public List<ReportWithOrganization> getByDate(Date startDate, Date finishDate) {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        List<ReportWithOrganization> salesOfSquareMetresList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_DATE)){
            preparedStatement.setDate(1, startDate);
            preparedStatement.setDate(2, finishDate);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                resultSet(salesOfSquareMetresList, resultSet);
            }
        } catch (SQLException e) {
            LOGGER.error("SQLException in SalesOfSquareMetresDaoImpl getByDate", e);
        } finally {
            connectionPool.returnConnection(connection);
        }
        return salesOfSquareMetresList;
    }

    @Override
    public void resultSet(List<ReportWithOrganization> salesOfSquareMetresList, ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            ReportWithOrganization salesOfSquareMetres = new ReportWithOrganization();

            salesOfSquareMetres.setId(resultSet.getInt("ID"));
            salesOfSquareMetres.setDate(resultSet.getDate("DATE"));
            salesOfSquareMetres.setOrganizationUnit(new OrganizationUnit(resultSet.getInt("ORGANIZATION_UNIT_ID"), resultSet.getString("OU.NAME")));
            salesOfSquareMetres.setAmount(resultSet.getLong("AMOUNT"));

            salesOfSquareMetresList.add(salesOfSquareMetres);
        }
    }

    @Override
    public List<ReportWithOrganization> getAll() {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        List<ReportWithOrganization> salesOfSquareMetresList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL);
             ResultSet resultSet = preparedStatement.executeQuery()){
            resultSet(salesOfSquareMetresList, resultSet);
        } catch (SQLException e) {
            LOGGER.error("SQLException in SalesOfSquareMetresDaoImpl getAll", e);
        } finally {
            connectionPool.returnConnection(connection);
        }
        return salesOfSquareMetresList;
    }

    @Override
    public ReportWithOrganization getByName(String name) {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        ReportWithOrganization salesOfSquareMetres = new ReportWithOrganization();
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_NAME)){
            preparedStatement.setString(1, name);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    salesOfSquareMetres.setId(resultSet.getLong("ID"));
                    salesOfSquareMetres.setDate(resultSet.getDate("DATE"));
                    salesOfSquareMetres.setOrganizationUnit(new OrganizationUnit(resultSet.getLong("ORGANIZATION_UNIT_ID"), resultSet.getString("OU.NAME")));
                    salesOfSquareMetres.setAmount(resultSet.getLong("AMOUNT"));
                }
            }
        } catch (SQLException e) {
            LOGGER.error("SQLException in SalesOfSquareMetresDaoImpl getByDate", e);
        } finally {
            connectionPool.returnConnection(connection);
        }
        return salesOfSquareMetres;
    }

    @Override
    public void create(ReportWithOrganization salesOfSquareMetres) {
        updateOrCreate(salesOfSquareMetres, ADD_SALES_OF_SQUARE_METRES);
    }

    @Override
    public void update(ReportWithOrganization salesOfSquareMetres) {
        updateOrCreate(salesOfSquareMetres, UPDATE_SALES_OF_SQUARE_METRES);
    }

    @Override
    public void delete(ReportWithOrganization salesOfSquareMetres) {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        try(PreparedStatement preparedStatement = connection.prepareStatement(DELETE_SALES_OF_SQUARE_METRES)){
            preparedStatement.setDate(1, salesOfSquareMetres.getDate());
            preparedStatement.setLong(2, salesOfSquareMetres.getOrganizationUnit().getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("SQLException in SalesOfSquareMetresDaoImpl delete", e);
        } finally {
            connectionPool.returnConnection(connection);
        }
    }

    @Override
    public void updateOrCreate(ReportWithOrganization salesOfSquareMetres, String sql) {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setLong(1, salesOfSquareMetres.getAmount());
            preparedStatement.setDate(2, salesOfSquareMetres.getDate());
            preparedStatement.setLong(3, salesOfSquareMetres.getOrganizationUnit().getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("SQLException in SalesOfSquareMetresDaoImpl updateOrCreate", e);
        } finally {
            connectionPool.returnConnection(connection);
        }
    }
}
