package com.samuel.solution.core;

import java.io.File;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public enum BrowserTypes implements DriverInstance<WebDriver> {
    CHROME {
        @Override
        public WebDriver getDriverInstance() {
            ChromeOptions options = new ChromeOptions();
            System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
            options.setBinary("D:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
            WebDriver driver = new ChromeDriver(options);
            return driver;
        }

    }, FIREFOX {
        @Override
        public WebDriver getDriverInstance() {
            //Typically the code would be:
            // WebDriver driver = new Firefox();
            //However, due to some issue in my machine, I have to hard set the path to binary.
            File pathToBinary = new File("C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
            FirefoxBinary ffBinary = new FirefoxBinary(pathToBinary);
            FirefoxProfile firefoxProfile = new FirefoxProfile();
            WebDriver driver = new FirefoxDriver(ffBinary, firefoxProfile);
            return driver;
        }

    }, IE {
        @Override
        public WebDriver getDriverInstance() {
            System.setProperty("webdriver.ie.driver", "D:\\IEDriverServer.exe");
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
            WebDriver driver = new InternetExplorerDriver(capabilities);
            return driver;
        }

    }
}
