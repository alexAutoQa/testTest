package helpers;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.util.Random;

public class Helper {
    public static String getRandomText() {
        String text = "abcdertyuncxzlkdnbm";
        String random = "";
        for (int i = 0; i < 5; i++) {
            random = random + text.charAt(new Random().nextInt(10));
        }
        return random;
    }

    public static void executeJS(String script, WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(script);
    }
}
