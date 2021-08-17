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

    @FindBy(xpath = "//h2[.='Frames and Windows']")
    public WebElement framesUndWindowsMenu;

    @FindBy(xpath = "//a[@target='_self']")  ////a[contains(@href,'#example-1')]
    public List<WebElement> tabs;

    @FindBy(xpath = "//html")
    public  WebElement newWindowTab;

    @FindBy(xpath = "//iframe[@class='demo-frame']")

    public WebElement firstFrame;

    @FindBy(xpath = "//div[@class='farme_window']/p/a")
    public List<WebElement> openLinkList;

    @FindBy(xpath = "//a[.='Open New Seprate Window']")
    public WebElement openMenu2;



}
