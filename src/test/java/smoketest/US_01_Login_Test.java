package smoketest;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US_01_Login_Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBase;

public class US_01_Login_Test extends TestBase {

    US_01_Login_Page us01LoginPage=new US_01_Login_Page();

    @Test
    public void TC_001() {
        Driver.getDriver().get(ConfigReader.getProperty("way2Automation_url"));
        Assert.assertTrue(us01LoginPage.RegistrationForm.isDisplayed());
    }

    @Test
    public void TC_002() {
        us01LoginPage.signinButton.click();
        us01LoginPage.usernameTextBox.sendKeys(ConfigReader.getProperty("valid_username"));
        us01LoginPage.passwordTextBox.sendKeys(ConfigReader.getProperty("valid_password"));
        us01LoginPage.submitButton.click();
        Assert.assertTrue(us01LoginPage.HomeText.isDisplayed());
    }

    @Test
    public void TC_003() {
        Driver.getDriver().get(ConfigReader.getProperty("way2Automation_url"));
        us01LoginPage.signinButton.click();
        us01LoginPage.usernameTextBox.sendKeys(ConfigReader.getProperty("invalid_username"));
        us01LoginPage.passwordTextBox.sendKeys(ConfigReader.getProperty("invalid_password"));
        us01LoginPage.submitButton.click();
        wait.until(ExpectedConditions.visibilityOf(us01LoginPage.loginErrorMesaj));
        Assert.assertTrue(us01LoginPage.loginErrorMesaj.isDisplayed());
    }

    @Test
    public void TC_004() {
        Driver.getDriver().get(ConfigReader.getProperty("way2Automation_url"));
        us01LoginPage.signinButton.click();
        us01LoginPage.usernameTextBox.sendKeys(ConfigReader.getProperty("invalid_username"));
        us01LoginPage.passwordTextBox.sendKeys(ConfigReader.getProperty("valid_password"));
        us01LoginPage.submitButton.click();
        wait.until(ExpectedConditions.visibilityOf(us01LoginPage.loginErrorMesaj));
        Assert.assertTrue(us01LoginPage.loginErrorMesaj.isDisplayed());
    }

    @Test
    public void TC_005() {
        //1)yanlis username, dogru password ile giris yapilamamali
        Driver.getDriver().get(ConfigReader.getProperty("way2Automation_url"));
        us01LoginPage.signinButton.click();
        us01LoginPage.usernameTextBox.sendKeys(ConfigReader.getProperty("valid_username"));
        us01LoginPage.passwordTextBox.sendKeys(ConfigReader.getProperty("invalid_password"));
        us01LoginPage.submitButton.click();
        wait.until(ExpectedConditions.visibilityOf(us01LoginPage.loginErrorMesaj));
        Assert.assertTrue(us01LoginPage.loginErrorMesaj.isDisplayed());
    }
}
