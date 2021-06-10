package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class US_15_Droppable_Page {

    public US_15_Droppable_Page() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//h2[.='Droppable']")
    public WebElement droppableMenu;

    @FindBy(xpath = "//a[@target='_self']")
    public List<WebElement> tabsList;

    @FindBy(xpath = "//div[contains(@id,'draggable')]")
    public List<WebElement> draggableList;

    @FindBy(xpath = "//div[contains(@id,'droppable')]")
    public List<WebElement> droppableList;

    @FindBy(xpath = "//h2[contains(@id,'ui-id-')]")
    public List<WebElement> productsList;



}
