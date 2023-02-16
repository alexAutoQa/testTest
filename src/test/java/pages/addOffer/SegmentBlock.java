package pages.addOffer;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;

import java.util.List;
import java.util.stream.Collectors;

public class SegmentBlock extends BasePage {
    private final String segmentBlockLoc = "//mat-card-title[text()=' Segments ']/parent::mat-card";

    public SegmentBlock(WebDriver webDriver) {
        super(webDriver);
    }

    public AddOfferPage returnToAddOfferPage() {
        return new AddOfferPage(webDriver);
    }

    public SegmentBlock clickAddButton() {
        webDriver.findElement(By.xpath(segmentBlockLoc + "//span[text()=' Add ']/parent::button")).click();
        return this;
    }

    public SegmentBlock clickAddGroupButton() {
        webDriver.findElement(By.xpath(segmentBlockLoc + "//span[text()=' Add group ']/parent::button")).click();
        return this;
    }

    public SegmentBlock clickAddSegmentButton() {
        webDriver.findElement(By.xpath(segmentBlockLoc + "//span[text()=' Add segment ']/parent::button")).click();
        return this;
    }

    public SegmentBlock checkThereIsSegmentInDropdownList(String segment) {
        webDriver.findElement(By.xpath(segmentBlockLoc + "//div[@class='mat-select-arrow-wrapper']")).click();
        List<String> list = webDriver.findElements(By.xpath("//div[contains(@class,'mat-select-panel-wrap')]//span[@class='mat-option-text']")).stream()
                .map(webElement -> webElement.getText()).collect(Collectors.toList());
        Assert.assertTrue(String.format("There is no %s segment in dropdown list", segment), list.contains(segment));
        return this;
    }

    public SegmentBlock selectSecondSegmentFromDropdownList() {
        webDriver.findElement(By.xpath(segmentBlockLoc + "//div[@class='mat-select-arrow-wrapper']")).click();
        WebElement elementOfDropdownList = webDriver.findElements(By.xpath("//div[contains(@class,'mat-select-panel-wrap')]//span[@class='mat-option-text']")).stream().skip(1).findFirst().get();
        elementOfDropdownList.click();
        return this;
    }

    public SegmentBlock clickDeleteSegmentButton() {
        webDriver.findElement(By.xpath(segmentBlockLoc + "//mat-form-field/following-sibling::button")).click();
        return this;
    }

    public SegmentBlock clickDeleteGroupButton() {
        webDriver.findElement(By.xpath(segmentBlockLoc + "//app-form-segments[@name='subsegment']//span[text()=' Delete ']")).click();
        return this;
    }

    public SegmentBlock checkAddedSegmentSectionIsVisible() {
        WebElement element = webDriver.findElement(By.xpath(segmentBlockLoc + "//mat-form-field"));
        Assert.assertTrue("Added segment section is not visible", element.isDisplayed());
        return this;
    }

    public SegmentBlock checkAddedSegmentSectionIsNotVisible() {
        int size = webDriver.findElements(By.xpath(segmentBlockLoc + "//mat-form-field")).size();
        Assert.assertTrue("Added segment section is visible", size == 0);
        return this;
    }

    public SegmentBlock checkAddedGroupSectionIsVisible() {
        WebElement element = webDriver.findElement(By.xpath(segmentBlockLoc + "//app-form-segments[@name='subsegment']"));
        Assert.assertTrue("Added group section is not visible", element.isDisplayed());
        return this;
    }

    public SegmentBlock checkAddedGroupSectionIsNotVisible() {
        int size = webDriver.findElements(By.xpath(segmentBlockLoc + "//app-form-segments[@name='subsegment']")).size();
        Assert.assertTrue("Added group section is visible", size == 0);
        return this;
    }
}
