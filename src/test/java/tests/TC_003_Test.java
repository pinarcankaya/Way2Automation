package tests;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.TC_003page;
import pages.US_01_Login_Page;
import pages.US_01_Page;
import utilities.ConfigReader;
import utilities.TestBase;

import java.io.FileInputStream;

public class TC_003_Test extends TestBase {

    TC_003page tc_003page = new TC_003page();
    US_01_Login_Page us01Page = new US_01_Login_Page();

    @BeforeMethod
    public void login(){
        us01Page.signinButton.click();
        us01Page.usernameTextBox.sendKeys(ConfigReader.getProperty("valid_username"));
        us01Page.passwordTextBox.sendKeys(ConfigReader.getProperty("valid_password"));
        us01Page.submitButton.click();
    }
    @Test
    public void TC_003() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(tc_003page.registrationHome));
        //actions.sendKeys(Keys.PAGE_DOWN).perform();
        tc_003page.registrationHome.click();
        //First Name kutusuna isim yazilabildigini dogrulayiniz
        tc_003page.firstname.sendKeys(ConfigReader.getProperty("firstname"));
        //Last Name kutusuna soyisim yazilabildigini dogrulayiniz
        tc_003page.lastname.sendKeys(ConfigReader.getProperty("lastname"));
        //Marital Status seceneklerinden ayni anda yalniz birinin tiklanabildigini assert ediniz.
        tc_003page.singlTextBox.click();
        //Hobby kutucuklarindan herbirinin birinin tiklanabildigini dogrulayiniz.(check Box)
        tc_003page.hobyCricket.click();
        tc_003page.hobyReading.click();
        tc_003page.hobyDance.click();
        //Country secilebilir oldugunu dogrulayiniz.
        Select selectCountry = new Select(tc_003page.countryBox);
        selectCountry.selectByValue("India");
        //Date of birth 'de sirasiyla Month ,Day ve Year secilebilir oldugunu dogrulayiniz.
        Select selectMonth = new Select(tc_003page.month);
        selectMonth.selectByIndex(1);
        Select selectDay = new Select(tc_003page.day);
        selectDay.selectByIndex(1);
        Select selectYear = new Select(tc_003page.year);
        selectYear.selectByIndex(1);
        //Phone Number kutusunun uygun sekilde doldurulabildigini assert ediniz.
        tc_003page.phoneNumber.sendKeys(ConfigReader.getProperty("phone_number"));
        //Username kutusuna yazi yazilabildigini assert ediniz.
        tc_003page.usernameSecond.sendKeys(ConfigReader.getProperty("invalid_username"));
        //E-mail kutucugunun uygun seklide doldurulabildigini assert ediniz.
        tc_003page.email.sendKeys(ConfigReader.getProperty("email"));
        //"Your Profile Picture  kutusunda ""Dosya Sec""butonu tiklanabilir ve

        tc_003page.cooseFile.sendKeys("C:\\Users\\atayz\\Pictures\\Team 5.jpeg");
        //dosya secilebilir oldugunu dogrulayiniz."
        //About Yourself kutusuna yazi yazilabildigini dogrulayiniz.
        tc_003page.aboutYourself.sendKeys("i am a student");
        //Password kutusunun uygun sekilde doldurulabildigini assert ediniz.
        tc_003page.password.sendKeys(ConfigReader.getProperty("invalid_password"));
        //Confirm Password kutusunun uygun sekilde doldurulabildigini assert ediniz.
        tc_003page.confirmPassword.sendKeys(ConfigReader.getProperty("invalid_password"));
        //Submit butonuna tiklandigini dogrulayiniz.
        tc_003page.submitBottun.click();

    }

}
