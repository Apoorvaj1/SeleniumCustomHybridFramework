package org.selenium.aj.pages.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.selenium.aj.base.CommonToAllPage;

import java.time.Duration;

import static org.selenium.aj.driver.DriverManagerTL.getDriver;

public class LoginPage_POM extends CommonToAllPage {

    public LoginPage_POM(){
        super();
    }

    private By login_button = By.xpath("//input[@value=\"Login\"]");
    private By error_message_login = By.xpath("//div[text()=\" Warning: Your account has exceeded allowed number of login attempts. Please try again in 1 hour.\"]");

    private By EmailAddress_Login = By.xpath("//input[@id=\"input-email\"]");

    private By Password_Login = By.xpath("//input[@name=\"password\"]");

    public void clickLogin(){
        clickElement(login_button);
    }

    public Dashboard_POM afterClickOnLogin123(){
        return new Dashboard_POM();
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
    public void enterAllData_LoginPage(String scenario, String username, String password) throws InterruptedException {
        enterInput(EmailAddress_Login, username);
        enterInput(Password_Login,password);
        getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        clickLogin();

        if(scenario.equals("both_wrong") && error_message_login().contains("Please try again in 1 hour")){
            clearLoginPageCredentials();
            System.out.println(getDriver().getCurrentUrl());
        }
        if(scenario.equals("both_correct")){
            afterClickOnLogin123();
            System.out.println(getDriver().getCurrentUrl());
        }
        Thread.sleep(3000);

    }
}
