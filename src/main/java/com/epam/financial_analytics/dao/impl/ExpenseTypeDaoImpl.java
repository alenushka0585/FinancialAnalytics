package com.epam.financial_analytics.dao.impl;

import com.epam.financial_analytics.connection.ConnectionPool;
import com.epam.financial_analytics.dao.BaseDao;
import com.epam.financial_analytics.entity.dictionary.ExpenseType;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ExpenseTypeDaoImpl implements BaseDao<ExpenseType> {
    private ConnectionPool connectionPool;
    private Connection connection;
    private static final Logger LOGGER = Logger.getLogger(ExpenseTypeDaoImpl.class);

    private static final String ADD_EXPENSE_TYPE = "INSERT INTO EXPENSE_TYPE (NAME, ID) VALUES (?,?)";
    private static final String GET_ALL = "SELECT * FROM EXPENSE_TYPE";
    private static final String GET_BY_NAME = "SELECT ID, NAME FROM EXPENSE_TYPE WHERE NAME=?";
    private static final String UPDATE_EXPENSE_TYPE = "UPDATE EXPENSE_TYPE SET NAME = ? WHERE ID = ?";
    private static final String DELETE_EXPENSE_TYPE ="DELETE FROM EXPENSE_TYPE WHERE ID = ?";

    @Override
    public List<ExpenseType> getAll(){
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        List<ExpenseType> expenseTypeList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL);
             ResultSet resultSet = preparedStatement.executeQuery()){
            while (resultSet.next()) {
                ExpenseType expenseType = new ExpenseType();
                expenseType.setId(resultSet.getLong("ID"));
                expenseType.setName(resultSet.getString("NAME"));

                expenseTypeList.add(expenseType);
            }
        } catch (SQLException e) {
            LOGGER.error("SQLException in ExpenseTypeDaoImpl getAll", e);
        } finally {
            connectionPool.returnConnection(connection);
        }
        return expenseTypeList;
    }

    @Override
    public ExpenseType getByName(String name){
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        ExpenseType expenseType = new ExpenseType();

        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_NAME)){
            preparedStatement.setString(1, name);

            try(ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    expenseType.setId(resultSet.getLong("ID"));
                    expenseType.setName(resultSet.getString("NAME"));
                }
            }
        } catch (SQLException e) {
            LOGGER.error("SQLException in ExpenseTypeDaoImpl getById", e);
        } finally {
            connectionPool.returnConnection(connection);
        }
        return expenseType;
    }

    @Override
    public void create(ExpenseType expenseType){
        updateOrCreate(expenseType, ADD_EXPENSE_TYPE);
    }

    @Override
    public void update(ExpenseType expenseType){
        updateOrCreate(expenseType, UPDATE_EXPENSE_TYPE);
    }

    @Override
    public void delete(ExpenseType expenseType){
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        try(PreparedStatement preparedStatement = connection.prepareStatement(DELETE_EXPENSE_TYPE)){
            preparedStatement.setLong(1, expenseType.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("SQLException in ExpenseTypeDaoImpl delete", e);
        } finally {
            connectionPool.returnConnection(connection);
        }
    }

    @Override
    public void updateOrCreate(ExpenseType expenseType, String sql){
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, expenseType.getName());
            preparedStatement.setLong(2, expenseType.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("SQLException in ExpenseTypeDaoImpl updateOrCreate", e);
        } finally {
            connectionPool.returnConnection(connection);
        }
    }
}
