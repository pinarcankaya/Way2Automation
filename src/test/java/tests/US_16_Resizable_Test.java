package tests;


import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.US_07_Accordion_Page;
import pages.US_16_Resizable_Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class US_16_Resizable_Test {

    US_07_Accordion_Page accordionPage = new US_07_Accordion_Page();
    US_16_Resizable_Page resizablePage = new US_16_Resizable_Page();
    Actions action = new Actions(Driver.getDriver());
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);

    @BeforeMethod
    public void setup() {
        Driver.getDriver().get(ConfigReader.getProperty("way2Automation_url"));
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        accordionPage.enterGiris.click();
        ReusableMethods.waitFor(1);
        resizablePage.resizableMenu.click();
        ReusableMethods.waitFor(1);
        Set<String> windowsHandle = Driver.getDriver().getWindowHandles();
        List<String> list = new ArrayList<>(windowsHandle);
        Driver.getDriver().switchTo().window(list.get(1));
    }

    @Test
    public void resizable1() {
        ReusableMethods.waitFor(1);
        resizablePage.resizableMenu.click();
        ReusableMethods.waitFor(1);
        Driver.getDriver().switchTo().frame(0);
        // Assert.assertTrue(resizablePage.resizable2.get(0).getAttribute("style").isEmpty());

        action.clickAndHold(resizablePage.resiableBoxOkIcon.get(0));
        action.moveByOffset(800, 214).build().perform();
        action.release().build().perform();

        System.out.println(resizablePage.allresizableBox.get(0).getAttribute("style"));
//        Assert.assertEquals(resizablePage.resizable2.get(0).getAttribute("style"), "width: 350px; height: 250px;");
//        Assert.assertTrue(resizablePage.resizable2.get(0).getAttribute("style").contains("width"));

    }

    @Test
    public void resizable2() {
        ReusableMethods.waitFor(1);
        resizablePage.resizableMenu.click();
        ReusableMethods.waitFor(1);
        resizablePage.allTabList.get(1).click();
        Driver.getDriver().switchTo().frame(1);
        ReusableMethods.waitFor(1);

        action.clickAndHold(resizablePage.resiableBoxOkIcon.get(0)).build().perform();
        action.moveByOffset(200, 100).build().perform();
        Assert.assertTrue(resizablePage.allresizableBox.get(0).getAttribute("style").isEmpty());
        action.release();
        action.click(resizablePage.allresizableBox.get(0)).perform();

        System.out.println(resizablePage.allresizableBox.get(0).getAttribute("style"));
        // Assert.assertEquals(resizablePage.resizable2.get(0).getAttribute("style"), "width: 350px; height: 250px;");
        Assert.assertTrue(resizablePage.allresizableBox.get(0).getAttribute("style").contains("width"));


    }

    //Resizable box'in sadece containment box sinirlari icinde acilabildigini assert ediniz
    @Test
    public void resizable3() {
        resizablePage.resizableMenu.click();
        ReusableMethods.waitFor(1);
        resizablePage.allTabList.get(2).click();
        Driver.getDriver().switchTo().frame(2);

       // action.dragAndDropBy(resizablePage.resiableBoxOkIcon.get(0), 90, 74).build().perform();//258///238
        action.clickAndHold(resizablePage.resiableBoxOkIcon.get(0)).moveByOffset(150,150).build().perform();
        Point p = resizablePage.allresizableBox.get(0).getLocation();
        System.out.println(p);
        Dimension d = resizablePage.allresizableBox.get(0).getSize();
        System.out.println(d.width + " " + d.height);
        action.release().build().perform();
    }

    //Helper box'in buyutulup kucultulurken etrafindaki cizginin mavi renk oldugunu ve
    // kesik cizgi seklinde oldugunu assert ediniz
    @Test
    public void resizable4() {
        resizablePage.resizableMenu.click();
        ReusableMethods.waitFor(1);
        resizablePage.allTabList.get(3).click();
        Driver.getDriver().switchTo().frame(3);

        action.clickAndHold(resizablePage.resiableBoxOkIcon.get(0)).moveByOffset(100, 100).build().perform();

        String cizgiRengi = resizablePage.noktaliCizgi.getCssValue("border-right-color");
        System.out.println(cizgiRengi);

        String cizgiTuru = resizablePage.noktaliCizgi.getCssValue("border-right-style");
        System.out.println(cizgiTuru);

        Assert.assertEquals(cizgiRengi, "rgba(0, 0, 255, 1)");
        Assert.assertEquals(cizgiTuru, "dotted");

        action.release().build().perform();


    }

    //Resize box'in en kucuk degerinin "width: 200px; height: 150px;" ve  en butuk degerinin
    //"width: 350px; height: 250px;" oldugunu assert ediniz
    @Test
    public void resizable5() {
        resizablePage.resizableMenu.click();
        ReusableMethods.waitFor(1);
        resizablePage.allTabList.get(4).click();
        Driver.getDriver().switchTo().frame(4);
        ReusableMethods.waitFor(2);


        action.clickAndHold(resizablePage.resiableBoxOkIcon.get(0)).moveByOffset(200, 100).build().perform();
        String maxStyle = resizablePage.allresizableBox.get(0).getAttribute("style");
        System.out.println(maxStyle);

        action.clickAndHold(resizablePage.resiableBoxOkIcon.get(0)).moveByOffset(-200, -100).build().perform();

        String minStyle = resizablePage.allresizableBox.get(0).getAttribute("style");
        System.out.println(minStyle);

        Assert.assertEquals(minStyle,"width: 200px; height: 150px;");
        Assert.assertEquals(maxStyle,"width: 350px; height: 250px;");












    }
}
