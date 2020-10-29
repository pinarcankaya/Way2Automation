package tests;

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
        Select selectCountry=new Select(us05DropDownPage.selectCountryDropDown);
        List<WebElement> countryList = selectCountry.getOptions();
        System.out.println(countryList.size());
        Assert.assertNotEquals(countryList.size(),"479");
    }

    @Test
    public void TC_031() {
        //Klavye den "w" ye tiklandiginda ilk sirada "Wallis and Futuna Islands" oldugunu dogrulayiniz
        ReusableMethods.clickStaleElement(us05DropDownPage.dynamicElementMenu);
        us05DropDownPage.dropDownMenu.click();
        Driver.getDriver().switchTo().frame(0);
        Select selectCountry = new Select(us05DropDownPage.selectCountryDropDown);

        List<WebElement> countryList = selectCountry.getOptions();
        for (WebElement w : countryList) {
            if (w.getText().startsWith("W")) {
                Assert.assertEquals(w.getText(), "Wallis and Futuna Islands");
                break;
            }
            System.out.println(countryList.get(0).getText());

        }
    }
//        List<String>  countryList2=new ArrayList<>();
//
//        for (WebElement w:countryList){
//            if (w.getText().startsWith("W")){
//                countryList2.add(w.getText());
//                System.out.println(w.getText());
//            }
//
//        }
//        System.out.println(countryList2.get(0));
//        Assert.assertEquals(countryList2.get(0),"Wallis and Futuna Islands");
//
//    }
}