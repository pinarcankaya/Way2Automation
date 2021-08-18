package tests;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.US_07_Accordion_Page;
import pages.US_15_Droppable_Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class  US_15_Droppable_Test {


    US_15_Droppable_Page droppablePage=new US_15_Droppable_Page();
    US_07_Accordion_Page accordionPage= new US_07_Accordion_Page();
    Actions action = new Actions(Driver.getDriver());
    Set<String> windowHandles;
    List<String> list;


    @BeforeClass
    public void setUp(){
        Driver.getDriver().get(ConfigReader.getProperty("way2Automation_url"));
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        accordionPage.enterGiris.click();
        ReusableMethods.waitFor(3);
        droppablePage.droppableMenu.click();
       windowHandles= Driver.getDriver().getWindowHandles();
        list= new ArrayList<>(windowHandles);
        Driver.getDriver().switchTo().window(list.get(1));
        ReusableMethods.waitFor(2);
    }

    @Test  //Default Fonksionality'de kucuk kutunun hareket ettigini buyuk kutunun hareket ettirelemedigini assert ediniz
    public void TC_79(){
        Driver.getDriver().switchTo().frame(0);

        Point smallBoxIlkKonum=droppablePage.draggableSmallBoxList.get(0).getLocation();//Mevcut konumunu verir.
        action.dragAndDropBy(droppablePage.draggableSmallBoxList.get(0),150,10).build().perform();
        ReusableMethods.waitFor(2);
        Point smallBoxSonKonum=droppablePage.draggableSmallBoxList.get(0).getLocation();

        Assert.assertNotEquals(smallBoxIlkKonum,smallBoxSonKonum);

        Point bigBoxIlkKonum=droppablePage.droppableBigBoxList.get(0).getLocation();//Mevcut konumunu verir.
        action.dragAndDropBy(droppablePage.droppableBigBoxList.get(0),150,10).build().perform();
        ReusableMethods.waitFor(2);
        Point bigBoxSonKonum=droppablePage.droppableBigBoxList.get(0).getLocation();

        Assert.assertEquals(bigBoxIlkKonum,bigBoxIlkKonum);

        System.out.println(smallBoxIlkKonum+"\n"+smallBoxSonKonum);
        System.out.println(bigBoxIlkKonum+"\n"+bigBoxSonKonum);

    }

    @Test  //Accept tab'inda kucuk kutunun her iki buyuk kutunun da icine koyulabildigini assert ediniz
    public void TC_80() {
        droppablePage.tabsList.get(1).click();
        Driver.getDriver().switchTo().frame(1);

        action.dragAndDrop(droppablePage.draggableSmallBoxList.get(0),droppablePage.droppableBigBoxList.get(0)).build().perform();
        action.dragAndDrop(droppablePage.draggableSmallBoxList.get(1),droppablePage.droppableBigBoxList.get(0)).build().perform();

        Point smallBoxKonum1=droppablePage.draggableSmallBoxList.get(0).getLocation();
        Point smallBoxKonum2=droppablePage.draggableSmallBoxList.get(1).getLocation();

        Assert.assertEquals(smallBoxKonum1,smallBoxKonum2);
        System.out.println(smallBoxKonum1+"  "+smallBoxKonum2);
    }

    @Test  //Prevent Propagation'da Drag me to my target box'in, buyuk kutulardan herhangi birine birakildiginda
    // kutularin isminin "Outer droppable" dan "dropped" 'a donustugunu ve renginin "#fbf9ee" 'e donustugunu dogrulayiniz
    public void TC_81() {
        droppablePage.tabsList.get(2).click();
        Driver.getDriver().switchTo().frame(2);

        String ilkRenk = droppablePage.droppableBigBoxList.get(0).getCssValue("background-color");
        String hexIlk = Color.fromString(ilkRenk).asHex();
        ReusableMethods.waitFor(1);
        String ilkYazi  = droppablePage.droppableBigBoxList.get(0).getText();

        action.dragAndDrop(droppablePage.draggableSmallBoxList.get(0),droppablePage.droppableBigBoxList.get(0)).build().perform();

        String sonRenk = droppablePage.droppableBigBoxList.get(0).getCssValue("background-color");
        String hexSon=Color.fromString(sonRenk).asHex();
        String sonYazi  = droppablePage.droppableBigBoxList.get(0).getText();

        Assert.assertNotEquals(ilkYazi,sonYazi);
        Assert.assertNotEquals(hexIlk,hexSon);
        Assert.assertEquals(hexSon,"#fbf9ee");

            System.out.println("ilk Renk  : "+hexIlk+"\n"+"ilkYazi : "+ilkYazi);
            System.out.println("SonRenk : "+sonRenk+"\n" + "SonYazi : "+sonYazi);
    }

      @Test  //Revert draggable Position'da "I revert when I'm dropped" kutusunun hedefe koyuldugunda geri dondugunu
    // "I revert when I'm not dropped" kutusunun hedefe koyuldugunda geri gonmedigini assert ediniz
    public void TC_82() {
        droppablePage.tabsList.get(3).click();
        Driver.getDriver().switchTo().frame(3);

        Point IamNotDroppedIlkKonum=droppablePage.draggableSmallBoxList.get(0).getLocation();
        action.dragAndDrop(droppablePage.draggableSmallBoxList.get(0),droppablePage.droppableBigBoxList.get(0)).build().perform();
        ReusableMethods.waitFor(2);
        Point IamNotDroppedSonKonum=droppablePage.draggableSmallBoxList.get(0).getLocation();

        Assert.assertEquals(IamNotDroppedIlkKonum,IamNotDroppedSonKonum);

        Point IamDroppedIlkKonum=droppablePage.draggableSmallBoxList.get(1).getLocation();
        action.dragAndDrop(droppablePage.draggableSmallBoxList.get(1),droppablePage.droppableBigBoxList.get(0)).build().perform();
        ReusableMethods.waitFor(2);
        Point IamDroppedSonKonum =droppablePage.draggableSmallBoxList.get(1).getLocation();

        Assert.assertNotEquals(IamDroppedIlkKonum,IamDroppedSonKonum);

    }

    @Test  //Shopping cart demo tab'inda T-Shirt, Bags, GadGets dropdownlarin acilabildigini assert ediniz
    public void TC_83() {
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
        Driver.getDriver().switchTo().defaultContent();
    }


}



