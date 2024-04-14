package org.selenium.aj.tests;
import org.selenium.aj.basetest.CommonToAllTest;
import org.selenium.aj.pages.POM.HomePage_POM;
import org.selenium.aj.utils.PropertyReader;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.selenium.aj.driver.DriverManager.getDriver;

public class OpenCartHomePage_Register extends CommonToAllTest {

    @Test
    public void clickRegisterOption() throws InterruptedException {
        HomePage_POM homepagepom = new HomePage_POM();
        homepagepom.openCartHomeURL();
        homepagepom.clickMyAccount();
        Thread.sleep(2000);
        homepagepom.clickRegister();
        Thread.sleep(2000);
        homepagepom.openCartRegisterURL();
        homepagepom.afterClickOnRegister();
        Assert.assertEquals(getDriver().getCurrentUrl(), PropertyReader.readKey("URL_REGISTER"));
    }
}
