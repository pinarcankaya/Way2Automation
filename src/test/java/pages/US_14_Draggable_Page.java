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
    public WebElement draggableMenu;
    @FindBy(xpath = "//a[@target='_self']")
    public List<WebElement> tabsList;
    @FindBy(xpath = "//div[@id='draggable']")
    public WebElement draggableMeAround;
    @FindBy(xpath = "(//div[@class='draggable ui-widget-content ui-draggable ui-draggable-handle'])[1]")
    public WebElement vertically;
    @FindBy(xpath = "(//div[@class='draggable ui-widget-content ui-draggable ui-draggable-handle'])[2]")
    public WebElement horizontally;
    @FindBy(xpath = "//span[@class='count']")
    public List<WebElement> eventAllInvoked;
    @FindBy(xpath = "//div[@id='draggable']")
    public WebElement eventDragBox;


}
