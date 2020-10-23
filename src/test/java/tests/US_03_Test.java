package tests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.US_03_Page;
import pages.US_01_Login_Page;
import utilities.ConfigReader;
import utilities.ReusableMethods;
import utilities.TestBase;


public class US_03_Test extends TestBase {

    US_03_Page US_03_Page = new US_03_Page();
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
        wait.until(ExpectedConditions.elementToBeClickable(US_03_Page.registrationHome));
        ReusableMethods.clickStaleElement(US_03_Page.registrationHome);
        //First Name kutusuna isim yazilabildigini dogrulayiniz
        US_03_Page.firstname.sendKeys(ConfigReader.getProperty("firstname"));
        //Last Name kutusuna soyisim yazilabildigini dogrulayiniz
        US_03_Page.lastname.sendKeys(ConfigReader.getProperty("lastname"));
        //Marital Status seceneklerinden ayni anda yalniz birinin tiklanabildigini assert ediniz.
        US_03_Page.singlTextBox.click();
        //Hobby kutucuklarindan herbirinin birinin tiklanabildigini dogrulayiniz.(check Box)
//        tc_003page.hobyCricket.click();
//        tc_003page.hobyReading.click();
//        tc_003page.hobyDance.click();
        for(WebElement w : US_03_Page.hobiList){
            Assert.assertTrue(w.isEnabled());
            w.click();
        }
        //Country secilebilir oldugunu dogrulayiniz.
        Select selectCountry = new Select(US_03_Page.countryBox);
        selectCountry.selectByValue("India");
        //Date of birth 'de sirasiyla Month ,Day ve Year secilebilir oldugunu dogrulayiniz.
        Select selectMonth = new Select(US_03_Page.month);
        selectMonth.selectByIndex(1);
        Select selectDay = new Select(US_03_Page.day);
        selectDay.selectByValue("India");
        Select selectYear = new Select(US_03_Page.year);
        selectYear.selectByVisibleText("2014");
        //Phone Number kutusunun uygun sekilde doldurulabildigini assert ediniz.
        US_03_Page.phoneNumber.sendKeys(ConfigReader.getProperty("phone_number"));
        //Username kutusuna yazi yazilabildigini assert ediniz.
        US_03_Page.usernameSecond.sendKeys(ConfigReader.getProperty("valid_username"));
        //E-mail kutucugunun uygun seklide doldurulabildigini assert ediniz.
        US_03_Page.email.sendKeys(ConfigReader.getProperty("email"));
        //"Your Profile Picture  kutusunda ""Dosya Sec""butonu tiklanabilir ve

        US_03_Page.cooseFile.sendKeys("C:\\Users\\atayz\\Pictures\\Team 5.jpeg");
        //dosya secilebilir oldugunu dogrulayiniz."
        //About Yourself kutusuna yazi yazilabildigini dogrulayiniz.
        US_03_Page.aboutYourself.sendKeys("i am a student");
        //Password kutusunun uygun sekilde doldurulabildigini assert ediniz.
        US_03_Page.password.sendKeys(ConfigReader.getProperty("valid_password"));
        //Confirm Password kutusunun uygun sekilde doldurulabildigini assert ediniz.
        US_03_Page.confirmPassword.sendKeys(ConfigReader.getProperty("valid_password"));
        //Submit butonuna tiklandigini dogrulayiniz.
        US_03_Page.submitBottun.click();
        //kayit yapildigini verify ediniz
        Assert.assertTrue(US_03_Page.result.isDisplayed());

    }

}
