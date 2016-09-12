package com.samuel.solution.pages;

import com.samuel.solution.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class ResizablePage {

    By resizableHandle = By.className("ui-icon-gripsmall-diagonal-se");

    public ResizablePage resizeHandle(WebDriver driver) {
        Actions actions = new Actions(driver);
        actions.clickAndHold(WaitUtils.waitForElement(driver, resizableHandle)).clickAndHold().moveByOffset(50, 50).build().perform();
        return this;
    }
}
