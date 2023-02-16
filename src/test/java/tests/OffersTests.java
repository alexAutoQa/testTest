package tests;

import constants.Constants;
import helpers.Helper;
import org.junit.Test;
import pages.dashboard.DashboardSectionEnum;
import pages.offerPage.ActionEnum;

public class OffersTests extends BaseTest {
    @Test
    public void createOfferAndCheckCountOnDashboardPage() {
        open(Constants.Urls.DASHBOARD_URL);
        dashboardPage.waitForAllSpinnerCompleted()
                .waitForCountOfEntitiesAppearsForAllSections();
        int countOfEntities = dashboardPage.getCountOfEntitiesForSection(DashboardSectionEnum.OFFERS);
        int newCount = countOfEntities + 1;

        open(Constants.Urls.ADD_URL);
        addOfferPage.checkSaveButtonIsDisabled()
                .setNameField("name" + Helper.getRandomText())
                .setKeyField("key" + Helper.getRandomText())
                .getNetworkCategoryGroupBlock()
                .selectFirstCategoryFromDropdownList()
                .selectFirstNetworkFromDropdownList()
                .selectFirstGroupFromDropdownList()
                .returnToAddOfferPage()

                .getSegmentBlock()
                .clickAddSegmentButton()
                .selectSecondSegmentFromDropdownList()
                .returnToAddOfferPage()
                .clickSaveButtonAndWaitForSpinnerCompleted();

        open(Constants.Urls.DASHBOARD_URL);
        dashboardPage.waitForAllSpinnerCompleted()
                .waitForCountOfEntitiesAppearsForAllSections()
                .checkCountOfEntitiesForSection(DashboardSectionEnum.OFFERS, newCount);

    }

    @Test
    public void checkDeleteOfferAndCheckOfferExistOnOfferPage() {
        String name = "name" + Helper.getRandomText();
        String key = "key" + Helper.getRandomText();

        open(Constants.Urls.ADD_URL);
        addOfferPage.checkSaveButtonIsDisabled()
                .setNameField(name)
                .setKeyField(key)
                .getNetworkCategoryGroupBlock()
                .selectFirstCategoryFromDropdownList()
                .selectFirstNetworkFromDropdownList()
                .selectFirstGroupFromDropdownList()
                .returnToAddOfferPage()

                .getSegmentBlock()
                .clickAddSegmentButton()
                .selectSecondSegmentFromDropdownList()
                .returnToAddOfferPage()
                .clickSaveButtonAndWaitForSpinnerCompleted()
                .performAction(name, ActionEnum.DELETE);
        offersPage.checkOfferDoesNotExist(name);
    }

    @Test
    public void checkDeleteOfferAndCheckOfferExistOnDashboardPage() {
        String name = "name" + Helper.getRandomText();
        String key = "key" + Helper.getRandomText();
        open(Constants.Urls.DASHBOARD_URL);
        dashboardPage.waitForAllSpinnerCompleted()
                .waitForCountOfEntitiesAppearsForAllSections();
        int countOfEntities = dashboardPage.getCountOfEntitiesForSection(DashboardSectionEnum.OFFERS);
        int newCount = countOfEntities;

        open(Constants.Urls.ADD_URL);
        addOfferPage.checkSaveButtonIsDisabled()
                .setNameField(name)
                .setKeyField(key)
                .getNetworkCategoryGroupBlock()
                .selectFirstCategoryFromDropdownList()
                .selectFirstNetworkFromDropdownList()
                .selectFirstGroupFromDropdownList()
                .returnToAddOfferPage()

                .getSegmentBlock()
                .clickAddSegmentButton()
                .selectSecondSegmentFromDropdownList()
                .returnToAddOfferPage()
                .clickSaveButtonAndWaitForSpinnerCompleted()
                .performAction(name, ActionEnum.DELETE);

        open(Constants.Urls.DASHBOARD_URL);
        dashboardPage.waitForAllSpinnerCompleted()
                .waitForCountOfEntitiesAppearsForAllSections()
                .checkCountOfEntitiesForSection(DashboardSectionEnum.OFFERS, newCount);
    }


    @Test
    public void createOfferAndCheckOnOfferPage() {
        String name = "name" + Helper.getRandomText();
        String key = "key" + Helper.getRandomText();
        open(Constants.Urls.LIST_URL);
        offersPage.clickAddButton()
                .checkSaveButtonIsDisabled()
                .setNameField(name)
                .setKeyField(key)
                .getNetworkCategoryGroupBlock()
                .selectFirstCategoryFromDropdownList()
                .selectFirstNetworkFromDropdownList()
                .selectFirstGroupFromDropdownList()
                .returnToAddOfferPage()

                .getSegmentBlock()
                .clickAddSegmentButton()
                .selectSecondSegmentFromDropdownList()
                .returnToAddOfferPage()
                .clickSaveButtonAndWaitForSpinnerCompleted()
                .checkNameAndKeyForOffer(name, key);
    }
}
