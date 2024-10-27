package org.example.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class AddressFormPage extends PageObject {

    @FindBy(id = "field-alias")
    private WebElement aliasInput;
    @FindBy(id = "field-address1")
    private WebElement addressInput;
    @FindBy(id = "field-city")
    private WebElement cityInput;
    @FindBy(id = "field-postcode")
    private WebElement postalCodeInput;
    @FindBy(id = "field-id_country")
    private WebElement countrySelect;

    @FindBy(xpath = "//button[@type=\"submit\"]")
    private WebElement saveButton;

    public AddressFormPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void enterAlias(String alias) {
        aliasInput.clear();
        aliasInput.sendKeys(alias);
    }

    public void enterAddress(String address) {
        addressInput.clear();
        addressInput.sendKeys(address);
    }

    public void enterCity(String city) {
        cityInput.clear();
        cityInput.sendKeys(city);
    }

    public void enterPostalCode(String postalCode) {
        postalCodeInput.clear();
        postalCodeInput.sendKeys(postalCode);
    }

    public void selectCountry(String country) {
        Select select = new Select(countrySelect);
        select.selectByVisibleText(country);
    }

    public MyAddressesPage clickSave() {
        saveButton.click();
        return new MyAddressesPage(webDriver);
    }

}
