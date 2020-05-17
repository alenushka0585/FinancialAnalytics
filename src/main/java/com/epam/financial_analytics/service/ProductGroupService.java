package com.epam.financial_analytics.service;

import com.epam.financial_analytics.dao.impl.*;
import com.epam.financial_analytics.entity.dictionary.*;
import com.epam.financial_analytics.entity.report_classes.ProductGroupSales;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;

import static com.epam.financial_analytics.service.ServiceConstant.*;

public class ProductGroupService implements Service {
    private ProductGroupDaoImpl productGroupDao = new ProductGroupDaoImpl();
    private SalesSumDaoIml salesSumDaoIml = new SalesSumDaoIml();
    private MarginSumDaoIml marginSumDaoIml = new MarginSumDaoIml();
    private ValueAddedTaxSumDaoIml valueAddedTaxSumDaoIml = new ValueAddedTaxSumDaoIml();
    private OrganizationUnitDaoImpl organizationUnitDao = new OrganizationUnitDaoImpl();
    private CurrencyDaoImpl currencyDao = new CurrencyDaoImpl();
    RequestDispatcher requestDispatcher;

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        Date date = Date.valueOf(req.getParameter(DATE));
        String kindOfReport = req.getParameter(KIND_OF_REPORT);
        Currency currency = currencyDao.getByName(req.getParameter(CURRENCY));
        OrganizationUnit organizationUnit = organizationUnitDao.getByName(req.getParameter(ORGANIZATION_UNIT));

        ProductGroup ovp = productGroupDao.getByName(req.getParameter(OVP));
        ProductGroup tsp = productGroupDao.getByName(req.getParameter(TSP));
        ProductGroup vs = productGroupDao.getByName(req.getParameter(VS));
        ProductGroup seo = productGroupDao.getByName(req.getParameter(SEO));
        ProductGroup enk = productGroupDao.getByName(req.getParameter(ENK));
        ProductGroup ebk = productGroupDao.getByName(req.getParameter(EBK));
        ProductGroup spps = productGroupDao.getByName(req.getParameter(SPPS));
        ProductGroup fk = productGroupDao.getByName(req.getParameter(FK));
        ProductGroup other = productGroupDao.getByName(req.getParameter(OTHER));
        ProductGroup goods = productGroupDao.getByName(req.getParameter(GOODS));

        ProductGroupSales salesSumOVP = new ProductGroupSales(date,Long.parseLong(req.getParameter(SALES_SUM_OVP)),organizationUnit,currency,ovp);
        ProductGroupSales salesSumTSP = new ProductGroupSales(date,Long.parseLong(req.getParameter(SALES_SUM_TSP)),organizationUnit,currency,tsp);
        ProductGroupSales salesSumVS = new ProductGroupSales(date,Long.parseLong(req.getParameter(SALES_SUM_VS)),organizationUnit,currency,vs);
        ProductGroupSales salesSumSEO = new ProductGroupSales(date,Long.parseLong(req.getParameter(SALES_SUM_SEO)),organizationUnit,currency,seo);
        ProductGroupSales salesSumENK = new ProductGroupSales(date,Long.parseLong(req.getParameter(SALES_SUM_ENK)),organizationUnit,currency,enk);
        ProductGroupSales salesSumEBK = new ProductGroupSales(date,Long.parseLong(req.getParameter(SALES_SUM_EBK)),organizationUnit,currency,ebk);
        ProductGroupSales salesSumSPPS = new ProductGroupSales(date,Long.parseLong(req.getParameter(SALES_SUM_SPPS)),organizationUnit,currency,spps);
        ProductGroupSales salesSumFK = new ProductGroupSales(date,Long.parseLong(req.getParameter(SALES_SUM_FK)),organizationUnit,currency,fk);
        ProductGroupSales salesSumOther = new ProductGroupSales(date,Long.parseLong(req.getParameter(SALES_SUM_OTHER)),organizationUnit,currency,other);
        ProductGroupSales salesSumGoods = new ProductGroupSales(date,Long.parseLong(req.getParameter(SALES_SUM_GOODS)),organizationUnit,currency,goods);

        ProductGroupSales marginSumOVP = new ProductGroupSales(date,Long.parseLong(req.getParameter(MARGIN_SUM_OVP)),organizationUnit,currency,ovp);
        ProductGroupSales marginSumTSP = new ProductGroupSales(date,Long.parseLong(req.getParameter(MARGIN_SUM_TSP)),organizationUnit,currency,tsp);
        ProductGroupSales marginSumVS = new ProductGroupSales(date,Long.parseLong(req.getParameter(MARGIN_SUM_VS)),organizationUnit,currency,vs);
        ProductGroupSales marginSumSEO = new ProductGroupSales(date,Long.parseLong(req.getParameter(MARGIN_SUM_SEO)),organizationUnit,currency,seo);
        ProductGroupSales marginSumENK = new ProductGroupSales(date,Long.parseLong(req.getParameter(MARGIN_SUM_ENK)),organizationUnit,currency,enk);
        ProductGroupSales marginSumEBK = new ProductGroupSales(date,Long.parseLong(req.getParameter(MARGIN_SUM_EBK)),organizationUnit,currency,ebk);
        ProductGroupSales marginSumSPPS = new ProductGroupSales(date,Long.parseLong(req.getParameter(MARGIN_SUM_SPPS)),organizationUnit,currency,spps);
        ProductGroupSales marginSumFK = new ProductGroupSales(date,Long.parseLong(req.getParameter(MARGIN_SUM_FK)),organizationUnit,currency,fk);
        ProductGroupSales marginSumOther = new ProductGroupSales(date,Long.parseLong(req.getParameter(MARGIN_SUM_OTHER)),organizationUnit,currency,other);
        ProductGroupSales marginSumGoods = new ProductGroupSales(date,Long.parseLong(req.getParameter(MARGIN_SUM_GOODS)),organizationUnit,currency,goods);

        ProductGroupSales valueAddedSumOVP = new ProductGroupSales(date,Long.parseLong(req.getParameter(VALUE_ADDED_SUM_OVP)),organizationUnit,currency,ovp);
        ProductGroupSales valueAddedSumTSP = new ProductGroupSales(date,Long.parseLong(req.getParameter(VALUE_ADDED_SUM_TSP)),organizationUnit,currency,tsp);
        ProductGroupSales valueAddedSumVS = new ProductGroupSales(date,Long.parseLong(req.getParameter(VALUE_ADDED_SUM_VS)),organizationUnit,currency,vs);
        ProductGroupSales valueAddedSumSEO = new ProductGroupSales(date,Long.parseLong(req.getParameter(VALUE_ADDED_SUM_SEO)),organizationUnit,currency,seo);
        ProductGroupSales valueAddedSumENK = new ProductGroupSales(date,Long.parseLong(req.getParameter(VALUE_ADDED_SUM_ENK)),organizationUnit,currency,enk);
        ProductGroupSales valueAddedSumEBK = new ProductGroupSales(date,Long.parseLong(req.getParameter(VALUE_ADDED_SUM_EBK)),organizationUnit,currency,ebk);
        ProductGroupSales valueAddedSumSPPS = new ProductGroupSales(date,Long.parseLong(req.getParameter(VALUE_ADDED_SUM_SPPS)),organizationUnit,currency,spps);
        ProductGroupSales valueAddedSumFK = new ProductGroupSales(date,Long.parseLong(req.getParameter(VALUE_ADDED_SUM_FK)),organizationUnit,currency,fk);
        ProductGroupSales valueAddedSumOther = new ProductGroupSales(date,Long.parseLong(req.getParameter(VALUE_ADDED_SUM_OTHER)),organizationUnit,currency,other);
        ProductGroupSales valueAddedSumGoods = new ProductGroupSales(date,Long.parseLong(req.getParameter(VALUE_ADDED_SUM_GOODS)),organizationUnit,currency,goods);

        HttpSession session = req.getSession();
        User user = (User)session.getAttribute(USER);
        String role = user.getRole().getName();

        if (role.equals(ADMINISTRATOR)){
            salesSumDaoIml.create(salesSumOVP);
            salesSumDaoIml.create(salesSumTSP);
            salesSumDaoIml.create(salesSumVS);
            salesSumDaoIml.create(salesSumSEO);
            salesSumDaoIml.create(salesSumENK);
            salesSumDaoIml.create(salesSumEBK);
            salesSumDaoIml.create(salesSumSPPS);
            salesSumDaoIml.create(salesSumFK);
            salesSumDaoIml.create(salesSumOther);
            salesSumDaoIml.create(salesSumGoods);

            marginSumDaoIml.create(marginSumOVP);
            marginSumDaoIml.create(marginSumTSP);
            marginSumDaoIml.create(marginSumVS);
            marginSumDaoIml.create(marginSumSEO);
            marginSumDaoIml.create(marginSumENK);
            marginSumDaoIml.create(marginSumEBK);
            marginSumDaoIml.create(marginSumSPPS);
            marginSumDaoIml.create(marginSumFK);
            marginSumDaoIml.create(marginSumOther);
            marginSumDaoIml.create(marginSumGoods);

            valueAddedTaxSumDaoIml.create(valueAddedSumOVP);
            valueAddedTaxSumDaoIml.create(valueAddedSumTSP);
            valueAddedTaxSumDaoIml.create(valueAddedSumVS);
            valueAddedTaxSumDaoIml.create(valueAddedSumSEO);
            valueAddedTaxSumDaoIml.create(valueAddedSumENK);
            valueAddedTaxSumDaoIml.create(valueAddedSumEBK);
            valueAddedTaxSumDaoIml.create(valueAddedSumSPPS);
            valueAddedTaxSumDaoIml.create(valueAddedSumFK);
            valueAddedTaxSumDaoIml.create(valueAddedSumOther);
            valueAddedTaxSumDaoIml.create(valueAddedSumGoods);

            req.setAttribute(KIND_OF_REPORT, kindOfReport);
            req.setAttribute(DATE, date);
            req.setAttribute(CURRENCY, currency);
            req.setAttribute(ORGANIZATION_UNIT, organizationUnit);

            req.setAttribute(SALES_SUM_OVP, salesSumDaoIml.getByDateAndOrganizationUnitAndProductGroup(date, date, organizationUnit.getName(), ovp.getName()).get(FIRST_INDEX));
            req.setAttribute(SALES_SUM_TSP, salesSumDaoIml.getByDateAndOrganizationUnitAndProductGroup(date, date, organizationUnit.getName(), tsp.getName()).get(FIRST_INDEX));
            req.setAttribute(SALES_SUM_VS, salesSumDaoIml.getByDateAndOrganizationUnitAndProductGroup(date, date, organizationUnit.getName(), vs.getName()).get(FIRST_INDEX));
            req.setAttribute(SALES_SUM_SEO, salesSumDaoIml.getByDateAndOrganizationUnitAndProductGroup(date, date, organizationUnit.getName(), seo.getName()).get(FIRST_INDEX));
            req.setAttribute(SALES_SUM_ENK, salesSumDaoIml.getByDateAndOrganizationUnitAndProductGroup(date, date, organizationUnit.getName(), enk.getName()).get(FIRST_INDEX));
            req.setAttribute(SALES_SUM_EBK, salesSumDaoIml.getByDateAndOrganizationUnitAndProductGroup(date, date, organizationUnit.getName(), ebk.getName()).get(FIRST_INDEX));
            req.setAttribute(SALES_SUM_SPPS, salesSumDaoIml.getByDateAndOrganizationUnitAndProductGroup(date, date, organizationUnit.getName(), spps.getName()).get(FIRST_INDEX));
            req.setAttribute(SALES_SUM_FK, salesSumDaoIml.getByDateAndOrganizationUnitAndProductGroup(date, date, organizationUnit.getName(), fk.getName()).get(FIRST_INDEX));
            req.setAttribute(SALES_SUM_OTHER, salesSumDaoIml.getByDateAndOrganizationUnitAndProductGroup(date, date, organizationUnit.getName(), other.getName()).get(FIRST_INDEX));
            req.setAttribute(SALES_SUM_GOODS, salesSumDaoIml.getByDateAndOrganizationUnitAndProductGroup(date, date, organizationUnit.getName(), goods.getName()).get(FIRST_INDEX));

            req.setAttribute(MARGIN_SUM_OVP, marginSumDaoIml.getByDateAndOrganizationUnitAndProductGroup(date, date, organizationUnit.getName(), ovp.getName()).get(FIRST_INDEX));
            req.setAttribute(MARGIN_SUM_TSP, marginSumDaoIml.getByDateAndOrganizationUnitAndProductGroup(date, date, organizationUnit.getName(), tsp.getName()).get(FIRST_INDEX));
            req.setAttribute(MARGIN_SUM_VS, marginSumDaoIml.getByDateAndOrganizationUnitAndProductGroup(date, date, organizationUnit.getName(), vs.getName()).get(FIRST_INDEX));
            req.setAttribute(MARGIN_SUM_SEO, marginSumDaoIml.getByDateAndOrganizationUnitAndProductGroup(date, date, organizationUnit.getName(), seo.getName()).get(FIRST_INDEX));
            req.setAttribute(MARGIN_SUM_ENK, marginSumDaoIml.getByDateAndOrganizationUnitAndProductGroup(date, date, organizationUnit.getName(), enk.getName()).get(FIRST_INDEX));
            req.setAttribute(MARGIN_SUM_EBK, marginSumDaoIml.getByDateAndOrganizationUnitAndProductGroup(date, date, organizationUnit.getName(), ebk.getName()).get(FIRST_INDEX));
            req.setAttribute(MARGIN_SUM_SPPS, marginSumDaoIml.getByDateAndOrganizationUnitAndProductGroup(date, date, organizationUnit.getName(), spps.getName()).get(FIRST_INDEX));
            req.setAttribute(MARGIN_SUM_FK, marginSumDaoIml.getByDateAndOrganizationUnitAndProductGroup(date, date, organizationUnit.getName(), fk.getName()).get(FIRST_INDEX));
            req.setAttribute(MARGIN_SUM_OTHER, marginSumDaoIml.getByDateAndOrganizationUnitAndProductGroup(date, date, organizationUnit.getName(), other.getName()).get(FIRST_INDEX));
            req.setAttribute(MARGIN_SUM_GOODS, marginSumDaoIml.getByDateAndOrganizationUnitAndProductGroup(date, date, organizationUnit.getName(), goods.getName()).get(FIRST_INDEX));

            req.setAttribute(VALUE_ADDED_SUM_OVP, valueAddedTaxSumDaoIml.getByDateAndOrganizationUnitAndProductGroup(date, date, organizationUnit.getName(), ovp.getName()).get(FIRST_INDEX));
            req.setAttribute(VALUE_ADDED_SUM_TSP, valueAddedTaxSumDaoIml.getByDateAndOrganizationUnitAndProductGroup(date, date, organizationUnit.getName(), tsp.getName()).get(FIRST_INDEX));
            req.setAttribute(VALUE_ADDED_SUM_VS, valueAddedTaxSumDaoIml.getByDateAndOrganizationUnitAndProductGroup(date, date, organizationUnit.getName(), vs.getName()).get(FIRST_INDEX));
            req.setAttribute(VALUE_ADDED_SUM_SEO, valueAddedTaxSumDaoIml.getByDateAndOrganizationUnitAndProductGroup(date, date, organizationUnit.getName(), seo.getName()).get(FIRST_INDEX));
            req.setAttribute(VALUE_ADDED_SUM_ENK, valueAddedTaxSumDaoIml.getByDateAndOrganizationUnitAndProductGroup(date, date, organizationUnit.getName(), enk.getName()).get(FIRST_INDEX));
            req.setAttribute(VALUE_ADDED_SUM_EBK, valueAddedTaxSumDaoIml.getByDateAndOrganizationUnitAndProductGroup(date, date, organizationUnit.getName(), ebk.getName()).get(FIRST_INDEX));
            req.setAttribute(VALUE_ADDED_SUM_SPPS, valueAddedTaxSumDaoIml.getByDateAndOrganizationUnitAndProductGroup(date, date, organizationUnit.getName(), spps.getName()).get(FIRST_INDEX));
            req.setAttribute(VALUE_ADDED_SUM_FK, valueAddedTaxSumDaoIml.getByDateAndOrganizationUnitAndProductGroup(date, date, organizationUnit.getName(), fk.getName()).get(FIRST_INDEX));
            req.setAttribute(VALUE_ADDED_SUM_OTHER, valueAddedTaxSumDaoIml.getByDateAndOrganizationUnitAndProductGroup(date, date, organizationUnit.getName(), other.getName()).get(FIRST_INDEX));
            req.setAttribute(VALUE_ADDED_SUM_GOODS, valueAddedTaxSumDaoIml.getByDateAndOrganizationUnitAndProductGroup(date, date, organizationUnit.getName(), goods.getName()).get(FIRST_INDEX));

            requestDispatcher = req.getRequestDispatcher(PRODUCT_GROUP_RESULT_URL + JSP);
            requestDispatcher.forward(req, resp);
        } else {
            resp.sendRedirect(RESTRICTED_URL + JSP);
        }
    }
}
