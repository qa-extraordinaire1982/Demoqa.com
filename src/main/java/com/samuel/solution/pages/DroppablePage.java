package com.samuel.solution.pages;

import com.samuel.solution.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class DroppablePage {

    By draggableView = By.id("draggableview");
    By droppableView = By.id("droppableview");

    public String getDroppableText(WebDriver driver) {
        return WaitUtils.waitForElement(driver, droppableView).getText();
    }

    public DroppablePage performDragDrop(WebDriver driver) {
        Actions actions = new Actions(driver);
        actions.dragAndDrop(WaitUtils.waitForElement(driver, draggableView), WaitUtils.waitForElement(driver, droppableView)).build().perform();
        return this;
    }
}
