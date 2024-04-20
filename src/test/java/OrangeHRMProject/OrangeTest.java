package OrangeHRMProject;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.selenium.aj.basetest.CommonToAllTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.selenium.aj.driver.DriverManagerTL.getDriver;

public class OrangeTest extends CommonToAllTest {

    Faker faker = new Faker();
    String enteredFirstName;
    String enteredLastName;

    @DataProvider(name = "loginTest")
    public Object[][] getData(){
        return new Object[][]{
                {"admin123","admin123"},
                {"Admin","admin123456"},
                {"Admin","admin123"}
        };
    }
    @Test
    public void loginValidationTest() throws InterruptedException {
        getDriver().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Thread.sleep(3000);
        WebElement loginButton = getDriver().findElement(By.cssSelector("button[class$=\"orangehrm-login-button\"]"));
        loginButton.click();
        WebElement username = getDriver().findElement(By.cssSelector("input[class$=\"oxd-input--error\"][name=\"username\"]"));
        String usernameValidation = getDriver().findElement(RelativeLocator.with(By.tagName("span")).below(username)).getText();
        System.out.println(usernameValidation);
        WebElement password = getDriver().findElement(By.cssSelector("input[class*=\"oxd-input\"][type=\"password\"]"));
        String passwordValidation = getDriver().findElement(RelativeLocator.with(By.tagName("span")).below(password)).getText();
        System.out.println(passwordValidation);
        Thread.sleep(2000);
        if(getDriver().getPageSource().contains("Login")){
            System.out.println("Yeah Login text is present");
        }
    }
    @Test(dependsOnMethods = "loginValidationTest", dataProvider = "loginTest")
    public void enterUsernameandPassword(String username1,String password1) throws InterruptedException {
        getDriver().navigate().refresh();
        Thread.sleep(2000);
        WebElement username = getDriver().findElement(By.cssSelector("input[class$=\"oxd-input--focus\"][name=\"username\"]"));
        username.sendKeys(username1);
        WebElement password = getDriver().findElement(By.cssSelector("input[class*=\"oxd-input\"][type=\"password\"]"));
        password.sendKeys(password1);
        WebElement loginButton = getDriver().findElement(By.cssSelector("button[class$=\"orangehrm-login-button\"]"));
        loginButton.click();
        Thread.sleep(4000);

    }
    @Test (dependsOnMethods = "enterUsernameandPassword")
    public void addEmployee() throws InterruptedException {
        WebElement PIM = getDriver().findElement(By.xpath("(//span[@class=\"oxd-text oxd-text--span oxd-main-menu-item--name\"])[2]"));
        PIM.click();
        Thread.sleep(2000);
       WebElement addEmployee = getDriver().findElement(By.linkText("Add Employee"));
       addEmployee.click();
       Thread.sleep(2000);
       enteredFirstName = faker.name().firstName();
       WebElement employeeFullName = getDriver().findElement(By.cssSelector("input.oxd-input.oxd-input--active.orangehrm-firstname"));
       employeeFullName.sendKeys(enteredFirstName);
       enteredLastName = faker.name().lastName();
       WebElement employeeLastName = getDriver().findElement(By.cssSelector("input.oxd-input.oxd-input--active.orangehrm-lastname"));
       employeeLastName.sendKeys(enteredLastName);
       WebElement saveButton = getDriver().findElement(By.cssSelector("button.oxd-button.oxd-button--medium.oxd-button--secondary.orangehrm-left-space"));
       if(saveButton.isDisplayed()){
           saveButton.click();
       }
       System.out.println("------------Entered details are-------------");
       System.out.println(enteredFirstName);
       System.out.println(enteredLastName);
       Thread.sleep(2000);
    }

    @Test(dependsOnMethods = "enterUsernameandPassword")
    public void verifyEmployeeData() throws InterruptedException {
        getDriver().findElement(By.linkText("Employee List")).click();
        Thread.sleep(4000);
        String name12 = enteredFirstName+" "+enteredLastName;
        if(getDriver().getPageSource().contains("Employee Information")){
            boolean visible = getDriver().findElement(By.xpath("(//div[@class=\"oxd-autocomplete-text-input oxd-autocomplete-text-input--active\"])[1]")).isDisplayed();
            System.out.println(visible);
            Thread.sleep(2000);
            getDriver().findElement(By.xpath("(//input[@placeholder=\"Type for hints...\"])[1]")).sendKeys(name12);
            getDriver().findElement(By.cssSelector("button.oxd-button.oxd-button--medium.oxd-button--secondary.orangehrm-left-space")).click();
            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            js.executeScript("window.scrollTo(0,1000)");
            Thread.sleep(4000);
            WebElement Id = getDriver().findElement(By.xpath("(//div[@class=\"oxd-table-cell oxd-padding-cell\"])[2]"));
            String name = getDriver().findElement(RelativeLocator.with(By.tagName("div")).toRightOf(Id)).getText();
            System.out.println("Name is "+name);
            if(name.equals(enteredFirstName)){
                getDriver().findElement(By.xpath("(//span[@class=\"oxd-checkbox-input oxd-checkbox-input--active --label-right oxd-checkbox-input\"])[2]")).click();
                Thread.sleep(2000);
                getDriver().findElement(By.xpath("(//button[@class=\"oxd-icon-button oxd-table-cell-action-space\"])[1]")).click();
                Thread.sleep(2000);
                getDriver().findElement(By.xpath("//button[@class=\"oxd-button oxd-button--medium oxd-button--label-danger orangehrm-button-margin\"]")).click();
            }
        }
        Thread.sleep(10000);
    }
}
