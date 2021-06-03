package tests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.US_07_Accordion_Page;
import pages.US_10_Menu_Page;
import pages.US_13_ToolTip_Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class US_13_ToolTip_Test {

    US_07_Accordion_Page accordionPage = new US_07_Accordion_Page();
    US_13_ToolTip_Page toolTipPage = new US_13_ToolTip_Page();
    Actions action = new Actions(Driver.getDriver());
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);

    @BeforeMethod
    public void setup() {
        Driver.getDriver().get(ConfigReader.getProperty("way2Automation_url"));
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        accordionPage.enterGiris.click();
        ReusableMethods.waitFor(1);
        toolTipPage.menuLink.click();
        ReusableMethods.waitFor(1);
        Set<String> windowsHandle = Driver.getDriver().getWindowHandles();
        List<String> list = new ArrayList<>(windowsHandle);
        Driver.getDriver().switchTo().window(list.get(1));
    }

    //Deafult fonk. menusunde bulunan tooltip linkinin mouse ile ustune gelindiginde
    // "That's what this widget is" yazisinin ciktigini dogrulayiniz
    @Test
    public void TC01() {
        Driver.getDriver().switchTo().frame(0);
        action.moveToElement(toolTipPage.tooltipAnimationLink).perform();
        System.out.println(toolTipPage.toolTipsAnimationText.getText());
        Assert.assertTrue(toolTipPage.toolTipsAnimationText.isDisplayed());
        Assert.assertEquals(toolTipPage.toolTipsAnimationText.getText(), "That's what this widget is");
    }


    //Deafult fonk. menusunde bulunan ThemeRoller linkinin mouse ile ustune gelindiginde  mouse style durumunun
    // "el"(pointer) sekline donustugunu assert ediniz
    @Test
    public void TC02() {
        Driver.getDriver().switchTo().frame(0);
        action.moveToElement(toolTipPage.themeRollerAnimationLink).perform();
        String cursor = toolTipPage.themeRollerAnimationLink.getCssValue("cursor");
        Assert.assertEquals(cursor, "pointer");
    }

    @Test//'Your age' text box'ina veri girilebildigini dogrulayiniz
    public void TC03() {
        Driver.getDriver().switchTo().frame(0);
        Assert.assertTrue(toolTipPage.ageTextBox.isEnabled());
    }

    @Test //custom animation demo menusunde 3 tane animasyon linki oldugunu dogrulayiniz
    public void TC04() {
        toolTipPage.customAnimationDemoLink.click();
        Driver.getDriver().switchTo().frame(1);
        for (WebElement w : toolTipPage.allActionLinks) {
            System.out.println(w.getText());
        }
        System.out.println(toolTipPage.allActionLinks.size());
        Assert.assertEquals(toolTipPage.allActionLinks.size(),3);

    }

    @AfterClass
    public void close(){
        Driver.getDriver();
    }

}
