package org.selenium.aj.tests;

import org.selenium.aj.basetest.CommonToAllTest;
import org.selenium.aj.pages.POM.Dashboard_POM;
import org.testng.annotations.Test;

public class DashboardPage extends CommonToAllTest {

    @Test
    public void enterData_DashboardPage() throws InterruptedException {
        Dashboard_POM dashboardPom = new Dashboard_POM();
        dashboardPom.clickMyAccount();
        Thread.sleep(2000);
        String actualText = dashboardPom.verifyMyAccountText();
        System.out.println("Text is: "+actualText);
        dashboardPom.clickDesktops();
        dashboardPom.select_MAC();
        Thread.sleep(3000);
    }

}
