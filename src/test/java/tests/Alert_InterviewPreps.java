package tests;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Alert_InterviewPreps_Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class Alert_InterviewPreps {

    Alert_InterviewPreps_Page alert_Page = new Alert_InterviewPreps_Page();
    Actions action = new Actions(Driver.getDriver());

    @BeforeMethod
    public void setup() {
        Driver.getDriver().get(ConfigReader.getProperty("way2Automation_url"));
        alert_Page.enterGiris.click();
        ReusableMethods.waitFor(1);
        alert_Page.toolTip.click();
        ReusableMethods.waitFor(1);
        Set<String> windowhandels = Driver.getDriver().getWindowHandles();
        List<String> list = new ArrayList<>(windowhandels);
        Driver.getDriver().switchTo().window(list.get(1));


    }

    @Test
    public void TC_01() {
        //Deafult fonk. menusunde bulunan tooltip linkinin mouse ile ustune gelindiginde
        // "That's what this widget is" yazisinin ciktigini dogrulayiniz
        Driver.getDriver().switchTo().frame(0);
        action.moveToElement(alert_Page.tollTipsLink).build().perform();
        System.out.println(alert_Page.toolTipsAlert.getText());
        Assert.assertEquals(alert_Page.toolTipsAlert.getText(), "That's what this widget is");

    }

    @Test
    public void TC_02() {//Deafult fonk. menusunde bulunan ThemeRoller linkinin mouse ile ustune gelindiginde
        //  mouse style durumunun "pointer" sekline donustugunu assert ediniz
        Driver.getDriver().switchTo().frame(0);
        action.moveToElement(alert_Page.themeRoller).build().perform();
        String ccsCursor = alert_Page.themeRoller.getCssValue("cursor");
        System.out.println(ccsCursor);
        Assert.assertEquals(ccsCursor, "pointer");


    }

    @Test
    public void testTabs() {
        //custom Animation Demo kutucuğunun üzerine geldiğinizde,kutucuğun renginin kirmiziya dönüştüğünü  doğrulayınız.

        String rgbBefore = alert_Page.custom.getCssValue("background-color");
        System.out.println(rgbBefore);
        action.moveToElement(alert_Page.custom).build().perform();
        String rgbAfter = alert_Page.custom.getCssValue("background-color");
        System.out.println(rgbAfter);
        String color = Color.fromString(rgbAfter).asHex();
        System.out.println(color);
        Assert.assertNotEquals(rgbBefore, rgbAfter);
    }

}
