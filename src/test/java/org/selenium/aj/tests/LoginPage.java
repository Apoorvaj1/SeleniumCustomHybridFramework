package org.selenium.aj.tests;

import org.selenium.aj.DDT.ExcelReader;
import org.selenium.aj.basetest.CommonToAllTest;
import org.selenium.aj.pages.POM.LoginPage_POM;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginPage extends CommonToAllTest {
    @DataProvider(name = "loginData")
    public String[][] testDataExcel() throws IOException {
        String testDataFile = "src/test/resources/Book12.xlsx";
        ExcelReader excelReader = new ExcelReader(testDataFile);
        String[][] data = excelReader.getDataFromSheet(testDataFile, "Sheet1");
        return data;
    }

    @Test(dataProvider = "loginData")
    public void enterData_LoginPage(String username,String password) throws InterruptedException {
        LoginPage_POM loginPagePom = new LoginPage_POM();
        loginPagePom.enterAllData_LoginPage(username,password);
    }

   /* @DataProvider(name = "loginData")
    public Object[][] testData(){
        return new Object[][]{
                {"rahul@gmail.com","rules123@@"},
                {"kunal@gmail.com","kunal123@@"},
                {"Isaiah3@gmail.com","Isaiahrules"}
        };
    }*/
}
