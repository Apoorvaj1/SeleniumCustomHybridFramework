package org.selenium.aj.base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.selenium.aj.utils.PropertyReader;

import java.time.Duration;

import static org.selenium.aj.driver.DriverManager.getDriver;

public class CommonToAllPage {
    public CommonToAllPage() {
        super();
    }

    public void openCartLoginURL() {
        getDriver().get(PropertyReader.readKey("URL_LOGIN"));
    }

    public void openCartRegisterURL() {
        getDriver().get(PropertyReader.readKey("URL_REGISTER"));
    }

    public void openCartHomeURL() {
        getDriver().get(PropertyReader.readKey("URL_HOMEPAGE"));
    }

    public void clickElement(By by) {
        getDriver().findElement(by).click();
    }

    public void clickElement(WebElement by){
        by.click();
    }

    public void enterInput(By by, String key) {
        getDriver().findElement(by).sendKeys(key);
    }
    public void enterInput(WebElement element, String key) {
        element.sendKeys(key);
    }

    public WebElement presenceOfElement(By elementLocation) {
        return new WebDriverWait(getDriver(), Duration.ofSeconds(20)).until(ExpectedConditions.presenceOfElementLocated(elementLocation));
    }

    public WebElement visibilityOfElement(By elementLocation) {
        return new WebDriverWait(getDriver(), Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(elementLocation));
    }

    public WebElement getElement(By key) {
        return getDriver().findElement(key);
    }

    public String getElementText(By key){
        return getDriver().findElement(key).getText();
    }

    public void goForJavascriptExecutor(By key){
        JavascriptExecutor js = (JavascriptExecutor)getDriver();
        js.executeScript("arguments[0].scrollIntoView();",getElement(key));
    }

    public Actions moveToElement(By key){
        Actions actions = new Actions(getDriver());
        return actions.moveToElement(getDriver().findElement(key));
    }

    public void addToCart(By by){
        clickElement(by);
    }

}
