package org.selenium.aj.tests;

import org.assertj.core.api.Assertions;
import org.selenium.aj.basetest.CommonToAllTest;
import org.selenium.aj.pages.POM.RegisterPage_POM;
import org.selenium.aj.utils.PropertyReader;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.selenium.aj.driver.DriverManagerTL.getDriver;


public class RegisterPage_NoData extends CommonToAllTest {

    @Test
    public void noDataEntered_Register() {
        RegisterPage_POM registerPagePom = new RegisterPage_POM();
        registerPagePom.clickContinueButton();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        Assertions.assertThat(registerPagePom.errorMessage()).isNotNull().isNotBlank().contains(PropertyReader.readKey("REGISTER_ERROR_MESSAGE"));
    }

}
