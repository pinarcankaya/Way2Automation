package tests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.US_06_Frames_Page;
import pages.US_07_Accordion_Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class US_06_Frames_Test extends TestBase {

    //US_01_Login_Page us01LoginPage = new US_01_Login_Page();
    US_07_Accordion_Page accordionPage= new US_07_Accordion_Page();
    US_06_Frames_Page framesPage = new US_06_Frames_Page();
    Actions action = new Actions(Driver.getDriver());
    Set<String> windowHandles;
    List<String> list;

    @BeforeMethod
    public void setUp(){
        Driver.getDriver().get(ConfigReader.getProperty("way2Automation_url"));
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        accordionPage.enterGiris.click();
        ReusableMethods.waitFor(1);
        framesPage.framesUndWindowsMenu.click();
        windowHandles= Driver.getDriver().getWindowHandles();
        list= new ArrayList<>(windowHandles);
        Driver.getDriver().switchTo().window(list.get(1));
        ReusableMethods.waitFor(2);
    }


    @Test //Frames and Windows kutusu tiklanabildigini assert ediniz
    public void TC_036() {
        Assert.assertTrue(framesPage.framesUndWindowsMenu.isEnabled());


    }

    @Test  //Frames and Windows kutusuna tiklandiginda cikan sayfada 4 adet menu bulundugunu dogrulayiniz
    public void TC37() {
        for(WebElement w:framesPage.tabs){
            System.out.println(w.getText());
        }
        int listSize=framesPage.tabs.size();

        Assert.assertEquals(listSize,4);

    }

    @Test  //Open New Window menusune altinda bulunan New Browser Tab linkine tiklandiginda
    // yeni bir tab acildigini dogrulayiniz
    public void TC38() {
        Driver.driver.switchTo().frame(0);

        Set<String>tumWindowHandles=Driver.getDriver().getWindowHandles();
        List<String>list2=new ArrayList<>(tumWindowHandles);
        System.out.println(list2.size());
        String window1=list2.get(0);
        ReusableMethods.waitFor(2);
        framesPage.openLinkList.get(0).click();
        ReusableMethods.waitFor(2);

      Driver.getDriver().switchTo().window(list2.get(1));
        String window2=list2.get(1);

        Assert.assertNotEquals(window1,window2);
        String yeniWindow=Driver.getDriver().getTitle();
        System.out.println(yeniWindow);
        System.out.println(window1);//CDwindow-7BB6D8543F605735EA08EA8899778FDB
        System.out.println(window2);//CDwindow-60868AA92FF5FF94DFF07024BFA6DD77

    }
    @Test  //Open New Seprate Window menusu altinda bulunan
    // Open Seprate New Window linkine tiklandiginda yeni bir pencere acildigini dogrulayiniz
    public void TC39() {
        framesPage.tabs.get(1).click();
        Driver.getDriver().switchTo().frame(1);
        framesPage.openLinkList.get(0).click();
        list= new ArrayList<>(windowHandles);
        System.out.println(list);
        Driver.getDriver().switchTo().window(list.get(1));
        String yeniWindow=Driver.getDriver().getTitle();
        System.out.println(yeniWindow);
        //1.Yol
//        String yeniSayfa=framesPage.newWindowTab.getTagName();
//        Assert.assertEquals(yeniSayfa,"html");
//        System.out.println(yeniSayfa);
        //2.Yol


    }

    @Test  //Frame Set menusu altinda bulunan  Open Frameset Window linkine tiklandiginda
    // acilan yeni tabda ikinci frame'a gecilebildigini assert ediiniz
    public void TC40() {
        framesPage.tabs.get(2).click();

    }

    @Test  //Frame Set menusu altinda bulunan  Open Frameset Window linkine tiklandiginda acilan
    // yeni tabda ikinci frame'in background color'i yesil olmalidir(arka fon rengi)
    public void TC41() {
        framesPage.tabs.get(2).click();
        Driver.driver.switchTo().frame(2);
    }

    @Test  //Open Multiple Windows icinde bulunan Open multiple pages linkine tiklandiginda
    // yeni bir pencere acildigini ve acilan bu pencerede Open multiple pages'e linkine tekrar
    // tiklandiginda tekrar yeni pencere acildigini assert ediniz
    public void TC42() {
        framesPage.tabs.get(3).click();
        Driver.driver.switchTo().frame(3);
        framesPage.openLinkList.get(3).click();
        list= new ArrayList<>(windowHandles);
        Driver.getDriver().switchTo().window(list.get(1));
        //1.Yol
        String yeniSayfa=framesPage.newWindowTab.getTagName();
        Assert.assertEquals(yeniSayfa,"html");
        System.out.println(yeniSayfa);

    }
//    @AfterMethod
//    public void tearDownMethod() {
//        Driver.getDriver().switchTo().window(list.get(0));
//    }
}
