package org.selenium.aj.pages.POM;

import org.openqa.selenium.By;
import org.selenium.aj.base.CommonToAllPage;

public class Dashboard_POM extends CommonToAllPage {
    public Dashboard_POM(){
        super();
    }

    By Desktops = By.linkText("Desktops");
    By MAC = By.xpath("//a[contains(text(),\"Mac \")]");

    By Phones = By.linkText("Phones & PDAs");

    By CartTotal = By.xpath("//span[@id=\"cart-total\"]");

    By MyAccount = By.xpath("//span[text()=\"My Account\"]");

    By MyAccount_Dropdown = By.xpath("(//a[text()=\"Transactions\"])[1]");

    public void clickDesktops(){
        moveToElement(Desktops).build().perform();
    }


    public void clickPhones(){
        moveToElement(Phones).build().perform();
    }


    public void select_MAC(){
        clickElement(MAC);
    }

    public void select_iphone(){
        clickElement(Phones);
    }

    public void click_TotalCart(){
        goForJavascriptExecutor(CartTotal);
        clickElement(CartTotal);
    }

    public void clickMyAccount(){
        clickElement(MyAccount);
    }
    public String verifyMyAccountText(){
        return getElementText(MyAccount_Dropdown);
    }
}
