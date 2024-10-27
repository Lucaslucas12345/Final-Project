package org.example.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageObject {

    @FindBy(id = "_desktop_user_info")
    private WebElement signInButton;

    @FindBy(xpath = "//div[@id='search_widget']/form/input[@type='text']")
    private WebElement searchInput;

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public LoginPage clickSignInButton() {
        signInButton.click();
        return new LoginPage(webDriver);
    }

    public ProductListPage enterSearchText(String searchText) {
        searchInput.clear();
        searchInput.sendKeys(searchText);
        searchInput.sendKeys(Keys.ENTER);
        return new ProductListPage(webDriver);
    }

}
