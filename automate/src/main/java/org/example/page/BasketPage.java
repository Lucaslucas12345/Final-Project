package org.example.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasketPage extends PageObject {

    @FindBy(xpath = "//div[@class='text-sm-center']/a")
    private WebElement proceedToCheckoutButton;

    public BasketPage(WebDriver webDriver) {
        super(webDriver);
    }

    public OrderDetailsPage clickProceedToCheckout() {
        proceedToCheckoutButton.click();
        return new OrderDetailsPage(webDriver);
    }

}
