package org.example.test;

import org.example.config.WebDriverType;
import org.example.page.AddressFormPage;
import org.example.page.HomePage;
import org.example.page.MyAddressesPage;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;

public class AddressTest {

    @Test
    void test() {
        var webDriver = WebDriverType.CHROME.create();
        webDriver.get("https://mystore-testlab.coderslab.pl");
        var homePage = new HomePage(webDriver);
        var loginPage = homePage.clickSignInButton();
        loginPage.enterEmail("aucxowbfknuhnicmbg@nbmbb.com");
        loginPage.enterPassword("12345");
        var accountPage = loginPage.clickSignIn();
        try {
            accountPage.clickElement("add first address");
        } catch (NoSuchElementException e) {
            accountPage.clickElement("addresses");
        }
        List<String> addresses;
        List<String> aliases;
        try {
            var addressFormPage = new AddressFormPage(webDriver);
            addressFormPage.enterAddress("address test");
            addressFormPage.enterPostalCode("99-999");
            addressFormPage.enterCity("city test");
            addressFormPage.enterAlias("alias test");
            addressFormPage.selectCountry("United Kingdom");
            var myAddressesPage = addressFormPage.clickSave();
            addresses = myAddressesPage.getAddresses();
            aliases = myAddressesPage.getAliases();
        } catch (Exception e) {
            var myAddressesPage = new MyAddressesPage(webDriver);
            var addressFormPage = myAddressesPage.clickCreateAddressButton();
            addressFormPage.enterAddress("address test");
            addressFormPage.enterPostalCode("99-999");
            addressFormPage.enterCity("city test");
            addressFormPage.enterAlias("alias test");
            addressFormPage.selectCountry("United Kingdom");
            myAddressesPage = addressFormPage.clickSave();
            addresses = myAddressesPage.getAddresses();
            aliases = myAddressesPage.getAliases();
        }
        assertThat(addresses)
                .anyMatch(s -> s.contains("address test"))
                .anyMatch(s -> s.contains("99-999"))
                .anyMatch(s -> s.contains("city test"))
                .anyMatch(s -> s.contains("United Kingdom"));
        assertThat(aliases)
                .anyMatch(s -> s.contains("alias test"));
    }

}
