package org.example.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AccountPage extends PageObject {

    @FindBy(xpath = "//section[@id='content']/div/div/a")
    private List<WebElement> categories;

    public AccountPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void clickElement(String element) {
        categories.stream()
                .filter(webElement -> webElement.getText().toLowerCase().contains(element))
                .findFirst()
                .orElseThrow()
                .click();
    }

}
