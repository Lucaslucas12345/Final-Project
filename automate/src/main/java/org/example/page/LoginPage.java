package org.example.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

//aucxowbfknuhnicmbg@nbmbb.com
//12345
public class LoginPage extends PageObject {

    @FindBy(id = "field-email")
    private WebElement emailInput;
    @FindBy(id = "field-password")
    private WebElement passwordInput;
    @FindBy(id = "submit-login")
    private WebElement signInButton;

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void enterEmail(String email) {
        emailInput.clear();
        emailInput.sendKeys(email);
    }

    public void enterPassword(String password) {
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public AccountPage clickSignIn() {
        signInButton.click();
        return new AccountPage(webDriver);
    }

}
