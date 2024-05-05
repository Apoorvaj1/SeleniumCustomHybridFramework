package org.selenium.aj.basetest;

import org.selenium.aj.driver.DriverManagerTL;
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
}
