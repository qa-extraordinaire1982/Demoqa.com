package com.samuel.solution.core;

import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class CoreTestCase extends Assert {

    protected WebDriver driver;
    private final static Logger LOG = Logger.getLogger(CoreTestCase.class);

    @BeforeMethod
    public void setup() {
        String browser = System.getProperty("selenium.browser");
        driver = BrowserTypes.valueOf(browser).getDriverInstance();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }

    public static Logger log() {
        return LOG;
    }
}
