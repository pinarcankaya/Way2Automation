package tests;


import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.US_14_Draggable_Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.concurrent.TimeUnit;

public class US_14_Draggable_Test {

    US_14_Draggable_Page page=new US_14_Draggable_Page();
    Actions action = new Actions(Driver.getDriver());
    @BeforeTest
    public void login() {
        Driver.getDriver().get(ConfigReader.getProperty("way2Automation_url"));
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        page.signinButton.click();
        page.usernameTextBox.sendKeys(ConfigReader.getProperty("valid_username"));
        page.passwordTextBox.sendKeys(ConfigReader.getProperty("valid_password"));
        page.submitButton.click();

    }


    @Test
    public void DefaultFonk() {
        ReusableMethods.waitFor(1);
        page.draggableLink.click();
        ReusableMethods.waitFor(2);
        Driver.getDriver().switchTo().frame(0);
        ReusableMethods.waitFor(1);
        String styleBefore=page.dragbox.getAttribute("style");
        System.out.println(styleBefore);
        action.clickAndHold(page.dragbox).perform();
        ReusableMethods.waitFor(2);
        action.moveByOffset(100,150).perform();
        action.release().build().perform();
        String styleAfter=page.dragbox.getAttribute("style");
        System.out.println(styleAfter);
        Driver.getDriver().switchTo().defaultContent();
        Assert.assertNotEquals(styleBefore,styleAfter);
        Assert.assertTrue(styleAfter.equals("position: relative; width: 150px; inset: 150px auto auto 100px; height: 150px;"));
    }

    @Test
    public void ConstreinMovement() {
        ReusableMethods.waitFor(1);
        action.sendKeys(Keys.PAGE_DOWN).perform();
        page.draggableLink.click();
        page.constrain.click();
        Driver.getDriver().switchTo().frame(1);
        ReusableMethods.waitFor(1);
       // action.moveToElement(page.verticalBox).perform();
        action.clickAndHold(page.verticalBox).perform();
        action.moveByOffset(0,150).perform();
        Driver.getDriver().switchTo().defaultContent();
    }

    @Test
    public void cursorStyle() {
        ReusableMethods.waitFor(1);
        page.draggableLink.click();
        ReusableMethods.waitFor(2);

        page.cursorStyleTab.click();
        ReusableMethods.waitFor(2);
        Driver.getDriver().switchTo().frame(2);


        action.clickAndHold(page.cursorBox1).build().perform();
        String cursorTypeBefore=page.cursorBox1.getCssValue("cursor");
        System.out.println(cursorTypeBefore);
        action.clickAndHold(page.cursorBox1).release();



        // action.dragAndDropBy(page.cursorBox1,50,40).build().perform();
        //action.moveByOffset(50,40).build().perform();
        //action.moveToElement(page.cursorBox1,100,150).release();
        String cursorTypeAfter=page.cursorBox1.getCssValue("cursor");
        System.out.println(cursorTypeAfter);

        ///***
       // action.dragAndDropBy(page.cursorBox2,80,100).build().perform();



    }
}
