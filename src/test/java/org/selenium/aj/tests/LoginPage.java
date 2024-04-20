package org.selenium.aj.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.selenium.aj.DDT.ExcelReader;
import org.selenium.aj.basetest.CommonToAllTest;
import org.selenium.aj.pages.POM.LoginPage_POM;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginPage extends CommonToAllTest {
    private static final Logger logger = LogManager.getLogger(LoginPage.class);
    String[][] data;

    @DataProvider(name = "loginData")
    public String[][] testDataExcel() throws IOException {
        String testDataFile = "src/test/resources/Book12.xlsx";
        ExcelReader excelReader = new ExcelReader();
        data = excelReader.getDataFromSheet(testDataFile, "Sheet1");
        return data;
    }

    @Test(dataProvider = "loginData")
    public void enterData_LoginPage(String scenario, String username,String password) throws InterruptedException {
        LoginPage_POM loginPagePom = new LoginPage_POM();
        loginPagePom.enterAllData_LoginPage(scenario,username,password);
        System.out.println("Hello");
        logger.info("Passed");
    }

    /*@DataProvider(name = "loginData")
    public Object[][] testData(){
        return new Object[][]{
                {"both_wrong","rahul@gmail.com","rules123@@"},
                {"both_wrong","kunal@gmail.com","kunal123@@"},
                {"both_correct","Isaiah3@gmail.com","Isaiahrules"}
        };
    }*/



}
