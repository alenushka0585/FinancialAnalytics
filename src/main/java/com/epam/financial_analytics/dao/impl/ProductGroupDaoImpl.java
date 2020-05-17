package com.epam.financial_analytics.dao.impl;

import com.epam.financial_analytics.connection.ConnectionPool;
import com.epam.financial_analytics.dao.BaseDao;
import com.epam.financial_analytics.entity.dictionary.ProductGroup;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductGroupDaoImpl implements BaseDao<ProductGroup>{
    private ConnectionPool connectionPool;
    private Connection connection;
    private static final Logger LOGGER = Logger.getLogger(ProductGroupDaoImpl.class);

    private static final String ADD_PRODUCT_GROUP = "INSERT INTO PRODUCT_GROUP (NAME, ID) VALUES (?,?)";
    private static final String GET_ALL = "SELECT * FROM PRODUCT_GROUP";
    private static final String GET_BY_NAME = "SELECT ID, NAME FROM PRODUCT_GROUP WHERE NAME=?";
    private static final String UPDATE_PRODUCT_GROUP = "UPDATE PRODUCT_GROUP SET NAME = ? WHERE ID = ?";
    private static final String DELETE_PRODUCT_GROUP ="DELETE FROM PRODUCT_GROUP WHERE ID = ?";

    @Override
    public List<ProductGroup> getAll(){
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        List<ProductGroup> productGroupList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL);
             ResultSet resultSet = preparedStatement.executeQuery()){
            while (resultSet.next()) {
                ProductGroup productGroup = new ProductGroup();
                productGroup.setId(resultSet.getLong("ID"));
                productGroup.setName(resultSet.getString("NAME"));

                productGroupList.add(productGroup);
            }
        } catch (SQLException e) {
            LOGGER.error("SQLException in ProductGroupDaoImpl getAll", e);
        } finally {
            connectionPool.returnConnection(connection);
        }
        return productGroupList;
    }

    @Override
    public ProductGroup getByName(String name){
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        ProductGroup productGroup = new ProductGroup();

        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_NAME)) {
            preparedStatement.setString(1, name);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    productGroup.setId(resultSet.getLong("ID"));
                    productGroup.setName(resultSet.getString("NAME"));
                }
            }
        } catch (SQLException e) {
            LOGGER.error("SQLException in ProductGroupDaoImpl getById", e);
        } finally {
            connectionPool.returnConnection(connection);
        }
        return productGroup;
    }

    @Override
    public void create(ProductGroup productGroup){
        updateOrCreate(productGroup, ADD_PRODUCT_GROUP);
    }

    @Override
    public void update(ProductGroup productGroup){
        updateOrCreate(productGroup, UPDATE_PRODUCT_GROUP);
    }

    @Override
    public void delete(ProductGroup productGroup){
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        try(PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PRODUCT_GROUP)){
            preparedStatement.setLong(1, productGroup.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("SQLException in ProductGroupDaoImpl delete", e);
        } finally {
            connectionPool.returnConnection(connection);
        }
    }

    @Override
    public void updateOrCreate(ProductGroup productGroup, String sql){
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, productGroup.getName());
            preparedStatement.setLong(2, productGroup.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("SQLException in ProductGroupDaoImpl updateOrCreate", e);
        } finally {
            connectionPool.returnConnection(connection);
        }
    }
}
