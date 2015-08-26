package org.training.wikia.pageObjects.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.training.wikia.pageObjects.Home;
import org.training.wikia.reader.Reader;

import static org.training.wikia.utils.WebDriverWaitUtils.waitUntilElementIsVisible;

/**
 * Created by Ganesh on 8/23/15.
 */
public class Login extends Home {

    public static WebElement getUserNameTxt() {
        return driver.findElement(By.id("usernameInput"));
    }

    public static WebElement getPasswordTxt() {
        return driver.findElement(By.id("passwordInput"));
    }

    public static WebElement getLoginBtn() {
        return driver.findElement(By.className("login-button"));
    }

    public static WebElement getAvatarEle() {
        return driver.findElement(By.cssSelector(".global-navigation>div>div:nth-child(4)>ul#AccountNavigation>." +
                "account-navigation-first-item>.links-container>a"));
    }

    public static boolean isLoginSuccessFul(String userName, String password) {

        setValueInTxtField(getUserNameTxt(), userName);
        setValueInTxtField(getPasswordTxt(), password);
        getLoginBtn().submit();
        waitUntilElementIsVisible(By.linkText("QM HomeWork Wikia"));
        return (getAvatarEle().getAttribute("title").equals(Reader.getValueOfKey("UserName") + " - My page"));
    }

    public static WebElement logOutLnk(){

        return driver.findElement(By.cssSelector(".AccountNavigation .user-menu > li:nth-child(4)>a"));

    }

    public static void closeSession(){
        clickOn(getAvatarEle());
        clickOn(logOutLnk());
        driver.quit();}

}
