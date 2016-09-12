package com.samuel.solution.tests;

import com.samuel.solution.core.CoreTestCase;
import com.samuel.solution.keywords.Keywords;
import com.samuel.solution.pages.DraggablePage;
import com.samuel.solution.pages.DroppablePage;
import com.samuel.solution.pages.FramesNWindowsPage;
import com.samuel.solution.pages.MainPage;
import com.samuel.solution.pages.NewWindowPage;
import com.samuel.solution.pages.RegistrationPage;
import com.samuel.solution.pages.ResizablePage;
import com.samuel.solution.pages.SelectablePage;
import com.samuel.solution.pages.SortablePage;
import com.samuel.solution.pojo.User;
import java.net.URISyntaxException;
import java.net.URL;
import org.openqa.selenium.Point;
import org.seleniumhq.jetty9.server.HomeBaseWarning;
import org.testng.annotations.Test;

public class DemoQATest extends CoreTestCase {

    @Test
    public void testRegistrationProcess() throws URISyntaxException {
        log().info("Executing the registration test");
        driver.get("http://demoqa.com/registration/");
        RegistrationPage page = new RegistrationPage();
        Keywords keywords = new Keywords();
        User user = new User();
        user.setFirstName("TestFirstName");
        user.setLastName("TestLastName");
        user.setMaritalStatus("Single");
        user.getHobbies().add("Dance");
        user.getHobbies().add("Cricket");
        user.setCountry("United States");
        user.setDob("1/1/1980");
        user.setPhoneNumber("1234567890");
        user.setUsername("Sam_" + Long.toString(System.currentTimeMillis()));
        user.setEmail("test_" + Long.toString(System.currentTimeMillis()) + "@test.com");
        URL url = Thread.currentThread().getContextClassLoader().getResource("ABC.jpg");
        user.setFilePath(url.toURI().getRawPath().replaceFirst("/", ""));
        user.setAboutYourself("Hi, I am Sam. This is my assignment to complete this test.");
        user.setPassword("testSam@1");
        page = keywords.fillRegistrationFrom(driver, page, user);
        assertEquals(page.getSuccessMessage(driver), "Thank you for your registration", "The registration did not succeed");
    }

    @Test
    public void testDraggableFunctionality() {
        log().info("Executing the Draggable test");
        driver.get("http://demoqa.com/draggable/");
        DraggablePage page = new DraggablePage();
        Point initialPosition = page.getDraggableObjectPosition(driver);
        page = page.dragObjectByOffset(driver, 150, 160);
        Point positionAfterDragging = page.getDraggableObjectPosition(driver);
        assertEquals(positionAfterDragging.getX() - initialPosition.getX(), 150, "The position is incorrect.");
        assertEquals(positionAfterDragging.getY() - initialPosition.getY(), 160, "The position is incorrect.");
    }

    @Test
    public void testDroppableFunctionality() {
        log().info("Executing the Droppable test");
        driver.get("http://demoqa.com/droppable/");
        DroppablePage page = new DroppablePage();
        String initialDropText = page.getDroppableText(driver);
        assertEquals(initialDropText, "Drop here");
        page = page.performDragDrop(driver);
        String textAfterDropping = page.getDroppableText(driver);
        assertEquals(textAfterDropping, "Dropped!");
    }

    @Test
    public void testResizableFunctionality() {
        log().info("Executing the Resizable test");
        driver.get("http://demoqa.com/resizable/");
        ResizablePage page = new ResizablePage();
        page = page.resizeHandle(driver);
    }

    @Test
    public void testSelectableFunctionality() {
        log().info("Executing the Selectable test");
        driver.get("http://demoqa.com/selectable/");
        SelectablePage page = new SelectablePage();
        page = page.selectARandomObject(driver);
    }

    @Test
    public void testSortableFunctionality() throws InterruptedException {
        log().info("Executing the Sortable test");
        driver.get("http://demoqa.com/sortable/");
        SortablePage page = new SortablePage();
        page = page.reorderElements(driver);
    }

    @Test
    public void testValidatingTextBetweenTabs() throws InterruptedException {
        log().info("Executing the Validating Text Between tabs test");
        driver.get("http://demoqa.com/");
        MainPage page = new MainPage();
        Keywords keywords = new Keywords();
        assertTrue(keywords.validateTextContentForAllTabs(driver, page), "The validation for the tab contents failed!");
    }

    @Test
    public void testSwitchingBetweenWindows() throws InterruptedException {
        log().info("Executing the Validating Text Between tabs test");
        driver.get("http://demoqa.com/frames-and-windows/");
        FramesNWindowsPage page = new FramesNWindowsPage();
        String newWindowText = page.clickOpenSeperateWindow(driver)
                .clickOpenNewWindow(driver)
                .getEntryTitle(driver);
        assertEquals(newWindowText,"Oops! That page can’t be found.");
        driver.close();
        NewWindowPage newWindowPage = new NewWindowPage();
        newWindowPage.switchToMainWindow(driver)
                .clickLogo(driver);
    }
}
