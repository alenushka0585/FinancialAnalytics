package com.epam.financial_analytics.dao;

import com.epam.financial_analytics.entity.abstract_classes.Report;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface ReportDao<M extends Report> extends BaseDao<M> {
    List<M> getByDate(Date startDate, Date finishDate);

    void resultSet(List<M> list, ResultSet resultSet) throws SQLException;
}
