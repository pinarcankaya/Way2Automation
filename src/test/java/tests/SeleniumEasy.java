package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.SeleniumEasyPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.concurrent.TimeUnit;

public class SeleniumEasy {

    //Kullanici, Single Input Field basligi altindaki "Enter message" box'ina mesaj yazdidinda ve
    //"Show Message" butonuna tikladiginda "Your Message:" kisminda mesaj box'ina yazmis
    //oldugu mesaji gormeli ve dogrulamalidir

    Actions action = new Actions(Driver.getDriver());
    SeleniumEasyPage seleniumEasyPage = new SeleniumEasyPage();

    @BeforeTest
    public void setup() {
        Driver.getDriver().get("https://www.seleniumeasy.com/test/");
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        seleniumEasyPage.noThanks.click();
        action.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(1);
        seleniumEasyPage.inputFormsLink.click();
        ReusableMethods.waitFor(1);
        seleniumEasyPage.simpleFormDemoLink.click();
    }

    @Test
    public void TC01() {
        seleniumEasyPage.textBox.sendKeys("Selam Dunya");
        seleniumEasyPage.showMessageButton.click();
        System.out.println(seleniumEasyPage.yourMessage.getText());
        Assert.assertTrue(seleniumEasyPage.yourMessage.isDisplayed());

    }

    //Kullanici, Two Input Fields basligi altindaki "Enter a" ve "Enter b" box'larina sayisal degerler
//disinda karakter girdiginde ve "Get Total" butonuna tiladiginda "Total a + b = NaN" mesajini
//almali ve bunu dogrulamalidir. Sayisal degerler girdiginde "Total a + b = ..." girdigi rakamlarin
//toplamini almali ve bunu dogrulayabilmelidir.
    @Test
    public void TC02() {
        seleniumEasyPage.enterA.sendKeys("ali");
        seleniumEasyPage.enterB.sendKeys("?");
        seleniumEasyPage.getTotatlButton.click();
        Assert.assertTrue(seleniumEasyPage.totatlMessage.isDisplayed());
        Assert.assertEquals(seleniumEasyPage.totatlMessage.getText(), "NaN");
        ReusableMethods.waitFor(1);
        Driver.getDriver().navigate().refresh();
        seleniumEasyPage.enterA.sendKeys("15");
        seleniumEasyPage.enterB.sendKeys("30");
        seleniumEasyPage.getTotatlButton.click();
        Assert.assertEquals(seleniumEasyPage.totatlMessage.getText(), "45");


    }

    @AfterTest
    public void tearDown() {
        Driver.closeDriver();
    }
}
