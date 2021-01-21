package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class US_05_DropDown_Page {
    public US_05_DropDown_Page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//a[.='Dynamic Elements']")
    public WebElement dynamicElementMenu;

    @FindBy(xpath = "//a[.='Dropdown']")
    public WebElement dropDownMenu;


    @FindBy(xpath = "//select")
    public WebElement selectCountryDropDown;

//    @FindBy(xpath = "//option[.='Please Select']")
//    public  WebElement optionMenu;.


    @FindBy(xpath = "//a[.='Enter Country']")
    public WebElement enterCountry;

    @FindBy(xpath = "//input[@autocomplete='off']")
    public WebElement enterCountryTextBox;

    @FindBy(xpath = "//div[@role='log']/div")
    public WebElement hataMesaji;

    @FindBy(xpath = "//span[@class='ui-button-icon-primary ui-icon ui-icon-triangle-1-s']")
    public  WebElement okMenu;

    @FindBy(xpath = "//div[.='Show All Items']")
    public WebElement showAllItems;

    @FindBy(xpath = "//li[@tabindex='-1']")
    public List<WebElement> ikiulke;


}
