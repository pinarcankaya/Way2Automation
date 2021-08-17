package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.US_07_Accordion_Page;
import pages.US_10_Menu_Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class US_10_Menu_Test {

    US_07_Accordion_Page accordionPage = new US_07_Accordion_Page();
    US_10_Menu_Page menuPage = new US_10_Menu_Page();
    Actions action = new Actions(Driver.getDriver());
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
    Set<String> windowsHandles ;
    List<String> list;

    @BeforeTest
    public void setup() {
        Driver.getDriver().get(ConfigReader.getProperty("way2Automation_url"));
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        accordionPage.enterGiris.click();
        ReusableMethods.waitFor(2);
        menuPage.menuLink.click();

        ReusableMethods.waitFor(2);
        windowsHandles = Driver.getDriver().getWindowHandles();
        list = new ArrayList<>(windowsHandles);
        Driver.getDriver().switchTo().window(list.get(1));
    }

    @Test//Widget menu linki altinda bulunan Menu kutusunun tiklanabildigini dogrulayiniz
    public void TC01() {
        boolean durum = false;
        if (menuPage.menuLink.isDisplayed() && menuPage.menuLink.isEnabled()) {
            menuPage.menuLink.click();
            durum = true;
            System.out.println("element tiklandi :" + durum);
            Assert.assertEquals(durum, true);
        }
    }

    @Test
//Widget menu linki altinda bulunan Menu kutusuna tiklandiginda Simple Menu,Menu With Sub Menu,Select Menu bulundugunu Assert ediniz.
    public void TC02() {
        String[] arr = {"SIMPLE MENU", "MENU WITH SUB MENU", "SELECT MENU"};
        for (int i = 0; i < arr.length; i++) {
            System.out.println(menuPage.allMenuList.get(i).getText());
            Assert.assertEquals(menuPage.allMenuList.get(i).getText(), arr[i]);
        }
    }

    @Test//Menu kutusuna tiklandiginda Simple Menu altinda alti tane baslik oldugunu verify ediniz
    public void TC03() {
        Driver.getDriver().switchTo().frame(0);
        System.out.println(menuPage.simpleMenuList.size());
        Assert.assertNotEquals(menuPage.simpleMenuList.size(), 6);  //8
    }

    @Test//Menu With Sub Menu basligi tiklandiginda Delphi Menu altindaki dort baslik oldugunu dogrulayiniz
    public void TC04() {
        menuPage.menuWithSubMenuLink.click();
        Driver.getDriver().switchTo().frame(1);

        action.moveToElement(menuPage.ariaPopUpList.get(1)).build().perform();  //delphi
        System.out.println(menuPage.ariaPopUpList.get(1).getText());

        List<String>  delphiSubMenu=new ArrayList<>();
        for (int i = 4; i < 8; i++) {
            delphiSubMenu.add(menuPage.subMenuList.get(i).getText());
            wait.until(ExpectedConditions.visibilityOf(menuPage.subMenuList.get(i)));
            System.out.println(menuPage.subMenuList.get(i).getText());
            Assert.assertTrue(menuPage.subMenuList.get(i).isDisplayed());
        }
        Assert.assertEquals(delphiSubMenu.size(),4);

    }

    @Test//Menu linki altinda bulunan Select Menu backraund color kirmizi oldugunu verify ediniz
    public void TC05() {
        menuPage.selectMenu.click();
        ReusableMethods.waitFor(2);
        String selectMenuColor = menuPage.selectMenu.getCssValue("background-color");
        System.out.println(selectMenuColor);
        //  Assert.assertEquals(selectMenuColor,"rgba(255, 0, 0)");
        String hex = Color.fromString(selectMenuColor).asHex();
        System.out.println(hex);
        Assert.assertEquals(hex, "#ff0000");
    }

    @Test//Menu linki altinda bulunan Select Menu basligi altinda bir image bulundugunu verify ediniz
    public void TC06() {
        menuPage.selectMenu.click();
        Driver.getDriver().switchTo().frame(2);
        Assert.assertTrue(menuPage.selectMenuImage.isDisplayed());

    }
    @AfterMethod
    public void tearDownMethod() {
        Driver.getDriver().switchTo().parentFrame();
    }

}
