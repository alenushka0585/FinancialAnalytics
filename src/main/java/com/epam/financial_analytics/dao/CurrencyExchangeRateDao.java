package com.epam.financial_analytics.dao;

import com.epam.financial_analytics.entity.report_classes.CurrencyExchangeRate;

import java.sql.Date;
import java.util.List;

public interface CurrencyExchangeRateDao extends ReportDao<CurrencyExchangeRate> {
    List<CurrencyExchangeRate> getByCurrency(String name);

    List<CurrencyExchangeRate> getByCurrencyAndDate(String name, Date startDate, Date finishDate);
}
