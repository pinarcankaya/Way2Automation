package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class US_05_DropDown_Page {
    public US_05_DropDown_Page() { PageFactory.initElements(Driver.getDriver(),this); }

     @FindBy(xpath = "(//a[.='ENTER TO THE TESTING WEBSITE'])[2]")
     public WebElement enterGiris;

    @FindBy(xpath ="//h2[.='Dropdown']" )
    public WebElement dropdownButton;

    @FindBy(xpath ="//select" )  //html/body/select
    public WebElement select;

    @FindBy(xpath ="//*[.='Enter Country']" )
    public WebElement enterCountry;

    @FindBy(xpath ="//input[@autocomplete='off']" )
    public WebElement enterbox;

    @FindBy(xpath ="//ul[@id='ui-id-1']/li" )
    public List<WebElement> acilanMenu;

    @FindBy(xpath ="//a[@role='button']" )
    public WebElement asagiButton;

    @FindBy(xpath ="//div[@class='ui-tooltip-content']" )
    public WebElement showAllItems;

    @FindBy(xpath = "//select[@id='combobox']")
    public WebElement selectEnterCountry;

}
