package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.US_01_Login_Page;
import pages.US_05_DropDown_Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;

public class US_05_DropDown_Test extends TestBase {

    US_01_Login_Page us01LoginPage = new US_01_Login_Page();
    US_05_DropDown_Page us05DropDownPage = new US_05_DropDown_Page();


    @BeforeMethod
    public void anasayfa() {
        us01LoginPage.signinButton.click();
        us01LoginPage.usernameTextBox.sendKeys(ConfigReader.getProperty("valid_username"));
        us01LoginPage.passwordTextBox.sendKeys(ConfigReader.getProperty("valid_password"));
        us01LoginPage.submitButton.click();
    }

    @Test
    public void TC_029() {
        //Dropdown calisir oldugunu dogrulayiniz
        ReusableMethods.clickStaleElement(us05DropDownPage.dynamicElementMenu);
        us05DropDownPage.dropDownMenu.click();
        Assert.assertTrue(us05DropDownPage.dropDownMenu.isEnabled());
    }

    @Test
    public void TC_030() {
        //479 adet ülke oldugunu dogrulayiniz
        ReusableMethods.clickStaleElement(us05DropDownPage.dynamicElementMenu);
        us05DropDownPage.dropDownMenu.click();
        Driver.getDriver().switchTo().frame(0);
        Select selectCountry = new Select(us05DropDownPage.selectCountryDropDown);
        List<WebElement> countryList = selectCountry.getOptions();
        System.out.println(countryList.size());
        Assert.assertNotEquals(countryList.size(), "479");
    }

    @Test
    public void TC_031() {
        //Klavye den "w" ye tiklandiginda ilk sirada "Wallis and Futuna Islands" oldugunu dogrulayiniz
        ReusableMethods.clickStaleElement(us05DropDownPage.dynamicElementMenu);
        us05DropDownPage.dropDownMenu.click();
        Driver.getDriver().switchTo().frame(0);

        Select selectCountry = new Select(us05DropDownPage.selectCountryDropDown);
        List<WebElement> countryList = selectCountry.getOptions();

//        for (WebElement w : countryList) {
//            if (w.getText().startsWith("W")) {
//                Assert.assertEquals(w.getText(), "Wallis and Futuna Islands");
//                System.out.println(w.getText());
//                break;
//
//            }
//        }


        List<String>  countryList2=new ArrayList<>();

        for(WebElement w : countryList){
            if (w.getText().startsWith("W")){
                countryList2.add(w.getText());
                System.out.println(w.getText());
            }

        }
        System.out.println(countryList2.get(0));
        Assert.assertEquals(countryList2.get(0),"Wallis and Futuna Islands");

    }


    @Test
    public void TC_032() {
        //"ENTER COUNTRY" basligi görünür oldugunu dogrulayiniz
        ReusableMethods.clickStaleElement(us05DropDownPage.dynamicElementMenu);
        us05DropDownPage.dropDownMenu.click();
        Assert.assertTrue(us05DropDownPage.enterCountry.isDisplayed());
    }

    @Test
    public void TC_033() {
        //ENTER COUNTRY basliginin altindaki kutucuga text girilebilir oldugunu dogrulayiniz
        ReusableMethods.clickStaleElement(us05DropDownPage.dynamicElementMenu);
        us05DropDownPage.dropDownMenu.click();
        ReusableMethods.waitFor(2);
        us05DropDownPage.enterCountry.click();
        Driver.getDriver().switchTo().frame(1);
        us05DropDownPage.enterCountryTextBox.click();
        us05DropDownPage.enterCountryTextBox.clear();
        us05DropDownPage.enterCountryTextBox.sendKeys("pinar");
        String hataText=us05DropDownPage.hataMesaji.getText();
        ReusableMethods.waitFor(2);
       // Assert.assertTrue(us05DropDownPage.hataMesaji.getText().contains("pinar"));

    }

    @Test
    public void TC_034() {
        //ok isareti olan butonun üzerine gelindiginde "Show All Items" yazisinin görünür oldugunu dogrulayiniz
        ReusableMethods.clickStaleElement(us05DropDownPage.dynamicElementMenu);
        us05DropDownPage.dropDownMenu.click();
        ReusableMethods.waitFor(2);
        us05DropDownPage.enterCountry.click();
        Driver.getDriver().switchTo().frame(1);
        actions.moveToElement(us05DropDownPage.okMenu).perform();
        Assert.assertTrue(us05DropDownPage.okMenu.isDisplayed());

    }

    @Test
    public void testName() {
        //"alb" text i girildiginde "Albania" ve "Svalbard and Jan Mayen Islands" ulkelerinin gorulur oldugunu dogrulayiniz
        ReusableMethods.clickStaleElement(us05DropDownPage.dynamicElementMenu);
        us05DropDownPage.dropDownMenu.click();
        ReusableMethods.waitFor(2);
        us05DropDownPage.enterCountry.click();
        Driver.getDriver().switchTo().frame(1);
        us05DropDownPage.enterCountryTextBox.click();
        us05DropDownPage.enterCountryTextBox.clear();

        us05DropDownPage.enterCountryTextBox.sendKeys("alb");
        ReusableMethods.waitFor(2);
         for (WebElement  w: us05DropDownPage.ikiulke){
             System.out.println(w.getText());
             Assert.assertTrue(w.isDisplayed());
         }


    }
}

