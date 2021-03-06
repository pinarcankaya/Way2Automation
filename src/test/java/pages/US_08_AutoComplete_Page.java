package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class US_08_AutoComplete_Page {

    public US_08_AutoComplete_Page() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//h2[.='Autocomplete']")
    public WebElement autoCompleteMenu;

    @FindBy(xpath = "//input[@class='ui-autocomplete-input']")
    public List<WebElement> autoInputList;   //3 farkli input da ayni locate'e sahip


    @FindBy(xpath = "//li[@class='ui-menu-item']")
    public List<WebElement> allTextResult;  //herhangi bir harf girdikten sonra cikan sonuclar//3 farkli input da ayni locate'e sahip

    @FindBy(xpath = "//a[.='Multiple Values']")
    public WebElement multipleValuesMenu;


    @FindBy(xpath = "//a[.='Categories']")
    public WebElement categoriesMenu;

    @FindBy(xpath = "//li[@class='ui-autocomplete-category']")
    public List<WebElement> categoriBasliklari;







}

