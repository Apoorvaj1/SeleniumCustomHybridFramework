package org.selenium.aj.tests;

import org.selenium.aj.basetest.CommonToAllTest;
import org.selenium.aj.pages.POM.RegisterPage_POM;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.selenium.aj.driver.DriverManager.getDriver;

public class RegisterPage extends CommonToAllTest {

    @Test
    public void enterData_RegisterPage() throws InterruptedException {
        RegisterPage_POM register_page = new RegisterPage_POM();
        register_page.enterAllData_Register();
        Thread.sleep(3000);
        Assert.assertTrue(getDriver().getPageSource().contains("Account"));
        System.out.println(register_page.mail_id);
        System.out.println(register_page.password);
    }

}
