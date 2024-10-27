package org.example.page;

import lombok.SneakyThrows;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;

public class ProductDetailsPage extends PageObject {

    @FindBy(id = "group_1")
    private WebElement sizeSelect;

    @FindBy(id = "quantity_wanted")
    private WebElement quantityInput;
    @FindBy(xpath = "//div[@class='add']/button[@type='submit']")
    private WebElement addToCardButton;

    public ProductDetailsPage(WebDriver webDriver) {
        super(webDriver);
    }

    public ProductDetailsPage selectSize(String size) {
        var select = new Select(sizeSelect);
        select.selectByVisibleText(size);
        return new ProductDetailsPage(webDriver);
    }

    @SneakyThrows
    public void enterQuantity(Integer quantity) {
        Thread.sleep(4000);
//        quantityInput.clear();
        quantityInput.sendKeys(Keys.BACK_SPACE + quantity.toString() + Keys.DELETE);
    }

    public ProductAddedToCartModal clickAddToCardButton() {
        webDriverWait.until((ExpectedCondition<Boolean>) driver1 -> {
            String attributeValue = addToCardButton.getAttribute("disabled");
            System.out.println(attributeValue);
            return attributeValue == null;  // Czekaj, aż atrybut zostanie usunięty (będzie null)
        });
        addToCardButton.click();
        return new ProductAddedToCartModal(webDriver);
    }

}
