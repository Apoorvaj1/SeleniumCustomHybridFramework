package org.selenium.aj.pages.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.selenium.aj.base.CommonToAllPage;

import static org.selenium.aj.driver.DriverManager.getDriver;

public class LoginPage_POM extends CommonToAllPage {

    public LoginPage_POM(){
        super();
    }

    By login_button = By.xpath("//input[@type=\"submit\"]");
    By error_message_login = By.xpath("//div[text()=\" Warning: Your account has exceeded allowed number of login attempts. Please try again in 1 hour.\"]");

    By EmailAddress_Login = By.xpath("//input[@id=\"input-email\"]");

    By Password_Login = By.xpath("//input[@name=\"password\"]");

    public void clickLogin(){
        clickElement(login_button);
    }
    public String error_message_login(){
        clickLogin();
        visibilityOfElement(error_message_login);
        presenceOfElement(error_message_login);
        return getElement(error_message_login).getText();
    }

    public void clearLoginPageCredentials(){
        Actions actions = new Actions(getDriver());
        actions.click(getDriver().findElement(By.name("email")))
                .keyDown(Keys.CONTROL)
                .sendKeys("a")
                .keyUp(Keys.CONTROL)
                .sendKeys(Keys.BACK_SPACE)
                .build()
                .perform();
        actions.click(getDriver().findElement(By.name("password")))
                .keyDown(Keys.CONTROL)
                .sendKeys("a")
                .keyUp(Keys.CONTROL)
                .sendKeys(Keys.BACK_SPACE)
                .build()
                .perform();

    }

    public void enterAllData_LoginPage(String username, String password) throws InterruptedException {
        enterInput(EmailAddress_Login, username);
        enterInput(Password_Login,password);
        clickLogin();
        Thread.sleep(2000);
        clearLoginPageCredentials();
        Thread.sleep(2000);
        afterClickOnLogin();
    }

    public Dashboard_POM afterClickOnLogin(){
        return new Dashboard_POM();
    }



}
