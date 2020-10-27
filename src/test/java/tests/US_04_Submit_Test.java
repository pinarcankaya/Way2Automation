package tests;

import org.apache.commons.codec.language.bm.Rule;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.US_01_Login_Page;
import pages.US_04_Submit_Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBase;

public class US_04_Submit_Test extends TestBase {

    US_01_Login_Page us01LoginPage = new US_01_Login_Page();
    US_04_Submit_Page us04SubmitPage = new US_04_Submit_Page();

    @BeforeMethod
    public void anasayfa() {
        us01LoginPage.signinButton.click();
        us01LoginPage.usernameTextBox.sendKeys(ConfigReader.getProperty("valid_username"));
        us01LoginPage.passwordTextBox.sendKeys(ConfigReader.getProperty("valid_password"));
        us01LoginPage.submitButton.click();
    }

    @Test
    public void TC_024() {
        //ana menüde Dynemic Elements başlığı altında Submit Button Clicked olduğunu assert ediniz .
        // wait.until(ExpectedConditions.visibilityOf(us04SubmitPage.dynamicElementMenu));
        ReusableMethods.clickStaleElement(us04SubmitPage.dynamicElementMenu);
        // actions.moveToElement(us04SubmitPage.dynamicElementMenu).perform();
        Assert.assertTrue(us04SubmitPage.submitButton.isDisplayed());
    }

    @Test
    public void TC_025() {
        //Submit sayfasında 3 tane menü olduğunu doğrulayınız.


        ReusableMethods.clickStaleElement(us04SubmitPage.dynamicElementMenu);
        us04SubmitPage.submitButton.click();
        int list = us04SubmitPage.submitMenuList.size();
        System.out.println("listenin uzunlugu :" + list);

        for (WebElement w : us04SubmitPage.submitMenuList) {
            System.out.println(w.getText());
        }

        Assert.assertEquals(list,3);

    }

    @Test
    public void TC_026() {
        //Start With menüsündeki kutucuğa yazı yazılabildiğini doğrulayınız.
        ReusableMethods.clickStaleElement(us04SubmitPage.dynamicElementMenu);
        us04SubmitPage.submitButton.click();
        Driver.getDriver().switchTo().frame(us04SubmitPage.firstFrame);
        ReusableMethods.waitFor(2);

        String firstText=us04SubmitPage.stasrtWithsubmitButton.getAttribute("id");
        System.out.println(firstText);//submit

        us04SubmitPage.startWithTextBox.sendKeys("abc");
        us04SubmitPage.stasrtWithsubmitButton.click();


        String secondText=us04SubmitPage.stasrtWithsubmitButton.getAttribute("id");
        System.out.println(secondText);

        Assert.assertNotEquals(firstText,secondText);

    }

    @Test
    public void TC_027() {
        //Ends With menüsüne tıklandığında zemin renginin kırmızı olduğunu doğrulayınız.
        ReusableMethods.clickStaleElement(us04SubmitPage.dynamicElementMenu);
        us04SubmitPage.submitButton.click();
       // us04SubmitPage.endsWith.click();
        actions.moveToElement(us04SubmitPage.endsWith).perform();

        String endsWithColor=us04SubmitPage.endsWith.getCssValue("background-color");
        System.out.println(endsWithColor);

        String hexColor= Color.fromString(endsWithColor).asHex();//rgb kodunu hex e cevirir//#ff0000
        System.out.println(hexColor);

        Assert.assertEquals(hexColor,"#ff0000");
    }


    @Test
    public void TC_028() {
        //Complete ID Dynemıc menüsüne tıklandığında menünün yazı renginin beyaz olduğunu doğrulayınız.
        ReusableMethods.clickStaleElement(us04SubmitPage.dynamicElementMenu);
        us04SubmitPage.submitButton.click();
        us04SubmitPage.completeIdDynamic.click();
        ReusableMethods.waitFor(2);

        String completeIdDynamicColor=us04SubmitPage.completeIdDynamic.getCssValue("color");
        System.out.println(completeIdDynamicColor);
        ReusableMethods.waitFor(2);

        String hexColor=Color.fromString(completeIdDynamicColor).asHex();
        System.out.println(hexColor);
        Assert.assertEquals(hexColor,"#ffffff");

    }

}
