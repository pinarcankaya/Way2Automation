package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import pages.US_01_Login_Page;
import pages.US_02_Alert_Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBase;

public class US_02_Test extends TestBase {

    US_02_Alert_Page us02AlertPage=new US_02_Alert_Page();
    US_01_Login_Page us01LoginPage=new US_01_Login_Page();
    @Test
    public void TC_001() {
        wait.until(ExpectedConditions.visibilityOf(us01Page.signinButton));
        us01LoginPage.signinButton.click();
        us01LoginPage.usernameTextBox.sendKeys(ConfigReader.getProperty("username"));
        us01LoginPage.passwordTextBox.sendKeys(ConfigReader.getProperty("password"));
        us01LoginPage.submitButton.click();

        wait.until(ExpectedConditions.elementToBeClickable( us02AlertPage.alertMenu));

    }
}
