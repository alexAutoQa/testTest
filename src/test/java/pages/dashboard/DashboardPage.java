package pages.dashboard;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DashboardPage extends BasePage {
    private final String COUNT_LOC = "//mat-card-title[text()='%s']/following-sibling::mat-card-content";

    public DashboardPage(WebDriver webDriver) {
        super(webDriver);
    }

    public DashboardPage checkDashboardPageIsOpened() {
        WebElement element = webDriver.findElement(By.xpath("//mat-card-title[text()='categories']/following-sibling::mat-card-content"));
        Assert.assertTrue("DashboardPage is not opened", element.isDisplayed());
        return this;
    }

    public DashboardPage checkCountOfEntitiesForSection(DashboardSectionEnum dashboardSectionEnum, int expectedCountOfEntities) {
        int actualCount = Integer.parseInt(webDriver.findElement(By.xpath(String.format(COUNT_LOC, dashboardSectionEnum.getValue()))).getText().split(" ")[1]);
        Assert.assertEquals(String.format("expectedCountOfEntities- %s, actualCountOfEntities- %s", expectedCountOfEntities, actualCount)
                , expectedCountOfEntities, actualCount);
        return this;
    }

    public int getCountOfEntitiesForSection(DashboardSectionEnum dashboardSectionEnum) {
        int count = Integer.parseInt(webDriver.findElement(By.xpath(String.format(COUNT_LOC, dashboardSectionEnum.getValue()))).getText().split(" ")[1]);
        return count;
    }

    public DashboardPage waitForCountOfEntitiesAppearsForAllSections() {
        for (int i = 0; i < 4; i++) {
            List<String> list = webDriver.findElements(By.xpath("//mat-card-content")).stream().map(element -> element.getText()).collect(Collectors.toList());
            if (list.contains("")) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            } else {
                break;
            }
        }
        return this;
    }

    public DashboardPage waitForAllSpinnerCompleted() {
        WebElement spinner = webDriver.findElement(By.xpath("//mat-spinner"));
        for (int i = 0; i < 4; i++) {
            if (!spinner.isDisplayed()) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            } else {
                break;
            }
        }
        return this;
    }

    public DashboardPage checkOrderOfSections(String... expectedOrderOfSections) {
        List<String> actualOrder = webDriver.findElements(By.xpath("//mat-card-title")).stream().map(element -> element.getText()).collect(Collectors.toList());
        int expectedCount = expectedOrderOfSections.length;
        int actualCount = actualOrder.size();
        List<String> expectedOrder = Arrays.stream(expectedOrderOfSections).collect(Collectors.toList());
        Assert.assertTrue(String.format("expectedCount- %s, actualCount- %s", expectedCount, actualCount), expectedCount == actualCount);
        Assert.assertEquals(expectedOrder, actualOrder);
        return this;
    }
}
