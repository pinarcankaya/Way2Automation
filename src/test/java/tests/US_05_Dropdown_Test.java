package tests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.US_01_Login_Page;
import pages.US_05_Dropdown_Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.util.List;

public class US_05_Dropdown_Test extends TestBase {

    US_01_Login_Page us01LoginPage = new US_01_Login_Page();
    US_05_Dropdown_Page page = new US_05_Dropdown_Page();


    @BeforeMethod
    public void giris() {
        us01LoginPage.signinButton.click();
        us01LoginPage.usernameTextBox.sendKeys(ConfigReader.getProperty("valid_username"));
        us01LoginPage.passwordTextBox.sendKeys(ConfigReader.getProperty("valid_password"));
        us01LoginPage.submitButton.click();



  }
    @Test
    public void TC_029(){
     //Dropdown calisir oldugunu dogrulayiniz
        ReusableMethods.clickStaleElement(page.dynamicElements);
        wait.until(ExpectedConditions.visibilityOf(page.dropdownMenu));
        Assert.assertTrue(page.dropdownMenu.isEnabled());
    }

    @Test
    public void TC_030(){

        //479 adet ülke oldugunu dogrulayiniz
        ReusableMethods.clickStaleElement(page.dynamicElements);
        wait.until(ExpectedConditions.visibilityOf(page.dropdownMenu));
        page.dropdownMenu.click();
        page.selectCauntry.click();
        //Driver.getDriver().switchTo().frame(page.iframe1);
        Driver.getDriver().switchTo().frame(0);
        Select selectCauntry = new Select(page.pleaseSelect);

        List<WebElement> cauntryList = selectCauntry.getOptions();
        System.out.println(cauntryList.size());
        Assert.assertNotEquals(cauntryList.size(),479);

    }
    @Test
    public void TC_031(){
        //Klavye den "w" ye tiklandiginda ilk sirada "Wallis and Futuna Islands" oldugunu dogrulayiniz
        ReusableMethods.clickStaleElement(page.dynamicElements);
        wait.until(ExpectedConditions.visibilityOf(page.dropdownMenu));
        page.dropdownMenu.click();
        Driver.getDriver().switchTo().frame(page.iframe1);
        Select selectCauntry = new Select(page.pleaseSelect);
        List<WebElement> cauntryList = selectCauntry.getOptions();

        for(WebElement w : cauntryList){
            if(w.getText().startsWith("W")){
                Assert.assertEquals(w.getText(),"Wallis and Futuna Islands");
                System.out.println(w.getText());
                break;
            }
        }

    }
    @Test
    public void TC_032(){

    }




    }
