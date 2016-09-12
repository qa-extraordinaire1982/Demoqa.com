package com.samuel.solution.pages;

import com.samuel.solution.utils.WaitUtils;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {

    By allTabs = By.id("tab_ul");
    By tabContents = By.className("tabcontent");

    public List<WebElement> getAllTabs(WebDriver driver) {
        return WaitUtils.waitForElement(driver, allTabs).findElements(By.tagName("li"));
    }

    public List<WebElement> getAllTabContents(WebDriver driver) {
        return WaitUtils.waitForElements(driver, tabContents);
    }
}
