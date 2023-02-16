package tests;

import constants.Constants;
import org.junit.Test;
import pages.dashboard.DashboardSectionEnum;

import static helpers.Helper.getRandomText;

public class CategoriesTests extends BaseTest {
    @Test
    public void createCategoryAndCheckCountOnDashboardPage() {
        String category = "newCategory" + getRandomText();
        open(Constants.Urls.DASHBOARD_URL);
        dashboardPage.waitForAllSpinnerCompleted()
                .waitForCountOfEntitiesAppearsForAllSections();
        int countOfEntities = dashboardPage.getCountOfEntitiesForSection(DashboardSectionEnum.CATEGORIES);
        int newCount = countOfEntities + 1;

        open(Constants.Urls.ADD_URL);
        addOfferPage.getNetworkCategoryGroupBlock()
                .clickCategoryAddButton()
                .returnToAddOfferPage()
                .setEntityOnDialogBlock(category)
                .clickCreateButtonOnDialogBlock();

        open(Constants.Urls.DASHBOARD_URL);
        dashboardPage.waitForAllSpinnerCompleted()
                .waitForCountOfEntitiesAppearsForAllSections()
                .checkCountOfEntitiesForSection(DashboardSectionEnum.CATEGORIES, newCount);
    }

    @Test
    public void createCategoryAndCheckCategoryInDropdownList() {
        String category = "newCategory" + getRandomText();
        open(Constants.Urls.ADD_URL);
        addOfferPage.getNetworkCategoryGroupBlock()
                .clickCategoryAddButton()
                .returnToAddOfferPage()
                .setEntityOnDialogBlock(category)
                .clickCreateButtonOnDialogBlock()

                .getNetworkCategoryGroupBlock()
                .checkThereIsCategoryInDropdownList(category);
    }
}
