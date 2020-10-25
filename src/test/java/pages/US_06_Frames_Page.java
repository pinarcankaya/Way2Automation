package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class US_06_Frames_Page {

    public US_06_Frames_Page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//a[.='Frames and Windows']")
    public WebElement framesMenu;


    @FindBy(xpath = "//a[@target='_self']")
    public List<WebElement> framesList;

    @FindBy(xpath = "//a[.='New Browser Tab']")
    public  WebElement newWindow;

    @FindBy(xpath = "//iframe[@class='demo-frame']")
    public WebElement firstFrame;

    @FindBy(xpath = "//a[.='Open Seprate New Window']")
    public WebElement openMenu;

    @FindBy(xpath = "//a[.='Open New Seprate Window']")
    public WebElement openMenu2;


}
