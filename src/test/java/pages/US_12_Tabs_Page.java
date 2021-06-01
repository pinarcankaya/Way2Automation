package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.ArrayList;
import java.util.List;

public class US_12_Tabs_Page {
    public US_12_Tabs_Page() {

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//h2[.='Tabs']")
    public WebElement tabsLink;

    @FindBy(xpath = "//li[contains(@class,'ui-state-default ui-corner-top')]")
    public List<WebElement> tabsMenus;

   @FindBy(xpath = "//p[contains(text(),'Proin elit arcu')]")
    public WebElement tab1text;

    @FindBy(xpath = "//p[contains(text(),'Morbi tincidunt')]")
    public WebElement tab2text;

    @FindBy(xpath = "//p[contains(text(),'Mauris eleifend')]")
    public WebElement tab3text;


    public List<WebElement> alltext() {
        List<WebElement> alltext = new ArrayList<>();
        alltext.add(tab1text);
        alltext.add(tab2text);
        alltext.add(tab3text);
        return alltext;
    }





}
