package com.samuel.solution.pages;

import com.samuel.solution.utils.WaitUtils;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewWindowPage {

    By entryTitle = By.className("entry-title");

    public String getEntryTitle(WebDriver driver) {
        return WaitUtils.waitForElement(driver, entryTitle).getText();
    }

    public FramesNWindowsPage switchToMainWindow(WebDriver driver) {
        List<String> allWindows = new ArrayList<>();
        allWindows.addAll(driver.getWindowHandles());
        driver.switchTo().window(allWindows.get(0));
        return new FramesNWindowsPage();
    }
}
