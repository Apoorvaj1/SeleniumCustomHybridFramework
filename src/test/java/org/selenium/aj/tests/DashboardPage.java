package org.selenium.aj.tests;
import org.selenium.aj.basetest.CommonToAllTest;
import org.selenium.aj.pages.POM.Dashboard_POM;
import org.testng.annotations.Test;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.time.Duration;

import static org.selenium.aj.driver.DriverManagerTL.getDriver;
public class DashboardPage extends CommonToAllTest {

    private static final Logger logger = LogManager.getLogger(DashboardPage.class);


    @Test
    public void enterData_DashboardPage() {
        Dashboard_POM dashboardPom = new Dashboard_POM();
        dashboardPom.clickMyAccount();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        String actualText = dashboardPom.verifyMyAccountText();
        System.out.println("Text is: "+actualText);
        dashboardPom.clickDesktops();
        dashboardPom.select_MAC();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        logger.info("Passed");
    }

}
