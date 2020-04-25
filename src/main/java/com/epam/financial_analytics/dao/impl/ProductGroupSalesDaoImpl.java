package com.epam.financial_analytics.dao.impl;

import com.epam.financial_analytics.connection.ConnectionPool;
import com.epam.financial_analytics.dao.ProductGroupSalesDao;
import com.epam.financial_analytics.entity.dictionary.*;
import com.epam.financial_analytics.entity.report_classes.ProductGroupSales;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductGroupSalesDaoImpl implements ProductGroupSalesDao {
    private ConnectionPool connectionPool;
    private Connection connection;
    private static final Logger LOGGER = Logger.getLogger(ProductGroupSalesDaoImpl.class);

    private static final String INNERJOIN = "AS PGS INNER JOIN ORGANIZATION_UNIT AS OU ON PGS.ORGANIZATION_UNIT_ID=OU.ID " +
            "INNER JOIN PRODUCT_GROUP AS PG ON PGS.PRODUCT_GROUP_ID=PG.ID " +
            "INNER JOIN CURRENCY AS C ON PGS.CURRENCY_ID=C.ID";
    private static final String ADD_PRODUCT_GROUP_SALES = "INSERT INTO PRODUCT_GROUP_SALES " +
            "(SALES_SUM, VALUE_ADDED_TAX_SUM, MARGIN_SUM, ID, DATE, ORGANIZATION_UNIT_ID, PRODUCT_GROUP_ID, CURRENCY_ID) " +
            "VALUES (?,?,?,?,?,?,?,?)";
    private static final String GET_ALL = "SELECT * FROM PRODUCT_GROUP_SALES " + INNERJOIN;
    private static final String GET_BY_DATE = "SELECT * FROM PRODUCT_GROUP_SALES "+ INNERJOIN + " WHERE DATE BETWEEN ? AND ?";
    private static final String GET_BY_ORGANIZATION_UNIT = "SELECT * FROM PRODUCT_GROUP_SALES "+ INNERJOIN + " WHERE OU.NAME=?";
    private static final String GET_BY_DATE_AND_ORGANIZATION_UNIT = "SELECT * FROM PRODUCT_GROUP_SALES " + INNERJOIN +
            " WHERE OU.NAME = ? AND DATE BETWEEN ? AND ?";
    private static final String UPDATE_PRODUCT_GROUP_SALES = "UPDATE PRODUCT_GROUP_SALES SET SALES_SUM = ?, " +
            "VALUE_ADDED_TAX_SUM = ?, MARGIN_SUM = ? WHERE ID=? AND DATE=? AND ORGANIZATION_UNIT_ID=? AND PRODUCT_GROUP_ID=? AND CURRENCY_ID=?";
    private static final String DELETE_PRODUCT_GROUP_SALES ="DELETE FROM PRODUCT_GROUP_SALES " +
            "WHERE DATE=? AND ORGANIZATION_UNIT_ID=? AND PRODUCT_GROUP_ID=?";
    private static final String GET_BY_PRODUCT_GROUP = "SELECT * FROM PRODUCT_GROUP_SALES " + INNERJOIN + " WHERE PG.NAME=?";
    private static final String GET_BY_DATE_AND_PRODUCT_GROUP = "SELECT * FROM PRODUCT_GROUP_SALES " + INNERJOIN +
            " WHERE PG.NAME = ? AND DATE BETWEEN ? AND ?";
    private static final String GET_BY_ORGANIZATION_UNIT_AND_PRODUCT_GROUP = "SELECT * FROM PRODUCT_GROUP_SALES " + INNERJOIN +
            " WHERE OU.NAME=? AND PG.NAME=?";
    private static final String GET_BY_DATE_AND_ORGANIZATION_UNIT_AND_PRODUCT_GROUP = "SELECT * FROM PRODUCT_GROUP_SALES " + INNERJOIN +
            " WHERE OU.NAME = ? AND PG.NAME =? AND DATE BETWEEN ? AND ?";
    private static final String GET_BY_ID = "SELECT * FROM PRODUCT_GROUP_SALES "+ INNERJOIN +  " WHERE PGS.ID = ?";

    @Override
    public List<ProductGroupSales> getByProductGroup(String productGroup) {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        List<ProductGroupSales> productGroupSalesList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_PRODUCT_GROUP)){
            preparedStatement.setString(1, productGroup);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                resultSet(productGroupSalesList, resultSet);
            }
        } catch (SQLException e) {
            LOGGER.error("SQLException in ProductGroupSalesDaoImpl getByProductGroup", e);
        } finally {
            connectionPool.returnConnection(connection);
        }
        return productGroupSalesList;
    }

    @Override
    public List<ProductGroupSales> getByDateAndProductGroup(Date startDate, Date finishDate, String productGroup) {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        List<ProductGroupSales> productGroupSalesList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_DATE_AND_PRODUCT_GROUP)){
            preparedStatement.setString(1, productGroup);
            preparedStatement.setDate(2, startDate);
            preparedStatement.setDate(3, finishDate);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                resultSet(productGroupSalesList, resultSet);
            }
        } catch (SQLException e) {
            LOGGER.error("SQLException in ProductGroupSalesDaoImpl getByDateAndProductGroup", e);
        } finally {
            connectionPool.returnConnection(connection);
        }
        return productGroupSalesList;
    }

    @Override
    public List<ProductGroupSales> getByOrganizationUnitAndProductGroup(String organizationUnit, String productGroup) {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        List<ProductGroupSales> productGroupSalesList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ORGANIZATION_UNIT_AND_PRODUCT_GROUP)){
            preparedStatement.setString(1, organizationUnit);
            preparedStatement.setString(2, productGroup);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                resultSet(productGroupSalesList, resultSet);
            }
        } catch (SQLException e) {
            LOGGER.error("SQLException in ProductGroupSalesDaoImpl getByOrganizationUnitAndProductGroup", e);
        } finally {
            connectionPool.returnConnection(connection);
        }
        return productGroupSalesList;
    }

    @Override
    public List<ProductGroupSales> getByDateAndOrganizationUnitAndProductGroup(Date startDate, Date finishDate, String organizationUnit, String productGroup) {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        List<ProductGroupSales> productGroupSalesList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_DATE_AND_ORGANIZATION_UNIT_AND_PRODUCT_GROUP)){
            preparedStatement.setString(1, organizationUnit);
            preparedStatement.setString(2, productGroup);
            preparedStatement.setDate(3, startDate);
            preparedStatement.setDate(4, finishDate);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                resultSet(productGroupSalesList, resultSet);
            }
        } catch (SQLException e) {
            LOGGER.error("SQLException in ProductGroupSalesDaoImpl getByDateAndOrganizationUnitAndProductGroup", e);
        } finally {
            connectionPool.returnConnection(connection);
        }
        return productGroupSalesList;
    }

    @Override
    public List<ProductGroupSales> getByOrganizationUnit(String organizationUnit) {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        List<ProductGroupSales> productGroupSalesList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ORGANIZATION_UNIT)){
            preparedStatement.setString(1, organizationUnit);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                resultSet(productGroupSalesList, resultSet);
            }
        } catch (SQLException e) {
            LOGGER.error("SQLException in ProductGroupSalesDaoIml getByOrganizationUnit", e);
        } finally {
            connectionPool.returnConnection(connection);
        }
        return productGroupSalesList;
    }

    @Override
    public List<ProductGroupSales> getByDateAndOrganizationUnit(Date startDate, Date finishDate, String organizationUnit) {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        List<ProductGroupSales> productGroupSalesList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_DATE_AND_ORGANIZATION_UNIT)){
            preparedStatement.setString(1, organizationUnit);
            preparedStatement.setDate(2, startDate);
            preparedStatement.setDate(3, finishDate);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                resultSet(productGroupSalesList, resultSet);
            }
        } catch (SQLException e) {
            LOGGER.error("SQLException in ProductGroupSalesDaoImpl getByDateAndOrganizationUnit", e);
        } finally {
            connectionPool.returnConnection(connection);
        }
        return productGroupSalesList;
    }

    @Override
    public List<ProductGroupSales> getByDate(Date startDate, Date finishDate) {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        List<ProductGroupSales> productGroupSalesList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_DATE)){
            preparedStatement.setDate(1, startDate);
            preparedStatement.setDate(2, finishDate);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                resultSet(productGroupSalesList, resultSet);
            }
        } catch (SQLException e) {
            LOGGER.error("SQLException in ProductGroupSalesDaoImpl getByDate", e);
        } finally {
            connectionPool.returnConnection(connection);
        }
        return productGroupSalesList;
    }

    @Override
    public void resultSet(List<ProductGroupSales> productGroupSalesList, ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            ProductGroupSales productGroupSales = new ProductGroupSales();

            productGroupSales.setId(resultSet.getLong("ID"));
            productGroupSales.setDate(resultSet.getDate("DATE"));
            productGroupSales.setOrganizationUnit(new OrganizationUnit(resultSet.getLong("ORGANIZATION_UNIT_ID"), resultSet.getString("OU.NAME")));
            productGroupSales.setCurrency(new Currency(resultSet.getLong("CURRENCY_ID"), resultSet.getString("C.NAME")));
            productGroupSales.setProductGroup(new ProductGroup(resultSet.getLong("PRODUCT_GROUP_ID"), resultSet.getString("PG.NAME")));
            productGroupSales.setSalesSum(resultSet.getLong("SALES_SUM"));
            productGroupSales.setValueAddedTaxSum(resultSet.getLong("VALUE_ADDED_TAX_SUM"));
            productGroupSales.setMarginSum(resultSet.getLong("MARGIN_SUM"));

            productGroupSalesList.add(productGroupSales);
        }
    }

    @Override
    public List<ProductGroupSales> getAll() {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        List<ProductGroupSales> productGroupSalesList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL);
             ResultSet resultSet = preparedStatement.executeQuery()){
            resultSet(productGroupSalesList, resultSet);
        } catch (SQLException e) {
            LOGGER.error("SQLException in ProductGroupSalesDaoImpl getAll", e);
        } finally {
            connectionPool.returnConnection(connection);
        }
        return productGroupSalesList;
    }

    @Override
    public ProductGroupSales getById(long id) {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        ProductGroupSales productGroupSales = new ProductGroupSales();
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID)){
            preparedStatement.setLong(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    productGroupSales.setId(resultSet.getLong("ID"));
                    productGroupSales.setDate(resultSet.getDate("DATE"));
                    productGroupSales.setOrganizationUnit(new OrganizationUnit(resultSet.getLong("ORGANIZATION_UNIT_ID"), resultSet.getString("OU.NAME")));
                    productGroupSales.setCurrency(new Currency(resultSet.getLong("CURRENCY_ID"), resultSet.getString("C.NAME")));
                    productGroupSales.setProductGroup(new ProductGroup(resultSet.getLong("PRODUCT_GROUP_ID"), resultSet.getString("PG.NAME")));
                    productGroupSales.setSalesSum(resultSet.getLong("SALES_SUM"));
                    productGroupSales.setValueAddedTaxSum(resultSet.getLong("VALUE_ADDED_TAX_SUM"));
                    productGroupSales.setMarginSum(resultSet.getLong("MARGIN_SUM"));
                }
            }
        } catch (SQLException e) {
            LOGGER.error("SQLException in ProductGroupSalesDaoImpl getById", e);
        } finally {
            connectionPool.returnConnection(connection);
        }
        return productGroupSales;
    }

    @Override
    public void create(ProductGroupSales productGroupSales) {
        updateOrCreate(productGroupSales, ADD_PRODUCT_GROUP_SALES);
    }

    @Override
    public void update(ProductGroupSales productGroupSales) {
        updateOrCreate(productGroupSales, UPDATE_PRODUCT_GROUP_SALES);
    }

    @Override
    public void delete(ProductGroupSales productGroupSales) {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        try(PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PRODUCT_GROUP_SALES)){
            preparedStatement.setDate(1,productGroupSales.getDate());
            preparedStatement.setLong(2, productGroupSales.getOrganizationUnit().getId());
            preparedStatement.setLong(3, productGroupSales.getProductGroup().getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("SQLException in ProductGroupSalesDaoImpl delete", e);
        } finally {
            connectionPool.returnConnection(connection);
        }
    }

    @Override
    public void updateOrCreate(ProductGroupSales productGroupSales, String sql) {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setLong(1, productGroupSales.getSalesSum());
            preparedStatement.setLong(2, productGroupSales.getValueAddedTaxSum());
            preparedStatement.setLong(3, productGroupSales.getMarginSum());
            preparedStatement.setLong(4, productGroupSales.getId());
            preparedStatement.setDate(5, productGroupSales.getDate());
            preparedStatement.setLong(6, productGroupSales.getOrganizationUnit().getId());
            preparedStatement.setLong(7, productGroupSales.getProductGroup().getId());
            preparedStatement.setLong(8, productGroupSales.getCurrency().getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("SQLException in ProductGroupSalesDaoImpl updateOrCreate", e);
        } finally {
            connectionPool.returnConnection(connection);
        }
    }
}
