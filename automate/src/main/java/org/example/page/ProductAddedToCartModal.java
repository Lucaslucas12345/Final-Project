package org.example.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductAddedToCartModal extends PageObject {

    @FindBy(xpath = "//div[@class='cart-content-btn']/a")
    private WebElement proceedToCheckoutButton;

    public ProductAddedToCartModal(WebDriver webDriver) {
        super(webDriver);
    }

    public BasketPage clickProceedToCheckout() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(proceedToCheckoutButton));
        proceedToCheckoutButton.click();
        return new BasketPage(webDriver);
    }

}
