package com.epam.financial_analytics.action;

import com.epam.financial_analytics.dao.impl.*;
import com.epam.financial_analytics.entity.dictionary.ProductGroup;
import com.epam.financial_analytics.entity.dictionary.User;
import com.epam.financial_analytics.entity.report_classes.CurrencyExchangeRate;
import com.epam.financial_analytics.entity.report_classes.Report;
import com.epam.financial_analytics.util.ActionUtil;
import com.epam.financial_analytics.util.IndicatorUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.epam.financial_analytics.action.ActionConstant.*;

public class ProductGroupForPeriodAction implements Action {
    private RequestDispatcher requestDispatcher;
    private final SalesSumDaoIml salesSumDao = new SalesSumDaoIml();
    private final MarginSumDaoIml marginSumDao = new MarginSumDaoIml();
    private final ValueAddedTaxSumDaoIml valueAddedTaxSumDao = new ValueAddedTaxSumDaoIml();
    private final ProductGroupDaoImpl productGroupDao = new ProductGroupDaoImpl();
    private final CurrencyExchangeRateDaoImpl currencyExchangeRateDao = new CurrencyExchangeRateDaoImpl();
    private List<CurrencyExchangeRate> currencyExchangeRateList;
    private Map<Integer, Long> salesMap = new HashMap<>();
    private Map<Integer, Long> marginMap = new HashMap<>();
    private Map<Integer, Long> vatMap = new HashMap<>();
    private final Map<String, Map<Integer,Long>> salesProductGroupMap = new HashMap<>();
    private final Map<String, Map<Integer,Long>> marginProductGroupMap = new HashMap<>();
    private final Map<String, Map<Integer,Long>> vatProductGroupMap = new HashMap<>();
    private List<Report> salesList;
    private List<Report> marginList;
    private List<Report> vatList;
    private List<ProductGroup> productGroupList;

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        Date startDate = Date.valueOf(req.getParameter(START_DATE));
        Date finishDate = Date.valueOf(req.getParameter(FINISH_DATE));
        String currency = req.getParameter(CURRENCY);
        String organizationUnit = req.getParameter(ORGANIZATION_UNIT);
        String kindOfReport = req.getParameter(KIND_OF_REPORT);

        currencyExchangeRateList = currencyExchangeRateDao.getByCurrencyAndDate(currency, startDate, finishDate);
        productGroupList = productGroupDao.getAll();

        req.setAttribute(KIND_OF_REPORT, kindOfReport);
        req.setAttribute(START_DATE, startDate);
        req.setAttribute(FINISH_DATE, finishDate);
        req.setAttribute(ORGANIZATION_UNIT, organizationUnit);

        HttpSession session = req.getSession();
        User user = (User)session.getAttribute(USER);
        String role = user.getRole().getName();

        if (organizationUnit.equals(KAZAKHSTAN) && (role.equals(ADMIN) || role.equals(DIRECTOR)) || role.contains(organizationUnit) ||
                role.equals(ADMIN) || role.equals(DIRECTOR)){
            for (ProductGroup productGroup : productGroupList) {
                if (organizationUnit.equals(KAZAKHSTAN)) {
                    salesList = IndicatorUtil.fillIndicatorSumListAndProductGroup
                            (salesSumDao, startDate, finishDate, productGroup.getName());
                    marginList = IndicatorUtil.fillIndicatorSumListAndProductGroup
                            (marginSumDao, startDate, finishDate, productGroup.getName());
                    vatList = IndicatorUtil.fillIndicatorSumListAndProductGroup
                            (valueAddedTaxSumDao, startDate, finishDate, productGroup.getName());
                } else{
                    salesList = IndicatorUtil.fillIndicatorSumListWithOrganizationUnitAndProductGroup
                            (salesSumDao, startDate, finishDate, organizationUnit, productGroup.getName());
                    marginList = IndicatorUtil.fillIndicatorSumListWithOrganizationUnitAndProductGroup
                            (marginSumDao, startDate, finishDate, organizationUnit, productGroup.getName());
                    vatList = IndicatorUtil.fillIndicatorSumListWithOrganizationUnitAndProductGroup
                            (valueAddedTaxSumDao, startDate, finishDate, organizationUnit, productGroup.getName());
                }

                salesMap = ActionUtil.getMapWithCurrency(salesList, currencyExchangeRateList, currency);
                marginMap = ActionUtil.getMapWithCurrency(marginList, currencyExchangeRateList, currency);
                vatMap = ActionUtil.getMapWithCurrency(vatList, currencyExchangeRateList, currency);

                salesProductGroupMap.put(productGroup.getName(), salesMap);
                marginProductGroupMap.put(productGroup.getName(), marginMap);
                vatProductGroupMap.put(productGroup.getName(), vatMap);
            }

            salesProductGroupMap.put(TOTAl, ActionUtil.getTotalMapForProductGroup(salesProductGroupMap, productGroupList));
            marginProductGroupMap.put(TOTAl, ActionUtil.getTotalMapForProductGroup(salesProductGroupMap, productGroupList));
            vatProductGroupMap.put(TOTAl, ActionUtil.getTotalMapForProductGroup(salesProductGroupMap, productGroupList));

            req.setAttribute(REPORT_SALES, salesProductGroupMap);
            req.setAttribute(REPORT_MARGIN, marginProductGroupMap);
            req.setAttribute(REPORT_VAT, vatProductGroupMap);

            requestDispatcher = req.getRequestDispatcher(PRODUCT_GROUP_FOR_PERIOD_RESULT_URL + JSP);
            requestDispatcher.forward(req, resp);

        }  else {
            resp.sendRedirect(RESTRICTED_URL + JSP);
        }
    }
}
