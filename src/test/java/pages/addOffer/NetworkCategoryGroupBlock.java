package pages.addOffer;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.BasePage;

import java.util.List;
import java.util.stream.Collectors;

public class NetworkCategoryGroupBlock extends BasePage {
    private final String networkCategoryGroupBlockLoc = "//mat-card-title[text()=' Networks, Category and Group ']/following-sibling::mat-card-content";
    private final String networkSectionLoc = networkCategoryGroupBlockLoc + "/mat-form-field[2]";
    private final String categorySectionLoc = networkCategoryGroupBlockLoc + "/mat-form-field[1]";
    private final String groupSectionLoc = networkCategoryGroupBlockLoc + "/mat-form-field[3]";

    public NetworkCategoryGroupBlock(WebDriver webDriver) {
        super(webDriver);
    }

    public AddOfferPage returnToAddOfferPage() {
        return new AddOfferPage(webDriver);
    }

    public NetworkCategoryGroupBlock clickNetworkAddButton() {
        webDriver.findElement(By.xpath(networkSectionLoc + "//button")).click();
        return this;
    }

    public NetworkCategoryGroupBlock clickCategoryAddButton() {
        webDriver.findElement(By.xpath(categorySectionLoc + "//button")).click();
        return this;
    }

    public NetworkCategoryGroupBlock clickGroupAddButton() {
        webDriver.findElement(By.xpath(groupSectionLoc + "//button")).click();
        return this;
    }

    public NetworkCategoryGroupBlock checkThereIsCategoryInDropdownList(String category) {
        List<String> list = webDriver.findElements(By.xpath(categorySectionLoc + "//select/option")).stream().skip(1)
                .map(webElement -> webElement.getText()).collect(Collectors.toList());
        Assert.assertTrue(String.format("There is no %s category in dropdown list", category), list.contains(category));
        return this;
    }

    public NetworkCategoryGroupBlock selectFirstCategoryFromDropdownList() {
        webDriver.findElement(By.xpath("//select")).click();
        WebElement element = webDriver.findElements(By.xpath(categorySectionLoc + "//select/option")).stream().skip(1).findFirst().get();
        element.click();
        return this;
    }

    public NetworkCategoryGroupBlock checkThereIsNetworkInDropdownList(String network) {
        webDriver.findElement(By.xpath(networkSectionLoc + "//div[@class='mat-select-arrow-wrapper']")).click();
        List<String> list = webDriver.findElements(By.xpath("//div[contains(@class,'mat-select-panel-wrap')]//span[@class='mat-option-text']")).stream()
                .map(webElement -> webElement.getText()).collect(Collectors.toList());
        Assert.assertTrue(String.format("There is no %s network in dropdown list", network), list.contains(network));
        return this;
    }

    public NetworkCategoryGroupBlock selectFirstNetworkFromDropdownList() {
        WebElement element = webDriver.findElement(By.xpath(networkSectionLoc + "//div[@class='mat-select-arrow-wrapper']"));
        element.click();
        WebElement elementOfDropdownList = webDriver.findElements(By.xpath("//div[contains(@class,'mat-select-panel-wrap')]//span[@class='mat-option-text']")).stream().findFirst().get();
        elementOfDropdownList.click();
        Actions action = new Actions(webDriver);
        action.sendKeys(Keys.ESCAPE).perform();
        return this;
    }

    public NetworkCategoryGroupBlock checkThereIsGroupInDropdownList(String group) {
        webDriver.findElement(By.xpath(groupSectionLoc + "//div[@class='mat-select-arrow-wrapper']")).click();
        List<String> list = webDriver.findElements(By.xpath("//div[contains(@class,'mat-select-panel-wrap')]//span[@class='mat-option-text']")).stream()
                .map(webElement -> webElement.getText()).collect(Collectors.toList());
        Assert.assertTrue(String.format("There is no %s group in dropdown list", group), list.contains(group));
        return this;
    }

    public NetworkCategoryGroupBlock selectFirstGroupFromDropdownList() {
        webDriver.findElement(By.xpath(groupSectionLoc + "//div[@class='mat-select-arrow-wrapper']")).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement elementOfDropdownList = webDriver.findElements(By.xpath("//div[contains(@class,'mat-select-panel-wrap')]//span[@class='mat-option-text']")).stream().findFirst().get();
        elementOfDropdownList.click();
        Actions action = new Actions(webDriver);
        action.sendKeys(Keys.ESCAPE).perform();
        return this;
    }
}
