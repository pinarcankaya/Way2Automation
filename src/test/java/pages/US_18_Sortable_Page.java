package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class US_18_Sortable_Page {


    public US_18_Sortable_Page() {

        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//h2[.='Sortable']")
    public WebElement sortableMenu;

    @FindBy(xpath = "//li[@class='ui-state-default ui-sortable-handle']")
    public List<WebElement> defaultfonkList;


    @FindBy(xpath = "//a[.='Connect Lists']")
    public WebElement connectListMenu;


    @FindBy(xpath = "//ul[@id='sortable1']/li")
    public List<WebElement> connectListGriItemList;

    @FindBy(xpath = "//ul[@id='sortable2']/li")
    public List<WebElement> connectListSariItemList;


    @FindBy(xpath = "//ul[@id='sortable']/li")
    public List<WebElement> displayasGridItemList;


    @FindBy(xpath = "//a[.='Display as grid']")
    public WebElement displayasGridMenu;


    @FindBy(xpath = "//a[.='Portlets']")
    public WebElement porletsMenu;



    @FindBy(xpath = "//span[@class='ui-icon ui-icon-minusthick portlet-toggle']")
    public List<WebElement> porletsAcilirKapanirMenus;
}
