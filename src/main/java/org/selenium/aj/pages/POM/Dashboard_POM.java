package org.selenium.aj.pages.POM;

import org.openqa.selenium.By;
import org.selenium.aj.base.CommonToAllPage;

public class Dashboard_POM extends CommonToAllPage {
    public Dashboard_POM(){
        super();
    }

    private By Desktops = By.linkText("Desktops");
    private By MAC = By.xpath("//a[contains(text(),\"Mac \")]");

    private By Phones = By.linkText("Phones & PDAs");

    private By CartTotal = By.xpath("//span[@id=\"cart-total\"]");

    private By MyAccount = By.xpath("//span[text()=\"My Account\"]");

    private By MyAccount_Dropdown = By.xpath("(//a[text()=\"Transactions\"])[1]");

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
