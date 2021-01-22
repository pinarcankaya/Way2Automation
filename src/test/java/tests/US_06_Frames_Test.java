package tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.US_01_Login_Page;
import pages.US_04_Submit_Page;
import pages.US_06_Frames_Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBase;

public class US_06_Frames_Test extends TestBase {

    US_01_Login_Page us01LoginPage = new US_01_Login_Page();
    US_06_Frames_Page us06FramesPage = new US_06_Frames_Page();

    @BeforeMethod
    public void anasayfa() {
        us01LoginPage.signinButton.click();
        us01LoginPage.usernameTextBox.sendKeys(ConfigReader.getProperty("valid_username"));
        us01LoginPage.passwordTextBox.sendKeys(ConfigReader.getProperty("valid_password"));
        us01LoginPage.submitButton.click();
    }

    @Test
    public void TC_036() {
        ReusableMethods.clickStaleElement(us06FramesPage.framesMenu);

        for(WebElement w:us06FramesPage.framesList){
            System.out.println(w.getText());
        }
        int listSize=us06FramesPage.framesList.size();
        Assert.assertEquals(listSize,4);

    }

    @Test
    public void testName() {
        ReusableMethods.clickStaleElement(us06FramesPage.framesMenu);
        Driver.getDriver().switchTo().frame(us06FramesPage.firstFrame);
        us06FramesPage.newWindow.click();
        Driver.getDriver().getTitle();
    }

    @Test
    public void ttt() {
        ReusableMethods.clickStaleElement(us06FramesPage.framesMenu);
       // Driver.getDriver().switchTo().frame(us06FramesPage.firstFrame);
        us06FramesPage.openMenu.click();
        us06FramesPage.openMenu2.click();
    }
}
