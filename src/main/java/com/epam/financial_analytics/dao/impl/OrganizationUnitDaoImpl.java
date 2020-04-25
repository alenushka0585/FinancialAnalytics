package com.epam.financial_analytics.dao.impl;

import com.epam.financial_analytics.connection.ConnectionPool;
import com.epam.financial_analytics.dao.BaseDao;
import com.epam.financial_analytics.entity.dictionary.OrganizationUnit;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrganizationUnitDaoImpl implements BaseDao<OrganizationUnit> {
    private ConnectionPool connectionPool;
    private Connection connection;
    private static final Logger LOGGER = Logger.getLogger(OrganizationUnitDaoImpl.class);

    private static final String ADD_ORGANIZATION_UNIT = "INSERT INTO ORGANIZATION_UNIT (NAME, ID) VALUES (?,?)";
    private static final String GET_ALL = "SELECT * FROM ORGANIZATION_UNIT";
    private static final String GET_BY_ID = "SELECT ID, NAME FROM ORGANIZATION_UNIT WHERE ID=?";
    private static final String UPDATE_ORGANIZATION_UNIT = "UPDATE ORGANIZATION_UNIT SET NAME = ? WHERE ID = ?";
    private static final String DELETE_ORGANIZATION_UNIT ="DELETE FROM ORGANIZATION_UNIT WHERE ID = ?";

    @Override
    public List<OrganizationUnit> getAll(){
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        List<OrganizationUnit> organizationUnitList = new ArrayList<>();
        try(PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL);
            ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                OrganizationUnit organizationUnit = new OrganizationUnit();
                organizationUnit.setId(resultSet.getInt("ID"));
                organizationUnit.setName(resultSet.getString("NAME"));

                organizationUnitList.add(organizationUnit);
            }
        } catch (SQLException e) {
            LOGGER.error("SQLException in OrganizationUnitDaoImlp getAll", e);
        } finally {
            connectionPool.returnConnection(connection);
        }
        return organizationUnitList;
    }

    @Override
    public OrganizationUnit getById(long id){
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        OrganizationUnit organizationUnit = new OrganizationUnit();

        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID)){
            preparedStatement.setLong(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    organizationUnit.setId(resultSet.getLong("ID"));
                    organizationUnit.setName(resultSet.getString("NAME"));
                }
            }
        } catch (SQLException e) {
            LOGGER.error("SQLException in OrganizationUnitDaoImlp getById", e);
        } finally {
            connectionPool.returnConnection(connection);
        }
        return organizationUnit;
    }

    @Override
    public void create(OrganizationUnit organizationUnit){
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        updateOrCreate(organizationUnit, ADD_ORGANIZATION_UNIT);
    }

    @Override
    public void update(OrganizationUnit organizationUnit){
        updateOrCreate(organizationUnit, UPDATE_ORGANIZATION_UNIT);
    }

    @Override
    public void delete(OrganizationUnit organizationUnit){
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        try(PreparedStatement preparedStatement = connection.prepareStatement(DELETE_ORGANIZATION_UNIT)){
            preparedStatement.setLong(1, organizationUnit.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("SQLException in OrganizationUnitDaoImlp delete", e);
        } finally {
            connectionPool.returnConnection(connection);
        }
    }

    @Override
    public void updateOrCreate(OrganizationUnit organizationUnit, String sql){
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, organizationUnit.getName());
            preparedStatement.setLong(2, organizationUnit.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("SQLException in OrganizationUnitDaoImlp updateOrCreate", e);
        } finally {
            connectionPool.returnConnection(connection);
        }
    }
}
