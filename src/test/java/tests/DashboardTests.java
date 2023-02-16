package tests;

import constants.Constants;
import org.junit.Test;

public class DashboardTests extends BaseTest{
    @Test
    public void checkOrderOfEntities() {
        open(Constants.Urls.DASHBOARD_URL);
        dashboardPage.waitForAllSpinnerCompleted()
                .checkDashboardPageIsOpened()
                .checkOrderOfSections("categories", "groups", "networks", "offers", "products", "segments");
    }
}
