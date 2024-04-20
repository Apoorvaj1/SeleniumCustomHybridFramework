package org.selenium.aj.tests;

import org.selenium.aj.basetest.CommonToAllTest;
import org.selenium.aj.driver.DriverManagerTL;
import org.selenium.aj.pages.POM.HomePage_POM;
import org.selenium.aj.utils.PropertyReader;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.selenium.aj.driver.DriverManagerTL.getDriver;

public class OpenCartHomePage_Login extends CommonToAllTest {

    @Test
    public void clickLoginOption() throws InterruptedException {
        HomePage_POM homepagepom = new HomePage_POM();
        homepagepom.openURL(PropertyReader.readKey("URL_HOMEPAGE"));
        homepagepom.clickMyAccount();
        Thread.sleep(2000);
        homepagepom.clickLogin();
        Thread.sleep(2000);
        homepagepom.openURL(PropertyReader.readKey("URL_LOGIN"));
        Assert.assertEquals(getDriver().getCurrentUrl(), PropertyReader.readKey("URL_LOGIN"));

    }
}
