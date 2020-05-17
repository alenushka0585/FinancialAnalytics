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

public class MarginSumDaoIml implements ReportWithOrganizationDao<ProductGroupSales>, ProductGroupSalesDao <ProductGroupSales> {
    private ConnectionPool connectionPool;
    private Connection connection;
    private static final Logger LOGGER = Logger.getLogger(MarginSumDaoIml.class);

    private static final String INNERJOIN = "AS SS INNER JOIN ORGANIZATION_UNIT AS OU ON SS.ORGANIZATION_UNIT_ID=OU.ID " +
            "INNER JOIN CURRENCY AS C ON SS.CURRENCY_ID=C.ID " + "INNER JOIN PRODUCT_GROUP AS P ON SS.PRODUCT_GROUP_ID=P.ID";
    private static final String ADD_MARGIN_SUM = "INSERT INTO MARGIN_SUM (AMOUNT, DATE, ORGANIZATION_UNIT_ID, CURRENCY_ID, PRODUCT_GROUP_ID) VALUES (?,?,?,?,?)";
    private static final String GET_ALL = "SELECT * FROM MARGIN_SUM " + INNERJOIN;
    private static final String GET_BY_DATE = "SELECT * FROM MARGIN_SUM " + INNERJOIN + " WHERE DATE BETWEEN ? AND ?";
    private static final String GET_BY_ORGANIZATION_UNIT = "SELECT * FROM MARGIN_SUM " + INNERJOIN + " WHERE OU.NAME = ?";
    private static final String GET_BY_DATE_AND_ORGANIZATION_UNIT = "SELECT * FROM MARGIN_SUM " + INNERJOIN +
            " WHERE OU.NAME = ? AND DATE BETWEEN ? AND ?";
    private static final String GET_BY_PRODUCT_GROUP = "SELECT * FROM MARGIN_SUM " + INNERJOIN + " WHERE P.NAME = ?";
    private static final String GET_BY_DATE_AND_PRODUCT_GROUP = "SELECT * FROM MARGIN_SUM " + INNERJOIN +
            " WHERE P.NAME = ? AND DATE BETWEEN ? AND ?";
    private static final String GET_BY_ORGANIZATION_UNIT_AND_PRODUCT_GROUP = "SELECT * FROM MARGIN_SUM " + INNERJOIN + " WHERE OU.NAME = ? AND P.NAME = ?";
    private static final String GET_BY_DATE_AND_ORGANIZATION_UNIT_AND_PRODUCT_GROUP = "SELECT * FROM MARGIN_SUM " + INNERJOIN +
            " WHERE OU.NAME = ? AND P.NAME = ? AND DATE BETWEEN ? AND ?";
    private static final String UPDATE_MARGIN_SUM = "UPDATE MARGIN_SUM SET AMOUNT = ? " +
            "WHERE DATE =? AND ORGANIZATION_UNIT_ID=? AND CURRENCY_ID = ? AND PRODUCT_GROUP_ID = ?";
    private static final String DELETE_MARGIN_SUM ="DELETE FROM MARGIN_SUM " +
            "WHERE DATE = ? AND ORGANIZATION_UNIT_ID = ? AND PRODUCT_GROUP_ID = ?";
    private static final String GET_BY_NAME = "SELECT * FROM MARGIN_SUM " + INNERJOIN + " WHERE SS.NAME = ?";

    @Override
    public List<ProductGroupSales> getByOrganizationUnit(String organizationUnit) {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        List<ProductGroupSales> marginSumList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ORGANIZATION_UNIT)){
            preparedStatement.setString(1, organizationUnit);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                resultSet(marginSumList, resultSet);
            }
        } catch (SQLException e) {
            LOGGER.error("SQLException in MarginSumDaoIml getByOrganizationUnit", e);
        } finally {
            connectionPool.returnConnection(connection);
        }
        return marginSumList;
    }

    @Override
    public List<ProductGroupSales> getByDateAndOrganizationUnit(Date startDate, Date finishDate, String organizationUnit) {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        List<ProductGroupSales> marginSumList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_DATE_AND_ORGANIZATION_UNIT)){
            preparedStatement.setString(1, organizationUnit);
            preparedStatement.setDate(2, startDate);
            preparedStatement.setDate(3, finishDate);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                resultSet(marginSumList, resultSet);
            }
        } catch (SQLException e) {
            LOGGER.error("SQLException in MarginSumDaoImpl getByDateAndOrganizationUnit", e);
        } finally {
            connectionPool.returnConnection(connection);
        }
        return marginSumList;
    }

    @Override
    public List<ProductGroupSales> getByDate(Date startDate, Date finishDate) {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        List<ProductGroupSales> marginSumList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_DATE)){
            preparedStatement.setDate(1, startDate);
            preparedStatement.setDate(2, finishDate);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                resultSet(marginSumList, resultSet);
            }
        } catch (SQLException e) {
            LOGGER.error("SQLException in MarginSumDaoImpl getByDate", e);
        } finally {
            connectionPool.returnConnection(connection);
        }
        return marginSumList;
    }

    @Override
    public void resultSet(List <ProductGroupSales> marginSumList, ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            ProductGroupSales marginSum = new ProductGroupSales();

            marginSum.setId(resultSet.getInt("ID"));
            marginSum.setDate(resultSet.getDate("DATE"));
            marginSum.setOrganizationUnit(new OrganizationUnit(resultSet.getInt("ORGANIZATION_UNIT_ID"), resultSet.getString("OU.NAME")));
            marginSum.setCurrency(new Currency(resultSet.getInt("CURRENCY_ID"), resultSet.getString("C.NAME")));
            marginSum.setProductGroup(new ProductGroup(resultSet.getInt("PRODUCT_GROUP_ID"), resultSet.getString("P.NAME")));
            marginSum.setAmount(resultSet.getLong("AMOUNT"));

            marginSumList.add(marginSum);
        }
    }

    @Override
    public List<ProductGroupSales> getAll() {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        List<ProductGroupSales> marginSumList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL);
             ResultSet resultSet = preparedStatement.executeQuery()){
            resultSet(marginSumList, resultSet);
        } catch (SQLException e) {
            LOGGER.error("SQLException in MarginSumDaoImpl getAll", e);
        } finally {
            connectionPool.returnConnection(connection);
        }
        return marginSumList;
    }

    @Override
    public ProductGroupSales getByName(String name) {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        ProductGroupSales marginSum = new ProductGroupSales();
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_NAME)){
            preparedStatement.setString(1, name);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    marginSum.setId(resultSet.getLong("ID"));
                    marginSum.setDate(resultSet.getDate("DATE"));
                    marginSum.setOrganizationUnit(new OrganizationUnit(resultSet.getLong("ORGANIZATION_UNIT_ID"), resultSet.getString("OU.NAME")));
                    marginSum.setCurrency(new Currency(resultSet.getLong("CURRENCY_ID"), resultSet.getString("C.NAME")));
                    marginSum.setProductGroup(new ProductGroup(resultSet.getLong("PRODUCT_GROUP_ID"), resultSet.getString("P.NAME")));
                    marginSum.setAmount(resultSet.getLong("AMOUNT"));
                }
            }
        } catch (SQLException e) {
            LOGGER.error("SQLException in MarginSumDaoImpl getById", e);
        } finally {
            connectionPool.returnConnection(connection);
        }
        return marginSum;
    }

    @Override
    public void create(ProductGroupSales marginSum) {
        updateOrCreate(marginSum, ADD_MARGIN_SUM);
    }

    @Override
    public void update(ProductGroupSales marginSum) {
        updateOrCreate(marginSum, UPDATE_MARGIN_SUM);
    }

    @Override
    public void delete(ProductGroupSales marginSum) {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        try(PreparedStatement preparedStatement = connection.prepareStatement(DELETE_MARGIN_SUM)){
            preparedStatement.setDate(1,marginSum.getDate());
            preparedStatement.setLong(2, marginSum.getOrganizationUnit().getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("SQLException in MarginSumDaoImpl delete", e);
        } finally {
            connectionPool.returnConnection(connection);
        }
    }

    @Override
    public void updateOrCreate(ProductGroupSales marginSum, String sql) {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setLong(1, marginSum.getAmount());
            preparedStatement.setDate(2, marginSum.getDate());
            preparedStatement.setLong(3, marginSum.getOrganizationUnit().getId());
            preparedStatement.setLong(4, marginSum.getCurrency().getId());
            preparedStatement.setLong(5, marginSum.getProductGroup().getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("SQLException in MarginSumDaoImpl updateOrCreate", e);
        } finally {
            connectionPool.returnConnection(connection);
        }
    }

    @Override
    public List<ProductGroupSales> getByProductGroup(String productGroup) {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        List<ProductGroupSales> marginSumList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_PRODUCT_GROUP)){
            preparedStatement.setString(1, productGroup);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                resultSet(marginSumList, resultSet);
            }
        } catch (SQLException e) {
            LOGGER.error("SQLException in MarginSumListDaoIml getByOrganizationUnit", e);
        } finally {
            connectionPool.returnConnection(connection);
        }
        return marginSumList;
    }

    @Override
    public List<ProductGroupSales> getByDateAndProductGroup(Date startDate, Date finishDate, String productGroup) {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        List<ProductGroupSales> marginSumList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_DATE_AND_PRODUCT_GROUP)){
            preparedStatement.setString(1, productGroup);
            preparedStatement.setDate(2, startDate);
            preparedStatement.setDate(3, finishDate);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                resultSet(marginSumList, resultSet);
            }
        } catch (SQLException e) {
            LOGGER.error("SQLException in MarginSumDaoImpl getByDateAndOrganizationUnit", e);
        } finally {
            connectionPool.returnConnection(connection);
        }
        return marginSumList;
    }

    @Override
    public List<ProductGroupSales> getByOrganizationUnitAndProductGroup(String organizationUnit, String productGroup) {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        List<ProductGroupSales> marginSumList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ORGANIZATION_UNIT_AND_PRODUCT_GROUP)){
            preparedStatement.setString(1, organizationUnit);
            preparedStatement.setString(2, productGroup);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                resultSet(marginSumList, resultSet);
            }
        } catch (SQLException e) {
            LOGGER.error("SQLException in MarginSumDaoImpl getByDateAndOrganizationUnit", e);
        } finally {
            connectionPool.returnConnection(connection);
        }
        return marginSumList;
    }

    @Override
    public List<ProductGroupSales> getByDateAndOrganizationUnitAndProductGroup(Date startDate, Date finishDate, String organizationUnit, String productGroup) {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        List<ProductGroupSales> marginSumList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_DATE_AND_ORGANIZATION_UNIT_AND_PRODUCT_GROUP)){
            preparedStatement.setString(1, organizationUnit);
            preparedStatement.setString(2, productGroup);
            preparedStatement.setDate(3, startDate);
            preparedStatement.setDate(4, finishDate);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                resultSet(marginSumList, resultSet);
            }
        } catch (SQLException e) {
            LOGGER.error("SQLException in MarginSumDaoImpl getByDateAndOrganizationUnit", e);
        } finally {
            connectionPool.returnConnection(connection);
        }
        return marginSumList;
    }
}
