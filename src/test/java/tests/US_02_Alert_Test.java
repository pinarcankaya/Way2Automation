package tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
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

    @BeforeClass
    public void setUp() {

        Driver.getDriver().get(ConfigReader.getProperty("way2Automation_url"));
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.MINUTES);
        ReusableMethods.waitFor(2);
        us01LoginPage.enterGiris.click();
        ReusableMethods.waitFor(2);
        alertPage.alertMenu.click();
        ReusableMethods.waitFor(2);
        Set<String> windowsHandle = Driver.getDriver().getWindowHandles();
        List<String> list = new ArrayList<>(windowsHandle);
        Driver.getDriver().switchTo().window(list.get(1));


    }

    @Test
    public void TC_003() {
        //Simple Alert butonuna tiklanabildigini assert ediniz
        System.out.println(alertPage.alertHeader.getText());
        Assert.assertTrue(alertPage.alertHeader.isDisplayed());
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
        //    Driver.getDriver().switchTo().frame(0);
        alertPage.simpleAlert.click();
        ReusableMethods.waitFor(2);
        String alertText = Driver.getDriver().switchTo().alert().getText();
        System.out.println(alertText);
        Driver.getDriver().switchTo().alert().accept();
        Assert.assertEquals(alertText, ("I am an alert box!"));

    }

    @Test
    public void TC_006() {
        //ok butonuna tiklanabildigini assert ediniz
        ReusableMethods.waitFor(2);
        //  Driver.getDriver().switchTo().frame(0);
        alertPage.simpleAlert.click();
        ReusableMethods.waitFor(2);
        Driver.getDriver().switchTo().alert().accept();
        Assert.assertTrue(alertPage.simpleAlert.isEnabled());
    }

    @Test
    public void TC_07() {
        //Input alert butonuna tiklanabildigini dogrulayiniz
//        ReusableMethods.waitFor(2);
//        Driver.getDriver().switchTo().frame(1);
//        ReusableMethods.waitFor(2);
//        String rgbBefor= alertPage.inputMenu.getCssValue("background-color");
//        String asHexBefor= Color.fromString(rgbBefor).asHex();
//        System.out.println(asHexBefor);
//        alertPage.inputMenu.click();
//          Assert.assertTrue(alertPage.inputMenu.isEnabled());
        //  wait.until(ExpectedConditions.visibilityOf(alertPage.inputMenu));
//        String rgbAfter= alertPage.inputMenu.getCssValue("background-color");
//        String asHexAfter= Color.fromString(rgbBefor).asHex();
//        System.out.println(asHexAfter);

        //maybe have a bug, i am try it tomorrow
    }

    @AfterClass
    public void tearDown() {
        Driver.closeDriver();
    }
}
