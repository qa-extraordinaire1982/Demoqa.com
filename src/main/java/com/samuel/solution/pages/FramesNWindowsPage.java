package com.samuel.solution.pages;

import com.samuel.solution.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FramesNWindowsPage {

    By logoBy = By.className("site-anchor");
    By openSeparateWindow = By.linkText("Open Seprate New Window");
    By openSeparateNewWindow = By.linkText("Open New Seprate Window");

    public MainPage clickLogo(WebDriver driver) {
        WaitUtils.waitForElement(driver, logoBy).click();
        return new MainPage();
    }

    public FramesNWindowsPage clickOpenSeperateWindow(WebDriver driver) {
        WaitUtils.waitForElement(driver, openSeparateWindow).click();
        return this;
    }

    public NewWindowPage clickOpenNewWindow(WebDriver driver) {
        WaitUtils.waitForElement(driver, openSeparateNewWindow).click();
        while (driver.getWindowHandles().size() < 2) {
            driver.getWindowHandles();
        }
        String windowId = driver.getWindowHandle();
        for (String handleId : driver.getWindowHandles()) {
            if (handleId.equals(windowId)) {
            } else {
                driver.switchTo().window(handleId);
                break;
            }
        }
        return new NewWindowPage();
    }

}
