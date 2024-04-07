package org.selenium.aj.pages.POM;

import org.openqa.selenium.By;
import org.selenium.aj.base.CommonToAllPage;

public class ProductList_POM extends CommonToAllPage {
    public ProductList_POM(){
        super();
    }

    By AddToCart = By.xpath("//span[text()=\"Add to Cart\"]");

    By AddToCart_iPhone = By.xpath("(//span[text()=\"Add to Cart\"])[2]");





    public void iMAC_addToCart(){
        goForJavascriptExecutor(AddToCart);
        addToCart(AddToCart);
    }

    public void iphone_addToCart(){
        goForJavascriptExecutor(AddToCart_iPhone);
        addToCart(AddToCart_iPhone);
    }

}
