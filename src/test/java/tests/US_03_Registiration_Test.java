package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
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
        ReusableMethods.waitFor(2);
        us03RegistirationPage.firstname.sendKeys(ConfigReader.getProperty("firstname"));
        us03RegistirationPage.lastname.sendKeys(ConfigReader.getProperty("lastname"));
        us03RegistirationPage.radioButton.click();
        us03RegistirationPage.checkBox.click();

        Select country=new Select(us03RegistirationPage.countryDropDown);
        country.selectByIndex(1);
        ReusableMethods.waitFor(1);

        Select month=new Select(us03RegistirationPage.monthyDropDown);
        month.selectByIndex(1);
        ReusableMethods.waitFor(1);

        Select day=new Select(us03RegistirationPage.dayDropDown);
        day.selectByIndex(1);
        ReusableMethods.waitFor(1);

        Select year=new Select(us03RegistirationPage.yearDropDown);
        year.selectByIndex(1);

        actions.sendKeys(Keys.PAGE_DOWN).perform();
        us03RegistirationPage.phoneTextBox.sendKeys(ConfigReader.getProperty("phone_number"));
        us03RegistirationPage.usernameTextBox.sendKeys(ConfigReader.getProperty("username"));
        us03RegistirationPage.emailTextBox.sendKeys(ConfigReader.getProperty("email"));

        String dosyaYukle="C:\\Users\\pinar\\Downloads\\image (12).png";
        us03RegistirationPage.chooseFileButton.sendKeys(dosyaYukle);

        us03RegistirationPage.aboutYourselfBox.sendKeys("pinarydjv");
        us03RegistirationPage.passwordTextBox.sendKeys("abc");
        us03RegistirationPage.confirimPasswordBox.sendKeys("abc");
        us03RegistirationPage.submitButton.click();

    }
}
