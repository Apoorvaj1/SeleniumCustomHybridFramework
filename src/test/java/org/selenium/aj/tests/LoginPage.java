package org.selenium.aj.tests;

import org.selenium.aj.basetest.CommonToAllTest;
import org.selenium.aj.pages.POM.LoginPage_POM;
import org.testng.annotations.Test;

public class LoginPage extends CommonToAllTest {

    @Test
    public void enterData_LoginPage() throws InterruptedException {
        LoginPage_POM loginPagePom = new LoginPage_POM();
        loginPagePom.enterAllData_LoginPage();
        Thread.sleep(3000);

    }
}
