package org.selenium.aj.pages.POM;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.selenium.aj.base.CommonToAllPage;

import static org.selenium.aj.driver.DriverManagerTL.getDriver;

public class RegisterPage_POM extends CommonToAllPage {
    Faker faker = new Faker();
    public String email;
    public String password12;


    final String firstname_dyanamic = faker.name().firstName();
    final String password = firstname_dyanamic+"rules123@";

    public String mail_id = firstname_dyanamic+faker.number().randomDigit()+"@gmail.com";


    public RegisterPage_POM(){
        super();
    }
    private By FirstName = By.xpath("//input[@name=\"firstname\"]");
    private By LastName = By.xpath("//input[@name=\"lastname\"]");
    private By Email = By.xpath("//input[@name=\"email\"]");
    private By Password = By.xpath("//input[@name=\"password\"]");
    private By Checkbox = By.xpath("//input[@type=\"checkbox\"]");

    private By Telephone = By.xpath("//input[@name=\"telephone\"]");

    private By confirmPassword = By.xpath("//input[@name=\"confirm\"]");
    private By Continue_button = By.xpath("//input[@type=\"submit\"]");

    private By error_message = By.xpath("//div[text()=\" Warning: You must agree to the Privacy Policy!\"]");

    public void enterFirstName(){
        enterInput(FirstName,firstname_dyanamic);
    }

    public void enterLastName(){
        enterInput(LastName, faker.name().lastName());
    }

    public String enterEmail(){
        enterInput(Email,mail_id);
        return mail_id;
    }

    public void clickCheckbox(){
        clickElement(Checkbox);
    }

    public void clickContinueButton(){
        clickElement(Continue_button);
    }

    public String setPassword(){
        enterInput(Password,password);
        return password;
    }

    public void setConfirmPassword(){
        enterInput(confirmPassword,password);
    }

    public void enterTelephone(){
        enterInput(Telephone, String.valueOf(faker.number().numberBetween(1,100000000)));
    }

    public void enterAllData_Register() throws InterruptedException {
        enterFirstName();
        enterLastName();
        enterEmail();
        email = getDriver().findElement(By.xpath("//input[@id=\"input-email\"]")).getAttribute("value");
        System.out.println(email);
        Thread.sleep(3000);
        enterTelephone();
        setPassword();
        password12 = getDriver().findElement(By.xpath("//input[@id=\"input-password\"]")).getAttribute("value");
        System.out.println(password12);
        setConfirmPassword();
        goForJavascriptExecutor(Checkbox);
        clickCheckbox();
        clickContinueButton();

    }

    public String errorMessage(){
        clickContinueButton();
        visibilityOfElement(error_message);
        presenceOfElement(error_message);
        return getElement(error_message).getText();
    }


}