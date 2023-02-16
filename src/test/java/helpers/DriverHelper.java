package helpers;

import config.BrowserEnum;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static constants.Constants.TimeoutVariable.IMPLICIT_WAIT;

public class DriverHelper {
    public static WebDriver createDriver(BrowserEnum browserEnum) {
        WebDriver webDriver = null;

        switch (browserEnum) {
            case CHROME:
                WebDriverManager.chromedriver().setup();
                webDriver = new ChromeDriver();
                break;
            default:
                Assert.fail(String.format("%s browser is not supported", browserEnum));
        }

        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT));
        webDriver.manage().window().maximize();
        return webDriver;
    }
}
