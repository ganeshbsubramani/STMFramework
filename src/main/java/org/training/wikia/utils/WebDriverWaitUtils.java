package org.training.wikia.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.training.wikia.driver.Driver;
import org.training.wikia.reader.Reader;

/**
 * Wait implementations
 * Created by Ganesh on 8/23/15.
 */
public class WebDriverWaitUtils extends Driver {


    private static Integer timeOutInSeconds() {
        return Integer.parseInt(Reader.getValueOfKey("TimeOut"));
    }

    private static void waitForCondition(ExpectedCondition<?> condition) {
        new WebDriverWait(driver, timeOutInSeconds()).until(condition);
    }

    public static void waitUntilElementIsVisible(By locator) {

        ExpectedCondition<WebElement> condition = ExpectedConditions.visibilityOfElementLocated(locator);
        waitForCondition(condition);
    }


}
