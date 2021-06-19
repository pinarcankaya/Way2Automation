package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class US_17_Selectable_Page {

    public US_17_Selectable_Page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//h2[.='Selectable']")
    public WebElement selectableMenu;
    @FindBy(xpath = "//a[@target='_self']")
    public List<WebElement> tabsList;
    @FindBy(xpath = "//li[contains(@class,'ui-widget-content ui')]")
    public List<WebElement> itemList;
    @FindBy(xpath = "//li[contains(@class,'ui-state-default')]")
    public List<WebElement> displaySelectList;
    @FindBy(xpath = "//span[contains(text(),'#')]")
    public WebElement serializeText;
}
