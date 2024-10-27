package org.example.config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public enum WebDriverType implements DriverSetup {
    FIREFOX {
        public FirefoxDriver create() {
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        }
    },
    CHROME {
        public ChromeDriver create() {
            WebDriverManager.chromedriver().setup();
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--start-maximized");
            return new ChromeDriver(chromeOptions);
        }
    },
    IE {
        public InternetExplorerDriver create() {
            WebDriverManager.iedriver().arch32().setup();
            return new InternetExplorerDriver();
        }
    },
    EDGE {
        @Override
        public WebDriver create() {
            WebDriverManager.edgedriver().setup();
            return new EdgeDriver();
        }
    }
}
