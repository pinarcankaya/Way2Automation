package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.US_01_Login_Page;
import pages.US_04_Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBase;

public class US_04_Test extends TestBase {
    US_01_Login_Page us01LoginPage = new US_01_Login_Page();
    US_04_Page us04Page = new US_04_Page();

    @BeforeMethod
    public void login_test() {
        us01LoginPage.signinButton.click();
        us01LoginPage.usernameTextBox.sendKeys(ConfigReader.getProperty("valid_username"));
        us01LoginPage.passwordTextBox.sendKeys(ConfigReader.getProperty("valid_password"));

        us01LoginPage.submitButton.click();
    }

    @Test
    public void TC_024t() {
        //  ana menüde Dynemic Elements başlığı altında Submit Button Clicked olduğunu assert ediniz .
        wait.until(ExpectedConditions.elementToBeClickable(us04Page.dynamicElements));
        //us04Page.dynamicElements.click();
        ReusableMethods.clickStaleElement(us04Page.dynamicElements);
        Assert.assertTrue(us04Page.submitButtonMenu.isDisplayed());
        //Select select= new Select(us04Page.dynamicElements);
        // select.deselectByIndex(1);
    }

    @Test
    public void TC_025() {
        // Submit sayfasında 3 tane menü olduğunu doğrulayınız
       // wait.until(ExpectedConditions.elementToBeClickable(us04Page.dynamicElements));
        ReusableMethods.clickStaleElement(us04Page.dynamicElements);
        us04Page.submitButtonMenu.click();
        int list = us04Page.submitButtonList.size();
        System.out.println(list);
        for (WebElement w : us04Page.submitButtonList) {
            System.out.println(w.getText());
        }
        Assert.assertEquals(list, 3);
    }

    @Test
    public void TC_026() {
        //Start With menüsündeki kutucuğa yazı yazılabildiğini doğrulayınız.
        wait.until(ExpectedConditions.elementToBeClickable(us04Page.dynamicElements));
        ReusableMethods.clickStaleElement(us04Page.dynamicElements);
        us04Page.submitButtonMenu.click();
        Driver.getDriver().switchTo().frame(0);
        String firstText=us04Page.startsWithsubmitButton.getAttribute("id");
        System.out.println(firstText);//submit

        us04Page.startsWithTestBox.sendKeys("abc");
        us04Page.startsWithsubmitButton.click();


        String secondText=us04Page.startsWithsubmitButton.getAttribute("id");
        System.out.println(secondText);

        Assert.assertNotEquals(firstText,secondText);

    }

    @Test
    public void TC_027() {
        //Ends With menüsüne tıklandığında zemin renginin kırmızı olduğunu doğrulayınız.
        ReusableMethods.clickStaleElement(us04Page.dynamicElements);
        us04Page.submitButtonMenu.click();
        us04Page.endsWith.click();
        actions.moveToElement(us04Page.endsWith).perform();
        String endsWithColor=us04Page.endsWith.getCssValue("background-color");
        System.out.println(endsWithColor);
        String hexColor= Color.fromString(endsWithColor).asHex();//rgb kodunu hex e cevirir//#ff0000
        System.out.println(hexColor);

        Assert.assertEquals(hexColor,"#ff0000");


        // Complete ID Dynemıc menüsüne tıklandığında menünün yazı renginin beyaz olduğunu doğrulayınız.
    }
    @Test
    public void  TC_028(){
        //Complete ID Dynemıc menüsüne tıklandığında menünün yazı renginin beyaz olduğunu doğrulayınız
        ReusableMethods.clickStaleElement(us04Page.dynamicElements);
        us04Page.submitButtonMenu.click();
        us04Page.completeIdDynamic.click();
        ReusableMethods.waitFor(2);

        String completeIdDynamicColor=us04Page.completeIdDynamic.getCssValue("color");
        System.out.println(completeIdDynamicColor);
        ReusableMethods.waitFor(2);

        String hexColor=Color.fromString(completeIdDynamicColor).asHex();
        System.out.println(hexColor);
        Assert.assertEquals(hexColor,"#ffffff");



    }

}
