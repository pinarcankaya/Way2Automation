package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
public class US_07_Accordion_Tests {
//
//    US_07_Accordion_Page accordionPage = new US_07_Accordion_Page();
//    Actions action = new Actions(Driver.getDriver());
//
//    @BeforeTest
//    public void testName() {
//        Driver.getDriver().get(ConfigReader.getProperty("way2Automation_url"));
//        Driver.getDriver().manage().window().maximize();
//        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        accordionPage.enterGiris.click();
//        ReusableMethods.waitFor(2);
//        accordionPage.accordionMenu.click();
//        ReusableMethods.waitFor(2);
//
//    }
//
//    ///WINDOWS HANDLE
//    @Test
//    // Default Functionality'de herbir section tiklandiginda icerdigi text'e ulasilmalidir
//    // Default Functionality'e tiklandiginda Section 1-2-3-4 acildigi gorulmelidir
//    public void defaultFunkcionality() {//
//        Set<String> windowsHandle = Driver.getDriver().getWindowHandles();///2 tane window var
//        List<String> list = new ArrayList<>(windowsHandle);
//        Driver.getDriver().switchTo().window(list.get(1));//child windowa gitmek istiyoruz//yani 2.siradaki
//
//
//        ReusableMethods.waitFor(2);
//        accordionPage.defaultFonkMenu.click();
//
//
//        Driver.getDriver().switchTo().frame(0);
//
//        action.sendKeys(Keys.ARROW_DOWN).perform();
//        action.sendKeys(Keys.ARROW_DOWN).perform();
//
//
//        for (WebElement w : accordionPage.selectionList) {
//            w.click();
//            ReusableMethods.waitFor(1);
//            Assert.assertTrue(w.isEnabled());
//        }
//
//        int listSize=accordionPage.selectionList.size();
//        Assert.assertEquals(listSize,4);
//
//
//        //Assertion 1.yol
//        Assert.assertTrue(accordionPage.selectionList.get(0).isDisplayed());
//        Assert.assertTrue(accordionPage.selectionList.get(1).isDisplayed());
//        Assert.assertTrue(accordionPage.selectionList.get(2).isDisplayed());
//        Assert.assertTrue(accordionPage.selectionList.get(3).isDisplayed());
//
//        // //Assertion 2.yol
//        String section1=accordionPage.selectionList.get(0).getText();
//        Assert.assertFalse(section1.isEmpty());
//
//        //Assertion 3.yol
//        Assert.assertTrue(accordionPage.selectionList.get(0).getText().
//                startsWith("Mauris mauris ante") && accordionPage.selectionList.get(0).getText().
//                endsWith("vulputate."));
//    }
//
//
//    @Test
//    public void customizeIcons() {//"toggle icons" butonuna sayfada bulunmali ve  tiklandiginda islevsel olmalidir
//        Set<String> windowsHandle = Driver.getDriver().getWindowHandles();
//        List<String> list = new ArrayList<>(windowsHandle);
//        Driver.getDriver().switchTo().window(list.get(1));
//        ReusableMethods.waitFor(2);
//        accordionPage.customizeIcons.click();
//
//        Driver.getDriver().switchTo().frame(1);
//
//        Assert.assertTrue(accordionPage.toggleIconButton.isDisplayed());
//
//
//        for (WebElement w: accordionPage.selectionListWithOk) {
//            Assert.assertTrue(w.isEnabled());
//        }
//
//        //"toggle icons" butonuna tiklandiginda " -> " iconu kaldirilmalir//
//
//        accordionPage.toggleIconButton.click();
//        for (WebElement w : accordionPage.selectionListWithOk) {
//            Assert.assertFalse(w.isDisplayed());
//        }
//
//
//    }
//
//    @Test
//    public void fillspace() {
//        Set<String> windowsHandle = Driver.getDriver().getWindowHandles();
//        List<String> list = new ArrayList<>(windowsHandle);
//        Driver.getDriver().switchTo().window(list.get(1));
//
//
//        ReusableMethods.waitFor(2);
//        accordionPage.fillspace.click();
//        Driver.getDriver().switchTo().frame(2);
//
//        action.sendKeys(Keys.ARROW_DOWN).perform();
//        action.sendKeys(Keys.ARROW_DOWN).perform();
//        action.sendKeys(Keys.ARROW_DOWN).perform();
//        action.sendKeys(Keys.ARROW_DOWN).perform();
//
//        ReusableMethods.waitFor(1);
//
//        //1.yol
//        action.clickAndHold(accordionPage.fillSpaceResiable).moveByOffset(100,50).
//                release(accordionPage.fillSpaceResiable).build().perform();
//
//        //2.yol///DROG AND DROP ILE BUTUP KUCULTME
//        action.dragAndDropBy(accordionPage.fillSpaceResiable,100,50).build().perform();
//        action.clickAndHold(accordionPage.fillSpaceResiable).moveByOffset(-100, -100).build().perform();
//        // action.release();
//        //   action.release().build().perform();//boyle de kullanilir
//

        /*Fare Eylemleri:

        click () : Öğeye tıklar .
        doubleClick () : Öğeye çift ​​tıklama.
        contextClick () : Öğe üzerinde bir bağlam tıklaması (sağ tıklama) gerçekleştirir.
        clickAndHold () : Mevcut fare konumunda bırakmadan tıklar .
        dragAndDrop (kaynak, hedef) : Kaynak konumunda tıklar ve fareyi bırakmadan önce hedef öğenin konumuna hareket eder. kaynak (yakalanacak öğe, hedef - bırakılacak öğe).
        dragAndDropBy (source, xOffset, yOffset) : Kaynak konumda tıklama ve bekletme gerçekleştirir, belirli bir uzaklık değerine göre kaydırır, ardından fareyi serbest bırakır. (X ofseti - yatay olarak kaydırmak için, Y Ofseti - dikey olarak kaydırmak için).
        moveByOffset (x ofset, y-offset) : Verilen ofset ile fareyi mevcut konumundan (veya 0,0) kaydırır. x-ofset - Yatay uzaklığı ayarlar (negatif değer - fareyi sola kaydırma), y-ofset - Dikey uzaklığı ayarlar (negatif değer - fareyi yukarı kaydırma).
        moveToElement (toElement) : Fareyi öğenin merkezine kaydırır.
        release () : Mevcut fare konumunda basılı sol fare düğmesini serbest bırakır.
        */



}
