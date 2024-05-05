package org.selenium.aj.basetest;

import org.selenium.aj.driver.DriverManagerTL;
import org.selenium.aj.utils.Helper;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class CommonToAllTest {

    @BeforeTest
    public void setUp(){
        DriverManagerTL.init("Edge");
    }

    @AfterTest
    public void tearDown(){
        DriverManagerTL.down();
    }
    @AfterMethod
    public void tearDownMethod(ITestResult result){
        if(result.getStatus()==ITestResult.FAILURE){
            Helper.captureScreenshot(DriverManagerTL.getDriver());
        }
    }
}
