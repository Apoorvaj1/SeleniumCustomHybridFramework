package org.selenium.aj.tests;

import org.assertj.core.api.Assertions;
import org.selenium.aj.basetest.CommonToAllTest;
import org.selenium.aj.pages.POM.RegisterPage_POM;
import org.selenium.aj.utils.PropertyReader;
import org.testng.annotations.Test;


public class RegisterPage_NoData extends CommonToAllTest {

    @Test
    public void noDataEntered_Register() throws InterruptedException {
        RegisterPage_POM registerPagePom = new RegisterPage_POM();
        registerPagePom.clickContinueButton();
        Thread.sleep(3000);
        Assertions.assertThat(registerPagePom.errorMessage()).isNotNull().isNotBlank().contains(PropertyReader.readKey("REGISTER_ERROR_MESSAGE"));
    }

}
