package tests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.US_07_Accordion_Page;
import pages.US_17_Selectable_Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class US_17_Selectable_Test {
    US_17_Selectable_Page selectable_page = new US_17_Selectable_Page();
    US_07_Accordion_Page accordionPage = new US_07_Accordion_Page();
    Set<String> windowHandles;
    List<String> list;

    @BeforeClass
    public void setUP() {
        Driver.getDriver().get(ConfigReader.getProperty("way2Automation_url"));
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        accordionPage.enterGiris.click();
        ReusableMethods.waitFor(2);
        selectable_page.selectableMenu.click();
        windowHandles = Driver.getDriver().getWindowHandles();
        list = new ArrayList<>(windowHandles);
        Driver.getDriver().switchTo().window(list.get(1));
        ReusableMethods.waitFor(2);

    }

    @Test   //Item 1'i seçtiginizde kutucugun renginin "#F39814" oldugunu  yazi renginin ise
    // " white" oldugunu Assert ediniz.
    public void TC_090() {
        Driver.getDriver().switchTo().frame(0);
        selectable_page.itemList.get(0).click();
        String rgbColor = selectable_page.itemList.get(0).getCssValue("background-color");
        String asHexBackground = Color.fromString(rgbColor).asHex();
        System.out.println(asHexBackground);
        String rgbWhite = selectable_page.itemList.get(0).getCssValue("color");
        String colorWhite = Color.fromString(rgbWhite).asHex();
        System.out.println("White asHex " + colorWhite);
        Assert.assertTrue(asHexBackground.contains("#f39814") && colorWhite.contains("#ffffff"));

    }

    @Test
    public void TC_091() {
        //Birden fazla (ör:4) kutucuğun aynı anda seçilebildigini doğrulayınız.
        //(6,7,8,10,11,12 kutucuklarının aynı anda seçilebildiğini assert ediniz.==>  Display as Grid
        selectable_page.tabsList.get(1).click();
        Driver.getDriver().switchTo().frame(1);

        for (int i = 0; i < 4; i++) {
            selectable_page.displaySelectList.get(i).click();
            Assert.assertTrue(selectable_page.displaySelectList.get(i).isEnabled());
        }
        ReusableMethods.waitFor(2);

        for (int i = 5; i < 12; i++) {
            selectable_page.displaySelectList.get(i).click();
            ReusableMethods.waitFor(2);
            Assert.assertTrue(selectable_page.displaySelectList.get(i).isEnabled());

        }

    }

    @Test
    public void TC_092() {
        //Seçilen kutuların renginin turuncu olduğunu assert ediniz. ==> Display as Grid
        ReusableMethods.waitFor(2);
        selectable_page.tabsList.get(1).click();
        Driver.getDriver().switchTo().frame(1);
        selectable_page.displaySelectList.get(0).click();
        String rgbColor = selectable_page.displaySelectList.get(0).getCssValue("background-color");
        String asHexBackground = Color.fromString(rgbColor).asHex();
        System.out.println(asHexBackground);
        Assert.assertTrue(asHexBackground.contains("#f39814"));

    }

    @Test
    public void TC_093() {
        //Tüm kutuların aynı anda seçilebildigini doğrulayınız ==> Serialize
        ReusableMethods.waitFor(2);
        selectable_page.tabsList.get(2).click();
        Driver.getDriver().switchTo().frame(2);
        for (WebElement w : selectable_page.itemList) {
            w.click();
            Assert.assertTrue(w.isEnabled());
        }
    }

    @Test
    public void TC_094() {
        //Kutu seçiminden önce ve sonra"You've selected: "yazısının karşısındaki değişimi assert ediniz
        ReusableMethods.waitFor(2);
        selectable_page.tabsList.get(2).click();
        Driver.getDriver().switchTo().frame(2);
        ReusableMethods.waitFor(2);
        String textBefore = selectable_page.serializeText.getText();
        System.out.println(textBefore);
        ReusableMethods.waitFor(2);
        for (int i = 8; i <selectable_page.itemList.size() ; i++) {
            selectable_page.itemList.get(i).click();

            ReusableMethods.waitFor(1);
            String textAfter = selectable_page.serializeText.getText();
            System.out.println(textAfter);
            ReusableMethods.waitFor(2);
            Assert.assertNotEquals(textBefore,textAfter);
        }
//         String textAfter=selectable_page.serializeText.getText();
//        System.out.println(textAfter);
//        Assert.assertNotEquals(textBefore,textAfter);

    }
    @AfterMethod
    public void tearDownMethod() {
        Driver.getDriver().switchTo().defaultContent();
    }
}
