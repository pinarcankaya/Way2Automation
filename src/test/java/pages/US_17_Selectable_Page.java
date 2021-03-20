package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class US_17_Selectable_Page {

    public US_17_Selectable_Page() {

        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//h2[.='Selectable']")
    public WebElement selectablelink;

    @FindBy(xpath = "//li[contains(text(),'Item ')]")///////*[contains(text(),'Item')]
    public List<WebElement> itemList;

    @FindBy(xpath = "//a[.='Display as grid']")
    public WebElement display;

    @FindBy(xpath = "//ol[@id='selectable']/li")
    public  List<WebElement> displayList;


    @FindBy(xpath = "//a[.='Serialize']")
    public WebElement serialize;

    @FindBy(xpath = "//li[contains(text(),'Item ')]")///////*[contains(text(),'Item')]
    public List<WebElement> serializeList;

    @FindBy(xpath = "//span[contains(text(),'#')]")
    public WebElement num;



}


