package smoketest;

import org.testng.annotations.Test;
import pages.US_01_Login_Page;
import utilities.ConfigReader;
import utilities.Driver;

public class US_01_Login_Test {

    US_01_Login_Page us01LoginPage=new US_01_Login_Page();
    @Test
    public void TC_001() {
        Driver.getDriver().get(ConfigReader.getProperty("way2Automation_url"));
        us01LoginPage.signinButton.click();
        us01LoginPage.usernameTextBox.sendKeys(ConfigReader.getProperty("username"));
        us01LoginPage.passwordTextBox.sendKeys(ConfigReader.getProperty("password"));
        us01LoginPage.submitButton.click();
    }

}
