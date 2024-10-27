package org.example.test;

import org.apache.commons.io.FileUtils;
import org.example.config.WebDriverType;
import org.example.page.HomePage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class OrderTest {

    @Test
    void test() {
        var webDriver = WebDriverType.CHROME.create();
        webDriver.get("https://mystore-testlab.coderslab.pl");
        var homePage = new HomePage(webDriver);
        var loginPage = homePage.clickSignInButton();
        loginPage.enterEmail("aucxowbfknuhnicmbg@nbmbb.com");
        loginPage.enterPassword("12345");
        loginPage.clickSignIn();
        var productListPage = homePage.enterSearchText("Hummingbird Printed Sweater");
        var productDetailsPage = productListPage.clickProductDetails("Hummingbird Printed Sweater");
        productDetailsPage = productDetailsPage.selectSize("M");
        productDetailsPage.enterQuantity(5);
        var productAddedToCartModal = productDetailsPage.clickAddToCardButton();
        var basketPage = productAddedToCartModal.clickProceedToCheckout();
        var orderDetailsPage = basketPage.clickProceedToCheckout();
        orderDetailsPage = orderDetailsPage.clickConfirmAddresses();
        orderDetailsPage = orderDetailsPage.clickConfirmShippingMethodButton();
        orderDetailsPage.clickPayByCheckButton();
        orderDetailsPage.clickApproveCheckbox();
        orderDetailsPage.clickConfirmPaymentButton();

        TakesScreenshot screenshot = (TakesScreenshot) webDriver;
        File screenshotFile = screenshot.getScreenshotAs(OutputType.FILE);
        File destinationFile = new File("screenshot.png");
        try {
            // Zapisanie zrzutu ekranu do pliku
            FileUtils.copyFile(screenshotFile, destinationFile);
            System.out.println("Screenshot zapisany jako screenshot.png");
        } catch (IOException e) {
            System.out.println("Wystąpił błąd podczas zapisywania zrzutu ekranu: " + e.getMessage());
        }
        webDriver.quit();
    }

}
