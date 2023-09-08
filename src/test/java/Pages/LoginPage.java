package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    @FindBy(css = "input[type='email']")
    private WebElement emailField;
    @FindBy(css = "input[type='password']")
    private WebElement passwordField;
    @FindBy(css = "button[type=submit]")
    private WebElement submitBtn;

    public void login() {
        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmit();
    }


    public LoginPage provideEmail(String email) {
        wait.until(ExpectedConditions.elementToBeClickable(emailField)).clear();
        emailField.sendKeys(email);
        return this;
    }

    public LoginPage providePassword(String password) {
        wait.until(ExpectedConditions.elementToBeClickable(passwordField)).clear();
        passwordField.sendKeys(password);
        return this;
    }

    public LoginPage clickSubmit() {
        wait.until(ExpectedConditions.elementToBeClickable(submitBtn)).click();
        return this;
    }


}