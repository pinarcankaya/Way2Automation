package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class US_19_Accordion_Page {
    public US_19_Accordion_Page() {

        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//h2[.='Accordion']")
    public WebElement accordionMenu;



    @FindBy(xpath = "//a[.='Customize icons']")
    public WebElement customizeIcons;

    @FindBy(xpath = "//h3[contains(text(),'Section ')]")
    public List<WebElement> selectionList;

    @FindBy(xpath = "//p[contains(text(),'Sed non urna')]")
    public WebElement selection2Text;

    @FindBy(xpath = "//p[contains(text(),'Mauris mauris ante')]")
    public WebElement selection1Text;


    @FindBy(xpath = "//a[.='Fill Space']")
    public WebElement fillspace;

    @FindBy(xpath ="//div[@class='ui-resizable-handle ui-resizable-se ui-icon ui-icon-gripsmall-diagonal-se']")
    public WebElement fillSpaceResiable;



}
