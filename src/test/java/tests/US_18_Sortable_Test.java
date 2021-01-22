package tests;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.US_14_Draggable_Page;
import pages.US_18_Sortable_Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.concurrent.TimeUnit;

public class US_18_Sortable_Test {
    US_14_Draggable_Page page = new US_14_Draggable_Page();
    US_18_Sortable_Page sortablePage = new US_18_Sortable_Page();
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

//        for (WebElement w:sortablePage.defaultfonkList){
//        action.clickAndHold(w).moveToElement(sortablePage.defaultfonkList.get(0)).release().perform();
//            System.out.println(w.getText());
//            // Assert.assertTrue(w);
//        }

        int j=0;
        for(int i=6;i>=0;i--){
            action.clickAndHold(sortablePage.defaultfonkList.get(i)).perform();
            action.moveToElement(sortablePage.defaultfonkList.get(j)).perform();
            action.release().perform();

            j++;
            System.out.println(sortablePage.defaultfonkList.get(i).getText());
           Assert.assertTrue(sortablePage.defaultfonkList.get(i).getText().equals("Item " + i));
//eksik

        }





    }
}