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
import pages.US_22_Menu_Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.concurrent.TimeUnit;

public class US_22_Menu_Test {

    US_14_Draggable_Page page = new US_14_Draggable_Page();
    US_22_Menu_Page menuPage = new US_22_Menu_Page();
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
    public void simpleMenu() {
        ReusableMethods.waitFor(1);
        action.sendKeys(Keys.PAGE_DOWN).perform();
        menuPage.menuLink.click();
        Driver.getDriver().switchTo().frame(0);
        System.out.println(menuPage.simpleMenuList.size());

        for (int i = 0; i < menuPage.simpleMenuList.size(); i++) {
                action.moveToElement(menuPage.simpleMenuList.get(i)).build().perform();
                String color = menuPage.simpleMenuList.get(i).getCssValue("background-color");
                System.out.println(color);
        }

        //background-color ile assertion
        menuPage.simpleMenuList.get(0).click();
        String notEnableData = menuPage.simpleMenuList.get(0).getCssValue("background-color");
        System.out.println(notEnableData);
        menuPage.simpleMenuList.get(1).click();
        String enableData = menuPage.simpleMenuList.get(1).getCssValue("background-color");
        System.out.println(enableData);
        Assert.assertNotEquals(notEnableData, enableData);

        //attribute ile assertion
        ReusableMethods.waitFor(1);
        String notEnable = menuPage.simpleMenuList.get(0).getAttribute("class");
        System.out.println(notEnable);
        String enable = menuPage.simpleMenuList.get(5).getAttribute("class");
        System.out.println(enable);
        Assert.assertNotEquals(notEnable, enable);


    }

    @Test
    public void MenuWithSubMenu() {
        ReusableMethods.waitFor(1);
        action.sendKeys(Keys.PAGE_DOWN).perform();
        menuPage.menuLink.click();
        menuPage.menuWithSubMenuLink.click();
        Driver.getDriver().switchTo().frame(1);


       WebDriverWait wait=new WebDriverWait(Driver.getDriver(),10);
//
//        for (int i = 0; i < menuPage.MenuList.size(); i++) {
//            action.moveToElement(menuPage.MenuList.get(i)).build().perform();
//            wait.until(ExpectedConditions.visibilityOf(menuPage.MenuList.get(i)));
//            System.out.println(menuPage.MenuList.get(i).getText());
//            if(menuPage.MenuList.get(i).getAttribute("aria-haspopup").equals("true")){
//                action.moveToElement(menuPage.MenuList.get(i)).build().perform();
//                ReusableMethods.waitFor(2);
//                for (WebElement w:menuPage.subMenuList){
//                 //   action.moveToElement(w).build().perform();
//                    System.out.println(w.getText());
//                    //Assert.assertTrue(w.isDisplayed());
//                }
//
//            }


       // }

        /////////////////
        for (int i = 0; i < menuPage.ariaPopUpList.size(); i++) {
            action.moveToElement(menuPage.ariaPopUpList.get(i)).build().perform();
            System.out.println(menuPage.ariaPopUpList.get(i).getText());
                   for (WebElement w : menuPage.subMenuList) {
                       ReusableMethods.waitFor(2);
                       System.out.println(w.getText());
                      Assert.assertTrue(w.isDisplayed());
                   }



           }
        }

    }
