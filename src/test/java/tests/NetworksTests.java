package tests;

import constants.Constants;
import org.junit.Test;
import pages.dashboard.DashboardSectionEnum;

import static helpers.Helper.getRandomText;

public class NetworksTests extends BaseTest{
    @Test
    public void createNetworkAndCheckCountOnDashboardPage(){
        String network = "newNetwork" + getRandomText();
        open(Constants.Urls.DASHBOARD_URL);
        dashboardPage.waitForAllSpinnerCompleted()
                .waitForCountOfEntitiesAppearsForAllSections();
        int countOfEntities = dashboardPage.getCountOfEntitiesForSection(DashboardSectionEnum.NETWORKS);
        int newCount = countOfEntities + 1;

        open(Constants.Urls.ADD_URL);
        addOfferPage.getNetworkCategoryGroupBlock()
                .clickNetworkAddButton()
                .returnToAddOfferPage()
                .setEntityOnDialogBlock(network)
                .clickCreateButtonOnDialogBlock();

        open(Constants.Urls.DASHBOARD_URL);
        dashboardPage.waitForAllSpinnerCompleted()
                .waitForCountOfEntitiesAppearsForAllSections()
                .checkCountOfEntitiesForSection(DashboardSectionEnum.NETWORKS, newCount);
    }

    @Test
    public void createNetworkAndCheckNetworkInDropdownList(){
        String network = "Newnetwork" + getRandomText();
        open(Constants.Urls.ADD_URL);
        addOfferPage.getNetworkCategoryGroupBlock()
                .clickNetworkAddButton()
                .returnToAddOfferPage()
                .setEntityOnDialogBlock(network)
                .clickCreateButtonOnDialogBlock()

                .getNetworkCategoryGroupBlock()
                .checkThereIsNetworkInDropdownList(network);
    }
}
