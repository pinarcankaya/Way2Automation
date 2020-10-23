package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class US_04_Submit_Page {
    public US_04_Submit_Page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//a[.='Dynamic Elements']")
    public WebElement dynamicElementMenu;


    @FindBy(xpath = "//a[.='Submit Button Clicked']")
    public WebElement submitButton;

    @FindBy(xpath = "//ul[@class='responsive-tabs']/li")
    public List<WebElement> submitMenuList;


    @FindBy(xpath = "//input[@type='text']")
    public WebElement startWithTextBox;

    @FindBy(xpath= "//input[@name='submit']")
    public WebElement stasrtWithsubmitButton;

    @FindBy(xpath = "//iframe[@class='demo-frame']")
    public WebElement firstFrame;
}
