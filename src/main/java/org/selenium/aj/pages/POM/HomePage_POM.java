package org.selenium.aj.pages.POM;

import org.openqa.selenium.By;
import org.selenium.aj.base.CommonToAllPage;

public class HomePage_POM extends CommonToAllPage {

    public HomePage_POM() {
        super();
    }

    //-------------Page Locators-------------------------
    private By MyAccount = By.xpath("(//span[@class=\"hidden-xs hidden-sm hidden-md\"])[3]");
    private By Currency = By.xpath("(//span[@class=\"hidden-xs hidden-sm hidden-md\"])[1]");
    private By ShoppingCart = By.xpath("(//span[@class=\"hidden-xs hidden-sm hidden-md\"])[5]");
    private By Checkout = By.xpath("(//span[@class=\"hidden-xs hidden-sm hidden-md\"])[6]");

    private By RegisterDropdown = By.linkText("Register");

    private By LoginDropdown = By.linkText("Login");

    private By Logout = By.linkText("Logout");

    public void clickMyAccount(){
        clickElement(MyAccount);
    }

    public void clickRegister(){
        clickElement(RegisterDropdown);
    }

    public void clickLogin(){
        clickElement(LoginDropdown);
    }

    public RegisterPage_POM afterClickOnRegister(){
        return new RegisterPage_POM();
    }
    public LoginPage_POM afterClickOnLogin(){
        return new LoginPage_POM();
    }

    public void clickLogout(){
        clickElement(Logout);
    }

    public void verifyCurrency(){
        presenceOfElement(Currency);
    }

}
