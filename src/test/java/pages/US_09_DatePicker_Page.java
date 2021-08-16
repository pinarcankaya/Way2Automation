package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class US_09_DatePicker_Page {

    public US_09_DatePicker_Page() {

        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//h2[.='Datepicker']")
    public WebElement datapickerMenu;


    @FindBy(xpath = "//*[@id='datepicker']")
    public List<WebElement> dataInputList;


    @FindBy(xpath = "//div[@class='ui-datepicker-title']")
    public WebElement dateTitle;


    @FindBy(xpath = "//td[@data-event='click']")
    public WebElement  dateClick;



    @FindBy(xpath = "//a[.='Animations']")
    public WebElement animationMenu;

    @FindBy(xpath = "//select[@id='anim']")
    public WebElement animationDropDown;


    @FindBy(xpath = "//a[.='Display month & year']")
    public WebElement displayMonthYearMenu;

    @FindBy(xpath = "//a[.='Default functionality']")
    public WebElement defauldMenu;

    @FindBy(xpath = "//select[@class='ui-datepicker-month']")
    public WebElement monthDropDown;


    @FindBy(xpath = "//select[@class='ui-datepicker-year']")
    public WebElement yearDropDown;

    @FindBy(xpath = "//a[.='Format date']")
    public WebElement formatDateMenu;


    @FindBy(xpath = "//select[@id='format']")
    public WebElement formatDropDown;



}
