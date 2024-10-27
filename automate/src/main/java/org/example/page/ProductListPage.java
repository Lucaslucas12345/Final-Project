package org.example.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductListPage extends PageObject {

    @FindBy(xpath = "//div[@id='js-product-list']/div/div/article/div/div/h2/a")
    private List<WebElement> products;

    public ProductListPage(WebDriver webDriver) {
        super(webDriver);
    }

    public ProductDetailsPage clickProductDetails(String productName) {
        products.stream()
                .filter(webElement -> webElement.getText().equals(productName))
                .findFirst()
                .orElseThrow()
                .click();
        return new ProductDetailsPage(webDriver);
    }

}
