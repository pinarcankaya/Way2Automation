package tests;

import org.testng.Assert;
import org.testng.annotations.*;
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

    @BeforeMethod
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
        //  ReusableMethods.switchToWindow();


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
        ReusableMethods.waitFor(2);
        Assert.assertTrue(alertPage.simpleAlert.isEnabled());

    }

    @Test
    public void TC_005() {
        //Texbox'a tikladiginizda Alert mesaj kutusunun aciliyor oldugunu dogrulayiniz
        ReusableMethods.waitFor(2);
        Driver.getDriver().switchTo().frame(0);
        ReusableMethods.waitFor(2);
        alertPage.simpleAlert.click();
        String alertText = Driver.getDriver().switchTo().alert().getText();
        System.out.println(alertText);
        Driver.getDriver().switchTo().alert().accept();
        Assert.assertEquals(alertText, ("I am an alert box!"));

    }

    @Test
    public void TC_006() {
        //ok butonuna tiklanabildigini assert ediniz
        ReusableMethods.waitFor(2);
        Driver.getDriver().switchTo().frame(0);
        ReusableMethods.waitFor(2);
        alertPage.simpleAlert.click();
        Driver.getDriver().switchTo().alert().accept();
        Assert.assertTrue(alertPage.simpleAlert.isEnabled());
    }

    @Test
    public void TC_007() {
        //Input alert butonuna tiklanabildigini dogrulayiniz
        //Driver.getDriver().switchTo().frame(1);
        ReusableMethods.waitFor(2);
        alertPage.tabsList.get(1).click();
        Assert.assertTrue(alertPage.tabsList.get(1).isEnabled());

        //Iframe oldugu halde ifram codu yazmadan calisiyor
    }

    @Test
    public void TC_008() {
        //"Click the button to demonstrate the input box" yazisini iceren textbox tiklanabildigini dogrulayiniz.
        alertPage.tabsList.get(1).click();
        Driver.getDriver().switchTo().frame(1);
        ReusableMethods.waitFor(2);
        alertPage.inputAlert.click();
        Driver.getDriver().switchTo().alert().accept();
        Assert.assertTrue(alertPage.inputAlert.isEnabled());
    }

    @Test
    public void TC_009() {
        //Cikan Alert kutucuguna "Harry Potter" ismini yazabildiginizi dogrulayiniz
        alertPage.tabsList.get(1).click();
        Driver.getDriver().switchTo().frame(1);
        ReusableMethods.waitFor(2);
        alertPage.inputAlert.click();
        Driver.getDriver().switchTo().alert().sendKeys("Harry Potter");
        Driver.getDriver().switchTo().alert().accept();
        System.out.println(alertPage.helloText.getText());
        Assert.assertEquals(alertPage.helloText.getText(), ("Hello Harry Potter! How are you today?"));
    }

    @Test
    public void TC_010() {
        //"Hello Harry Potter! How are you today?" yazisinin gorundugunu dogrulayiniz
        alertPage.tabsList.get(1).click();
        Driver.getDriver().switchTo().frame(1);
        ReusableMethods.waitFor(2);
        alertPage.inputAlert.click();
        Driver.getDriver().switchTo().alert().sendKeys("Harry Potter");
        Driver.getDriver().switchTo().alert().accept();
        System.out.println(alertPage.helloText.getText());
        Assert.assertTrue(alertPage.helloText.isDisplayed());
    }

    @Test
    public void TC_011() {
        //Allertte "Cancel" butonuna basilabildigini dogrulayiniz
        alertPage.tabsList.get(1).click();
        Driver.getDriver().switchTo().frame(1);
        ReusableMethods.waitFor(2);
        alertPage.inputAlert.click();
        Driver.getDriver().switchTo().alert().dismiss();
        //  Assert.assertFalse(alertPage.helloText.isDisplayed());
    }

    @AfterMethod
    public void tearDown() {
        Driver.closeDriver();
    }
}
