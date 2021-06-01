package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class US_13_ToolTip_Page {

    public US_13_ToolTip_Page() {

        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//h2[.='Tooltip']")
    public WebElement menuLink;


    @FindBy(xpath = "//a[.='Tooltips']")
    public WebElement tooltipAnimationLink;


    @FindBy(xpath = "//a[.='ThemeRoller']")
    public WebElement themeRollerAnimationLink;


    @FindBy(xpath = "//input[@id='age']")
    public WebElement ageTextBox;


    @FindBy(xpath = "//div[@class='ui-tooltip-content']")
    public WebElement toolTipsAnimationText;

    @FindBy(xpath = "//body/p/a")
    public List<WebElement>  allActionLinks;


    @FindBy(xpath = "//a[.='custom animation demo']")
    public WebElement customAnimationDemoLink;



}
