package com.samuel.solution.pages;

import com.samuel.solution.utils.WaitUtils;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage {

    By firstName = By.id("name_3_firstname");
    By lastName = By.id("name_3_lastname");
    By country = By.id("dropdown_7");
    By monthBy = By.id("mm_date_8");
    By dateBy = By.id("dd_date_8");
    By yearBy = By.id("yy_date_8");
    By phoneNumber = By.id("phone_9");
    By userNameBy = By.id("username");
    By emailBy = By.id("email_1");
    By profilePicture = By.id("profile_pic_10");
    By aboutYourselfBy = By.id("description");
    By passwordBy = By.id("password_2");
    By confirmPasswordBy = By.id("confirm_password_password_2");
    By submitBtn = By.name("pie_submit");
    By successBy = By.className("piereg_message");

    public RegistrationPage enterFirstName(WebDriver driver, String firstName) {
        WaitUtils.waitForElement(driver, this.firstName).sendKeys(firstName);
        return this;
    }

    public RegistrationPage enterLastName(WebDriver driver, String lastName) {
        WaitUtils.waitForElement(driver, this.lastName).sendKeys(lastName);
        return this;
    }

    public RegistrationPage clickSubmit(WebDriver driver) {
        WaitUtils.waitForElement(driver, submitBtn).click();
        return this;
    }

    public RegistrationPage enterPassword(WebDriver driver, String password) {
        WaitUtils.waitForElement(driver, passwordBy).sendKeys(password);
        WaitUtils.waitForElement(driver, confirmPasswordBy).sendKeys(password);
        return this;
    }

    public RegistrationPage attachProfilePicture(WebDriver driver, String filePath) {
        WaitUtils.waitForElement(driver, profilePicture).sendKeys(filePath);
        return this;
    }

    public RegistrationPage enterAboutYourself(WebDriver driver, String aboutYourself) {
        WaitUtils.waitForElement(driver, aboutYourselfBy).sendKeys(aboutYourself);
        return this;
    }

    public RegistrationPage enterEmail(WebDriver driver, String email) {
        WaitUtils.waitForElement(driver, emailBy).sendKeys(email);
        return this;
    }

    public RegistrationPage enterPhoneNumber(WebDriver driver, String phoneNumber) {
        WaitUtils.waitForElement(driver, this.phoneNumber).sendKeys(phoneNumber);
        return this;
    }

    public RegistrationPage enterUserName(WebDriver driver, String userName) {
        //String dateTimeStamp = "Sam_" + Long.toString(System.currentTimeMillis());
        WaitUtils.waitForElement(driver, userNameBy).sendKeys(userName);
        return this;
    }

    public RegistrationPage selectMaritalStatus(WebDriver driver, String maritalStatus) {
        By maritalStatusBy = By.xpath("//input[@value='" + maritalStatus.toLowerCase() + "']");
        WebElement maritalStatusElement = WaitUtils.waitForElement(driver, maritalStatusBy);
        maritalStatusElement.click();
        return this;
    }

    public RegistrationPage selectHobbies(WebDriver driver, List<String> hobbies) {
        for (String hobby : hobbies) {
            By hobbyBy = By.xpath("//input[contains(@value,'" + hobby.toLowerCase() + "')]");
            WebElement hobbyElement = WaitUtils.waitForElement(driver, hobbyBy);
            hobbyElement.click();
        }
        return this;
    }

    public RegistrationPage selectCountry(WebDriver driver, String country) {
        selectFromDropDown(driver, this.country, country);
        return this;
    }

    private void selectFromDropDown(WebDriver driver, By by, String text) {
        Select select = new Select(WaitUtils.waitForElement(driver, by));
        select.selectByVisibleText(text);
    }

    public RegistrationPage selectDateOfBirth(WebDriver driver, String dob) {
        String[] dobs = dob.split("/");
        selectFromDropDown(driver, monthBy, dobs[0]);
        selectFromDropDown(driver, dateBy, dobs[1]);
        selectFromDropDown(driver, yearBy, dobs[2]);
        return this;
    }

    public String getSuccessMessage(WebDriver driver) {
        return WaitUtils.waitForElement(driver, successBy).getText();
    }
}
