package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;


public class US_02_Alert_Page {
    public US_02_Alert_Page() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//h2[.='Alert']")
    public WebElement alertMenu;
    @FindBy(xpath = "//h1[@class='heading']")
    public WebElement alertHeader;
    @FindBy(xpath = "//button[.='Click the button to display an alert box:']")
    public WebElement simpleAlert;
    @FindBy(xpath = "(//a[contains(@href,'#example')])[2]")
    public WebElement inputMenu;
    @FindBy(xpath = "//p[.='Hello Harry Potter! How are you today?']")
    public WebElement haryPotreText;
    @FindBy(xpath = "//button[.='Click the button to demonstrate the Input box.']")
    public WebElement inputClickButton;

}
