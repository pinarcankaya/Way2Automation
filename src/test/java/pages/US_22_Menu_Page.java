package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class US_22_Menu_Page {

    public US_22_Menu_Page() {

        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//h2[.='Menu']")
    public WebElement menuLink;

    @FindBy(xpath = "//ul[@id='menu']//li")
    public List<WebElement> simpleMenuList;

    @FindBy(xpath = "//a[.='Menu With Sub Menu']")
    public  WebElement menuWithSubMenuLink;

    @FindBy(xpath = "//li[@class='ui-menu-item']")
    public List<WebElement> MenuList;

    @FindBy(xpath = "//li[@aria-haspopup='true']")
    public List<WebElement> ariaPopUpList;

    @FindBy(xpath = "//li[contains(text(),'Sub Menu')]")
    public List<WebElement> subMenuList;

}
