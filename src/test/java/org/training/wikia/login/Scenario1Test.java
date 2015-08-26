package org.training.wikia.login;

import junit.framework.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.training.wikia.driver.Driver;
import org.training.wikia.pageObjects.Home;
import org.training.wikia.reader.Reader;

import static org.training.wikia.driver.Driver.*;
import static org.training.wikia.pageObjects.login.Login.closeSession;
import static org.training.wikia.pageObjects.login.Login.isLoginSuccessFul;


/**
 * Login with predefined user name and password from properties file.
 * Created by Ganesh on 8/23/15.
 */
public class Scenario1Test {

    @BeforeTest
    public void setUp() {
        Driver.openURL(Reader.getValueOfKey("URL"));
    }

    @Test
    public static void testScenario1() {

        clickOn(Home.getSignInLabel());
        Assert.assertTrue(isLoginSuccessFul(Reader.getValueOfKey("UserName"), Reader.getValueOfKey("Password")));
    }

    @AfterTest
    public void tearDown() {
        closeSession();
    }
}
