package com.epam.financial_analytics.dao.impl;

import com.epam.financial_analytics.connection.ConnectionPool;
import com.epam.financial_analytics.dao.ExpenseInfoDao;
import com.epam.financial_analytics.dao.ReportWithOrganizationDao;
import com.epam.financial_analytics.entity.dictionary.*;
import com.epam.financial_analytics.entity.report_classes.ExpenseInfo;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ExpenseInfoDaoImpl implements ExpenseInfoDao<ExpenseInfo>, ReportWithOrganizationDao<ExpenseInfo> {
    private ConnectionPool connectionPool;
    private Connection connection;
    private static final Logger LOGGER = Logger.getLogger(ExpenseInfoDaoImpl.class);

    private static final String INNERJOIN = "AS EI INNER JOIN ORGANIZATION_UNIT AS OU ON EI.ORGANIZATION_UNIT_ID=OU.ID " +
            "INNER JOIN EXPENSE_TYPE AS ET ON EI.EXPENSE_TYPE_ID=ET.ID " +
            "INNER JOIN CURRENCY AS C ON EI.CURRENCY_ID=C.ID";

    private static final String ADD_EXPENSE_INFO = "INSERT INTO EXPENSE_INFO " +
            "(AMOUNT, DATE, ORGANIZATION_UNIT_ID, EXPENSE_TYPE_ID, CURRENCY_ID) VALUES (?,?,?,?,?)";
    private static final String GET_ALL = "SELECT * FROM EXPENSE_INFO " + INNERJOIN;
    private static final String GET_BY_DATE = "SELECT * FROM EXPENSE_INFO " + INNERJOIN + " WHERE DATE BETWEEN ? AND ?";
    private static final String GET_BY_ORGANIZATION_UNIT = "SELECT * FROM EXPENSE_INFO  " + INNERJOIN +
            " WHERE OU.NAME=?";
    private static final String GET_BY_DATE_AND_ORGANIZATION_UNIT = "SELECT * FROM EXPENSE_INFO  " + INNERJOIN +
            " WHERE OU.NAME = ? AND DATE BETWEEN ? AND ?";
    private static final String UPDATE_EXPENSE_INFO = "UPDATE EXPENSE_INFO SET AMOUNT = ? " +
            "WHERE DATE =? AND ORGANIZATION_UNIT_ID=? AND EXPENSE_TYPE_ID=? AND CURRENCY_ID = ?";
    private static final String DELETE_EXPENSE_INFO ="DELETE FROM EXPENSE_INFO " +
            "WHERE DATE = ? AND ORGANIZATION_UNIT_ID=? AND EXPENSE_TYPE_ID=?";
    private static final String GET_BY_EXPENSE = "SELECT * FROM EXPENSE_INFO  " + INNERJOIN + " WHERE ET.NAME=?";
    private static final String GET_BY_DATE_AND_EXPENSE = "SELECT * FROM EXPENSE_INFO  " + INNERJOIN +
            " WHERE ET.NAME = ? AND DATE BETWEEN ? AND ?";
    private static final String GET_BY_ORGANIZATION_UNIT_AND_EXPENSE = "SELECT * FROM EXPENSE_INFO " +  INNERJOIN +
            " WHERE OU.NAME=? AND ET.NAME=?";
    private static final String GET_BY_DATE_AND_ORGANIZATION_UNIT_AND_EXPENSE = "SELECT * FROM EXPENSE_INFO  "
            + INNERJOIN + " WHERE OU.NAME = ? AND ET.NAME =? AND DATE BETWEEN ? AND ?";
    private static final String GET_BY_NAME = "SELECT * FROM EXPENSE_INFO  " + INNERJOIN + " WHERE EI.NAME = ?";

    @Override
    public List<ExpenseInfo> getByDate(Date startDate, Date finishDate) {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        List<ExpenseInfo> expenseInfoList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_DATE)){
            preparedStatement.setDate(1, startDate);
            preparedStatement.setDate(2, finishDate);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                resultSet(expenseInfoList, resultSet);
            }
        } catch (SQLException e) {
            LOGGER.error("SQLException in ExpenseInfoDaoImpl getByDate", e);
        } finally {
            connectionPool.returnConnection(connection);
        }
        return expenseInfoList;
    }

    @Override
    public void resultSet(List<ExpenseInfo> expenseInfoList, ResultSet resultSet) throws SQLException{
        while (resultSet.next()) {
            ExpenseInfo expenseInfo = new ExpenseInfo();

            expenseInfo.setId(resultSet.getInt("ID"));
            expenseInfo.setDate(resultSet.getDate("DATE"));
            expenseInfo.setOrganizationUnit(new OrganizationUnit(resultSet.getInt("ORGANIZATION_UNIT_ID"), resultSet.getString("OU.NAME")));
            expenseInfo.setExpenseType(new ExpenseType(resultSet.getLong("EXPENSE_TYPE_ID"), resultSet.getString("ET.NAME")));
            expenseInfo.setCurrency(new Currency(resultSet.getLong("CURRENCY_ID"), resultSet.getString("C.NAME")));
            expenseInfo.setAmount(resultSet.getLong("AMOUNT"));

            expenseInfoList.add(expenseInfo);
        }
    }

    @Override
    public List<ExpenseInfo> getAll(){
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        List<ExpenseInfo> expenseInfoList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL);
             ResultSet resultSet = preparedStatement.executeQuery()){
            resultSet(expenseInfoList, resultSet);
        } catch (SQLException e) {
            LOGGER.error("SQLException in ExpenseInfoDaoImpl getAll", e);
        } finally {
            connectionPool.returnConnection(connection);
        }
        return expenseInfoList;
    }

    @Override
    public ExpenseInfo getByName(String name) {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        ExpenseInfo expenseInfo = new ExpenseInfo();
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_NAME)){
            preparedStatement.setString(1, name);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    expenseInfo.setId(resultSet.getInt("ID"));
                    expenseInfo.setDate(resultSet.getDate("DATE"));
                    expenseInfo.setOrganizationUnit(new OrganizationUnit(resultSet.getLong("ORGANIZATION_UNIT_ID"), resultSet.getString("OU.NAME")));
                    expenseInfo.setExpenseType(new ExpenseType(resultSet.getLong("EXPENSE_TYPE_ID"), resultSet.getString("ET.NAME")));
                    expenseInfo.setCurrency(new Currency(resultSet.getLong("CURRENCY_ID"), resultSet.getString("C.NAME")));
                    expenseInfo.setAmount(resultSet.getLong("AMOUNT"));
                }
            }
        } catch (SQLException e) {
            LOGGER.error("SQLException in ExpenseInfoDaoImpl getByDate", e);
        } finally {
            connectionPool.returnConnection(connection);
        }
        return expenseInfo;
    }

    @Override
    public void create(ExpenseInfo expenseInfo){
        updateOrCreate(expenseInfo, ADD_EXPENSE_INFO);
    }

    @Override
    public void update(ExpenseInfo expenseInfo){
        updateOrCreate(expenseInfo, UPDATE_EXPENSE_INFO);
    }

    @Override
    public void delete(ExpenseInfo expenseInfo){
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        try(PreparedStatement preparedStatement = connection.prepareStatement(DELETE_EXPENSE_INFO)){
            preparedStatement.setDate(1,expenseInfo.getDate());
            preparedStatement.setLong(2, expenseInfo.getOrganizationUnit().getId());
            preparedStatement.setLong(3, expenseInfo.getExpenseType().getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("SQLException in ExpenseInfoDaoImpl delete", e);
        } finally {
            connectionPool.returnConnection(connection);
        }
    }

    @Override
    public void updateOrCreate(ExpenseInfo expenseInfo, String sql){
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setLong(1, expenseInfo.getAmount());
            preparedStatement.setDate(2, expenseInfo.getDate());
            preparedStatement.setLong(3, expenseInfo.getOrganizationUnit().getId());
            preparedStatement.setLong(4, expenseInfo.getExpenseType().getId());
            preparedStatement.setLong(5, expenseInfo.getCurrency().getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("SQLException in ExpenseInfoDaoImpl updateOrCreate", e);
        } finally {
            connectionPool.returnConnection(connection);
        }
    }

    @Override
    public List<ExpenseInfo> getByExpense(String expenseType) {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        List<ExpenseInfo> expenseInfoList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_EXPENSE)){
            preparedStatement.setString(1, expenseType);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                resultSet(expenseInfoList, resultSet);
            }
        } catch (SQLException e) {
            LOGGER.error("SQLException in ExpenseInfoDaoImpl getByExpense", e);
        } finally {
            connectionPool.returnConnection(connection);
        }
        return expenseInfoList;
    }

    @Override
    public List<ExpenseInfo> getByDateAndExpense(Date startDate, Date finishDate, String expenseType) {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        List<ExpenseInfo> expenseInfoList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_DATE_AND_EXPENSE)){
            preparedStatement.setString(1, expenseType);
            preparedStatement.setDate(2, startDate);
            preparedStatement.setDate(3, finishDate);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                resultSet(expenseInfoList, resultSet);
            }
        } catch (SQLException e) {
            LOGGER.error("SQLException in ExpenseInfoDaoImpl getByDateAndExpense", e);
        } finally {
            connectionPool.returnConnection(connection);
        }
        return expenseInfoList;
    }

    @Override
    public List<ExpenseInfo> getByOrganizationUnitAndExpense(String organizationUnit, String expense) {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        List<ExpenseInfo> expenseInfoList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ORGANIZATION_UNIT_AND_EXPENSE)){
            preparedStatement.setString(1, organizationUnit);
            preparedStatement.setString(2, expense);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                resultSet(expenseInfoList, resultSet);
            }
        } catch (SQLException e) {
            LOGGER.error("SQLException in ExpenseInfoDaoImpl getByOrganizationUnitAndExpense", e);
        } finally {
            connectionPool.returnConnection(connection);
        }
        return expenseInfoList;
    }

    @Override
    public List<ExpenseInfo> getByDateAndOrganizationUnitAndExpense(Date startDate, Date finishDate, String organizationUnit, String expense) {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        List<ExpenseInfo> expenseInfoList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_DATE_AND_ORGANIZATION_UNIT_AND_EXPENSE)){
            preparedStatement.setString(1, organizationUnit);
            preparedStatement.setString(2, expense);
            preparedStatement.setDate(3, startDate);
            preparedStatement.setDate(4, finishDate);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                resultSet(expenseInfoList, resultSet);
            }
        } catch (SQLException e) {
            LOGGER.error("SQLException in ExpenseInfoDaoImpl getByDateAndOrganizationUnitAndExpense", e);
        } finally {
            connectionPool.returnConnection(connection);
        }
        return expenseInfoList;
    }

    @Override
    public List<ExpenseInfo> getByOrganizationUnit(String organizationUnit) {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        List<ExpenseInfo> expenseInfoList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ORGANIZATION_UNIT)){
            preparedStatement.setString(1, organizationUnit);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                resultSet(expenseInfoList, resultSet);
            }
        } catch (SQLException e) {
            LOGGER.error("SQLException in ExpenseInfoDaoIml getByOrganizationUnit", e);
        } finally {
            connectionPool.returnConnection(connection);
        }
        return expenseInfoList;
    }

    @Override
    public List<ExpenseInfo> getByDateAndOrganizationUnit(Date startDate, Date finishDate, String organizationUnit) {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        List<ExpenseInfo> expenseInfoList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_DATE_AND_ORGANIZATION_UNIT)){
            preparedStatement.setString(1, organizationUnit);
            preparedStatement.setDate(2, startDate);
            preparedStatement.setDate(3, finishDate);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                resultSet(expenseInfoList, resultSet);
            }
        } catch (SQLException e) {
            LOGGER.error("SQLException in ExpenseInfoDaoImpl getByDateAndOrganizationUnit", e);
        } finally {
            connectionPool.returnConnection(connection);
        }
        return expenseInfoList;
    }
}
