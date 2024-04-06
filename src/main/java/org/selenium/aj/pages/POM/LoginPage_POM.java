package org.selenium.aj.pages.POM;

import org.openqa.selenium.By;
import org.selenium.aj.base.CommonToAllPage;

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

    public void enterAllData_LoginPage(){
        RegisterPage_POM registerPagePom = new RegisterPage_POM();
        enterInput(EmailAddress_Login,registerPagePom.mail_id);
        enterInput(Password_Login,registerPagePom.password);
        clickLogin();

    }



}
