package org.training.wikia.driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.training.wikia.reader.Reader;

import static org.training.wikia.utils.WebDriverWaitUtils.waitUntilElementIsVisible;

/**
 * Base class containing all WebDriver methods and instances.
 * Created by Ganesh on 8/23/15.
 */
public class Driver {

    protected static WebDriver driver = null;

    public static WebDriver getDriver() {

        String browserToBeUsed = null;

        browserToBeUsed = Reader.getValueOfKey("Browser");
        if (browserToBeUsed.equalsIgnoreCase("CH")) driver = new ChromeDriver();
        else if (browserToBeUsed.equalsIgnoreCase("SF")) {
            driver = new SafariDriver();
        } else {
            driver = new FirefoxDriver();

        }
        return driver;
    }

    public static void openURL(String url) {
        getDriver().get(url);
        waitUntilElementIsVisible(By.className("sign-in-label"));
    }

    public static void clickOn(WebElement webElement) {
        webElement.click();
    }

    public static void submitTheForm(WebElement webElement) {
        webElement.submit();
    }

    public static void setValueInTxtField(WebElement webElement, String value) {
        webElement.sendKeys(value);
    }

}
