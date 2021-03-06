package tests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.US_07_Accordion_Page;
import pages.US_13_ToolTip_Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class US_13_ToolTip_Test {

    US_13_ToolTip_Page toolTipPage = new US_13_ToolTip_Page();
    US_07_Accordion_Page accordionPage = new US_07_Accordion_Page();
    Actions action = new Actions(Driver.getDriver());

    @BeforeTest
    public void setup() {
        Driver.getDriver().get(ConfigReader.getProperty("way2Automation_url"));
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        accordionPage.enterGiris.click();
        ReusableMethods.waitFor(1);
        toolTipPage.toolTip.click();
        ReusableMethods.waitFor(1);
        Set<String> windowsHandle = Driver.getDriver().getWindowHandles();
        List<String> list = new ArrayList<>(windowsHandle);
        Driver.getDriver().switchTo().window(list.get(1));
    }


    @Test  //Deafult fonk. menusunde bulunan tooltip linkinin mouse ile ustune gelindiginde
    // "That's what this widget is" yazisinin ciktigini dogrulayiniz
    public void TC_70() {
        Driver.getDriver().switchTo().frame(0);
        action.moveToElement(toolTipPage.tollTipsLink).perform();
        System.out.println(toolTipPage.yazi.getText());
        Assert.assertEquals(toolTipPage.yazi.getText(), "That's what this widget is");


    }

    @Test  //Deafult fonk. menusunde bulunan ThemeRoller linkinin mouse ile ustune gelindiginde
    //  mouse style durumunun "el"(pointer) sekline donustugunu assert ediniz
    public void TC71() {
        Driver.getDriver().switchTo().frame(0);
        action.moveToElement(toolTipPage.themeRoller).perform();
        String el = toolTipPage.themeRoller.getCssValue("cursor");
        System.out.println(el);
        Assert.assertEquals(el, "pointer");

    }

    @Test  //'Your age' text box'ina veri girilebildigini dogrulayiniz
    public void TC72() {
        Driver.getDriver().switchTo().frame(0);
        toolTipPage.yourAge.click();
        toolTipPage.yourAge.sendKeys("Merhaba");
        Assert.assertTrue(toolTipPage.yourAge.isEnabled());

    }

    @Test  //custom animation demo menusunde 3 tane animasyon linki oldugunu dogrulayiniz
    public void TC73() {
        toolTipPage.custom.click();
        Driver.getDriver().switchTo().frame(1);
        for (WebElement w : toolTipPage.allActionLinks) {
            System.out.println(w.getText());
        }
        System.out.println(toolTipPage.allActionLinks.size());
        Assert.assertEquals(toolTipPage.allActionLinks.size(),3);


    }

    @AfterClass
    public void close() {
        Driver.closeDriver();

    }
}