package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.US_14_Draggable_Page;
import pages.US_22_Menu_Page;
import pages.US_23_Slider_Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.concurrent.TimeUnit;

public class US_23_Slider_Test {

    US_14_Draggable_Page page = new US_14_Draggable_Page();
    US_23_Slider_Page sliderPage = new US_23_Slider_Page();
    Actions action = new Actions(Driver.getDriver());


    @BeforeTest
    public void login() {
        Driver.getDriver().get(ConfigReader.getProperty("way2Automation_url"));
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        page.signinButton.click();
        page.usernameTextBox.sendKeys(ConfigReader.getProperty("valid_username"));
        page.passwordTextBox.sendKeys(ConfigReader.getProperty("valid_password"));
        page.submitButton.click();

    }

    @Test
    public void simpleMenu() {
        ReusableMethods.waitFor(1);
        action.sendKeys(Keys.PAGE_DOWN).perform();
        sliderPage.sliderLink.click();
        Driver.getDriver().switchTo().frame(0);
        ReusableMethods.waitFor(2);
      //  action.dragAndDropBy(sliderPage.sliderButton,44 , 0).build().perform();
     // action.moveToElement(sliderPage.sliderButton).moveByOffset(44,0).release().perform();
      //  action.moveByOffset(44,0).build().perform();

        JavascriptExecutor js= (JavascriptExecutor)Driver.getDriver();

        js.executeScript("arguments[0].setAttribute('style', 'left: 99%;')",sliderPage.sliderButton);
    }












}