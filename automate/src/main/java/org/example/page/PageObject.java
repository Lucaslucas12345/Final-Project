package org.example.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class PageObject {

    protected WebDriver webDriver;

    protected WebDriverWait webDriverWait;

    public PageObject(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
        webDriverWait = new WebDriverWait(webDriver, Duration.of(60, ChronoUnit.SECONDS), Duration.of(1000, ChronoUnit.MILLIS));
    }

}
