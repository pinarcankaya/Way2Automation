package tests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
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

public class US_12_Tabs {

    US_07_Accordion_Page accordionPage = new US_07_Accordion_Page();
    US_12_Tabs_Page us12TabsPage = new US_12_Tabs_Page();
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


    }

    @Test//Tabs kutucuğunun üzerine geldiğinizde,kutucuğun renginin griye dönüştüğünü  doğrulayınız.
    public void TC01() {
        Set<String> windowsHandle = Driver.getDriver().getWindowHandles();
        List<String> list = new ArrayList<>(windowsHandle);
        Driver.getDriver().switchTo().window(list.get(1));
        Driver.getDriver().switchTo().frame(0);

    }

    @Test//Tab 1,Tab 2,Tab 3 Elementlerinin tıklanabiliyor ve Textbox'daki yazıların da görülebiliyor olduğunu assert ediniz.
    public void TC02() {
        Set<String> windowsHandle = Driver.getDriver().getWindowHandles();
        List<String> list = new ArrayList<>(windowsHandle);
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
        Set<String> windowsHandle = Driver.getDriver().getWindowHandles();
        List<String> list = new ArrayList<>(windowsHandle);
        Driver.getDriver().switchTo().window(list.get(1));

        Driver.getDriver().switchTo().frame(0);
        for (WebElement w:us12TabsPage.tabsMenus){
            String colorbefore=w.getCssValue("background-color");
            System.out.println(colorbefore);
            w.click();
            String colorafter=w.getCssValue("background-color");
            System.out.println(colorafter);

            Assert.assertNotEquals(colorbefore,colorafter);
            Assert.assertEquals(colorafter,"rgba(255, 255, 255, 1)");
        }
    }

    @Test//Tab 1 icindeki yazılar "Proin" ile başlayıp,"lectus."  ile bittiğini tespit edip doğrulayınız.
    public void TC04() {
        Set<String> windowsHandle = Driver.getDriver().getWindowHandles();
        List<String> list = new ArrayList<>(windowsHandle);
        Driver.getDriver().switchTo().window(list.get(1));
        Driver.getDriver().switchTo().frame(0);
        String text=us12TabsPage.tab1text.getText();
        System.out.println(text);
        Assert.assertTrue(text.startsWith("Proin") && text.endsWith("lectus."));
    }

    @Test//Tab 2 icindeki paragrafta "Aenean vel metus." cumlesi varmi assert ediniz.
    public void TC05() {
        Set<String> windowsHandle = Driver.getDriver().getWindowHandles();
        List<String> list = new ArrayList<>(windowsHandle);
        Driver.getDriver().switchTo().window(list.get(1));
        Driver.getDriver().switchTo().frame(0);
        us12TabsPage.tabsMenus.get(1).click();
        Assert.assertTrue(us12TabsPage.alltext().get(1).getText().contains("Aenean vel metus."));
    }

    @Test//Tab 2 "Mauris eleifend est et turpis." cumlesi ilemi basliyor dogrulayiniz.
    public void TC06() {
        Set<String> windowsHandle = Driver.getDriver().getWindowHandles();
        List<String> list = new ArrayList<>(windowsHandle);
        Driver.getDriver().switchTo().window(list.get(1));
        Driver.getDriver().switchTo().frame(0);
        us12TabsPage.tabsMenus.get(2).click();
        Assert.assertTrue(us12TabsPage.alltext().get(2).getText().startsWith("Mauris eleifend est et turpis."));
    }

}
