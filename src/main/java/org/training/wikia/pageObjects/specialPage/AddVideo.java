package org.training.wikia.pageObjects.specialPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.training.wikia.driver.Driver;

/**
 * Created by Ganesh on 8/24/15.
 */
public class AddVideo extends Driver {

    public static WebElement getAddVideoUrlTxt() {
        return driver.findElement(By.id("wpWikiaVideoAddUrl"));
    }

    public static WebElement getAddBtn() {
        return driver.findElement(By.className("submits"));
    }

    public static WebElement getMessageArea() {
        return driver.findElement(By.cssSelector("#WikiaPage>div>div>div>div>a"));
    }

    //todo: to be moved.

    public static WebElement getTitleOfVideo() {
        return driver.findElement(By.cssSelector("div.header-column:nth-child(1) > h1:nth-child(1)"));
    }

    public static boolean isMsgContainsTitle(String msg) {

        String value = getTitleOfVideo().getText();

        System.out.println(value);
        return value.equals(msg.replace("_", " "));
    }


}
