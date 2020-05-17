package com.epam.financial_analytics.dao;

import com.epam.financial_analytics.entity.report_classes.CurrencyExchangeRate;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface CurrencyExchangeRateDao {
    List<CurrencyExchangeRate> getAll();

    CurrencyExchangeRate getByName(String name);

    void create(CurrencyExchangeRate entity);

    void update(CurrencyExchangeRate entity);

    void delete(CurrencyExchangeRate entity);

    void updateOrCreate (CurrencyExchangeRate entity, String sql);

    List<CurrencyExchangeRate> getByDate(Date startDate, Date finishDate);

    void resultSet(List<CurrencyExchangeRate> list, ResultSet resultSet) throws SQLException;

    List<CurrencyExchangeRate> getByCurrency(String name);

    List<CurrencyExchangeRate> getByCurrencyAndDate(String name, Date startDate, Date finishDate);
}
