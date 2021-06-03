package tests;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.US_07_Accordion_Page;
import pages.US_12_Tabs_Page;
import pages.US_14_Draggable_Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class US_14_Draggable_Test {

    US_07_Accordion_Page accordionPage = new US_07_Accordion_Page();
    US_14_Draggable_Page draggablePage = new US_14_Draggable_Page();
    Actions action = new Actions(Driver.getDriver());
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);

    @BeforeTest
    public void setup() {
        Driver.getDriver().get(ConfigReader.getProperty("way2Automation_url"));
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        accordionPage.enterGiris.click();
        ReusableMethods.waitFor(1);
        draggablePage.draggableMenuLink.click();
        ReusableMethods.waitFor(1);
        Set<String> windowsHandle = Driver.getDriver().getWindowHandles();
        List<String> list = new ArrayList<>(windowsHandle);
        Driver.getDriver().switchTo().window(list.get(1));
    }

    //Drag Box'in x ekseninde 100 y eksininde 150 px hareket edilebildigini assert ediniz
    @Test
    public void TC01() {
        Driver.getDriver().switchTo().frame(0);
        action.dragAndDropBy(draggablePage.dragMeBox, 100, 150).build().perform();
        String style = draggablePage.dragMeBox.getAttribute("style");
        System.out.println(style);
        Assert.assertTrue(style.contains("inset: 150px auto auto 100px;"));
    }

    // "I can be dragged only vertically" box'in sadece dikey yonlu ,"I can be dragged only horizontally
    // sadece yatay yonlu hareket edilebildigini assert ediniz
    @Test
    public void TC02() {
        draggablePage.allDraggableMenuTabList.get(1).click();
        Driver.getDriver().switchTo().frame(1);

        //dikey hareket
        action.dragAndDropBy(draggablePage.constrainMovementDrabBoxs.get(0), 50, 50).build().perform();
        String beforeVerticaly = draggablePage.constrainMovementDrabBoxs.get(0).getAttribute("style");
        System.out.println(beforeVerticaly);
        action.dragAndDropBy(draggablePage.constrainMovementDrabBoxs.get(0), 60, 60).build().perform();
        String afterVerticaly = draggablePage.constrainMovementDrabBoxs.get(0).getAttribute("style");
        System.out.println(afterVerticaly);

        Assert.assertTrue(beforeVerticaly.contains("left: 0px") && afterVerticaly.contains("left: 0px"));

        //yatay hareket
        action.dragAndDropBy(draggablePage.constrainMovementDrabBoxs.get(1), 50, 50).build().perform();
        String beforeHorizontaly = draggablePage.constrainMovementDrabBoxs.get(1).getAttribute("style");
        System.out.println(beforeHorizontaly);
        action.dragAndDropBy(draggablePage.constrainMovementDrabBoxs.get(1), 60, 60).build().perform();
        String afterHorizantaly = draggablePage.constrainMovementDrabBoxs.get(1).getAttribute("style");
        System.out.println(afterHorizantaly);

        Assert.assertTrue(beforeHorizontaly.contains("top: 0px") && afterHorizantaly.contains("top: 0px"));
    }

    @Test
    public void TC03() {
        draggablePage.allDraggableMenuTabList.get(2).click();
        Driver.getDriver().switchTo().frame(2);


    }
}