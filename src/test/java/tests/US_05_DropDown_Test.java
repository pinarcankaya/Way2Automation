package tests;


import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.US_05_DropDown_Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class US_05_DropDown_Test {

    US_05_DropDown_Page dropDownPage = new US_05_DropDown_Page();
    Actions action = new Actions(Driver.getDriver());
    Set<String> windowsHandles ;
    List<String> list;

    @BeforeMethod
    public void setup() {
        Driver.getDriver().get(ConfigReader.getProperty("way2Automation_url"));
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        dropDownPage.enterGiris.click();
        ReusableMethods.waitFor(2);
        dropDownPage.dropdownButton.click();
        //ReusableMethods.switchToWindow("1");
        windowsHandles = Driver.getDriver().getWindowHandles();
        list = new ArrayList<>(windowsHandles);
        Driver.getDriver().switchTo().window(list.get(1));

    }

    @Test  //Dropdown calisir oldugunu dogrulayiniz
    public void TC29() {
        Driver.driver.switchTo().frame(0);
        //1.Yol
        Assert.assertTrue(dropDownPage.select.isEnabled());

        //2.yol
        Select select = new Select(dropDownPage.select);
        List<WebElement> tumSecenekler = select.getOptions();
        for (WebElement w : tumSecenekler) {
            System.out.println(w.getText());
            Assert.assertTrue(w.isDisplayed());
        }
        String ilkSecenek = select.getFirstSelectedOption().getText();
        System.out.println(ilkSecenek);
    }

    @Test  //239 adet ülke oldugunu dogrulayiniz
    public void TC30() {
        Driver.driver.switchTo().frame(0);
        Select select = new Select(dropDownPage.select);
        List<WebElement> tumSecenekler = select.getOptions();
        System.out.println(tumSecenekler.size());//240,ilki "Please Select" yazisi.
        Assert.assertEquals(tumSecenekler.size() - 1, 239);
    }

    @Test  //Klavye den "w" ye tiklandiginda ilk sirada "Wallis and Futuna Islands" oldugunu dogrulayiniz
    public void TC31() {
        Driver.driver.switchTo().frame(0);
        dropDownPage.select.sendKeys("w");
        Select select = new Select(dropDownPage.select);
        String wIlkSira = select.getFirstSelectedOption().getText();
        System.out.println(wIlkSira);
        Assert.assertEquals(wIlkSira, "Wallis and Futuna Islands");
    }

    @Test  //"ENTER COUNTRY" basligi görünür oldugunu dogrulayiniz
    public void TC32() {
        Assert.assertTrue(dropDownPage.enterCountry.isDisplayed());
    }

    @Test  //ENTER COUNTRY basliginin altindaki kutucuga text girilebilir oldugunu dogrulayiniz
    public void TC33() {
        dropDownPage.enterCountry.click();
        Driver.driver.switchTo().frame(1);
        dropDownPage.enterbox.clear();
        dropDownPage.enterbox.sendKeys("af");
        String af = dropDownPage.acilanMenu.get(0).getText();
        Assert.assertEquals(af, "Afghanistan");
        System.out.println(af);

    }

    @Test  //ok isareti olan butonun üzerine gelindiginde "Show All Items" yazisinin görünür oldugunu dogrulayiniz
    public void TC34() {
        dropDownPage.enterCountry.click();
        Driver.driver.switchTo().frame(1);
        action.moveToElement(dropDownPage.asagiButton).build().perform();
        //1.Yol
        Assert.assertTrue(dropDownPage.showAllItems.isDisplayed());
        //2.Yol
        Assert.assertEquals(dropDownPage.showAllItems.getText(), "Show All Items");
        System.out.println(dropDownPage.showAllItems.getText());

    }

    @Test  //"alb" text i girildiginde "Albania" ve "Svalbard and Jan Mayen Islands"
    // ulkelerinin gorulur oldugunu dogrulayiniz
    public void TC35() {
        dropDownPage.enterCountry.click();
        Driver.getDriver().switchTo().frame(1);
        dropDownPage.enterbox.clear();
        dropDownPage.enterbox.sendKeys("alb");
        Select select = new Select(dropDownPage.selectEnterCountry);
        ReusableMethods.waitFor(3);
        List<WebElement> list = select.getAllSelectedOptions();
        for (WebElement w : list) {
            System.out.println(w.getText());

        }
    }
    @AfterMethod
    public void tearDownMethod() {
        Driver.getDriver().switchTo().window(list.get(0));
    }
}