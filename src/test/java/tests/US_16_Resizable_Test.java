package tests;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.US_14_Draggable_Page;
import pages.US_16_Resizable_Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.concurrent.TimeUnit;

public class US_16_Resizable_Test {

    US_16_Resizable_Page resizablePage = new US_16_Resizable_Page();
    US_14_Draggable_Page page = new US_14_Draggable_Page();
    Actions action = new Actions(Driver.getDriver());

    @BeforeTest
    public void singin() {
        Driver.getDriver().get(ConfigReader.getProperty("way2Automation_url"));
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        page.signinButton.click();
        page.usernameTextBox.sendKeys(ConfigReader.getProperty("valid_username"));
        page.passwordTextBox.sendKeys(ConfigReader.getProperty("valid_password"));
        page.submitButton.click();
        //  Driver.getDriver().switchTo().defaultContent();
    }

    @Test
    public void resizable1() {
        ReusableMethods.waitFor(1);
        resizablePage.resizable.click();
        ReusableMethods.waitFor(1);
        Driver.getDriver().switchTo().frame(0);
        Assert.assertTrue(resizablePage.resizable2.get(0).getAttribute("style").isEmpty());

        action.clickAndHold(resizablePage.resiableBox.get(0)).build().perform();
        action.moveByOffset(200, 100).build().perform();
        action.release();

        System.out.println(resizablePage.resizable2.get(0).getAttribute("style"));
        Assert.assertEquals(resizablePage.resizable2.get(0).getAttribute("style"), "width: 350px; height: 250px;");
        Assert.assertTrue(resizablePage.resizable2.get(0).getAttribute("style").contains("width"));

    }

    @Test
    public void resizable2() {
        ReusableMethods.waitFor(1);
        resizablePage.resizable.click();
        ReusableMethods.waitFor(1);
        resizablePage.animateBox.click();
        Driver.getDriver().switchTo().frame(1);
        ReusableMethods.waitFor(1);

        action.clickAndHold(resizablePage.resiableBox.get(0)).build().perform();
        action.moveByOffset(200, 100).build().perform();
        Assert.assertTrue(resizablePage.resizable2.get(0).getAttribute("style").isEmpty());
        action.release();
        action.click(resizablePage.resizable2.get(0)).perform();

        System.out.println(resizablePage.resizable2.get(0).getAttribute("style"));
       // Assert.assertEquals(resizablePage.resizable2.get(0).getAttribute("style"), "width: 350px; height: 250px;");
        Assert.assertTrue(resizablePage.resizable2.get(0).getAttribute("style").contains("width"));

    }
}