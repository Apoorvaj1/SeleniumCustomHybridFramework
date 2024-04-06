package org.selenium.aj.pages.POM;

import org.openqa.selenium.By;
import org.selenium.aj.base.CommonToAllPage;

public class Dashboard_POM extends CommonToAllPage {
    public Dashboard_POM(){
        super();
    }

    By Desktops = By.linkText("Desktops");
    By MAC = By.xpath("//a[contains(text(),\"Mac \")]");

    public void clickDesktops(){
        moveToElement(Desktops).build().perform();
    }

    public void select_MAC(){
        clickElement(MAC);
    }



}
