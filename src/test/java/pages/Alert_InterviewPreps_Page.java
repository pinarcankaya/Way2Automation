package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.ArrayList;
import java.util.List;

public class Alert_InterviewPreps_Page {

    public Alert_InterviewPreps_Page() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//a[.='ENTER TO THE TESTING WEBSITE'])[2]")
    public WebElement enterGiris;
    @FindBy(xpath = "//h2[.='Tooltip']")
    public WebElement toolTip;
    @FindBy(xpath = "//a[.='Tooltips']")
    public WebElement tollTipsLink;
    @FindBy(xpath = "//div[@class='ui-tooltip-content']")
    public WebElement toolTipsAlert;
    @FindBy(xpath = "//a[.='ThemeRoller']")
    public WebElement themeRoller;
    @FindBy(xpath = "//a[.='custom animation demo']")
    public WebElement custom;


}
