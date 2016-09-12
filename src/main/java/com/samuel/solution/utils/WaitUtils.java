package com.samuel.solution.utils;

import com.google.common.base.Predicate;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;

public class WaitUtils {

    public static WebElement waitForElement(WebDriver driver, final By by) {
        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        wait.withTimeout(10, TimeUnit.SECONDS)
                .pollingEvery(2, TimeUnit.SECONDS)
                .until(new Predicate<WebDriver>() {
                    @Override
                    public boolean apply(WebDriver d) {
                        return ((SearchContext) d).findElements(by).size() > 0;
                    }
                });
        return driver.findElement(by);
    }
    
    public static List<WebElement> waitForElements(WebDriver driver, final By by) {
        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        wait.withTimeout(10, TimeUnit.SECONDS)
                .pollingEvery(2, TimeUnit.SECONDS)
                .until(new Predicate<WebDriver>() {
                    @Override
                    public boolean apply(WebDriver d) {
                        return ((SearchContext) d).findElements(by).size() > 0;
                    }
                });
        return driver.findElements(by);
    }
}
