package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.US_11_Slider_Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class US_11_Slider_Test {



    US_11_Slider_Page sliderPage = new US_11_Slider_Page();
    Actions action = new Actions(Driver.getDriver());
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);

    @BeforeTest
    public void setup() {
        Driver.getDriver().get(ConfigReader.getProperty("way2Automation_url"));
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        sliderPage.enterGiris.click();
        ReusableMethods.waitFor(1);
        sliderPage.sliderLink.click();
        ReusableMethods.waitFor(1);
        Set<String> windowsHandle = Driver.getDriver().getWindowHandles();
        List<String> list = new ArrayList<>(windowsHandle);
        Driver.getDriver().switchTo().window(list.get(1));
    }

    @Test
    public void renk() {
        ReusableMethods.waitFor(1);
     //   sliderPage.sliderLink.click();
        //Driver.getDriver().switchTo().frame(0);
      //  ReusableMethods.waitFor(2);
        action.moveToElement(sliderPage.sliderLink).build().perform();
        String color=sliderPage.sliderImg.getCssValue("background");
        System.out.println(color);
    }

    @Test
    public void rangeslider01() {
        ReusableMethods.waitFor(1);
       // sliderPage.sliderLink.click();
        Driver.getDriver().switchTo().frame(0);
        ReusableMethods.waitFor(2);


         JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

        js.executeScript("arguments[0].setAttribute('style', 'left: 55.5556%;')", sliderPage.sliderButton);

        ReusableMethods.waitFor(2);
        String style = sliderPage.sliderButton.getAttribute("style");
        System.out.println(style);
        Assert.assertEquals(style, "left: 55.5556%;");
    }

    @Test
    public void rangeslider02() {
        ReusableMethods.waitFor(1);
        sliderPage.sliderLink.click();
        Driver.getDriver().switchTo().frame(0);
        ReusableMethods.waitFor(2);
        String borderTopColor = sliderPage.sliderButton.getCssValue("border-top-color");
        System.out.println(borderTopColor);
        String hexColor = Color.fromString(borderTopColor).asHex();
        System.out.println(hexColor);
        Assert.assertEquals(hexColor, "#d3d3d3");
    }

    @Test
    public void rangeslider03() {
        ReusableMethods.waitFor(1);
        sliderPage.sliderLink.click();
        Driver.getDriver().switchTo().frame(0);
        ReusableMethods.waitFor(2);
        // ? System.out.println(sliderPage.numberOfBeddooms.getText());

    }
}