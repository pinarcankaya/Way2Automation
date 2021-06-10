package tests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.US_07_Accordion_Page;
import pages.US_15_Droppable_Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class US_15_Droppable_Test {


    US_15_Droppable_Page droppablePage=new US_15_Droppable_Page();
    US_07_Accordion_Page accordionPage= new US_07_Accordion_Page();
    Actions action = new Actions(Driver.getDriver());
    @BeforeMethod
    public void setUp(){
        Driver.getDriver().get(ConfigReader.getProperty("way2Automation_url"));
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        accordionPage.enterGiris.click();
        ReusableMethods.waitFor(2);
        droppablePage.droppableMenu.click();
        Set<String> windowHandles= Driver.getDriver().getWindowHandles();
        List<String> list= new ArrayList<>(windowHandles);
        Driver.getDriver().switchTo().window(list.get(1));
        ReusableMethods.waitFor(2);
    }

    @Test  //Default Fonksionality'de kucuk kutunun hareket ettigini buyuk kutunun hareket ettirelemedigini assert ediniz
    public void TC_79(){
        Driver.getDriver().switchTo().frame(0);
        ReusableMethods.waitFor(2);

        String ilkDurum=droppablePage.draggableList.get(0).getAttribute("style");
        action.dragAndDropBy(droppablePage.draggableList.get(0),150,10).build().perform();
        String ikinciDurum= droppablePage.draggableList.get(0).getAttribute("style");
        System.out.println(ilkDurum+"\n"+ikinciDurum);
        Assert.assertNotEquals(ilkDurum,ikinciDurum);

        String ilkDurum1=droppablePage.droppableList.get(0).getAttribute("style");
        action.dragAndDropBy(droppablePage.droppableList.get(0),150,10).build().perform();
        String ikinciDurum1= droppablePage.droppableList.get(0).getAttribute("style");
        System.out.println(ilkDurum1+"\n"+ikinciDurum1);
        Assert.assertEquals(ilkDurum,ikinciDurum);

    }

    @Test  //Accept tab'inda kucuk kutunun her iki buyuk kutunun da icine koyulabildigini assert ediniz
    public void TC_80() {
        droppablePage.tabsList.get(1).click();
        Driver.getDriver().switchTo().frame(1);
        action.dragAndDrop(droppablePage.draggableList.get(0),droppablePage.droppableList.get(0)).build().perform();
        action.dragAndDrop(droppablePage.draggableList.get(1),droppablePage.droppableList.get(0)).build().perform();
        String style1= droppablePage.draggableList.get(0).getAttribute("style");
        String style2= droppablePage.draggableList.get(1).getAttribute("style");
        System.out.println(style1+"\n"+style2);
        Assert.assertEquals(style1.contains("inset: 25px"),style2.contains("inset: 25px"));
    }

    @Test  //Prevent Propagation'da Drag me to my target box'in, buyuk kutulardan herhangi birine birakildiginda
    // kutularin isminin "Outer droppable" dan "dropped" 'a donustugunu ve renginin "#fcefa1" 'e donustugunu dogrulayiniz
    public void TC_81() {
        droppablePage.tabsList.get(2).click();
        Driver.getDriver().switchTo().frame(2);
        for (WebElement w : droppablePage.droppableList) {
            String ilkRenk = w.getCssValue("background");
            System.out.println("ilkRenk : "+ilkRenk);
        }
            ReusableMethods.waitFor(1);
        String ilkYazi  = droppablePage.droppableList.get(0).getText();


            action.dragAndDropBy(droppablePage.draggableList.get(0),180,70).build().perform();
            String sonRenkDis = droppablePage.droppableList.get(0).getCssValue("background");
            String sonRenkIc = droppablePage.droppableList.get(1).getCssValue("background");
            String sonYazi  = droppablePage.droppableList.get(0).getText();

            System.out.println("SonRenkDis : "+sonRenkDis + "\n" + "SonRenkIc : " + sonRenkIc+
                    "\n"+"ilkYazi : "+ilkYazi+ "\n"+"SonYazi : "+sonYazi);
            Assert.assertNotEquals(ilkYazi,sonYazi);

//
//            Driver.getDriver().navigate().refresh();
//
//            action.dragAndDropBy(droppablePage.draggableList.get(0),439,71).build().perform();
//            String sonRenkDis1 = droppablePage.droppableList.get(2).getCssValue("background");
//            String sonRenkIc1 = droppablePage.draggableList.get(3).getCssValue("background");
//            System.out.println(sonRenkDis1 + "\n" + sonRenkIc1);

    }

      @Test  //Revert draggable Position'da "I revert when I'm dropped" kutusunun hedefe koyuldugunda geri dondugunu
    // "I revert when I'm not dropped" kutusunun hedefe koyuldugunda geri gonmedigini assert ediniz
    public void TC_82() {
        droppablePage.tabsList.get(3).click();
        Driver.getDriver().switchTo().frame(3);
        action.dragAndDrop(droppablePage.draggableList.get(0),droppablePage.droppableList.get(0)).build().perform();
        String style= droppablePage.draggableList.get(0).getAttribute("style");
        System.out.println(style);
        ReusableMethods.waitFor(2);
        String styleSon= droppablePage.draggableList.get(0).getAttribute("style");
        System.out.println(styleSon);
        Assert.assertNotEquals(style,styleSon);

        action.dragAndDrop(droppablePage.draggableList.get(1),droppablePage.droppableList.get(0)).build().perform();
        String style1= droppablePage.draggableList.get(1).getAttribute("style");
        System.out.println(style1);
        ReusableMethods.waitFor(2);
        String style1Son= droppablePage.draggableList.get(1).getAttribute("style");
        System.out.println(style1Son);
        Assert.assertEquals(style1,style1Son);

    }


    @Test  //Shopping cart demo tab'inda T-Shirt, Bags, GadGets dropdownlarin acilabildigini assert ediniz
    public void TC_75() {
        droppablePage.tabsList.get(4).click();
        Driver.getDriver().switchTo().frame(4);
        for (WebElement w : droppablePage.productsList) {
            w.click();
            ReusableMethods.waitFor(1);
            Assert.assertTrue(w.isEnabled());
        }

    }

    @AfterMethod
    public void tearDownMethod() {
        Driver.closeDriver();
    }


}



