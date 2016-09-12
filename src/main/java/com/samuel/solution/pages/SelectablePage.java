package com.samuel.solution.pages;

import com.samuel.solution.utils.WaitUtils;
import java.util.List;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class SelectablePage {

    By orderedList = By.id("selectable");

    public SelectablePage selectARandomObject(WebDriver driver) {
        Actions actions = new Actions(driver);
        List<WebElement> listElements = WaitUtils.waitForElement(driver, orderedList).findElements(By.tagName("li"));
        Random rnd = new Random();
        int random = rnd.nextInt(listElements.size()-1);
        actions.click(listElements.get(random)).build().perform();
        return this;
    }
}
