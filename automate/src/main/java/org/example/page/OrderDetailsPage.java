package org.example.page;

import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OrderDetailsPage extends PageObject {

    @FindBy(id = "field-firstname")
    private WebElement firstNameInput;
    @FindBy(id = "field-lastname")
    private WebElement lastNameInput;
    @FindBy(id = "field-email")
    private WebElement emailInput;
    @FindBy(name = "customer_privacy")
    private WebElement privacyCheckbox;
    @FindBy(name = "psgdpr")
    private WebElement termsCheckbox;
    @FindBy(name = "confirm-addresses")
    private WebElement confirmAddressesButton;
    @FindBy(xpath = "//form[@id='js-delivery']/button")
    private WebElement confirmShippingMethodButton;
    @FindBy(xpath = "//div[@id='payment-option-1-container']/span/input")
    private WebElement payByCheckButton;
    @FindBy(id = "conditions_to_approve[terms-and-conditions]")
    private WebElement approveCheckbox;
    @FindBy(xpath = "//div[@id='payment-confirmation']/div/button")
    private WebElement confirmPaymentButton;

    public OrderDetailsPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void enterFirstName(String firstName) {
        firstNameInput.clear();
        firstNameInput.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        lastNameInput.clear();
        lastNameInput.sendKeys(lastName);
    }

    public void enterEmail(String email) {
        emailInput.clear();
        emailInput.sendKeys(email);
    }

    public void clickPrivacyCheckbox() {
        privacyCheckbox.click();
    }

    public void clickTermsCheckbox() {
        termsCheckbox.click();
    }
    public void clickPayByCheckButton() {
        payByCheckButton.click();
    }
    public void clickApproveCheckbox() {
        approveCheckbox.click();
    }
    public void clickConfirmPaymentButton() {
        confirmPaymentButton.click();
    }

    public OrderDetailsPage clickConfirmAddresses() {
//        webDriverWait.until(ExpectedConditions.elementToBeClickable(continueButton));
        confirmAddressesButton.click();
        return new OrderDetailsPage(webDriver);
    }

    @SneakyThrows
    public OrderDetailsPage clickConfirmShippingMethodButton() {
        Thread.sleep(4000);
//        webDriverWait.until(ExpectedConditions.elementToBeClickable(continueButton));
        confirmShippingMethodButton.click();
        return new OrderDetailsPage(webDriver);
    }

}
