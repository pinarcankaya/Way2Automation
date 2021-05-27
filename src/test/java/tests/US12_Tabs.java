package tests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SourceType;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.US12_Tabs_Page;
import pages.US_07_Accordion_Page;
import pages.US_10_Menu_Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class US12_Tabs {

    US_07_Accordion_Page accordionPage = new US_07_Accordion_Page();
    US12_Tabs_Page us12TabsPage = new US12_Tabs_Page();
    Actions action = new Actions(Driver.getDriver());
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);

    @BeforeTest
    public void setup() {
        Driver.getDriver().get(ConfigReader.getProperty("way2Automation_url"));
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        accordionPage.enterGiris.click();
        ReusableMethods.waitFor(1);
        us12TabsPage.tabsLink.click();
        ReusableMethods.waitFor(1);
        Set<String> windowsHandle = Driver.getDriver().getWindowHandles();
        List<String> list = new ArrayList<>(windowsHandle);
        Driver.getDriver().switchTo().window(list.get(1));
    }

    @Test//Tabs kutucuğunun üzerine geldiğinizde,kutucuğun renginin griye dönüştüğünü  doğrulayınız.
    public void TC01() {
        Driver.getDriver().switchTo().frame(0);
        String a=us12TabsPage.tabsMenus.get(0).getText();
        System.out.println(a);
        String backroundColor1=us12TabsPage.tabsMenus.get(1).getCssValue("background");
        System.out.println(backroundColor1);
        action.moveToElement(us12TabsPage.tabsMenus.get(1)).perform();
        String backroundColor2=us12TabsPage.tabsMenus.get(1).getCssValue("background");
        System.out.println(backroundColor2);
        Assert.assertNotEquals(backroundColor1,backroundColor2);
    }

    @Test//Tab 1,Tab 2,Tab 3 Elementlerinin tıklanabiliyor ve Textbox'daki yazıların da görülebiliyor olduğunu assert ediniz.
    public void TC02() {
        Driver.getDriver().switchTo().frame(0);
        for (WebElement w:us12TabsPage.tabsMenus){
            w.click();
            Assert.assertTrue(w.isEnabled());
            Assert.assertTrue(w.isDisplayed());
        }
    }

    @Test//Tab 1,Tab 2,Tab 3  kutucuklarından herhangi birine tıklanıldığında ,
    // Backround renginin griden beyaza dönüştüğünü assert ediniz.
    public void TC03() {

        Driver.getDriver().switchTo().frame(0);
        for (WebElement w:us12TabsPage.tabsMenus){
            w.click();
            String color=w.getCssValue("background-color");
            System.out.println(color);
            Assert.assertEquals(color,"rgba(255, 255, 255, 1)");
        }
    }

    @Test//Tab 1 icindeki yazılar "Proin" ile başlayıp,"lectus."  ile bittiğini tespit edip doğrulayınız.
    public void TC04() {
        Driver.getDriver().switchTo().frame(0);
        String text=us12TabsPage.tab1text.getText();
        System.out.println(text);
        Assert.assertTrue(text.startsWith("Proin") && text.endsWith("lectus."));
    }
}
