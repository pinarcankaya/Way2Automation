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
        ReusableMethods.waitFor(2);
        autoCompletePage.autoCompleteMenu.click();
        ReusableMethods.waitFor(2);
        Set<String> windowsHandle = Driver.getDriver().getWindowHandles();
        List<String> list = new ArrayList<>(windowsHandle);
        Driver.getDriver().switchTo().window(list.get(1));

    }

    //Default Functionalitye tiklandiginda textbox bolumune 'e' harfi giirldiginde 6 sonuc ciktigini dogrulayiniz
    @Test
    public void defaultFonk() {


        ReusableMethods.waitFor(1);
        action.sendKeys(Keys.PAGE_DOWN).perform();
        Driver.getDriver().switchTo().frame(0);
        autoCompletePage.autoInputList.get(0).sendKeys("e");  ///birinci input tag get(0)

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 2);
        wait.until(ExpectedConditions.visibilityOf(autoCompletePage.textBoxList.get(0)));
        System.out.println("e ==> harfinden " + autoCompletePage.textBoxList.size() + " tane var ");
        Assert.assertEquals(autoCompletePage.textBoxList.size(), 6);


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
//            Driver.getDriver().navigate().refresh();
//
//        }
//        System.out.println(sum);///tekrarli elemanlar toplami
//        System.out.println(tekrarsizElemanlar.size()); //tekrarsiz elemanlar toplami


    }

    //Default Functionalitye tiklandiginda textbox bolumune 'j' harfi girildiginde cikan listede 'java' ifadesinin gectigini dogrulayiniz
    @Test
    public void multipleValues() {
        ReusableMethods.waitFor(1);
        Driver.getDriver().switchTo().frame(0);
        autoCompletePage.autoInputList.get(0).sendKeys("j");
        System.out.println("j ==> harfinden " + autoCompletePage.textBoxList.size() + " tane var ");

        boolean deger=false;
        for(WebElement w:autoCompletePage.textBoxList){
            System.out.println(w.getText());
            if(w.getText().equalsIgnoreCase("Java")){
                System.out.println("listin icinde java ifadesi var");
                deger=true;
                Assert.assertTrue(deger==true);
            }

        }

    }
//Multiple Values tiklandiginda textbox bolumune birden fazla kategori yazilabildigini dogrulayiniz
    @Test
    public void categories() {
        ReusableMethods.waitFor(1);
        autoCompletePage.multipleValuesMenu.click();
        Driver.getDriver().switchTo().frame(1);
        ReusableMethods.waitFor(1);

        autoCompletePage.autoInputList.get(0).click();
        autoCompletePage.autoInputList.get(0).sendKeys("b");
        autoCompletePage.textBoxList.get(0).click();
        ReusableMethods.waitFor(1);
        autoCompletePage.autoInputList.get(0).click();
        autoCompletePage.autoInputList.get(0).sendKeys("y");
        ReusableMethods.waitFor(1);
        autoCompletePage.textBoxList.get(0).click();
      //  action.sendKeys(Keys.BACK_SPACE).perform();
       // action.sendKeys(Keys.BACK_SPACE).perform();
       // System.out.println( autoCompletePage.textBoxList.size());
       // System.out.println( autoCompletePage.textBoxList.get(0).getText());

        for (WebElement w:autoCompletePage.textBoxList){
            System.out.println(w.getText());
        }


    }
//Categories tiklandiginda textbox bolumune 'a' harfi yazildiginda "Products" ve "People" basliklari gorunuyor olmali
    @Test
    public void TC50() {

        ReusableMethods.waitFor(1);
        autoCompletePage.categoriesMenu.click();
        Driver.getDriver().switchTo().frame(2);
        ReusableMethods.waitFor(1);
        autoCompletePage.autoInputList.get(0).click();
        autoCompletePage.autoInputList.get(0).sendKeys("a");


        for(WebElement w:autoCompletePage.categoriBasliklari){
            if(w.getText().contains("People") || w.getText().contains("Products")){
                System.out.println(w.getText());
                Assert.assertTrue(w.isDisplayed());
            }
            }
    }
}


