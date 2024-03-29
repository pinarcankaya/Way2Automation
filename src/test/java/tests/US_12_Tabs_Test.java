package tests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.US_12_Tabs_Page;
import pages.US_07_Accordion_Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class US_12_Tabs_Test {

    US_07_Accordion_Page accordionPage = new US_07_Accordion_Page();
    US_12_Tabs_Page us12TabsPage = new US_12_Tabs_Page();
    Actions action = new Actions(Driver.getDriver());
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
    Set<String> windowsHandles ;
    List<String> list;

    @BeforeClass
    public void setup() {
        Driver.getDriver().get(ConfigReader.getProperty("way2Automation_url"));
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        accordionPage.enterGiris.click();
        ReusableMethods.waitFor(2);

    }

    @Test//Tabs kutucuğunun üzerine geldiğinizde,kutucuğun renginin griye dönüştüğünü  doğrulayınız.
    public void TC01() {

        String rgbColorBefor= us12TabsPage.tabsLink.getCssValue("background-color");
        String hexColor= Color.fromString(rgbColorBefor).asHex();
        System.out.println("Before ashex "+hexColor);//Before ashex #000000
        System.out.println("rgb Before "+rgbColorBefor);//rgb Before rgba(0, 0, 0, 0)
        ReusableMethods.hover(us12TabsPage.tabsLink);
        String rgbColorAfter= us12TabsPage.tabsLink.getCssValue("background-color");
        String colorHexAfter= Color.fromString(rgbColorAfter).asHex();
        System.out.println(colorHexAfter);//#333333
        System.out.println(rgbColorAfter);//rgba(51, 51, 51, 1)
        ReusableMethods.waitFor(2);
        Assert.assertNotEquals(rgbColorBefor,rgbColorAfter);
    }

    @Test//Tab 1,Tab 2,Tab 3 Elementlerinin tıklanabiliyor ve Textbox'daki yazıların da görülebiliyor olduğunu assert ediniz.
    public void TC02() {
        us12TabsPage.tabsLink.click();
        windowsHandles = Driver.getDriver().getWindowHandles();
        list = new ArrayList<>(windowsHandles);
        Driver.getDriver().switchTo().window(list.get(1));
        Driver.getDriver().switchTo().frame(0);
        
        for (int i = 0; i <us12TabsPage.tabsMenus.size() ; i++) {
            if( us12TabsPage.tabsMenus.get(i).isEnabled()){
                us12TabsPage.tabsMenus.get(i).click();
                System.out.println(us12TabsPage.alltext().get(i).getText());
                Assert.assertTrue(us12TabsPage.alltext().get(i).isDisplayed());
            }
            
        }
        
    }

    @Test//Tab 1,Tab 2,Tab 3  kutucuklarından herhangi birine tıklanıldığında ,
    // Backround renginin griden beyaza dönüştüğünü assert ediniz.
    public void TC03() {
        us12TabsPage.tabsLink.click();
        windowsHandles = Driver.getDriver().getWindowHandles();
        list = new ArrayList<>(windowsHandles);
        Driver.getDriver().switchTo().window(list.get(1));
        Driver.getDriver().switchTo().frame(0);
        // ReusableMethods.waitFor(3);
        String colorbefore=us12TabsPage.tabsMenus.get(1).getCssValue("background-color");
        ReusableMethods.waitForClickablility(us12TabsPage.tabsMenus.get(0),5);
        us12TabsPage.tabsMenus.get(1).click();
        String colorafter=us12TabsPage.tabsMenus.get(1).getCssValue("background-color");

        System.out.println("color before = "+colorbefore);
        System.out.println("color after = "+colorafter);
        Assert.assertNotEquals(colorbefore,colorafter);

//
//        for (WebElement w:us12TabsPage.tabsMenus){
//            String colorbefore=w.getCssValue("background-color");
//            System.out.println("color before = "+colorbefore);
//            ReusableMethods.waitForClickablility(w,5);
//            w.click();
//            String colorafter=w.getCssValue("background-color");
//            ReusableMethods.waitFor(2);
//            System.out.println("color after = "+colorafter);
//            Assert.assertEquals(colorbefore,colorafter);
//
//
//           // Assert.assertEquals(colorafter,"rgba(255, 255, 255, 1)");
//        }
    }

    @Test//Tab 1 icindeki yazılar "Proin" ile başlayıp,"lectus."  ile bittiğini tespit edip doğrulayınız.
    public void TC04() {
        us12TabsPage.tabsLink.click();
        windowsHandles = Driver.getDriver().getWindowHandles();
        list = new ArrayList<>(windowsHandles);
        Driver.getDriver().switchTo().window(list.get(1));
        Driver.getDriver().switchTo().frame(0);
        String text=us12TabsPage.tab1text.getText();
        System.out.println(text);
        Assert.assertTrue(text.startsWith("Proin") && text.endsWith("lectus."));
    }

    @Test//Tab 2 icindeki paragrafta "Aenean vel metus." cumlesi varmi assert ediniz.
    public void TC05() {
        us12TabsPage.tabsLink.click();
        windowsHandles= Driver.getDriver().getWindowHandles();
        list = new ArrayList<>(windowsHandles);
        Driver.getDriver().switchTo().window(list.get(1));
        Driver.getDriver().switchTo().frame(0);
        us12TabsPage.tabsMenus.get(1).click();
        Assert.assertTrue(us12TabsPage.alltext().get(1).getText().contains("Aenean vel metus."));
    }

    @Test//Tab 2 "Mauris eleifend est et turpis." cumlesi ilemi basliyor dogrulayiniz.
    public void TC06() {
        us12TabsPage.tabsLink.click();
        windowsHandles = Driver.getDriver().getWindowHandles();
        list = new ArrayList<>(windowsHandles);
        Driver.getDriver().switchTo().window(list.get(1));
        Driver.getDriver().switchTo().frame(0);
        us12TabsPage.tabsMenus.get(2).click();
        Assert.assertTrue(us12TabsPage.alltext().get(2).getText().startsWith("Mauris eleifend est et turpis."));
    }

    @AfterMethod
    public void tearDownMethod() {
        Driver.getDriver().switchTo().defaultContent();
       // Driver.getDriver().switchTo().parentFrame();
    }
}
