package tests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
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

public class US_14_DraggableTest {

    US_14_Draggable_Page draggablePage= new US_14_Draggable_Page();
    US_07_Accordion_Page accordionPage= new US_07_Accordion_Page();
    Actions acctions= new Actions(Driver.getDriver());
    @BeforeMethod
    public void setUp(){
        Driver.getDriver().get(ConfigReader.getProperty("way2Automation_url"));
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        accordionPage.enterGiris.click();
        ReusableMethods.waitFor(2);
        draggablePage.draggableMenu.click();
        Set<String> windowHandles= Driver.getDriver().getWindowHandles();
        List<String> list= new ArrayList<>(windowHandles);
        Driver.getDriver().switchTo().window(list.get(1));
        ReusableMethods.waitFor(2);
    }
    @Test
    public void TC_74(){
        //Drag Box'in x ekseninde 100 y eksininde 150 px hareket edilebildigini assert ediniz
        Driver.getDriver().switchTo().frame(0);
        ReusableMethods.waitFor(2);
        acctions.dragAndDropBy(draggablePage.draggableMeAround,100,150).build().perform();
        String style= draggablePage.draggableMeAround.getAttribute("style");
        System.out.println(style);
        Assert.assertTrue(style.contains("150px auto auto 100px"));

    }

    @Test
    public void TC_75() {
        //"I can be dragged only vertically" box'in sadece dikey yonlu ,
        // "I can be dragged only horizontally sadece yatay yonlu hareket edilebildigini assert ediniz
        draggablePage.tabsList.get(1).click();
        Driver.getDriver().switchTo().frame(1);
        acctions.dragAndDropBy(draggablePage.vertically,50,50).build().perform();
        String style= draggablePage.vertically.getAttribute("style");
        System.out.println(style);
        Assert.assertTrue(style.contains("left: 0px; top: 50px"));
    }

    @Test
    public void TC_76() {
        //Drag Box'lar hareket ettiginde cursor  turunun fare hareketine gore
        // degistigini assert ediniz(move,auto,crosshair)
    }

    @Test
    public void TC_77() {
        //Drag Box suruklendiginde start,drag ve stop'taki sayilarin hareket miktarina gore arttigini assert ediniz
        draggablePage.tabsList.get(3).click();
        Driver.getDriver().switchTo().frame(3);
        acctions.dragAndDropBy(draggablePage.eventDragBox,50,40).build().perform();
        acctions.dragAndDropBy(draggablePage.eventDragBox,30,50).build().perform();
        //  acctions.dragAndDropBy(draggablePage.eventDragBox,30,50).build().perform();
        for (WebElement w : draggablePage.eventAllInvoked) {
            System.out.println(w.getText());

        }
        Assert.assertTrue(draggablePage.eventAllInvoked.get(0).getText().equals("2")&&draggablePage.eventAllInvoked.get(1).getText().
                equals("2")&&draggablePage.eventAllInvoked.get(2).getText().equals("2") );
    }
}
