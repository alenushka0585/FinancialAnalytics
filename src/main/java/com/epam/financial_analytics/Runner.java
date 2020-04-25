package com.epam.financial_analytics;

import com.epam.financial_analytics.dao.impl.*;
import com.epam.financial_analytics.entity.dictionary.*;
import com.epam.financial_analytics.entity.report_classes.*;
import com.epam.financial_analytics.logic.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;

public class Runner {
    public static void main(String[] args){
        UserDaoImpl userDao = new UserDaoImpl();
//        ProductGroupDaoImpl productGroupDao = new ProductGroupDaoImpl();
//        OrganizationUnitDaoImpl organizationUnitDaoImlp = new OrganizationUnitDaoImpl();
//        LanguageDaoImpl languageDao = new LanguageDaoImpl();
//        ExpenseTypeDaoImpl expenseTypeDao = new ExpenseTypeDaoImpl();
//        CurrencyDaoImpl currencyDao= new CurrencyDaoImpl();
//        CurrencyExchangeRateDaoImpl currencyExchangeRateDao = new CurrencyExchangeRateDaoImpl();
        ExpenseInfoDaoImpl expenseInfoDao = new ExpenseInfoDaoImpl();
//        LabourCostDaoImpl labourCostDao = new LabourCostDaoImpl();
//        MetallProcessingDaoImpl metallProcessingDao = new MetallProcessingDaoImpl();
//        NumberOfStuffDaoImpl numberOfStuffDao = new NumberOfStuffDaoImpl();
//        ProductGroupSalesDaoImpl productGroupSalesDao = new ProductGroupSalesDaoImpl();
//        RevenueDaoImpl revenueDao = new RevenueDaoImpl();
//        SquareMetresAndTonnsSalesDaoImpl squareMetresAndTonnsSalesDao = new SquareMetresAndTonnsSalesDaoImpl();

        java.sql.Date date = java.sql.Date.valueOf(LocalDate.of(2019,01,01));
        java.sql.Date date1 = java.sql.Date.valueOf(LocalDate.of(2019,02,28));
        java.sql.Date date2 = java.sql.Date.valueOf(LocalDate.of(2018,01,01));
        java.sql.Date date3 = java.sql.Date.valueOf(LocalDate.of(2018,02,28));

//        User user = new User();
//        ProductGroup productGroup = productGroupDao.getById(2);
//        OrganizationUnit organizationUnit = organizationUnitDaoImlp.getById(2);
//        Language language = new Language(3, "ZZ");
//        ExpenseType expenseType = expenseTypeDao.getById(1);
//        Currency currency = currencyDao.getById(3);
//        LocalDate d1 = LocalDate.of(2019, 1,01);
//        LocalDate d2 = LocalDate.of(2019, 3,01);
//        CurrencyExchangeRate currencyExchangeRate = new CurrencyExchangeRate(5, date, currency, 435.55);
//        ExpenseInfo expenseInfo = new ExpenseInfo(6, date1, organizationUnit, currency, expenseType, 155);
//        LabourCost labourCost = new LabourCost(6, date1,organizationUnit, currency, 440);
//        MetallProcessing metallProcessing = new MetallProcessing(7, date1, organizationUnit, 560);
//        NumberOfStuff numberOfStuff = new NumberOfStuff(7,date1, organizationUnit, 100);
//        ProductGroupSales productGroupSales = new ProductGroupSales(12,date1,organizationUnit,currency,productGroup,83000,8300,8500);
//        Revenue revenue = new Revenue(7, date1, organizationUnit, currency, 660);
//        SquareMetresAndTonnsSales squareMetresAndTonnsSales = new SquareMetresAndTonnsSales(7, date1,organizationUnit, 555500,65);

//        userDao.getById(currency);

//        System.out.println(userDao.getAll());

//        List<SquareMetresAndTonnsSales> list2 = squareMetresAndTonnsSalesDao.getByDateAndOrganizationUnit(date, date1, organizationUnit.getName());
//        for (SquareMetresAndTonnsSales m: list2){
//            System.out.println(m);}

//        Analytics analytics = new Analytics(date, date1, date2, date3);
//        analytics.setRevenueSum();
//        System.out.println(analytics.getChangingOfRevenue());
//        System.out.println(analytics.getChangingOfRevenueInPercents());


//        Period period = Period.between(date.toLocalDate(), date1.toLocalDate());
//        Period period2 = Period.between(d1, d2);
//        System.out.println(period2.getMonths());
//        System.out.println(date);
//        System.out.println(date1);
//        System.out.println(period.toTotalMonths());
//        System.out.println((10 / (period.getMonths()+1)) );
//

//        KazakhstanIndicator kazakhstanIndicator = new KazakhstanIndicator(date,date1,date2,date3,"RUB");
//        kazakhstanIndicator.setAll();
//
        BasicIndicator basicIndicatorAlmaty = new BasicIndicator(date,date1,date2,date3,"RUB");
//        BasicIndicator basicIndicatorAtyrau = new BasicIndicator(date,date1,date2,date3,"RUB");
//        BasicIndicator basicIndicatorAstana = new BasicIndicator(date,date1,date2,date3,"RUB");
//        BasicIndicator basicIndicatorAktobe = new BasicIndicator(date,date1,date2,date3,"RUB");
//        BasicIndicator basicIndicatorOskemen = new BasicIndicator(date,date1,date2,date3,"RUB");
//        BasicIndicator basicIndicatorShymkent = new BasicIndicator(date,date1,date2,date3,"RUB");
        basicIndicatorAlmaty.setAllWithOrganizationUnit("Алматы");
//        basicIndicatorAtyrau.setAllWithOrganizationUnit("Атырау");
//        basicIndicatorAstana.setAllWithOrganizationUnit("Астана");
//        basicIndicatorAktobe.setAllWithOrganizationUnit("Актобе");
//        basicIndicatorOskemen.setAllWithOrganizationUnit("Оскемен");
//        basicIndicatorShymkent.setAllWithOrganizationUnit("Шымкент");

//        System.out.println("Казахстан наст " + kazakhstanIndicator.getPresentPeriodMarginOnEmployeeinMonth());
//        System.out.println("Казахстан прош " + kazakhstanIndicator.getPastPeriodMarginOnEmployeeinMonth());
//        System.out.println("Казахстан изменен " + kazakhstanIndicator.getChangingOfMarginOnEmployeeinMonth());
//        System.out.println("Казахстан изменен " + kazakhstanIndicator.getChangingOfMarginOnEmployeeInPercents());
//        System.out.println("Алматы наст " + basicIndicatorAlmaty.getProductGroupIndicator().getPresentPeriodProductionProfitability());
//        System.out.println("Алматы наст " + basicIndicatorAlmaty.getProductGroupIndicator().getPresentPeriodProductionProfitability());

//        System.out.println(basicIndicatorAlmaty.getChangingOfRevenueInPercents());
        System.out.println("Almaty прош " + basicIndicatorAlmaty.getExpenseIndicator().getPresentPeriodAllExpenses());
        System.out.println("Almaty прош " + basicIndicatorAlmaty.getPresentPeriodRevenue());
        System.out.println("Almaty прош " + basicIndicatorAlmaty.getPresentPeriodPercentOfExpenseToRevenue());
//        System.out.println("Atyrau наст " + basicIndicatorAtyrau.getProductGroupIndicator().getPresentPeriodAllProfitability());
//        System.out.println("Atyrau прош " + basicIndicatorAtyrau.getProductGroupIndicator().getPastPeriodAllProfitability());
//        System.out.println("Astana наст " + basicIndicatorAstana.getProductGroupIndicator().getPresentPeriodAllProfitability());
//        System.out.println("Astana прош " + basicIndicatorAstana.getProductGroupIndicator().getPastPeriodAllProfitability());
//        System.out.println("Aktobe наст " + basicIndicatorAktobe.getProductGroupIndicator().getPresentPeriodAllProfitability());
//        System.out.println("Aktobe прош " + basicIndicatorAktobe.getProductGroupIndicator().getPastPeriodAllProfitability());
//        System.out.println("Oskemen наст " + basicIndicatorOskemen.getProductGroupIndicator().getPresentPeriodAllProfitability());
//        System.out.println("Oskemen прош " + basicIndicatorOskemen.getProductGroupIndicator().getPastPeriodAllProfitability());
//        System.out.println("Shymkent наст " + basicIndicatorShymkent.getProductGroupIndicator().getPresentPeriodAllProfitability());
//        System.out.println("Shymkent прош " + basicIndicatorShymkent.getProductGroupIndicator().getPastPeriodAllProfitability());

//        BigDecimal present = BigDecimal.valueOf(500000);
//        BigDecimal past = BigDecimal.valueOf(450000);
//        BigDecimal chang = Util.countPercent(present, past);
//        System.out.println(chang);
    }
}
