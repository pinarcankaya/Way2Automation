package tests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.US_09_DatePicker_Page;
import pages.US_07_Accordion_Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class US_09_DatePicker_Test {

    US_09_DatePicker_Page datePickerPage = new US_09_DatePicker_Page();
    US_07_Accordion_Page accordionPage = new US_07_Accordion_Page();
    Actions action = new Actions(Driver.getDriver());
   Set<String> windowHandles;
    List<String> list;

    @BeforeTest
    public void setup() {
        Driver.getDriver().get(ConfigReader.getProperty("way2Automation_url"));
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        accordionPage.enterGiris.click();
        ReusableMethods.waitFor(2);//thread sleep
        datePickerPage.datapickerMenu.click();
        ReusableMethods.waitFor(1);
        windowHandles = Driver.getDriver().getWindowHandles();
         list = new ArrayList<>(windowHandles);
        Driver.getDriver().switchTo().window(list.get(1));
        ReusableMethods.waitFor(2);
    }

    @Test //1)Date Picker basligi altindaki Default Functionality tiklanmali,
    // Date box tiklandiginda tarih gorunmeli,Tarih secilebilmeli
    public void defaultFonk() {
        datePickerPage.defauldMenu.click();
        Driver.driver.switchTo().frame(0);
        datePickerPage.dataInputList.get(0).click();
        Assert.assertTrue(datePickerPage.dateTitle.isDisplayed());
        datePickerPage.dataInputList.get(0).sendKeys("05/05/2050");
    }

    @Test  //1)Wigdet basligi altindaki Animasyon tiklanmali
//Animasyon tiklandiginda Animasyon textbox (dropdown)gorunuyor oldugunu dogrulayiniz
//Dropdowndan drop animation secilebiyor oldugunu dogrulayiniz
    public void animationMenu() {
        datePickerPage.animationMenu.click();
        Driver.getDriver().switchTo().frame(1);
        Assert.assertTrue(datePickerPage.animationDropDown.isDisplayed());

        Select select = new Select(datePickerPage.animationDropDown);
      //  select.selectByVisibleText("Drop (UI Effect)");
        select.selectByValue("drop");
        ReusableMethods.waitFor(2);

        String actualResult=select.getFirstSelectedOption().getText();
        String expectedResult="Drop (UI Effect)";
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test  //1)Date Picker basligi altindaki Display Month & Year kutusu tiklanmali
//Date textbox'u tiklandiginda ay ve yil gorunmel ,Ay ve yil secilebilmeli
    public void displayMonthYear() {
        datePickerPage.displayMonthYearMenu.click();
        Driver.getDriver().switchTo().frame(2);
        datePickerPage.dataInputList.get(0).click();

        Assert.assertTrue(datePickerPage.monthDropDown.isDisplayed() && datePickerPage.yearDropDown.isDisplayed());

        Select month = new Select(datePickerPage.monthDropDown);
        Select year = new Select(datePickerPage.yearDropDown);

        month.selectByVisibleText("Apr");  //text olarak getirir
       // month.selectByValue("3");  //attribute degeri olarak getirir
       // month.selectByIndex(3); //index olarak getirir
        year.selectByValue("2030");
        System.out.println(month.getFirstSelectedOption().getText());

        System.out.println(year.getFirstSelectedOption().getText());
        Assert.assertEquals(month.getFirstSelectedOption().getText(),"Apr");
        Assert.assertEquals(year.getFirstSelectedOption().getText(),"2030");

    }

    @Test  //1)Wigdet basligi altindaki Format Date tiklanmali,Fomat Date tiklandiginda option gorunuyor olmali
           //Format option  full secenegi secildigindeyeni formatta date yazdigini dogrulayiniz
    public void formatDate() {
        datePickerPage.formatDateMenu.click();
        Driver.getDriver().switchTo().frame(3);
        Select formatDate = new Select(datePickerPage.formatDropDown);
       // formatDate.selectByValue("DD, d MM, yy");
        formatDate.selectByIndex(4);

        System.out.println(formatDate.getFirstSelectedOption().getText());
        Assert.assertEquals(formatDate.getFirstSelectedOption().getText(),"Full - DD, d MM, yy");

        for(WebElement w: formatDate.getOptions() ){  //tum elementleri getirir
            System.out.println(w.getText());
        }
    }
    @AfterMethod
    public void tearDownMethod() {
        Driver.getDriver().switchTo().parentFrame();
    }
}
