package org.selenium.aj.tests;

import org.selenium.aj.basetest.CommonToAllTest;
import org.selenium.aj.pages.POM.Dashboard_POM;
import org.testng.annotations.Test;

public class DashboardPage extends CommonToAllTest {

    @Test
    public void enterData_DashboardPage() throws InterruptedException {
        Dashboard_POM dashboardPom = new Dashboard_POM();
        dashboardPom.clickDesktops();
        dashboardPom.select_MAC();
        Thread.sleep(3000);
    }

}
