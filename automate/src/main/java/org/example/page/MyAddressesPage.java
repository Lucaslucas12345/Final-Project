package org.example.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MyAddressesPage extends PageObject {

    @FindBy(xpath = "//address")
    private List<WebElement> addresses;
    @FindBy(xpath = "//article/div/h4")
    private List<WebElement> aliases;

    @FindBy(xpath = "//section[@id='content']/div/a")
    private WebElement createAddressButton;

    public MyAddressesPage(WebDriver webDriver) {
        super(webDriver);
    }

    public List<String> getAddresses() {
        return addresses.stream()
                .map(WebElement::getText)
                .toList();
    }

    public List<String> getAliases() {
        return aliases.stream()
                .map(WebElement::getText)
                .toList();
    }

    public AddressFormPage clickCreateAddressButton() {
        createAddressButton.click();
        return new AddressFormPage(webDriver);
    }

}
