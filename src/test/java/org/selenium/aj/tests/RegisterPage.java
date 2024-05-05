package org.selenium.aj.tests;

import org.openqa.selenium.By;
import org.selenium.aj.basetest.CommonToAllTest;
import org.selenium.aj.pages.POM.RegisterPage_POM;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.selenium.aj.driver.DriverManagerTL.getDriver;

public class RegisterPage extends CommonToAllTest {



    @Test
    public void enterData_RegisterPage() throws InterruptedException {
        RegisterPage_POM register_page = new RegisterPage_POM();
        register_page.enterAllData_Register();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        Assert.assertTrue(getDriver().getPageSource().contains("Account"));


    }

}
