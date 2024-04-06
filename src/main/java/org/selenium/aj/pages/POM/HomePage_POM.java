package org.selenium.aj.pages.POM;

import org.openqa.selenium.By;
import org.selenium.aj.base.CommonToAllPage;

public class HomePage_POM extends CommonToAllPage {

    public HomePage_POM() {
        super();
    }

    //-------------Page Locators-------------------------
    By MyAccount = By.xpath("(//span[@class=\"hidden-xs hidden-sm hidden-md\"])[3]");
    By Currency = By.xpath("(//span[@class=\"hidden-xs hidden-sm hidden-md\"])[1]");
    By ShoppingCart = By.xpath("(//span[@class=\"hidden-xs hidden-sm hidden-md\"])[5]");
    By Checkout = By.xpath("(//span[@class=\"hidden-xs hidden-sm hidden-md\"])[6]");

    By RegisterDropdown = By.linkText("Register");

    By LoginDropdown = By.linkText("Login");

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

}
