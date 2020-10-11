package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class US_02_Alert_Page {
    public  US_02_Alert_Page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//a[.='Alert']")
    public WebElement alertMenu;


    @FindBy(xpath = "//a[.='Simple Alert']")
    public WebElement simpleAlertBaslik;

    @FindBy(xpath = "//button[.='Click the button to display an alert box:']")
    public WebElement simpleAlertButton;   ///alerti acan buton


    @FindBy(xpath = "//ul[@id='toggleNav']/li")
    public List<WebElement> alertKutu;

    @FindBy(xpath = "//iframe[@class='demo-frame']")
    public WebElement frame;


}
