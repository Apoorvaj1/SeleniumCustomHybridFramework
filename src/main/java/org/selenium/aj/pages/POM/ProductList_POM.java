package org.selenium.aj.pages.POM;
import static org.selenium.aj.driver.DriverManagerTL.getDriver;
import org.openqa.selenium.By;
import org.selenium.aj.base.CommonToAllPage;

public class ProductList_POM extends CommonToAllPage {
    public ProductList_POM(){
        super();
    }

    private By AddToCart = By.xpath("//span[text()=\"Add to Cart\"]");

    private By AddToCart_iPhone = By.xpath("(//span[text()=\"Add to Cart\"])[2]");

    private By viewCart = By.xpath("//strong[text()=\" View Cart\"]");

    private By checkout = By.linkText("Checkout");

    private By logout = By.linkText("Logout");

    private By Continue = By.linkText("Continue");

    private By totalCost = By.xpath("(//table[@class=\"table table-bordered\"])[1]/tbody/tr[4]/td[2]");

    public void clickViewCart(){
        clickElement(viewCart);
    }

    public void clickCheckout(){
        goForJavascriptExecutor(checkout);
        clickElement(checkout);
    }

    public String totalValue(){
        return getElement(totalCost).getText();
    }



    public void iMAC_addToCart(){
        goForJavascriptExecutor(AddToCart);
        addToCart(AddToCart);
    }

    public void iphone_addToCart(){
        goForJavascriptExecutor(AddToCart_iPhone);
        addToCart(AddToCart_iPhone);
    }

    public void clickLogout(){
        clickElement(logout);
    }

    public void clickContinue(){
        clickElement(Continue);
    }

}
