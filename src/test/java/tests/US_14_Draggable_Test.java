package tests;


import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.US_07_Accordion_Page;
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
        String verticalyBox = draggablePage.constrainMovementDrabBoxs.get(0).getAttribute("style");
        System.out.println(verticalyBox);

        Assert.assertTrue(verticalyBox.contains("left: 0px; top: 50px"));

        //yatay hareket
        action.dragAndDropBy(draggablePage.constrainMovementDrabBoxs.get(1), 50, 50).build().perform();
        String horizantalyBox = draggablePage.constrainMovementDrabBoxs.get(1).getAttribute("style");
        System.out.println(horizantalyBox);

        Assert.assertTrue(horizantalyBox.contains("left: 50px; top: 0px"));
    }

    //Drag Box'lar hareket ettiginde cursor  turunun fare hareketine gore degistigini assert ediniz
    // (move,auto,crosshair)
    @Test
    public void TC03() {
        draggablePage.allDraggableMenuTabList.get(2).click();
        Driver.getDriver().switchTo().frame(2);

        for (WebElement w : draggablePage.dragMeBoxList) {
            action.clickAndHold(w).perform();
            //System.out.println(w.getCssValue("cursor"));
            action.moveToElement(w, 20, 20).build().perform();
            System.out.println(w.getCssValue("cursor"));

            if (w.getCssValue("cursor").equals("move")) {
                Assert.assertTrue(draggablePage.dragMeBoxList.get(0).getCssValue("cursor").equals("move"));
                action.release().build().perform();
            }
            if (w.getCssValue("cursor").equals("crosshair")) {
                Assert.assertTrue(draggablePage.dragMeBoxList.get(0).getCssValue("cursor").equals("crosshair"));
                action.release().build().perform();
            }
            if (w.getCssValue("cursor").equals("auto")) {
                Assert.assertTrue(draggablePage.dragMeBoxList.get(0).getCssValue("cursor").equals("auto"));
                action.release().build().perform();
            }


        }
//        Assert.assertTrue(draggablePage.dragMeBoxList.get(0).equals("move") &&
//                draggablePage.dragMeBoxList.get(1).equals("crosshair") &&
//                draggablePage.dragMeBoxList.get(2).equals("auto"));

    }

    //Drag Box suruklendiginde start,drag ve stop'taki sayilarin hareket miktarina gore arttigini assert ediniz
    @Test
    public void TC04() {
        draggablePage.allDraggableMenuTabList.get(3).click();
        Driver.getDriver().switchTo().frame(3);
        action.dragAndDropBy(draggablePage.dragMeBox, 50, 40).build().perform();
        action.dragAndDropBy(draggablePage.dragMeBox, 30, 50).build().perform();

        for (WebElement w : draggablePage.eventAllInvoked) {
            System.out.println(w.getText());

        }
        Assert.assertTrue(draggablePage.eventAllInvoked.get(0).getText().equals("2") && draggablePage.eventAllInvoked.get(1).getText().
                equals("2") && draggablePage.eventAllInvoked.get(2).getText().equals("2"));


    }

    //"Drag me Down" box'in her suruklendiginde sayisinin arttigini assert ediniz(Ornek;10 kez suruklenip
    // birakildiginda 10 tane ayni box olmali)
    @Test
    public void TC05() {
        draggablePage.allDraggableMenuTabList.get(4).click();
        Driver.getDriver().switchTo().frame(4);

        action.dragAndDrop(draggablePage.dragMeButton, draggablePage.itemList.get(4)).build().perform();
        action.release().build().perform();
        action.dragAndDrop(draggablePage.dragMeButton, draggablePage.itemList.get(4)).build().perform();
        action.release().build().perform();


    }
}