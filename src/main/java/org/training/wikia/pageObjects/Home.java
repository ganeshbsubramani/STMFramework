package org.training.wikia.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.training.wikia.driver.Driver;

/**
 * All web elements and objects in home page would be captured here.
 * Only capture the elements needed for the test and not everything.
 * Created by Ganesh on 8/23/15.
 */
public class Home extends Driver {

    public static WebElement getSignInLabel() {
        return driver.findElement(By.className("sign-in-label"));
    }

    public static WebElement getContributeElement() {
        return driver.findElement(By.cssSelector(".WikiHeader>div>nav"));
    }

    /*
      todo : this needs to be modified later in a way like  passing the string would click a link.
     */

    public static WebElement getLinksUnderContribute(int linkNo ){
        return driver.findElement(By.cssSelector(".WikiHeader>div>nav>ul.WikiaMenuElement>li:nth-child("+linkNo+")>a"));
       // return driver.findElement(By.linkText("Add a Video"));
    }


}
