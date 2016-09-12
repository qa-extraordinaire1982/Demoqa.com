package com.samuel.solution.keywords;

import com.samuel.solution.pages.MainPage;
import com.samuel.solution.pages.RegistrationPage;
import com.samuel.solution.pojo.User;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Keywords {

    public RegistrationPage fillRegistrationFrom(WebDriver driver, RegistrationPage registrationPage, User user) {
        return registrationPage.enterFirstName(driver, user.getFirstName())
                .enterLastName(driver, user.getLastName())
                .selectMaritalStatus(driver, user.getMaritalStatus())
                .selectHobbies(driver, user.getHobbies())
                .selectCountry(driver, user.getCountry())
                .selectDateOfBirth(driver, user.getDob())
                .enterPhoneNumber(driver, user.getPhoneNumber())
                .enterUserName(driver, user.getUsername())
                .enterEmail(driver, user.getEmail())
                .attachProfilePicture(driver, user.getFilePath())
                .enterAboutYourself(driver, user.getAboutYourself())
                .enterPassword(driver, user.getPassword())
                .clickSubmit(driver);
    }

    public boolean validateTextContentForAllTabs(WebDriver driver, MainPage mainPage) {
        boolean contentsValidated = false;
        List<WebElement> allTabs = mainPage.getAllTabs(driver);
        List<WebElement> tabContents = mainPage.getAllTabContents(driver);
        int maxCnt = allTabs.size();
        for (int i = 0; i < maxCnt; i++) {
            WebElement currentTab = allTabs.get(i);
            if (currentTab.getAttribute("aria-selected").equals("true")) {

            } else {
                currentTab.findElement(By.partialLinkText("Tab " + (i + 1))).click();
            }
            WebElement contentElement = tabContents.get(i);
            if (currentTab.getAttribute("aria-labelledBy").equals(contentElement.getAttribute("aria-labelledBy"))) {
                assertEquals(currentTab.getAttribute("aria-selected"), "true", "The attributes for aria-selected do not match");
                assertEquals(contentElement.getAttribute("aria-expanded"), "true", "The tab is not expanded");
                assertEquals(contentElement.getAttribute("aria-hidden"), "false", "The tab content is not displayed");
                assertEquals(contentElement.findElement(By.tagName("b")).getText(), "Content " + (i + 1) + " Title");
                contentsValidated = true;
            }
            if (contentsValidated) {
            } else {
                break;
            }
        }
        return contentsValidated;
    }
}
