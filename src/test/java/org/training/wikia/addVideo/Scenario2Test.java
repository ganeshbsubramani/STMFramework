package org.training.wikia.addVideo;

import junit.framework.Assert;
import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.training.wikia.driver.Driver;
import org.training.wikia.pageObjects.Home;
import org.training.wikia.reader.Reader;

import static org.training.wikia.driver.Driver.*;
import static org.training.wikia.pageObjects.Home.getContributeElement;
import static org.training.wikia.pageObjects.Home.getLinksUnderContribute;
import static org.training.wikia.pageObjects.login.Login.closeSession;
import static org.training.wikia.pageObjects.login.Login.isLoginSuccessFul;
import static org.training.wikia.pageObjects.specialPage.AddVideo.*;
import static org.training.wikia.utils.WebDriverWaitUtils.waitUntilElementIsVisible;

/**
 * pre-condition 1 - You have previously created an account and user name for Wikia.com
 * pre-condition 2 - User is logged in to Wikia.com
 * <p>
 * Navigate to http://qm-homework.wikia.com
 * User is redirected to the home page http://qm-homework.wikia.com/wiki/QM_HomeWork_Wikia
 * Left click the “Contribute” button
 * The Contribute drop-down expanded
 * Left click the “Add a video” button
 * User is redirected to the WikiaVideoAdd page http://qm-homework.wikia.com/wiki/Special:WikiaVideoAdd
 * Type URL to video from youtube into the “Video URL” field and left click the “Add” button e.g. url http://www.youtube.com/watch?v=h9tRIZyTXTI
 * Flash message with text: “Video page File:FILENAME successfully added.” is displayed near the top of the page
 * Left click the link to file on the flash message
 * User is redirected to the http://qm-homework.wikia.com/wiki/File:FILENAME page
 * Verify that the filename is the same as on the flash message (note spaces may be shown as underscores)
 * Confirmed
 * Created by Ganesh on 8/23/15.
 */
public class Scenario2Test {

    @BeforeTest
    public void setUp() {
        Driver.openURL(Reader.getValueOfKey("URL"));
    }

    @Test
    public static void testScenario2() {

        clickOn(Home.getSignInLabel());
        Assert.assertTrue(isLoginSuccessFul(Reader.getValueOfKey("UserName"), Reader.getValueOfKey("Password")));
        clickOn(getContributeElement());
        clickOn(getLinksUnderContribute(2));
        waitUntilElementIsVisible(By.id("wpWikiaVideoAddUrl"));
        setValueInTxtField(getAddVideoUrlTxt(), "http://www.youtube.com/watch?v=h9tRIZyTXTI");
        submitTheForm(getAddBtn());
        waitUntilElementIsVisible(By.cssSelector(".selected-items"));
        clickOn(getMessageArea());
        waitUntilElementIsVisible(By.id("ca-edit"));
        Assert.assertTrue(isMsgContainsTitle("The Best Classical Music In The World"));
    }

    @AfterTest
    public void tearDown() {
        closeSession();
    }

}
