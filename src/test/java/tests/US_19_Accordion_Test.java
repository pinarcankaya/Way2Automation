package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.US_19_Accordion_Page;
import pages.US_14_Draggable_Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.concurrent.TimeUnit;

public class US_19_Accordion_Test {

    US_19_Accordion_Page accordionPage = new US_19_Accordion_Page();
    US_14_Draggable_Page page = new US_14_Draggable_Page();
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

    }

    @Test
    public void customizeIcons() {
        ReusableMethods.waitFor(1);
        action.sendKeys(Keys.PAGE_DOWN).perform();
        accordionPage.accordionMenu.click();
        accordionPage.customizeIcons.click();
        Driver.getDriver().switchTo().frame(1);

        for (int i = 0; i < accordionPage.selectionList.size(); i++) {
            accordionPage.selectionList.get(i).click();
            Assert.assertTrue(accordionPage.selectionList.get(i).isEnabled());
        }

        ReusableMethods.waitFor(2);
        accordionPage.selectionList.get(0).click();
        System.out.println(accordionPage.selection1Text.getText());
        Assert.assertTrue(accordionPage.selection1Text.getText().startsWith("Mauris mauris ante") && accordionPage.selection1Text.getText().endsWith("vulputate."));

        //selection1' tiklaninca selection 2'deki text gorunmemeli
        Assert.assertFalse(accordionPage.selection2Text.isDisplayed());

        Driver.getDriver().switchTo().defaultContent();
    }

    @Test
    public void fillspace() {
        ReusableMethods.waitFor(1);
        action.sendKeys(Keys.PAGE_DOWN).perform();
        accordionPage.accordionMenu.click();
        accordionPage.fillspace.click();
        Driver.getDriver().switchTo().frame(2);

        action.sendKeys(Keys.ARROW_DOWN).perform();
        action.sendKeys(Keys.ARROW_DOWN).perform();

        ReusableMethods.waitFor(2);
        action.clickAndHold(accordionPage.fillSpaceResiable).moveByOffset(220, 0).build().perform();
        action.release();
        ///y eksenine deger verince calismiyor


    }
}
