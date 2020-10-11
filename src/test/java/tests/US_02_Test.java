package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.US_01_Login_Page;
import pages.US_02_Alert_Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBase;

public class US_02_Test  {

    US_02_Alert_Page us02AlertPage=new US_02_Alert_Page();
    US_01_Login_Page us01LoginPage=new US_01_Login_Page();
    protected Actions actions;
    protected WebDriverWait wait;

    @BeforeMethod
    public void setup() {
        Driver.getDriver().get(ConfigReader.getProperty("way2Automation_url"));
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        wait.until(ExpectedConditions.visibilityOf(us01LoginPage.signinButton));
        us01LoginPage.signinButton.click();
        us01LoginPage.usernameTextBox.sendKeys(ConfigReader.getProperty("valid_username"));
        us01LoginPage.passwordTextBox.sendKeys(ConfigReader.getProperty("valid_password"));
        us01LoginPage.submitButton.click();
    }

    @Test
    public void TC_006() {
        //Simple Alert butonuna tiklanabildigini assert ediniz
        wait.until(ExpectedConditions.elementToBeClickable(us02AlertPage.alertMenu));
        us02AlertPage.alertMenu.click();
        Assert.assertTrue(us02AlertPage.alertMenu.isSelected());
    }

    @Test
    public void TC_007() {
        //"Click to button to display an alert box" yazisini iceren textbox'in tiklanabildigini assert ediniz
        wait.until(ExpectedConditions.elementToBeClickable(us02AlertPage.alertMenu));
        us02AlertPage.alertMenu.click();
        Assert.assertTrue(us02AlertPage.simpleAlertButton.isSelected());

    }

    @Test
    public void TC_008() {
        //Texbox'a tikladiginizda Alert mesaj kutusunun aciliyor oldugunu dogrulayiniz
        wait.until(ExpectedConditions.elementToBeClickable(us02AlertPage.simpleAlertBaslik));
        us02AlertPage.alertMenu.click();
        us02AlertPage.simpleAlertButton.click();
        Driver.getDriver().switchTo().alert(); //alerte gecis
        System.out.println(Driver.getDriver().switchTo().alert().getText());  //consolda gor
        Assert.assertTrue(Driver.getDriver().switchTo().alert().getText().equals("I am an alert box!")); //dogrula

    }
}
