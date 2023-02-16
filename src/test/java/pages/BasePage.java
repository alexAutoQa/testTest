package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static constants.Constants.TimeoutVariable.EXPLICIT_WAIT;

public class BasePage {
    protected WebDriver webDriver;

    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }


    public WebElement waitForElementIsVisible(WebElement webElement) {
        new WebDriverWait(webDriver, Duration.ofSeconds(EXPLICIT_WAIT)).until(ExpectedConditions.visibilityOf(webElement));
        return webElement;
    }
}
