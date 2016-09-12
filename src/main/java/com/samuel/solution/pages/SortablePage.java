package com.samuel.solution.pages;

import com.samuel.solution.utils.WaitUtils;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class SortablePage {

    By unorderedList = By.id("sortable");

    public SortablePage reorderElements(WebDriver driver) throws InterruptedException {
        WebElement list = WaitUtils.waitForElement(driver, unorderedList);
        List<WebElement> items = list.findElements(By.tagName("li"));
        //for (WebElement item : items) {
            Actions actions = new Actions(driver);
            actions.clickAndHold(items.get(2)).moveByOffset(0, 100).moveByOffset(0, 200).moveByOffset(0, 100).release().build().perform();
            Thread.sleep(10000);
        //}
        return this;
    }
}
