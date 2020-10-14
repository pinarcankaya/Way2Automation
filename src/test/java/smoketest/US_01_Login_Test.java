package smoketest;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import pages.US_01_Login_Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBase;

import java.security.PublicKey;

public class US_01_Login_Test extends TestBase {

    US_01_Login_Page us01LoginPage = new US_01_Login_Page();

    @Test
    public void TC_001() {
        //1)musteri http://way2automation.com/way2auto_jquery/index.php web sayfasina girebiliyor olmali
        Assert.assertTrue(us01LoginPage.RegistrationFormText.isDisplayed());
    }

    @Test
    public void TC_002() {
       // 1)dogru username ve dogru password ile giris yapilabiliyor olmal
        us01LoginPage.signinButton.click();
        us01LoginPage.usernameTextBox.sendKeys(ConfigReader.getProperty("valid_username"));
        us01LoginPage.passwordTextBox.sendKeys(ConfigReader.getProperty("valid_password"));

        us01LoginPage.submitButton.click();
    wait.until(ExpectedConditions.visibilityOf(us01LoginPage.homeText));
        Assert.assertTrue(us01LoginPage.homeText.isDisplayed());
    }

    @Test
    public void TC_003() {
        //1)yanlis username, dogru password ile giris yapilamamali
        us01LoginPage.signinButton.click();
        us01LoginPage.usernameTextBox.sendKeys(ConfigReader.getProperty("invalid_username"));
        us01LoginPage.passwordTextBox.sendKeys(ConfigReader.getProperty("valid_password"));
        us01LoginPage.submitButton.click();

        wait.until(ExpectedConditions.visibilityOf(us01LoginPage.loginErrorMesaj));
        Assert.assertTrue(us01LoginPage.loginErrorMesaj.isDisplayed());

    }

    @Test
    public void TC_004() {
        //dogru username,yanlis password  giris yapilmamali
        us01LoginPage.signinButton.click();
        us01LoginPage.usernameTextBox.sendKeys(ConfigReader.getProperty("valid_username"));
        us01LoginPage.passwordTextBox.sendKeys(ConfigReader.getProperty("invalid_password"));
        us01LoginPage.submitButton.click();

        wait.until(ExpectedConditions.visibilityOf(us01LoginPage.loginErrorMesaj));
        Assert.assertTrue(us01LoginPage.loginErrorMesaj.isDisplayed());
    }
    @Test
    public void TC_005() {
        //yanlis username,yanlis password giris yapilmamali
        us01LoginPage.signinButton.click();
        us01LoginPage.usernameTextBox.sendKeys(ConfigReader.getProperty("invalid_username"));
        us01LoginPage.passwordTextBox.sendKeys(ConfigReader.getProperty("invalid_password"));
        us01LoginPage.submitButton.click();

        wait.until(ExpectedConditions.visibilityOf(us01LoginPage.loginErrorMesaj));
        Assert.assertTrue(us01LoginPage.loginErrorMesaj.isDisplayed());
    }
    //@AfterClass
    //public void tearDown(){
      //  Driver.closeDriver();
    //}
}


