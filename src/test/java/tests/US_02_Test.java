package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.US_01_Login_Page;
import pages.US_02_Alert_Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBase;

public class US_02_Test extends TestBase {

    US_02_Alert_Page us02AlertPage = new US_02_Alert_Page();
    US_01_Login_Page us01LoginPage = new US_01_Login_Page();


    @BeforeMethod
    public void anasayfa() {
        us01LoginPage.signinButton.click();
        us01LoginPage.usernameTextBox.sendKeys(ConfigReader.getProperty("valid_username"));
        us01LoginPage.passwordTextBox.sendKeys(ConfigReader.getProperty("valid_password"));
        us01LoginPage.submitButton.click();
    }

    @Test
    public void TC_006() {
        //Simple Alert butonuna tiklanabildigini assert ediniz
        wait.until(ExpectedConditions.visibilityOf(us02AlertPage.alertMenu));
        //us02AlertPage.alertMenu.click();
        Assert.assertTrue(us02AlertPage.alertMenu.isEnabled());
    }

    @Test
    public void TC_007() {
        //"Click to button to display an alert box" yazisini iceren textbox'in tiklanabildigini assert ediniz
        wait.until(ExpectedConditions.visibilityOf(us02AlertPage.alertMenu));
        us02AlertPage.alertMenu.click();
        Assert.assertTrue(us02AlertPage.simpleAlertButton.isSelected());

    }

    @Test
    public void TC_008() {
        //Texbox'a tikladiginizda Alert mesaj kutusunun aciliyor oldugunu dogrulayiniz
        ReusableMethods.clickStaleElement(us02AlertPage.alertMenu);

//        boolean cevir = true;
//        int i = 0;
//        while (cevir) {
//            try {
//                wait.until(ExpectedConditions.elementToBeClickable(us02AlertPage.alertMenu));
//                us02AlertPage.alertMenu.click();
//                cevir = false;
//            } catch (StaleElementReferenceException e) {
//                cevir = true;
//            }
//            i++;
//        }
        // System.out.println(i);


        // wait.until(ExpectedConditions.visibilityOf(us02AlertPage.simpleAlertBaslik));
//        us02AlertPage.simpleAlertBaslik.click();
       // wait.until(ExpectedConditions.elementToBeClickable(us02AlertPage.simpleAlertButton));
       Driver.getDriver().switchTo().frame(us02AlertPage.frame);
        actions.click(us02AlertPage.simpleAlertButton).perform();

        wait.until(ExpectedConditions.alertIsPresent());
        Driver.getDriver().switchTo().alert(); //alerte gecis
        String alertText = Driver.getDriver().switchTo().alert().getText();
        Assert.assertTrue(alertText.equals("I am an alert box!")); //dogrula

    }

    @AfterClass
    public void tearDown() {
//        Driver.closeDriver();
    }
}
