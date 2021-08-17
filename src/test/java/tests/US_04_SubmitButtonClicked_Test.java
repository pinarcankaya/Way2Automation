package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.US_04_SubmitButtonClicked_Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class US_04_SubmitButtonClicked_Test  {
    US_04_SubmitButtonClicked_Page submitPage = new US_04_SubmitButtonClicked_Page();
    Actions action = new Actions(Driver.getDriver());
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
    Set<String> windowHandles;
    List<String> list;

    @BeforeClass
    public void setup() {
        Driver.getDriver().get(ConfigReader.getProperty("way2Automation_url"));
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        submitPage.enterGiris.click();
        action.sendKeys(Keys.PAGE_DOWN).perform();
        submitPage.submitButtonMenu.click();
        ReusableMethods.waitFor(1);
        windowHandles = Driver.getDriver().getWindowHandles();
        list = new ArrayList<>(windowHandles);
        Driver.getDriver().switchTo().window(list.get(1));
        ReusableMethods.waitFor(2);
    }


    @Test  //  ana menüde Dynemic Elements başlığı altında Submit Button Clicked olduğunu assert ediniz .
    public void TC_024() {
        Assert.assertTrue(submitPage.submitButtonMenu.isDisplayed());
    }

    @Test // Submit sayfasında 3 tane menü olduğunu doğrulayınız
    public void TC_025() {
        int list = submitPage.tabList.size();
        System.out.println(list);
        for (WebElement w : submitPage.tabList) {
            System.out.println(w.getText());
        }
        Assert.assertEquals(list, 3);
    }

    @Test  //Start With menüsündeki kutucuğa yazı yazılabildiğini doğrulayınız.
    public void TC_026() {
        Driver.getDriver().switchTo().frame(0);
        String firstText= submitPage.startsWithsubmitButton.getAttribute("id");
        System.out.println(firstText);//submit

        submitPage.startsWithTestBox.sendKeys("abc");
        submitPage.startsWithsubmitButton.click();


        String secondText= submitPage.startsWithsubmitButton.getAttribute("id");
        System.out.println(secondText);

        Assert.assertNotEquals(firstText,secondText);

    }

    @Test  //Ends With menüsüne tıklandığında zemin renginin kırmızı olduğunu doğrulayınız.
    public void TC_027() {
        submitPage.tabList.get(1).click();
        //action.moveToElement(submitPage.tabList.get(1)).perform();
        String endsWithColor= submitPage.tabList.get(1).getCssValue("background-color");
        System.out.println(endsWithColor);
        String hexColor= Color.fromString(endsWithColor).asHex();//rgb kodunu hex e cevirir//#ff0000
        System.out.println(hexColor);

        Assert.assertEquals(hexColor,"#ff0000");


    }
    @Test  //Complete ID Dynemıc menüsüne tıklandığında menünün yazı renginin beyaz olduğunu doğrulayınız
    public void  TC_028(){
        submitPage.tabList.get(2).click();
        ReusableMethods.waitFor(2);

        String completeIdDynamicColor= submitPage.tabList.get(2).getCssValue("color");
        ReusableMethods.waitFor(2);
        String hexColor=Color.fromString(completeIdDynamicColor).asHex();

        System.out.println(completeIdDynamicColor);
        System.out.println(hexColor);

        Assert.assertEquals(hexColor,"#ffffff");

    }

    @AfterMethod
    public void tearDownMethod() {
        Driver.getDriver().switchTo().defaultContent();
    }

}
