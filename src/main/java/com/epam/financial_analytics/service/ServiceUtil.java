package com.epam.financial_analytics.service;

import com.epam.financial_analytics.dao.ReportWithOrganizationDao;
import com.epam.financial_analytics.dao.impl.*;
import com.epam.financial_analytics.entity.dictionary.Currency;
import com.epam.financial_analytics.entity.dictionary.OrganizationUnit;
import com.epam.financial_analytics.entity.report_classes.ReportWithOrganization;
import com.epam.financial_analytics.entity.report_classes.ReportWithOrganizationAndCurrency;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;

import java.sql.Date;

import static com.epam.financial_analytics.service.ServiceConstant.*;

public class ServiceUtil {
    private static final Logger LOGGER = Logger.getLogger(ServiceUtil.class);


    public static ReportWithOrganizationDao getDao(String kindOfReport){
     ReportWithOrganizationDao dao;
      if (kindOfReport.equals(NUMBER_OF_STUFF)){
          dao = new NumberOfStuffDaoImpl();
      } else if (kindOfReport.equals(LABOUR_COST)){
          dao = new LabourCostDaoImpl();
      } else if (kindOfReport.equals(SALES_OF_SQUARE_METRES)){
          dao = new SalesOfSquareMetresDaoImpl();
      } else if (kindOfReport.equals(SALES_OF_TONS)){
          dao = new SalesOfTonsDaoImpl();
      } else {
          dao = new RevenueDaoImpl();
      }
     return dao;
    }

    public static ReportWithOrganization fillReport(String kindOfReport, Date date, long amountKaraganda, OrganizationUnit organizationUnitKaraganda, Currency currency){
        ReportWithOrganization report;

        if (kindOfReport.equals(NUMBER_OF_STUFF) || kindOfReport.equals(SALES_OF_SQUARE_METRES) || kindOfReport.equals(SALES_OF_TONS)) {
            report = new ReportWithOrganization(date, amountKaraganda, organizationUnitKaraganda);
        } else {
            report = new ReportWithOrganizationAndCurrency(date, amountKaraganda, organizationUnitKaraganda, currency);
        }
        return report;
    }

    public static String md5Apache(String st) {
        String md5Hex = DigestUtils.md5Hex(st);

        return md5Hex;
    }
}
