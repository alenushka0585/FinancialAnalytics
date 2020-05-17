package com.epam.financial_analytics.dao.impl;

import com.epam.financial_analytics.connection.ConnectionPool;
import com.epam.financial_analytics.dao.ProductGroupSalesDao;
import com.epam.financial_analytics.dao.ReportWithOrganizationDao;
import com.epam.financial_analytics.entity.dictionary.Currency;
import com.epam.financial_analytics.entity.dictionary.OrganizationUnit;
import com.epam.financial_analytics.entity.dictionary.ProductGroup;
import com.epam.financial_analytics.entity.report_classes.ProductGroupSales;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ValueAddedTaxSumDaoIml implements ReportWithOrganizationDao<ProductGroupSales>, ProductGroupSalesDao <ProductGroupSales> {
    private ConnectionPool connectionPool;
    private Connection connection;
    private static final Logger LOGGER = Logger.getLogger(ValueAddedTaxSumDaoIml.class);

    private static final String INNERJOIN = "AS SS INNER JOIN ORGANIZATION_UNIT AS OU ON SS.ORGANIZATION_UNIT_ID=OU.ID " +
            "INNER JOIN CURRENCY AS C ON SS.CURRENCY_ID=C.ID " + "INNER JOIN PRODUCT_GROUP AS P ON SS.PRODUCT_GROUP_ID=P.ID";
    private static final String ADD_VALUE_ADDED_TAX_SUM = "INSERT INTO VALUE_ADDED_TAX_SUM (AMOUNT, DATE, ORGANIZATION_UNIT_ID, CURRENCY_ID, PRODUCT_GROUP_ID) VALUES (?,?,?,?,?)";
    private static final String GET_ALL = "SELECT * FROM VALUE_ADDED_TAX_SUM " + INNERJOIN;
    private static final String GET_BY_DATE = "SELECT * FROM VALUE_ADDED_TAX_SUM " + INNERJOIN + " WHERE DATE BETWEEN ? AND ?";
    private static final String GET_BY_ORGANIZATION_UNIT = "SELECT * FROM VALUE_ADDED_TAX_SUM " + INNERJOIN + " WHERE OU.NAME = ?";
    private static final String GET_BY_DATE_AND_ORGANIZATION_UNIT = "SELECT * FROM VALUE_ADDED_TAX_SUM " + INNERJOIN +
            " WHERE OU.NAME = ? AND DATE BETWEEN ? AND ?";
    private static final String GET_BY_PRODUCT_GROUP = "SELECT * FROM VALUE_ADDED_TAX_SUM " + INNERJOIN + " WHERE P.NAME = ?";
    private static final String GET_BY_DATE_AND_PRODUCT_GROUP = "SELECT * FROM VALUE_ADDED_TAX_SUM " + INNERJOIN +
            " WHERE P.NAME = ? AND DATE BETWEEN ? AND ?";
    private static final String GET_BY_ORGANIZATION_UNIT_AND_PRODUCT_GROUP = "SELECT * FROM VALUE_ADDED_TAX_SUM " + INNERJOIN + " WHERE OU.NAME = ? AND P.NAME = ?";
    private static final String GET_BY_DATE_AND_ORGANIZATION_UNIT_AND_PRODUCT_GROUP = "SELECT * FROM VALUE_ADDED_TAX_SUM " + INNERJOIN +
            " WHERE OU.NAME = ? AND P.NAME = ? AND DATE BETWEEN ? AND ?";
    private static final String UPDATE_VALUE_ADDED_TAX_SUM = "UPDATE VALUE_ADDED_TAX_SUM SET AMOUNT = ? " +
            "WHERE DATE =? AND ORGANIZATION_UNIT_ID=? AND CURRENCY_ID = ? AND PRODUCT_GROUP_ID = ?";
    private static final String DELETE_VALUE_ADDED_TAX_SUM ="DELETE FROM VALUE_ADDED_TAX_SUM " +
            "WHERE DATE = ? AND ORGANIZATION_UNIT_ID = ? AND PRODUCT_GROUP_ID = ?";
    private static final String GET_BY_NAME = "SELECT * FROM VALUE_ADDED_TAX_SUM " + INNERJOIN + " WHERE SS.NAME = ?";

    @Override
    public List<ProductGroupSales> getByOrganizationUnit(String organizationUnit) {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        List<ProductGroupSales> vatSumList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ORGANIZATION_UNIT)){
            preparedStatement.setString(1, organizationUnit);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                resultSet(vatSumList, resultSet);
            }
        } catch (SQLException e) {
            LOGGER.error("SQLException in vatSumDaoIml getByOrganizationUnit", e);
        } finally {
            connectionPool.returnConnection(connection);
        }
        return vatSumList;
    }

    @Override
    public List<ProductGroupSales> getByDateAndOrganizationUnit(Date startDate, Date finishDate, String organizationUnit) {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        List<ProductGroupSales> vatSumList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_DATE_AND_ORGANIZATION_UNIT)){
            preparedStatement.setString(1, organizationUnit);
            preparedStatement.setDate(2, startDate);
            preparedStatement.setDate(3, finishDate);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                resultSet(vatSumList, resultSet);
            }
        } catch (SQLException e) {
            LOGGER.error("SQLException in vatSumDaoImpl getByDateAndOrganizationUnit", e);
        } finally {
            connectionPool.returnConnection(connection);
        }
        return vatSumList;
    }

    @Override
    public List<ProductGroupSales> getByDate(Date startDate, Date finishDate) {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        List<ProductGroupSales> vatSumList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_DATE)){
            preparedStatement.setDate(1, startDate);
            preparedStatement.setDate(2, finishDate);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                resultSet(vatSumList, resultSet);
            }
        } catch (SQLException e) {
            LOGGER.error("SQLException in vatSumDaoImpl getByDate", e);
        } finally {
            connectionPool.returnConnection(connection);
        }
        return vatSumList;
    }

    @Override
    public void resultSet(List <ProductGroupSales> vatSumList, ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            ProductGroupSales vatSum = new ProductGroupSales();

            vatSum.setId(resultSet.getInt("ID"));
            vatSum.setDate(resultSet.getDate("DATE"));
            vatSum.setOrganizationUnit(new OrganizationUnit(resultSet.getInt("ORGANIZATION_UNIT_ID"), resultSet.getString("OU.NAME")));
            vatSum.setCurrency(new Currency(resultSet.getInt("CURRENCY_ID"), resultSet.getString("C.NAME")));
            vatSum.setProductGroup(new ProductGroup(resultSet.getInt("PRODUCT_GROUP_ID"), resultSet.getString("P.NAME")));
            vatSum.setAmount(resultSet.getLong("AMOUNT"));

            vatSumList.add(vatSum);
        }
    }

    @Override
    public List<ProductGroupSales> getAll() {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        List<ProductGroupSales> vatSumList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL);
             ResultSet resultSet = preparedStatement.executeQuery()){
            resultSet(vatSumList, resultSet);
        } catch (SQLException e) {
            LOGGER.error("SQLException in vatSumDaoImpl getAll", e);
        } finally {
            connectionPool.returnConnection(connection);
        }
        return vatSumList;
    }

    @Override
    public ProductGroupSales getByName(String name) {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        ProductGroupSales vatSum = new ProductGroupSales();
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_NAME)){
            preparedStatement.setString(1, name);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    vatSum.setId(resultSet.getLong("ID"));
                    vatSum.setDate(resultSet.getDate("DATE"));
                    vatSum.setOrganizationUnit(new OrganizationUnit(resultSet.getLong("ORGANIZATION_UNIT_ID"), resultSet.getString("OU.NAME")));
                    vatSum.setCurrency(new Currency(resultSet.getLong("CURRENCY_ID"), resultSet.getString("C.NAME")));
                    vatSum.setProductGroup(new ProductGroup(resultSet.getLong("PRODUCT_GROUP_ID"), resultSet.getString("P.NAME")));
                    vatSum.setAmount(resultSet.getLong("AMOUNT"));
                }
            }
        } catch (SQLException e) {
            LOGGER.error("SQLException in vatSumDaoImpl getById", e);
        } finally {
            connectionPool.returnConnection(connection);
        }
        return vatSum;
    }

    @Override
    public void create(ProductGroupSales vatSum) {
        updateOrCreate(vatSum, ADD_VALUE_ADDED_TAX_SUM);
    }

    @Override
    public void update(ProductGroupSales vatSum) {
        updateOrCreate(vatSum, UPDATE_VALUE_ADDED_TAX_SUM);
    }

    @Override
    public void delete(ProductGroupSales vatSum) {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        try(PreparedStatement preparedStatement = connection.prepareStatement(DELETE_VALUE_ADDED_TAX_SUM)){
            preparedStatement.setDate(1,vatSum.getDate());
            preparedStatement.setLong(2, vatSum.getOrganizationUnit().getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("SQLException in vatSumDaoImpl delete", e);
        } finally {
            connectionPool.returnConnection(connection);
        }
    }

    @Override
    public void updateOrCreate(ProductGroupSales vatSum, String sql) {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setLong(1, vatSum.getAmount());
            preparedStatement.setDate(2, vatSum.getDate());
            preparedStatement.setLong(3, vatSum.getOrganizationUnit().getId());
            preparedStatement.setLong(4, vatSum.getCurrency().getId());
            preparedStatement.setLong(5, vatSum.getProductGroup().getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("SQLException in vatSumDaoImpl updateOrCreate", e);
        } finally {
            connectionPool.returnConnection(connection);
        }
    }

    @Override
    public List<ProductGroupSales> getByProductGroup(String productGroup) {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        List<ProductGroupSales> vatSumList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_PRODUCT_GROUP)){
            preparedStatement.setString(1, productGroup);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                resultSet(vatSumList, resultSet);
            }
        } catch (SQLException e) {
            LOGGER.error("SQLException in vatSumListDaoIml getByOrganizationUnit", e);
        } finally {
            connectionPool.returnConnection(connection);
        }
        return vatSumList;
    }

    @Override
    public List<ProductGroupSales> getByDateAndProductGroup(Date startDate, Date finishDate, String productGroup) {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        List<ProductGroupSales> vatSumList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_DATE_AND_PRODUCT_GROUP)){
            preparedStatement.setString(1, productGroup);
            preparedStatement.setDate(2, startDate);
            preparedStatement.setDate(3, finishDate);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                resultSet(vatSumList, resultSet);
            }
        } catch (SQLException e) {
            LOGGER.error("SQLException in vatSumDaoImpl getByDateAndOrganizationUnit", e);
        } finally {
            connectionPool.returnConnection(connection);
        }
        return vatSumList;
    }

    @Override
    public List<ProductGroupSales> getByOrganizationUnitAndProductGroup(String organizationUnit, String productGroup) {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        List<ProductGroupSales> vatSumList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ORGANIZATION_UNIT_AND_PRODUCT_GROUP)){
            preparedStatement.setString(1, organizationUnit);
            preparedStatement.setString(2, productGroup);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                resultSet(vatSumList, resultSet);
            }
        } catch (SQLException e) {
            LOGGER.error("SQLException in vatSumDaoImpl getByDateAndOrganizationUnit", e);
        } finally {
            connectionPool.returnConnection(connection);
        }
        return vatSumList;
    }

    @Override
    public List<ProductGroupSales> getByDateAndOrganizationUnitAndProductGroup(Date startDate, Date finishDate, String organizationUnit, String productGroup) {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        List<ProductGroupSales> vatSumList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_DATE_AND_ORGANIZATION_UNIT_AND_PRODUCT_GROUP)){
            preparedStatement.setString(1, organizationUnit);
            preparedStatement.setString(2, productGroup);
            preparedStatement.setDate(3, startDate);
            preparedStatement.setDate(4, finishDate);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                resultSet(vatSumList, resultSet);
            }
        } catch (SQLException e) {
            LOGGER.error("SQLException in vatSumDaoImpl getByDateAndOrganizationUnit", e);
        } finally {
            connectionPool.returnConnection(connection);
        }
        return vatSumList;
    }
}
