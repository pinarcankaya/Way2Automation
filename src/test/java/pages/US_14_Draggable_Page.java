package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class US_14_Draggable_Page {

    public US_14_Draggable_Page() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//h2[.='Draggable']")
    public WebElement draggableMenuLink;


    @FindBy(xpath = "//div[@id='draggable']")
    public WebElement dragMeBox;

    @FindBy(xpath = "//div[contains(@id,'draggable')]")
    public List<WebElement> dragMeBoxList;


    @FindBy(xpath = "//ul[@class='responsive-tabs']/li")
    public List<WebElement> allDraggableMenuTabList;


    @FindBy(xpath = "//div[@class='draggable ui-widget-content ui-draggable ui-draggable-handle']")
    public List<WebElement> constrainMovementDrabBoxs;

    @FindBy(xpath = "//span[@class='count']")
    public List<WebElement> eventAllInvoked;

    @FindBy(xpath = "//li[@id='draggable']")
    public WebElement   dragMeButton;

    @FindBy(xpath = "//li[contains(text(),'Item')]")
    public List<WebElement> itemList;

    @FindBy(xpath = "//li[.='Drag me down']")
    public List<WebElement> dragMeDownButtonList;

}
