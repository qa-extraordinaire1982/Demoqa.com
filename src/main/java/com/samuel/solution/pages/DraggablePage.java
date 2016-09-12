package com.samuel.solution.pages;

import com.samuel.solution.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class DraggablePage {

    By draggable = By.id("draggable");

    public DraggablePage dragObjectByOffset(WebDriver driver, int x, int y) {
        Actions actions = new Actions(driver);
        actions.clickAndHold(WaitUtils.waitForElement(driver, draggable)).moveByOffset(x, y).release().build().perform();
        return this;
    }

    public Point getDraggableObjectPosition(WebDriver driver) {
        return WaitUtils.waitForElement(driver, draggable).getLocation();
    }
}
