package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.DropDown_Page;
import pages.SeleniumEasyPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DropDown_Test {

    SeleniumEasyPage seleniumEasyPage = new SeleniumEasyPage();
    Actions action = new Actions(Driver.getDriver());
    DropDown_Page dropDownPage = new DropDown_Page();

    @BeforeTest
    public void setup() {
        Driver.getDriver().get("https://www.seleniumeasy.com/test/");
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        seleniumEasyPage.noThanks.click();
        action.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(1);
        seleniumEasyPage.inputFormsLink.click();
        ReusableMethods.waitFor(1);
        dropDownPage.selectDropDownLink.click();

    }

    //Kullanici, Select List Demo basligi altindaki "Select a day (select one):" dropDown'dan tum
    // gunleri secebildilgini dogrulamalidir. Son olarak 'Friday' secip  'Day selected :- Friday'
    // yazisi goruldugu dogrulanmalidir.
    @Test
    public void TC02() {
        Select select = new Select(dropDownPage.selectDayDropDown);
        for (WebElement w : dropDownPage.dayList) {
            System.out.println(w.getText());
            Assert.assertTrue(w.isEnabled());
        }
        select.selectByVisibleText("Friday");
        Assert.assertTrue(dropDownPage.isFriday.getText().contains("Friday"));

    }

    //Kullanici, Multi Select List Demo basligi altinda birden fazla eyalet sectiginde ve
    //'First Selected' butonuna tikladiginda eyalet kutucugunun altinda bulunan
    //"First selected option is :"  yazisinin devaminda tikladigi ilk eyaletin isminin yazili oldugunu
    //dogrulamalidir.
    @Test
    public void TC03() {
        Select select = new Select(dropDownPage.multiSelect);
        action.sendKeys(Keys.CONTROL).perform();
        select.selectByVisibleText("Ohio");
        ReusableMethods.waitFor(1);
        select.selectByVisibleText("Florida");
        ReusableMethods.waitFor(1);
        select.selectByVisibleText("Texas");
        ReusableMethods.waitFor(1);
        dropDownPage.firstSelectedButton.click();

        //   Assert.assertTrue(dropDownPage.firstSelectedText.getText().contains("Ohio"));
        System.out.println(dropDownPage.firstSelectedText.getText());


    }
  /*  Kullanici, Multi Select List Demo basligi altinda tum eyaletleri sectikten sonra "Get All Selected"
butonuna tikladiginda tum eyaletlerin 'Options selected are :' yazisinin devaminda secili
oldugunu gormelidir..*/

    @Test
    public void TC04() {
        String city[]={"California","Florida","New Jersey","New York","Ohio","Texas","Pennsylvania","Washington"};

        for(int i=3; i<dropDownPage.allCityList.size(); i++){
            action.sendKeys(Keys.CONTROL);
            dropDownPage.allCityList.get(i).click();
            dropDownPage.getAllSelectedButton.click();
            System.out.println(dropDownPage.allCityList.get(i).getText());

        }
    }
}

