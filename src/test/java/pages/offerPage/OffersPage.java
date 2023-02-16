package pages.offerPage;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;
import pages.addOffer.AddOfferPage;

public class OffersPage extends BasePage {
    public OffersPage(WebDriver webDriver) {
        super(webDriver);
    }

    public AddOfferPage clickAddButton() {
        WebElement element = webDriver.findElement(By.xpath("//span[text()=' Add ']/parent::button"));
        element.click();
        return new AddOfferPage(webDriver);
    }

    public OffersPage checkNameAndKeyForOffer(String name, String key) {
        WebElement row = getReportRow(name);
        String actualKey = row.findElement(By.xpath("./td[contains(@class,'column-key')]")).getText();
        Assert.assertEquals(key, actualKey);
        return this;
    }

    public OffersPage checkOfferDoesNotExist(String name) {
        int size = webDriver.findElements(By.xpath(String.format("//td[text()='%s']/parent::tr", name))).size();
        Assert.assertTrue("Offer exists", size == 0);
        return this;
    }

    public void performAction(String name, ActionEnum actionEnum) {
        WebElement row = getReportRow(name);
        WebElement element = row.findElement(By.xpath(String.format(".//span[text()='%s']/parent::button", actionEnum.getValue())));
        element.click();
        if (actionEnum == ActionEnum.DELETE) {
            webDriver.findElement(By.xpath("//simple-snack-bar//button")).click();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private WebElement getReportRow(String name) {
        WebElement row = webDriver.findElement(By.xpath(String.format("//td[text()='%s']/parent::tr", name)));
        return row;
    }
}
