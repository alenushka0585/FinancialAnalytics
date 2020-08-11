package com.epam.financial_analytics.action;

import com.epam.financial_analytics.dao.impl.*;
import com.epam.financial_analytics.entity.dictionary.*;
import com.epam.financial_analytics.entity.dictionary.Currency;
import com.epam.financial_analytics.entity.report_classes.ProductGroupSales;
import org.apache.log4j.Logger;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.util.*;

import static com.epam.financial_analytics.action.ActionConstant.*;

public class ProductGroupAction implements Action {
    private static final Logger LOGGER = Logger.getLogger(ProductGroupAction.class);
    public static final String SALES_SUM = "salesSum";
    public static final String MARGIN_SUM = "marginSum";
    public static final String VALUE_ADDED_SUM = "valueAddedSum";

    private final ProductGroupDaoImpl productGroupDao = new ProductGroupDaoImpl();
    private final SalesSumDaoIml salesSumDaoIml = new SalesSumDaoIml();
    private final MarginSumDaoIml marginSumDaoIml = new MarginSumDaoIml();
    private final ValueAddedTaxSumDaoIml valueAddedTaxSumDaoIml = new ValueAddedTaxSumDaoIml();
    private final OrganizationUnitDaoImpl organizationUnitDao = new OrganizationUnitDaoImpl();
    private final CurrencyDaoImpl currencyDao = new CurrencyDaoImpl();
    RequestDispatcher requestDispatcher;
    private final Map<String, Long> salesSumMap = new HashMap<>();
    private final Map<String, Long> marginSumMap = new HashMap<>();
    private final Map<String, Long> valueAddedSumMap = new HashMap<>();


    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        LOGGER.info("Execute method starts in ProductGroupAction");
        Date date = Date.valueOf(req.getParameter(DATE));
        String kindOfReport = req.getParameter(KIND_OF_REPORT);
        Currency currency = currencyDao.getByName(req.getParameter(CURRENCY));
        OrganizationUnit organizationUnit = organizationUnitDao.getByName(req.getParameter(ORGANIZATION_UNIT));

        List<ProductGroup> productGroupList = productGroupDao.getAll();

        Enumeration paramNames = req.getParameterNames();

        HttpSession session = req.getSession();
        User user = (User)session.getAttribute(USER);
        String role = user.getRole().getName();

        if (role.equals(ADMIN)){
            while(paramNames.hasMoreElements()) {
                String paramName = (String)paramNames.nextElement();

                for (ProductGroup productGroup: productGroupList) {
                    if (paramName.contains(productGroup.getName()) && paramName.contains(SALES_SUM)) {
                        ProductGroupSales productGroupSales = new ProductGroupSales
                                (date,Long.parseLong(req.getParameter(paramName)),organizationUnit,currency, productGroup);
                        salesSumMap.put(productGroup.getName(), productGroupSales.getAmount());
                        salesSumDaoIml.create(productGroupSales);
                    } else if (paramName.contains(productGroup.getName()) && paramName.contains(MARGIN_SUM)){
                        ProductGroupSales productGroupSales = new ProductGroupSales
                                (date,Long.parseLong(req.getParameter(paramName)),organizationUnit,currency, productGroup);
                        marginSumMap.put(productGroup.getName(), Long.parseLong(req.getParameter(paramName)));
                        marginSumDaoIml.create(productGroupSales);
                    } else if (paramName.contains(productGroup.getName()) && paramName.contains(VALUE_ADDED_SUM)){
                        ProductGroupSales productGroupSales = new ProductGroupSales
                                (date,Long.parseLong(req.getParameter(paramName)),organizationUnit,currency, productGroup);
                        valueAddedSumMap.put(productGroup.getName(), Long.parseLong(req.getParameter(paramName)));
                        valueAddedTaxSumDaoIml.create(productGroupSales);
                    }
                }
            }
            req.setAttribute(KIND_OF_REPORT, kindOfReport);
            req.setAttribute(DATE, date);
            req.setAttribute(CURRENCY, currency);
            req.setAttribute(ORGANIZATION_UNIT, organizationUnit);
            req.setAttribute(REPORT_SALES, salesSumMap);
            req.setAttribute(REPORT_MARGIN, marginSumMap);
            req.setAttribute(REPORT_VAT, valueAddedSumMap);

            requestDispatcher = req.getRequestDispatcher(PRODUCT_GROUP_RESULT_URL + JSP);
            requestDispatcher.forward(req, resp);
        } else {
            resp.sendRedirect(RESTRICTED_URL + JSP);
        }
    }
}
