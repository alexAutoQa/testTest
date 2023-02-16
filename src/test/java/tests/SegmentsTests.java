package tests;

import constants.Constants;
import org.junit.Test;
import pages.dashboard.DashboardSectionEnum;

import static helpers.Helper.getRandomText;

public class SegmentsTests extends BaseTest{
    @Test
    public void createSegmentAndCheckCountOnDashboardPage(){
        String segment = "newSegment" + getRandomText();
        open(Constants.Urls.DASHBOARD_URL);
        dashboardPage.waitForAllSpinnerCompleted()
                .waitForCountOfEntitiesAppearsForAllSections();
        int countOfEntities = dashboardPage.getCountOfEntitiesForSection(DashboardSectionEnum.SEGMENTS);
        int newCount = countOfEntities + 1;

        open(Constants.Urls.ADD_URL);
        addOfferPage.getSegmentBlock()
                .clickAddButton()
                .returnToAddOfferPage()
                .setEntityOnDialogBlock(segment)
                .clickCreateButtonOnDialogBlock();

        open(Constants.Urls.DASHBOARD_URL);
        dashboardPage.waitForAllSpinnerCompleted()
                .waitForCountOfEntitiesAppearsForAllSections()
                .checkCountOfEntitiesForSection(DashboardSectionEnum.SEGMENTS, newCount);
    }

    @Test
    public void createSegmentAndCheckSegmentInDropdownList(){
        String segment = "Newsegment" + getRandomText();
        open(Constants.Urls.ADD_URL);
        addOfferPage.getSegmentBlock()
                .clickAddButton()
                .returnToAddOfferPage()
                .setEntityOnDialogBlock(segment)
                .clickCreateButtonOnDialogBlock()

                .getSegmentBlock()
                .clickAddSegmentButton()
                .checkThereIsSegmentInDropdownList(segment);
    }

    @Test
    public void checkAddAndDeleteSegmentSectionInSegmentBlock() {
        open(Constants.Urls.ADD_URL);
        addOfferPage.getSegmentBlock()
                .clickAddSegmentButton()
                .checkAddedSegmentSectionIsVisible()
                .clickDeleteSegmentButton()
                .checkAddedSegmentSectionIsNotVisible();
    }

    @Test
    public void checkAddAndDeleteGroupSectionInSegmentBlock() {
        open(Constants.Urls.ADD_URL);
        addOfferPage.getSegmentBlock()
                .clickAddGroupButton()
                .checkAddedGroupSectionIsVisible()
                .clickDeleteGroupButton()
                .checkAddedGroupSectionIsNotVisible();
    }
}
