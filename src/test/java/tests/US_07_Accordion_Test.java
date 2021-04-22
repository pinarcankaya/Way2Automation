package tests;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.US_07_Accordion_Page;

import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class US_19_Accordion_Test {

    US_07_Accordion_Page accordionPage = new US_07_Accordion_Page();
    Actions action = new Actions(Driver.getDriver());

    @BeforeTest
    public void testName() {
        Driver.getDriver().get(ConfigReader.getProperty("way2Automation_url"));
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        accordionPage.enterGiris.click();
        ReusableMethods.waitFor(2);
        accordionPage.accordionMenu.click();
        ReusableMethods.waitFor(2);

    }

    @Test
    public void defaultFunkcionality() {//Windows handle
        Set<String> windowsHandle = Driver.getDriver().getWindowHandles();///2 tane window var
        List<String> list = new ArrayList<>(windowsHandle);
        Driver.getDriver().switchTo().window(list.get(1));//child windowa gitmek istiyor


        ReusableMethods.waitFor(2);
        accordionPage.defaultFonkMenu.click();

        //  Driver.getDriver().switchTo().frame(accordionPage.iframe1);//locate ile frame'e gecis
        Driver.getDriver().switchTo().frame(0);

        action.sendKeys(Keys.ARROW_DOWN).perform();
        action.sendKeys(Keys.ARROW_DOWN).perform();


        for (WebElement w : accordionPage.selectionList) {
            w.click();
            ReusableMethods.waitFor(1);
            Assert.assertTrue(w.isEnabled());
        }

        int listSize=accordionPage.selectionList.size();
        Assert.assertEquals(listSize,4);


        //Assertion 1.yol
        Assert.assertTrue(accordionPage.selectionList.get(0).isDisplayed());
        Assert.assertTrue(accordionPage.selectionList.get(1).isDisplayed());
        Assert.assertTrue(accordionPage.selectionList.get(2).isDisplayed());
        Assert.assertTrue(accordionPage.selectionList.get(3).isDisplayed());

        // //Assertion 2.yol
        String section1=accordionPage.selectionList.get(0).getText();
        Assert.assertFalse(section1.isEmpty());

        //Assertion 3.yol
        Assert.assertTrue(accordionPage.selectionList.get(0).getText().
                startsWith("Mauris mauris ante") && accordionPage.selectionList.get(0).getText().endsWith("vulputate."));
    }


    @Test
    public void customizeIcons() {
        //String url = "http://way2automation.com/way2auto_jquery/accordion.php#load_box";
        Set<String> windowsHandle = Driver.getDriver().getWindowHandles();
        List<String> list = new ArrayList<>(windowsHandle);
        Driver.getDriver().switchTo().window(list.get(1));
        ReusableMethods.waitFor(2);
        // accordionPage.customizeIcons.click();
        // action.click(accordionPage.customizeIcons).perform();


        //click//action(click)//JSExecuter
        JavascriptExecutor jsExecuter = (JavascriptExecutor) Driver.getDriver();
        jsExecuter.executeScript("arguments[0].click();", accordionPage.customizeIcons);

        Driver.getDriver().switchTo().frame(1);

        Assert.assertTrue(accordionPage.toggleIconButton.isDisplayed());

        //toggleIcon Is NOt Display?
        accordionPage.toggleIconButton.click();
//        for (WebElement w : accordionPage.selectionListWithOk) {
//            Assert.assertFalse(w.isDisplayed());
//        }

        for (WebElement w : accordionPage.selectionList) {
            w.click();
            ReusableMethods.waitFor(1);
            Assert.assertTrue(w.isEnabled());
        }

        ReusableMethods.waitFor(2);
        accordionPage.selectionList.get(0).click();
        System.out.println(accordionPage.selection1Text.getText());
        Assert.assertTrue(accordionPage.selection1Text.getText().startsWith("Mauris mauris ante") && accordionPage.selection1Text.getText().endsWith("vulputate."));

        //selection1' tiklaninca selection 2'deki text gorunmemeli
        Assert.assertFalse(accordionPage.selection2Text.isDisplayed());

        //Driver.getDriver().switchTo().defaultContent();
    }

    @Test
    public void fillspace() {
        Set<String> windowsHandle = Driver.getDriver().getWindowHandles();
        List<String> list = new ArrayList<>(windowsHandle);
        Driver.getDriver().switchTo().window(list.get(1));
        // System.out.println(Driver.getDriver().getTitle());
        ReusableMethods.waitFor(2);
        accordionPage.fillspace.click();
        Driver.getDriver().switchTo().frame(2);

        action.sendKeys(Keys.ARROW_DOWN).perform();
        action.sendKeys(Keys.ARROW_DOWN).perform();
        action.sendKeys(Keys.ARROW_DOWN).perform();
        action.sendKeys(Keys.ARROW_DOWN).perform();

        ReusableMethods.waitFor(1);

        //1.yol
//        action.clickAndHold(accordionPage.fillSpaceResiable).moveByOffset(100,50).
//                release(accordionPage.fillSpaceResiable).build().perform();

        //2.yol
        action.dragAndDropBy(accordionPage.fillSpaceResiable,100,50).build().perform();

        action.clickAndHold(accordionPage.fillSpaceResiable).moveByOffset(-100, -100).build().perform();
        // action.release();//fareyi serbest birak
        //   action.release().build().perform();//boyle de kullaniliyor


        /*Mouse Eylemleri:

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