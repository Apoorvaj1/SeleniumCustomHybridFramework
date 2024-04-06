package org.selenium.aj.tests;

import org.assertj.core.api.Assertions;
import org.selenium.aj.basetest.CommonToAllTest;
import org.selenium.aj.pages.POM.LoginPage_POM;
import org.selenium.aj.utils.PropertyReader;
import org.testng.annotations.Test;

public class LoginPage_NoData extends CommonToAllTest {

    @Test
    public void noDataEntered_Login() throws InterruptedException {
        LoginPage_POM loginPagePom = new LoginPage_POM();
        loginPagePom.clickLogin();
        Thread.sleep(3000);
        Assertions.assertThat(loginPagePom.error_message_login()).isNotNull().isNotBlank().contains(PropertyReader.readKey("LOGIN_ERROR_MESSAGE"));
    }

}
