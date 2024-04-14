package org.selenium.aj.tests;

import org.selenium.aj.basetest.CommonToAllTest;
import org.selenium.aj.pages.POM.Dashboard_POM;
import org.selenium.aj.pages.POM.ProductList_POM;
import org.testng.annotations.Test;

public class ProductListPage extends CommonToAllTest {
    ProductList_POM productListPom;
    Dashboard_POM dashboardPom;

    @Test
    public void addProduct_iMAC() throws InterruptedException {
        productListPom = new ProductList_POM();
        productListPom.iMAC_addToCart();
        Thread.sleep(3000);

    }
    @Test (dependsOnMethods = "addProduct_iMAC")
    public void addProduct_iphone() throws InterruptedException {
        dashboardPom = new Dashboard_POM();
        dashboardPom.clickPhones();
        dashboardPom.select_iphone();
        productListPom.iphone_addToCart();
        Thread.sleep(3000);
        dashboardPom.click_TotalCart();
        Thread.sleep(3000);
        System.out.println(productListPom.totalValue());
        Thread.sleep(3000);
        productListPom.clickViewCart();
        Thread.sleep(3000);
        productListPom.clickCheckout();
        Thread.sleep(5000);
        dashboardPom.clickMyAccount();
        Thread.sleep(3000);
        productListPom.clickLogout();
        Thread.sleep(3000);
        productListPom.clickContinue();
    }

}
