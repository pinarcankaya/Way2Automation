package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US_05_Dropdown_Page {

    public US_05_Dropdown_Page(){

        PageFactory.initElements(Driver.getDriver(),this);

    }

    @FindBy(xpath = " //a[.='Dynamic Elements']")
    public WebElement dynamicElements;

    @FindBy(xpath = "//a[.='Dropdown']")
    public WebElement dropdownMenu;

    @FindBy(xpath = "//a[.='Select Country']")
    public WebElement selectCauntry;

    @FindBy(xpath = "//select")
    public WebElement pleaseSelect;

    @FindBy(xpath = "//a[.='Enter Country']")
    public WebElement enterCauntry;

    @FindBy(tagName = "//input")
    public WebElement enterTextBox;

    @FindBy(xpath = "(//iframe)[1]")
    public WebElement iframe1;




}
