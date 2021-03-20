package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.US_14_Draggable_Page;
import pages.US_20_AutoComplete_Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class US_20_AutoComplete_Test {

    US_20_AutoComplete_Page autoCompletePage = new US_20_AutoComplete_Page();
    US_14_Draggable_Page page = new US_14_Draggable_Page();
    Actions action = new Actions(Driver.getDriver());

    @BeforeTest
    public void login() {
        Driver.getDriver().get(ConfigReader.getProperty("way2Automation_url"));
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        page.signinButton.click();
        page.usernameTextBox.sendKeys(ConfigReader.getProperty("valid_username"));
        page.passwordTextBox.sendKeys(ConfigReader.getProperty("valid_password"));
        page.submitButton.click();

    }

    @Test
    public void defaultFonk() {
        ReusableMethods.waitFor(1);
        action.sendKeys(Keys.PAGE_DOWN).perform();
        autoCompletePage.autoCompleteMenu.click();
        Set<String> tekrarsizElemanlar=new HashSet<>();

        int sum=0;

        for (char i = 'a'; i <='z' ; i++) {
            Driver.getDriver().switchTo().frame(0);
            char harf=i;
            autoCompletePage.autoInputList.get(0).sendKeys(i+"");

          // ReusableMethods.waitFor(1);


            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 2);   //bu wait de kullanilabilir
            wait.until(ExpectedConditions.visibilityOf(autoCompletePage.textBoxList.get(0)));//?


            System.out.println(i + " ==> harfinden " + autoCompletePage.textBoxList.size() +" tane var ");

            sum=sum+autoCompletePage.textBoxList.size();

            if(autoCompletePage.textBoxList.size()!=0){
                for (WebElement w :autoCompletePage.textBoxList){
                    System.out.println(w.getText());
                    Assert.assertTrue(w.getText().toLowerCase().contains(i+""));
                    tekrarsizElemanlar.add(w.getText());
                }
            }

            Driver.getDriver().navigate().refresh();

        }
        System.out.println(sum);///tekrarli elemanlar toplami
        System.out.println(tekrarsizElemanlar.size()); //tekrarsiz elemanlar toplami



    }

    @Test
    public void multipleValues() {
        ReusableMethods.waitFor(1);
        action.sendKeys(Keys.PAGE_DOWN).perform();
        autoCompletePage.autoCompleteMenu.click();
        Driver.getDriver().switchTo().frame(1);
        autoCompletePage.autoInputList.get(1).sendKeys("a");





    }

    @Test
    public void categories() {
        ReusableMethods.waitFor(1);
        action.sendKeys(Keys.PAGE_DOWN).perform();
        autoCompletePage.autoCompleteMenu.click();
        Driver.getDriver().switchTo().frame(2);

    }
}