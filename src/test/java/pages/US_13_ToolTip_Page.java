package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.nio.file.WatchEvent;
import java.util.List;
import java.util.WeakHashMap;

public class US_13_ToolTip_Page {
    public US_13_ToolTip_Page() { PageFactory.initElements(Driver.getDriver(),this); }

    @FindBy(xpath = "//h2[.='Tooltip']")
    public WebElement toolTip;

    @FindBy(xpath = "//a[.='Tooltips']")
    public WebElement tollTipsLink;

    @FindBy(xpath = "//div[@role='tooltip']")
    public WebElement yazi;

    @FindBy(xpath = "//a[.='ThemeRoller']")
    public WebElement themeRoller;

    @FindBy(xpath = "//input[@id='age']")
    public WebElement yourAge;

    @FindBy(xpath = "//a[.='custom animation demo']")
    public WebElement custom;

    @FindBy(xpath = "//body/p/a")
    public List<WebElement> allActionLinks;

    @FindBy(xpath = "//iframe")
    public List<WebElement> frame;


}
