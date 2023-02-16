package tests;

import constants.Constants;
import org.junit.Test;
import pages.dashboard.DashboardSectionEnum;

import static helpers.Helper.getRandomText;

public class GroupsTests extends BaseTest{

    @Test
    public void createGroupAndCheckCountOnDashboardPage(){
        String group = "newGroup" + getRandomText();
        open(Constants.Urls.DASHBOARD_URL);
        dashboardPage.waitForAllSpinnerCompleted()
                .waitForCountOfEntitiesAppearsForAllSections();
        int countOfEntities = dashboardPage.getCountOfEntitiesForSection(DashboardSectionEnum.GROUPS);
        int newCount = countOfEntities + 1;

        open(Constants.Urls.ADD_URL);
        addOfferPage.getNetworkCategoryGroupBlock()
                .clickGroupAddButton()
                .returnToAddOfferPage()
                .setEntityOnDialogBlock(group)
                .clickCreateButtonOnDialogBlock();

        open(Constants.Urls.DASHBOARD_URL);
        dashboardPage.waitForAllSpinnerCompleted()
                .waitForCountOfEntitiesAppearsForAllSections()
                .checkCountOfEntitiesForSection(DashboardSectionEnum.GROUPS, newCount);
    }

    @Test
    public void createGroupAndCheckGroupInDropdownList(){
        String group = "newGroup" + getRandomText();
        open(Constants.Urls.ADD_URL);
        addOfferPage.getNetworkCategoryGroupBlock()
                .clickGroupAddButton()
                .returnToAddOfferPage()
                .setEntityOnDialogBlock(group)
                .clickCreateButtonOnDialogBlock()

                .getNetworkCategoryGroupBlock()
                .checkThereIsGroupInDropdownList(group);
    }
}
