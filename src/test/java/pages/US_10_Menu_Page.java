package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class US_10_Menu_Page {

    public US_10_Menu_Page() {

        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//h2[.='Menu']")
    public WebElement menuLink;

    @FindBy(xpath = "//ul[@class='responsive-tabs']/li")  ////*[contains(@href,'#example-1-tab-')]
    public List<WebElement> allMenuList;

    @FindBy(xpath = "//ul[@id='menu']//li")
    public List<WebElement> simpleMenuList;


    @FindBy(xpath = "//li[@aria-disabled='true']")
    public List<WebElement>  displayMenu;  //2 tane display menu var//aktif olmayan element

    @FindBy(xpath = "//a[.='Menu With Sub Menu']")
    public  WebElement menuWithSubMenuLink;

    @FindBy(xpath = "//li[@class='ui-menu-item']")
    public List<WebElement> MenuList;

    @FindBy(xpath = "//li[@aria-haspopup='true']")  //3 tane acilir menu
    public List<WebElement> ariaPopUpList;

    @FindBy(xpath = "//li[contains(text(),'Sub Menu')]")
    public List<WebElement> subMenuList;


    @FindBy(xpath = "//a[.='Select Menu']")
    public  WebElement selectMenu;


    @FindBy(xpath = "//img[@src='../images/popup_pic.gif']")
    public  WebElement selectMenuImage;

}
