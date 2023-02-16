package tests;

import config.Config;
import helpers.DriverHelper;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import pages.addOffer.AddOfferPage;
import pages.dashboard.DashboardPage;
import pages.offerPage.OffersPage;

public class BaseTest {
    protected WebDriver webDriver;
    protected OffersPage offersPage;
    protected DashboardPage dashboardPage;
    protected AddOfferPage addOfferPage;

    @Before
    public void setup() {
        webDriver = DriverHelper.createDriver(Config.BROWSER);
        dashboardPage = new DashboardPage(webDriver);
        addOfferPage = new AddOfferPage(webDriver);
        offersPage = new OffersPage(webDriver);
    }

    @After
    public void teardown() {
        webDriver.quit();
    }

    public void open(String url) {
        webDriver.get(url);
    }
}
