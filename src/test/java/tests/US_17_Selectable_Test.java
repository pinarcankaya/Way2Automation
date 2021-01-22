package tests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.US_14_Draggable_Page;
import pages.US_17_Selectable_Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.concurrent.TimeUnit;

public class US_17_Selectable_Test {

    US_14_Draggable_Page page = new US_14_Draggable_Page();
    US_17_Selectable_Page selectablePage = new US_17_Selectable_Page();
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

    }

    @Test
    public void defaultfonk() {
        ReusableMethods.waitFor(1);
        selectablePage.selectablelink.click();
        ReusableMethods.waitFor(1);
        Driver.getDriver().switchTo().frame(0);


        for (WebElement w : selectablePage.itemList) {
            w.click();
            Assert.assertTrue(w.isEnabled());
            String color1 = w.getCssValue("background-color");
            ReusableMethods.waitFor(1);
            System.out.println(color1);
            String hex = Color.fromString(color1).asHex();
            System.out.println(hex);
            Assert.assertEquals(hex, "#f39814");
        }
    }

    @Test
    public void displayAsGrid() {
        ReusableMethods.waitFor(1);
        selectablePage.selectablelink.click();
        // action.sendKeys(Keys.PAGE_DOWN).perform();
        selectablePage.display.click();
        ReusableMethods.waitFor(1);
        Driver.getDriver().switchTo().frame(1);


        for (WebElement w : selectablePage.displayList) {
            w.click();
            Assert.assertTrue(w.isEnabled());
            ReusableMethods.waitFor(1);
            String color2 = w.getCssValue("background-color");
            ReusableMethods.waitFor(1);
            System.out.println(color2);
            String hex = Color.fromString(color2).asHex();
            System.out.println(hex);
            Assert.assertEquals(hex, "#f39814");
        }

    }

    @Test
    public void serialize() {
        ReusableMethods.waitFor(1);
        selectablePage.selectablelink.click();
        selectablePage.serialize.click();
        ReusableMethods.waitFor(1);
        Driver.getDriver().switchTo().frame(2);

        for (int i = 0; i < selectablePage.serializeList.size(); i++) {
            selectablePage.serializeList.get(i).click();
            Assert.assertEquals(selectablePage.num.getText(), "#" + (i + 1));
            String color3 = selectablePage.serializeList.get(i).getCssValue("background-color");
            ReusableMethods.waitFor(1);
            String hex = Color.fromString(color3).asHex();
            System.out.println(hex);
            Assert.assertEquals(hex, "#f39814");
        }
    }
}