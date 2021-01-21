package tests;


import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.Draggable_Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import javax.swing.*;
import java.util.concurrent.TimeUnit;

public class Draggable_Test {

    Draggable_Page page=new Draggable_Page();
    Actions action = new Actions(Driver.getDriver());
    @BeforeTest
    public void testName() {
        Driver.getDriver().get(ConfigReader.getProperty("way2Automation_url"));
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        page.signinButton.click();
        page.usernameTextBox.sendKeys(ConfigReader.getProperty("valid_username"));
        page.passwordTextBox.sendKeys(ConfigReader.getProperty("valid_password"));
        page.submitButton.click();
        Driver.getDriver().switchTo().defaultContent();
    }


    @Test
    public void test1() {
        ReusableMethods.waitFor(1);
        page.draggableLink.click();
        ReusableMethods.waitFor(2);
        Driver.getDriver().switchTo().frame(0);
        ReusableMethods.waitFor(1);
        action.clickAndHold(page.dragbox).perform();
        //action.dragAndDropBy(page.dragbox,100,200).perform();
        ReusableMethods.waitFor(2);
        action.moveByOffset(100,150).perform();
        Driver.getDriver().switchTo().defaultContent();

    }

    @Test
    public void test2() {
        ReusableMethods.waitFor(1);
        action.sendKeys(Keys.PAGE_DOWN).perform();
        page.draggableLink.click();
        page.constrain.click();
        Driver.getDriver().switchTo().frame(1);
        ReusableMethods.waitFor(1);
       // action.moveToElement(page.verticalBox).perform();
        action.clickAndHold(page.verticalBox).perform();
        action.moveByOffset(0,150).perform();
      //  Driver.getDriver().switchTo().defaultContent();
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
