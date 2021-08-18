package tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.US_01_Login_Page;
import pages.US_02_Alert_Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class US_02_Alert_Test {

    US_02_Alert_Page alertPage = new US_02_Alert_Page();
    US_01_Login_Page us01LoginPage = new US_01_Login_Page();
    Set<String> windowHandles;
    List<String> list;

    @BeforeClass
    public void setUp() {

        Driver.getDriver().get(ConfigReader.getProperty("way2Automation_url"));
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.MINUTES);
        ReusableMethods.waitFor(2);
        us01LoginPage.enterGiris.click();
        Driver.getDriver().manage().window().maximize();
        ReusableMethods.waitFor(2);
        alertPage.alertMenu.click();
        ReusableMethods.waitFor(2);
        windowHandles = Driver.getDriver().getWindowHandles();
        list = new ArrayList<>(windowHandles);
        Driver.getDriver().switchTo().window(list.get(1));


    }

    @Test
    public void TC_003() {
        //Simple Alert butonuna tiklanabildigini assert ediniz
        Assert.assertTrue(alertPage.alertHeader.isEnabled());
    }

    @Test
    public void TC_004() {
        //"Click to button to display an alert box" yazisini iceren textbox'in tiklanabildigini assert ediniz
        Driver.getDriver().switchTo().frame(0);
        alertPage.simpleAlert.click();
        ReusableMethods.waitFor(2);
        Driver.getDriver().switchTo().alert().accept();
        Assert.assertTrue(alertPage.simpleAlert.isEnabled());

    }
    @Test
    public void TC_005() {
        //Texbox'a tikladiginizda Alert mesaj kutusunun aciliyor oldugunu dogrulayiniz
        ReusableMethods.waitFor(2);
        Driver.getDriver().switchTo().frame(0);
        alertPage.simpleAlert.click();
        ReusableMethods.waitFor(2);
        String alertText = Driver.getDriver().switchTo().alert().getText();
        System.out.println(alertText);
        Driver.getDriver().switchTo().alert().accept();
        Assert.assertEquals(alertText,("I am an alert box!"));

    }

    @Test
    public void TC_006() {
        //ok butonuna tiklanabildigini assert ediniz
        ReusableMethods.waitFor(2);
        Driver.getDriver().switchTo().frame(0);
        alertPage.simpleAlert.click();
        ReusableMethods.waitFor(2);
        Driver.getDriver().switchTo().alert().accept();
        Assert.assertTrue(alertPage.simpleAlert.isEnabled());
    }
    @Test  //Input alert butonuna tiklanabildigini dogrulayiniz
    public void TC_07() {
        //1.Yol
//        ReusableMethods.waitFor(2);
//        alertPage.inputMenu.click();
//        Assert.assertTrue(alertPage.inputMenu.isEnabled());
        //2.Yol
        ReusableMethods.waitFor(2);
        String rgbBefor= alertPage.inputMenu.getCssValue("background-color");
        String asHexBefor= Color.fromString(rgbBefor).asHex();
        System.out.println(asHexBefor);

        alertPage.inputMenu.click();

        String rgbAfter= alertPage.inputMenu.getCssValue("background-color");
        String asHexAfter= Color.fromString(rgbBefor).asHex();
        System.out.println(asHexAfter);

        Assert.assertNotEquals(rgbBefor,rgbAfter);

    }

    @Test
    public void TC08() {
        //"Click the button to demonstrate the input box" yazisini iceren textbox tiklanabildigini dogrulayiniz
        ReusableMethods.waitFor(2);
        alertPage.inputMenu.click();
        Driver.getDriver().switchTo().frame(1);
       Assert.assertTrue(alertPage.inputClickButton.isEnabled());

    }

    @Test
    public void TC09() {
        //Cikan Alert kutucuguna "Harry Potter" ismini yazabildiginizi dogrulayiniz
        ReusableMethods.waitFor(2);
        alertPage.inputMenu.click();
        Driver.getDriver().switchTo().frame(1);
        alertPage.inputClickButton.click();
        Driver.getDriver().switchTo().alert().sendKeys("Harry Potter");
        Driver.getDriver().switchTo().alert().accept();
        Assert.assertTrue(alertPage.haryPotreText.getText().contains("Harry Potter!"));
    }

    @Test
    public void TC10() {
        //Allertte OK tusuna basildigini dogrulayiniz
        ReusableMethods.waitFor(2);
        alertPage.inputMenu.click();
        Driver.getDriver().switchTo().frame(1);
        alertPage.inputClickButton.click();
        Driver.getDriver().switchTo().alert().accept();
        Assert.assertTrue(alertPage.inputClickButton.isEnabled());
    }

    @Test
    public void TC11() {
        //"Hello Harry Potter! How are you today?" yazisinin gorundugunu dogrulayiniz
        ReusableMethods.waitFor(2);
        alertPage.inputMenu.click();
        Driver.getDriver().switchTo().frame(1);
        alertPage.inputClickButton.click();
        Driver.getDriver().switchTo().alert().accept();
        Assert.assertTrue(alertPage.haryPotreText.isDisplayed());
    }

    @Test
    public void TC12() {
        //Allertte "Cancel" butonuna basilabildigini dogrulayiniz

        ReusableMethods.waitFor(2);
        alertPage.inputMenu.click();
        Driver.getDriver().switchTo().frame(1);
        alertPage.inputClickButton.click();
        Driver.getDriver().switchTo().alert().dismiss();
        Assert.assertTrue(alertPage.inputClickButton.isEnabled());
    }


    @AfterMethod
    public void tearDownMethod() {
        Driver.getDriver().switchTo().defaultContent();// Birden fazla fream olmasi olasiligina karsi
                                                      //  en bastaki fream'e gider'
       //  Driver.closeDriver();
    }
}
