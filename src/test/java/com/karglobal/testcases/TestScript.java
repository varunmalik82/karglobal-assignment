package com.karglobal.testcases;

import com.karglobal.web.PageObjectManager;
import com.karglobal.web.core.utils.BrowserUtils;
import com.karglobal.web.core.utils.ConfigUtils;
import com.karglobal.web.core.utils.TestDataRow;
import com.karglobal.web.core.utils.TestDataUtils;
import com.karglobal.web.pages.CareersPage;
import com.karglobal.web.pages.HomePage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestScript {

    private WebDriver driver;
    final static Logger logger = Logger.getLogger(TestScript.class);

    @BeforeMethod
    public void setUp() {
        driver = BrowserUtils.getDriver();
    }

    @DataProvider
    public Object[][] testDataProvider() {
        // Read test data from TestData.json
        return TestDataUtils.getTestData();
    }

    @Test(dataProvider = "testDataProvider")
    // Scenario 1: check whether Canada TradeRev career page is displayed properly
    // Change - Seems like there have been some changes in the site, tried to aligned with what we are seeing on site right now
    public void testTradeRevCareersPage(TestDataRow testDataRow) {
        driver.get(ConfigUtils.getProperty("TradeRevHomePageUrl"));
        HomePage homePage = PageObjectManager.getHomePageInstance();
        homePage.navigateToWorkWithTradeRev();
        PageObjectManager.getWorkWithTradeRevPageInstance().navigateToKarGlobalCarrersPage();
        PageObjectManager.getWorkDayCareersPageInstance().validateCanadianJobsSite(testDataRow.getValue("title"), testDataRow.getValue("workDayJobsUrl"));
    }

    //Scenario 2: check whether job filter (city) is working properly
    @Test(dataProvider = "testDataProvider")
    public void testJobsSearchByCity(TestDataRow testDataRow) {
        driver.get(ConfigUtils.getProperty("careersPageUrl"));
        CareersPage careersPage = PageObjectManager.getCareersPageInstance();
        careersPage.validateJobSearchByCity(testDataRow.getValue("location"));
    }

    //Scenario 3: check whether job filter (city) and (team) is working properly
    @Test(dataProvider = "testDataProvider")
    public void testJobsSearchByCityAndTeam(TestDataRow testDataRow) {
        driver.get(ConfigUtils.getProperty("careersPageUrl"));
        CareersPage careersPage = PageObjectManager.getCareersPageInstance();
        careersPage.validateJobsSearchByCityAndTeam(testDataRow.getValue("location"), testDataRow.getValue("team"));
    }

    @AfterMethod
    public void tearDown() {
        BrowserUtils.closeBrowser();
    }
}
