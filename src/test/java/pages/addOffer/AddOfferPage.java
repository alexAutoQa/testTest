package pages.addOffer;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;
import pages.offerPage.OffersPage;

public class AddOfferPage extends BasePage {
    private final String dialogBlockLoc = "//mat-dialog-container";
    private final String nameFieldLoc = "//input[@name='name']";
    private final String keyFieldLoc = "//input[@name='key']";
    private NetworkCategoryGroupBlock networkCategoryGroupBlock;
    private SegmentBlock segmentBlock;

    public AddOfferPage(WebDriver webDriver) {
        super(webDriver);
        networkCategoryGroupBlock = new NetworkCategoryGroupBlock(webDriver);
        segmentBlock = new SegmentBlock(webDriver);
    }

    public NetworkCategoryGroupBlock getNetworkCategoryGroupBlock() {
        return networkCategoryGroupBlock;
    }

    public SegmentBlock getSegmentBlock() {
        return segmentBlock;
    }

    public AddOfferPage setEntityOnDialogBlock(String entity) {
        webDriver.findElement(By.xpath(dialogBlockLoc + "//input")).sendKeys(entity);
        return this;
    }

    public OffersPage clickSaveButtonAndWaitForSpinnerCompleted() {
        webDriver.findElement(By.xpath("//span[text()=' Save ']/parent::button")).click();
        try {
            Thread.sleep(1000);   //need to wait for the value to be updated
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return new OffersPage(webDriver);
    }

    public AddOfferPage checkSaveButtonIsDisabled() {
        String attributeValue = webDriver.findElement(By.xpath("//span[text()=' Save ']/parent::button")).getAttribute("disabled");
        Assert.assertTrue("Save button is not disabled", attributeValue.equalsIgnoreCase("true"));
        return this;
    }

    public AddOfferPage clickCreateButtonOnDialogBlock() {
        webDriver.findElement(By.xpath(dialogBlockLoc + "//span[text()=' Create ']/parent::button")).click();
        try {
            Thread.sleep(1000);   //need to wait for the value to be updated
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return this;
    }

    public AddOfferPage clickCancelButtonOnDialogBlock() {
        webDriver.findElement(By.xpath(dialogBlockLoc + "//span[text()='Cancel']/parent::button")).click();
        return this;
    }

    public AddOfferPage setNameField(String name) {
        webDriver.findElement(By.xpath(nameFieldLoc)).sendKeys(name);
        return this;
    }

    public AddOfferPage setKeyField(String key) {
        webDriver.findElement(By.xpath(keyFieldLoc)).sendKeys(key);
        return this;
    }
}
