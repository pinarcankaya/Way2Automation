package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.US_07_Accordion_Page;
import pages.US_08_AutoComplete_Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class US_08_AutoComplete_Test {


    US_08_AutoComplete_Page autoCompletePage = new US_08_AutoComplete_Page();
    US_07_Accordion_Page accordionPage = new US_07_Accordion_Page();
    Actions action = new Actions(Driver.getDriver());

    @BeforeTest
    public void testName() {
        Driver.getDriver().get(ConfigReader.getProperty("way2Automation_url"));
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        accordionPage.enterGiris.click();
        ReusableMethods.waitFor(1);//thread sleep
        autoCompletePage.autoCompleteMenu.click();
        ReusableMethods.waitFor(1);
        Set<String> windowsHandle = Driver.getDriver().getWindowHandles();
        List<String> list = new ArrayList<>(windowsHandle);
        Driver.getDriver().switchTo().window(list.get(1));
    }


    //Default Functionalitye tiklandiginda textbox bolumune 'e' harfi giirldiginde 6 sonuc ciktigini dogrulayiniz
    @Test(priority = 1)
    public void defaultFonk() {

        Driver.getDriver().switchTo().frame(0);
        autoCompletePage.autoInputList.get(0).sendKeys("e");
        System.out.println(" e harfinden " + autoCompletePage.allTextResult.size() + " tane var");
        Assert.assertEquals(autoCompletePage.allTextResult.size(), 6);

        for (WebElement w : autoCompletePage.allTextResult) {
            System.out.println(w.getText());
            Assert.assertTrue(w.isDisplayed());
        }


        /////butun harfleri sirayla gonderip saydiralim
//
//        Set<String> tekrarsizElemanlar = new HashSet<>();
//
//        int sum = 0;
//        for (char i = 'a'; i <= 'z'; i++) {
//            Driver.getDriver().switchTo().frame(0);
//            char harf = i;
//            autoCompletePage.autoInputList.get(0).sendKeys(i + "");
//
//            ReusableMethods.waitFor(1);
//            wait.until(ExpectedConditions.visibilityOf(autoCompletePage.textBoxList.get(0)));
//
//            System.out.println(i + " ==> harfinden " + autoCompletePage.textBoxList.size() + " tane var ");
//
//            sum = sum + autoCompletePage.textBoxList.size();
//
//            if (autoCompletePage.textBoxList.size() != 0) {
//                for (WebElement w : autoCompletePage.textBoxList) {
//                    System.out.println(w.getText());
//                    Assert.assertTrue(w.getText().toLowerCase().contains(i + ""));
//                    tekrarsizElemanlar.add(w.getText());
//                }
//            }
//
          Driver.getDriver().navigate().refresh();
//
//        }
//        System.out.println(sum);///tekrarli elemanlar toplami
//        System.out.println(tekrarsizElemanlar.size()); //tekrarsiz elemanlar toplami


    }

    //Default Functionalitye tiklandiginda textbox bolumune 'j' harfi girildiginde cikan listede 'java' ifadesinin gectigini dogrulayiniz
    @Test(priority = 2)
    public void multipleValues() {
        ReusableMethods.waitFor(1);
        Driver.getDriver().switchTo().frame(0);
        autoCompletePage.autoInputList.get(0).sendKeys("j");
        System.out.println("j ==> harfinden " + autoCompletePage.allTextResult.size() + " tane var ");

        boolean deger = false;
        for (WebElement w : autoCompletePage.allTextResult) {
            System.out.println(w.getText());
            if (w.getText().equalsIgnoreCase("Java")) {
                System.out.println("listin icinde java ifadesi var");
                deger = true;
                Assert.assertTrue(deger == true);
            }

        }
        Driver.getDriver().navigate().refresh();

    }

    //Multiple Values tiklandiginda textbox bolumune birden fazla kategori yazilabildigini dogrulayiniz
    @Test(priority = 3)
    public void categories() {
        ReusableMethods.waitFor(1);
        autoCompletePage.multipleValuesMenu.click();
        Driver.getDriver().switchTo().frame(1);
        ReusableMethods.waitFor(1);

        autoCompletePage.autoInputList.get(0).click();
        autoCompletePage.autoInputList.get(0).sendKeys("basic");

        ReusableMethods.waitFor(1);


        autoCompletePage.allTextResult.get(0).click();

        autoCompletePage.autoInputList.get(0).sendKeys("cobol");
        ReusableMethods.waitFor(1);
        autoCompletePage.allTextResult.get(0).click();


        autoCompletePage.autoInputList.get(0).sendKeys("b");
        ReusableMethods.waitFor(1);


        for (WebElement w: autoCompletePage.allTextResult){
           // System.out.println(w.getText());
            if(w.getText().equalsIgnoreCase("basic") || w.getText().equalsIgnoreCase("cobol") )
                System.out.println(w.getText());
            Assert.assertTrue(w.getText().contains("BASIC") || w.getText().contains("COBOL"));

        }
        System.out.println("gecti");

       // autoCompletePage.autoInputList.get(0).sendKeys("b");

        ReusableMethods.waitFor(1);
        Driver.getDriver().navigate().refresh();
    }

    //Categories tiklandiginda textbox bolumune 'a' harfi yazildiginda "Products" ve "People" basliklari gorunuyor olmali
    @Test(priority = 4)
    public void TC50() {

        ReusableMethods.waitFor(1);
      //  autoCompletePage.categoriesMenu.click();
        Driver.getDriver().switchTo().frame(2);
        ReusableMethods.waitFor(1);
        autoCompletePage.autoInputList.get(0).click();
        autoCompletePage.autoInputList.get(0).sendKeys("a");


        for (WebElement w : autoCompletePage.categoriBasliklari) {
            if (w.getText().contains("People") || w.getText().contains("Products")) {
                System.out.println(w.getText());
                Assert.assertTrue(w.isDisplayed());
            }
        }
        Driver.getDriver().navigate().refresh();
    }

}


