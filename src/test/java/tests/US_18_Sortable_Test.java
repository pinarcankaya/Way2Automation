package tests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.Draggable_Page;
import pages.Selectable_Page;
import pages.Sortable_Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.concurrent.TimeUnit;

public class US_18_Sortable_Test {
    Draggable_Page page = new Draggable_Page();
    Sortable_Page sortablePage = new Sortable_Page();
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
        sortablePage.sortable.click();
        ReusableMethods.waitFor(1);
        Driver.getDriver().switchTo().frame(0);
//
//        for (WebElement w:sortablePage.defaultfonkList){
//        action.clickAndHold(w).moveToElement(sortablePage.defaultfonkList.get(0)).release().perform();
//            System.out.println(w.getText());
//            // Assert.assertTrue(w);
//        }

        int j=0;
        for(int i=6;i>=0;i--){
            action.clickAndHold(sortablePage.defaultfonkList.get(6)).perform();
            action.moveToElement(sortablePage.defaultfonkList.get(j)).perform();
            action.release().perform();
            System.out.println(sortablePage.defaultfonkList.get(j).getText());
          // String last=sortablePage.defaultfonkList.get(j).getText().endsWith(j);
          //  Assert.assertEquals(last,);
            j++;


        }





    }
}