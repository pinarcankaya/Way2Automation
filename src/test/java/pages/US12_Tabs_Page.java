package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class US12_Tabs_Page {
    public US12_Tabs_Page() {

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//h2[.='Tabs']")
    public WebElement tabsLink;


    @FindBy(xpath = "//li[contains(@class,'ui-state-default ui-corner-top')]")
    public List<WebElement> tabsMenus;

   @FindBy(xpath = "//p[contains(text(),'Proin elit arcu')]")
    public WebElement tab1text;

}
