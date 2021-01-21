package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.Draggable_Page;
import pages.Selectable_Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.concurrent.TimeUnit;

public class US_17_Selectable_Test {

    Draggable_Page page = new Draggable_Page();
    Selectable_Page selectablePage = new Selectable_Page();
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
    public void defaultfonk() {
        ReusableMethods.waitFor(1);
        selectablePage.selectablelink.click();
        ReusableMethods.waitFor(1);
        Driver.getDriver().switchTo().frame(0);


//        selectablePage.itemList.get(1).click();
//        ReusableMethods.waitFor(5);
//        String color=selectablePage.itemList.get(1).getCssValue("background-color");
//        ReusableMethods.waitFor(5);
//        System.out.println(color);
//        String hex= Color.fromString(color).asHex();
//        System.out.println(hex);

        for (WebElement w : selectablePage.itemList) {
            w.click();
            // Assert.assertTrue(w.isSelected());
            ReusableMethods.waitFor(1);
            String color1 = w.getCssValue("background-color");
            ReusableMethods.waitFor(1);
            System.out.println(color1);

        }
    }

    @Test
    public void display() {
        ReusableMethods.waitFor(1);
        selectablePage.selectablelink.click();
        // action.sendKeys(Keys.PAGE_DOWN).perform();
        selectablePage.display.click();
        ReusableMethods.waitFor(1);
        Driver.getDriver().switchTo().frame(1);


        for (WebElement w : selectablePage.displayList) {
            w.click();
            // Assert.assertTrue(w.isSelected());
            ReusableMethods.waitFor(1);
//            String color1=w.getCssValue("background-color");
//            ReusableMethods.waitFor(1);
//            System.out.println(color1);
        }

    }

    @Test
    public void serialize() {
        ReusableMethods.waitFor(1);
        selectablePage.selectablelink.click();
        selectablePage.serialize.click();
        ReusableMethods.waitFor(1);
        Driver.getDriver().switchTo().frame(2);

        for(int i=0; i<selectablePage.serializeList.size(); i++){
            selectablePage.serializeList.get(i).click();
           Assert.assertEquals(selectablePage.num.getText(),"#"+(i+1));
            String color1 = selectablePage.serializeList.get(i).getCssValue("background-color");
            ReusableMethods.waitFor(1);
        }
    }
}