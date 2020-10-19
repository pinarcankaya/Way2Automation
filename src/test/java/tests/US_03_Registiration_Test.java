package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.US_01_Login_Page;
import pages.US_03_Registiration_Page;
import utilities.ConfigReader;
import utilities.ReusableMethods;
import utilities.TestBase;

public class US_03_Registiration_Test extends TestBase {

    US_01_Login_Page us01LoginPage = new US_01_Login_Page();
    US_03_Registiration_Page us03RegistirationPage=new US_03_Registiration_Page();

    @BeforeMethod
    public void anasayfa() {
        us01LoginPage.signinButton.click();
        us01LoginPage.usernameTextBox.sendKeys(ConfigReader.getProperty("valid_username"));
        us01LoginPage.passwordTextBox.sendKeys(ConfigReader.getProperty("valid_password"));
        us01LoginPage.submitButton.click();
    }

    @Test
    public void TC_014() {
        ReusableMethods.waitFor(2);
        us03RegistirationPage.registrationMenu.click();
    }
}
