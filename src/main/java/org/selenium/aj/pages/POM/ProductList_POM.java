package org.selenium.aj.pages.POM;
import static org.selenium.aj.driver.DriverManager.getDriver;
import org.openqa.selenium.By;
import org.selenium.aj.base.CommonToAllPage;

public class ProductList_POM extends CommonToAllPage {
    public ProductList_POM(){
        super();
    }

    By AddToCart = By.xpath("//span[text()=\"Add to Cart\"]");

    By AddToCart_iPhone = By.xpath("(//span[text()=\"Add to Cart\"])[2]");

    By viewCart = By.xpath("//strong[text()=\" View Cart\"]");

    By checkout = By.linkText("Checkout");

    public void clickViewCart(){
        clickElement(viewCart);
    }

    public void clickCheckout(){
        goForJavascriptExecutor(checkout);
        clickElement(checkout);
    }

    public String totalValue(){
        return getDriver().findElement(By.xpath("(//table[@class=\"table table-bordered\"])[1]/tbody/tr[4]/td[2]")).getText();
    }



    public void iMAC_addToCart(){
        goForJavascriptExecutor(AddToCart);
        addToCart(AddToCart);
    }

    public void iphone_addToCart(){
        goForJavascriptExecutor(AddToCart_iPhone);
        addToCart(AddToCart_iPhone);
    }

}
