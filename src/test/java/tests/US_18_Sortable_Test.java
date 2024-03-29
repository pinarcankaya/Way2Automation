package tests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.US_11_Slider_Page;
import pages.US_18_Sortable_Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class US_18_Sortable_Test {

    US_18_Sortable_Page sortablePage = new US_18_Sortable_Page();
    US_11_Slider_Page sliderPage = new US_11_Slider_Page();
    Actions action = new Actions(Driver.getDriver());
    Set<String> windowHandles;
    List<String> list;

    @BeforeClass
    public void setup() {
        Driver.getDriver().get(ConfigReader.getProperty("way2Automation_url"));
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        sliderPage.enterGiris.click();
        ReusableMethods.waitFor(1);
        sortablePage.sortableMenu.click();
        ReusableMethods.waitFor(1);
        windowHandles = Driver.getDriver().getWindowHandles();
        list = new ArrayList<>(windowHandles);
        Driver.getDriver().switchTo().window(list.get(1));
    }

    //Default Fonk.Menusundeki itemleri buyukten kucuge dogru siralayiniz(7-6-5-4-3-2-1)
    @Test (priority = 1)
    public void defaultfonk() {
        ReusableMethods.waitFor(1);
        Driver.getDriver().switchTo().frame(0);


        int j = 7;
        int i=0;
        for (; i <= 6; i++) {

            action.dragAndDrop(sortablePage.defaultfonkList.get(6), sortablePage.defaultfonkList.get(i)).build().perform();
            ReusableMethods.waitForVisibility(sortablePage.defaultfonkList.get(i),5);
            System.out.println(sortablePage.defaultfonkList.get(i).getText());

            Assert.assertTrue(sortablePage.defaultfonkList.get(i).getText().equals("Item " + j));
            ReusableMethods.waitFor(1);
            j--;

        }
    }

    //Connect List menusundeki item'larin hepsinin sagdaki bolume suruklenebildigini dogrulayiniz
    @Test (priority = 2)
    public void connectList() {
        ReusableMethods.waitFor(1);
        sortablePage.connectListMenu.click();
        Driver.getDriver().switchTo().frame(1);
        ReusableMethods.waitFor(1);

        for (int i = 0; i < 5; i++) {
            action.dragAndDrop(sortablePage.connectListGriItemList.get(0), sortablePage.connectListSariItemList.get(i)).build().perform();

            ReusableMethods.waitFor(1);

        }
        System.out.println(sortablePage.connectListGriItemList.size());
        Assert.assertEquals(sortablePage.connectListGriItemList.size(), 0);
    }

    //Display as Grid menusundeki sol bastaki her elementin sag alt koseye surukleyiniz.
    // Islem bittiginde elementlerin son halinin ilk haline esit oldugunu dogrulayiniz
    @Test (priority = 3)
    public void displayasGrid() {
        ReusableMethods.waitFor(1);
        sortablePage.displayasGridMenu.click();
        Driver.getDriver().switchTo().frame(2);
        ReusableMethods.waitFor(1);

        ReusableMethods.waitFor(1);   //DUZELTILMELI!!!!!!!!
        for (int i = 0; i < sortablePage.displayasGridItemList.size(); i++) {
            action.dragAndDrop(sortablePage.displayasGridItemList.get(i), sortablePage.displayasGridItemList.get(11)).build().perform();
//            action.clickAndHold(sortablePage.displayasGridItemList.get(i)).
//            moveToElement(sortablePage.displayasGridItemList.get(11)).
//            release().build().perform();
            ReusableMethods.waitFor(2);
        }


    }


    //Porlets menusunde 5 tane acilir kapanir menu oldugunu dogrulayiniz,Menulerin acik ve kapali konuma gelebildigini dogrulayiniz
    @Test (priority = 4)
    public void porlets() {
        ReusableMethods.waitFor(1);
        sortablePage.porletsMenu.click();
        Driver.getDriver().switchTo().frame(3);
        ReusableMethods.waitFor(1);
        System.out.println(sortablePage.porletsAcilirKapanirMenus.size());

        for (WebElement w : sortablePage.porletsAcilirKapanirMenus) {
            System.out.println(w.getAttribute("class"));
            System.out.println("-------------");
            Assert.assertTrue(w.getAttribute("class").contains("minusthick"));
            w.click();
            System.out.println(w.getAttribute("class"));
            Assert.assertTrue(w.getAttribute("class").contains("plusthick"));
        }


    }
    @AfterMethod
    public void tearDownMethod() {
        Driver.getDriver().switchTo().defaultContent();
    }


}






