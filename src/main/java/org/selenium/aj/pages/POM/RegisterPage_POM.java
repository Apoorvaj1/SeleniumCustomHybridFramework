package org.selenium.aj.pages.POM;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.selenium.aj.base.CommonToAllPage;

public class RegisterPage_POM extends CommonToAllPage {
    Faker faker = new Faker();

    String firstname_dyanamic = faker.name().firstName();
    public String password = firstname_dyanamic+"rules";

    public String mail_id = firstname_dyanamic+faker.number().randomDigit()+"@gmail.com";

    public RegisterPage_POM(){
        super();
    }
    By FirstName = By.xpath("//input[@name=\"firstname\"]");
    By LastName = By.xpath("//input[@name=\"lastname\"]");
    By Email = By.xpath("//input[@name=\"email\"]");
    By Password = By.xpath("//input[@name=\"password\"]");
    By Checkbox = By.xpath("//input[@type=\"checkbox\"]");

    By Telephone = By.xpath("//input[@name=\"telephone\"]");

    By confirmPassword = By.xpath("//input[@name=\"confirm\"]");
    By Continue_button = By.xpath("//input[@type=\"submit\"]");

    By error_message = By.xpath("//div[text()=\" Warning: You must agree to the Privacy Policy!\"]");

    public void enterFirstName(){
        enterInput(FirstName,firstname_dyanamic);
    }

    public void enterLastName(){
        enterInput(LastName, faker.name().lastName());
    }

    public void enterEmail(){
        enterInput(Email,mail_id);
    }

    public void clickCheckbox(){
        clickElement(Checkbox);
    }

    public void clickContinueButton(){
        clickElement(Continue_button);
    }

    public void setPassword(){
        enterInput(Password,password);
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
        Thread.sleep(3000);
        enterTelephone();
        setPassword();
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