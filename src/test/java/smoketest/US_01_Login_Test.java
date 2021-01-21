package smoketest;
<<<<<<< HEAD
import org.openqa.selenium.support.ui.ExpectedConditions;
=======

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
>>>>>>> offline
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import pages.US_01_Login_Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBase;

<<<<<<< HEAD
import java.security.PublicKey;

public class US_01_Login_Test extends TestBase {

    US_01_Login_Page us01LoginPage = new US_01_Login_Page();
=======
public class US_01_Login_Test extends TestBase {

    US_01_Login_Page us01LoginPage=new US_01_Login_Page();

>>>>>>> offline

    @Test
    public void TC_001() {
        //1)musteri http://way2automation.com/way2auto_jquery/index.php web sayfasina girebiliyor olmali
        Assert.assertTrue(us01LoginPage.RegistrationFormText.isDisplayed());
    }

    @Test
    public void TC_002() {
<<<<<<< HEAD
       // 1)dogru username ve dogru password ile giris yapilabiliyor olmal
        us01LoginPage.signinButton.click();
        us01LoginPage.usernameTextBox.sendKeys(ConfigReader.getProperty("valid_username"));
        us01LoginPage.passwordTextBox.sendKeys(ConfigReader.getProperty("valid_password"));

        us01LoginPage.submitButton.click();
    wait.until(ExpectedConditions.visibilityOf(us01LoginPage.homeText));
        Assert.assertTrue(us01LoginPage.homeText.isDisplayed());
=======
        //1)dogru username ve dogru password ile giris yapilabiliyor olmali
        us01LoginPage.signinButton.click();
        us01LoginPage.usernameTextBox.sendKeys(ConfigReader.getProperty("valid_username"));
        us01LoginPage.passwordTextBox.sendKeys(ConfigReader.getProperty("valid_password"));
        us01LoginPage.submitButton.click();
        //wait eklenebilir
        Assert.assertTrue(us01LoginPage.HomeText.isDisplayed());
>>>>>>> offline
    }

    @Test
    public void TC_003() {
        //1)yanlis username, dogru password ile giris yapilamamali
        us01LoginPage.signinButton.click();
        us01LoginPage.usernameTextBox.sendKeys(ConfigReader.getProperty("invalid_username"));
<<<<<<< HEAD
        us01LoginPage.passwordTextBox.sendKeys(ConfigReader.getProperty("valid_password"));
        us01LoginPage.submitButton.click();

        wait.until(ExpectedConditions.visibilityOf(us01LoginPage.loginErrorMesaj));
        Assert.assertTrue(us01LoginPage.loginErrorMesaj.isDisplayed());

=======
        us01LoginPage.passwordTextBox.sendKeys(ConfigReader.getProperty("invalid_password"));
        us01LoginPage.submitButton.click();
        wait.until(ExpectedConditions.visibilityOf(us01LoginPage.loginErrorMesaj));
        Assert.assertTrue(us01LoginPage.loginErrorMesaj.isDisplayed());
>>>>>>> offline
    }

    @Test
    public void TC_004() {
<<<<<<< HEAD
        //dogru username,yanlis password  giris yapilmamali
        us01LoginPage.signinButton.click();
        us01LoginPage.usernameTextBox.sendKeys(ConfigReader.getProperty("valid_username"));
        us01LoginPage.passwordTextBox.sendKeys(ConfigReader.getProperty("invalid_password"));
=======
        //1)yanlis username, dogru password ile giris yapilamamali
        us01LoginPage.signinButton.click();
        us01LoginPage.usernameTextBox.sendKeys(ConfigReader.getProperty("invalid_username"));
        us01LoginPage.passwordTextBox.sendKeys(ConfigReader.getProperty("valid_password"));
>>>>>>> offline
        us01LoginPage.submitButton.click();

        wait.until(ExpectedConditions.visibilityOf(us01LoginPage.loginErrorMesaj));
        Assert.assertTrue(us01LoginPage.loginErrorMesaj.isDisplayed());
    }
<<<<<<< HEAD
    @Test
    public void TC_005() {
        //yanlis username,yanlis password giris yapilmamali
        us01LoginPage.signinButton.click();
        us01LoginPage.usernameTextBox.sendKeys(ConfigReader.getProperty("invalid_username"));
=======

    @Test
    public void TC_005() {
       // 2)dogru username, yanlis password ile giris yapilamamali
        us01LoginPage.signinButton.click();
        us01LoginPage.usernameTextBox.sendKeys(ConfigReader.getProperty("valid_username"));
>>>>>>> offline
        us01LoginPage.passwordTextBox.sendKeys(ConfigReader.getProperty("invalid_password"));
        us01LoginPage.submitButton.click();

        wait.until(ExpectedConditions.visibilityOf(us01LoginPage.loginErrorMesaj));
        Assert.assertTrue(us01LoginPage.loginErrorMesaj.isDisplayed());
    }
<<<<<<< HEAD
    //@AfterClass
    //public void tearDown(){
      //  Driver.closeDriver();
    //}
}


=======
    @AfterClass
    public void tearDown() {
        Driver.closeDriver();
    }




}
>>>>>>> offline
