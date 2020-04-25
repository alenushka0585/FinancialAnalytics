package com.epam.financial_analytics.dao.impl;

import com.epam.financial_analytics.connection.ConnectionPool;
import com.epam.financial_analytics.dao.ReportWithOrganizationDao;
import com.epam.financial_analytics.entity.dictionary.OrganizationUnit;
import com.epam.financial_analytics.entity.report_classes.SquareMetresAndTonnsSales;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SquareMetresAndTonnsSalesDaoImpl implements ReportWithOrganizationDao<SquareMetresAndTonnsSales> {
    private ConnectionPool connectionPool;
    private Connection connection;
    private static final Logger LOGGER = Logger.getLogger(SquareMetresAndTonnsSalesDaoImpl.class);

    private static final String INNERJOIN = "AS SS INNER JOIN ORGANIZATION_UNIT AS OU ON SS.ORGANIZATION_UNIT_ID=OU.ID";
    private static final String ADD_SALES_OF_SQUARE_METRES_AND_TONNS = "INSERT INTO SALES_OF_SQUARE_METRES_AND_TONNS " +
            "(SQUARE_METRES_AMOUNT, TONNS_AMOUNT, ID, DATE, ORGANIZATION_UNIT_ID) VALUES (?,?,?,?,?)";
    private static final String GET_ALL = "SELECT * FROM SALES_OF_SQUARE_METRES_AND_TONNS " + INNERJOIN;
    private static final String GET_BY_DATE = "SELECT * FROM SALES_OF_SQUARE_METRES_AND_TONNS " + INNERJOIN + " WHERE DATE BETWEEN ? AND ?";
    private static final String GET_BY_ORGANIZATION_UNIT= "SELECT * FROM SALES_OF_SQUARE_METRES_AND_TONNS " + INNERJOIN + " WHERE OU.NAME=?";
    private static final String GET_BY_DATE_AND_ORGANIZATION_UNIT = "SELECT * FROM SALES_OF_SQUARE_METRES_AND_TONNS " + INNERJOIN +
            " WHERE OU.NAME = ? AND DATE BETWEEN ? AND ?";
    private static final String UPDATE_SALES_OF_SQUARE_METRES_AND_TONNS = "UPDATE SALES_OF_SQUARE_METRES_AND_TONNS " +
            "SET SQUARE_METRES_AMOUNT = ?, TONNS_AMOUNT = ? WHERE ID = ? AND DATE = ? AND ORGANIZATION_UNIT_ID=?";
    private static final String DELETE_SALES_OF_SQUARE_METRES_AND_TONNS ="DELETE FROM SALES_OF_SQUARE_METRES_AND_TONNS " +
            "WHERE DATE=? AND ORGANIZATION_UNIT_ID=?";
    private static final String GET_BY_ID = "SELECT * FROM SALES_OF_SQUARE_METRES_AND_TONNS " + INNERJOIN + " WHERE SS.ID = ?";

    @Override
    public List<SquareMetresAndTonnsSales> getByOrganizationUnit(String organizationUnit) {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        List<SquareMetresAndTonnsSales> squareMetresAndTonnsSalesList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ORGANIZATION_UNIT)){
            preparedStatement.setString(1, organizationUnit);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                resultSet(squareMetresAndTonnsSalesList, resultSet);
            }
        } catch (SQLException e) {
            LOGGER.error("SQLException in SquareMetresAndTonnsSalesDaoIml getByOrganizationUnit", e);
        } finally {
            connectionPool.returnConnection(connection);
        }
        return squareMetresAndTonnsSalesList;
    }

    @Override
    public List<SquareMetresAndTonnsSales> getByDateAndOrganizationUnit(Date startDate, Date finishDate, String organizationUnit) {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        List<SquareMetresAndTonnsSales> squareMetresAndTonnsSalesList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_DATE_AND_ORGANIZATION_UNIT)){
            preparedStatement.setString(1, organizationUnit);
            preparedStatement.setDate(2, startDate);
            preparedStatement.setDate(3, finishDate);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                resultSet(squareMetresAndTonnsSalesList, resultSet);
            }
        } catch (SQLException e) {
            LOGGER.error("SQLException in SquareMetresAndTonnsSalesDaoImpl getByDateAndOrganizationUnit", e);
        } finally {
            connectionPool.returnConnection(connection);
        }
        return squareMetresAndTonnsSalesList;
    }

    @Override
    public List<SquareMetresAndTonnsSales> getByDate(Date startDate, Date finishDate) {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        List<SquareMetresAndTonnsSales> squareMetresAndTonnsSalesList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_DATE)){
            preparedStatement.setDate(1, startDate);
            preparedStatement.setDate(2, finishDate);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                resultSet(squareMetresAndTonnsSalesList, resultSet);
            }
        } catch (SQLException e) {
            LOGGER.error("SQLException in SquareMetresAndTonnsSalesDaoImpl getByDate", e);
        } finally {
            connectionPool.returnConnection(connection);
        }
        return squareMetresAndTonnsSalesList;
    }

    @Override
    public void resultSet(List<SquareMetresAndTonnsSales> squareMetresAndTonnsSalesList, ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            SquareMetresAndTonnsSales squareMetresAndTonnsSales = new SquareMetresAndTonnsSales();

            squareMetresAndTonnsSales.setId(resultSet.getLong("ID"));
            squareMetresAndTonnsSales.setDate(resultSet.getDate("DATE"));
            squareMetresAndTonnsSales.setOrganizationUnit(new OrganizationUnit(resultSet.getLong("ORGANIZATION_UNIT_ID"), resultSet.getString("OU.NAME")));
            squareMetresAndTonnsSales.setSquareMetresAmount(resultSet.getLong("SQUARE_METRES_AMOUNT"));
            squareMetresAndTonnsSales.setTonnsAmount(resultSet.getLong("TONNS_AMOUNT"));

            squareMetresAndTonnsSalesList.add(squareMetresAndTonnsSales);
        }
    }

    @Override
    public List<SquareMetresAndTonnsSales> getAll() {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        List<SquareMetresAndTonnsSales> squareMetresAndTonnsSalesList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL);
             ResultSet resultSet = preparedStatement.executeQuery()){
            resultSet(squareMetresAndTonnsSalesList, resultSet);
        } catch (SQLException e) {
            LOGGER.error("SQLException in SquareMetresAndTonnsSalesDaoImpl getAll", e);
        } finally {
            connectionPool.returnConnection(connection);
        }
        return squareMetresAndTonnsSalesList;
    }

    @Override
    public SquareMetresAndTonnsSales getById(long id) {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        SquareMetresAndTonnsSales squareMetresAndTonnsSales = new SquareMetresAndTonnsSales();
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID)){
            preparedStatement.setLong(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    squareMetresAndTonnsSales.setId(resultSet.getLong("ID"));
                    squareMetresAndTonnsSales.setDate(resultSet.getDate("DATE"));
                    squareMetresAndTonnsSales.setOrganizationUnit(new OrganizationUnit(resultSet.getLong("ORGANIZATION_UNIT_ID"), resultSet.getString("OU.NAME")));
                    squareMetresAndTonnsSales.setSquareMetresAmount(resultSet.getLong("SQUARE_METRES_AMOUNT"));
                    squareMetresAndTonnsSales.setTonnsAmount(resultSet.getLong("TONNS_AMOUNT"));
                }
            }
        } catch (SQLException e) {
            LOGGER.error("SQLException in SquareMetresAndTonnsSalesDaoImpl getById", e);
        } finally {
            connectionPool.returnConnection(connection);
        }
        return squareMetresAndTonnsSales;
    }

    @Override
    public void create(SquareMetresAndTonnsSales squareMetresAndTonnsSales) {
        updateOrCreate(squareMetresAndTonnsSales, ADD_SALES_OF_SQUARE_METRES_AND_TONNS);
    }

    @Override
    public void update(SquareMetresAndTonnsSales squareMetresAndTonnsSales) {
        updateOrCreate(squareMetresAndTonnsSales, UPDATE_SALES_OF_SQUARE_METRES_AND_TONNS);
    }

    @Override
    public void delete(SquareMetresAndTonnsSales squareMetresAndTonnsSales) {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        try(PreparedStatement preparedStatement = connection.prepareStatement(DELETE_SALES_OF_SQUARE_METRES_AND_TONNS)){
            preparedStatement.setDate(1, squareMetresAndTonnsSales.getDate());
            preparedStatement.setLong(2, squareMetresAndTonnsSales.getOrganizationUnit().getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("SQLException in SquareMetresAndTonnsSalesDaoImpl delete", e);
        } finally {
            connectionPool.returnConnection(connection);
        }
    }

    @Override
    public void updateOrCreate(SquareMetresAndTonnsSales squareMetresAndTonnsSales, String sql) {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setLong(1, squareMetresAndTonnsSales.getSquareMetresAmount());
            preparedStatement.setLong(2, squareMetresAndTonnsSales.getTonnsAmount());
            preparedStatement.setLong(3, squareMetresAndTonnsSales.getId());
            preparedStatement.setDate(4, squareMetresAndTonnsSales.getDate());
            preparedStatement.setLong(5, squareMetresAndTonnsSales.getOrganizationUnit().getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("SQLException in SquareMetresAndTonnsSalesDaoImpl updateOrCreate", e);
        } finally {
            connectionPool.returnConnection(connection);
        }
    }
}
