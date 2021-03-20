package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class DropDown_Page {


    public DropDown_Page(){
        PageFactory.initElements(Driver.getDriver(),this);}


    @FindBy(xpath = "(//a[.='Select Dropdown List'])[2]")
    public WebElement selectDropDownLink;

    //option[@value='Sunday']
    @FindBy(xpath = "//select[@id='select-demo']")
    public WebElement selectDayDropDown;

   @FindBy(xpath = "//option[contains(text(),'day')]")
    public List<WebElement> dayList;


    @FindBy(xpath = "//p[@class='selected-value']")
    public WebElement  friday;

    @FindBy(xpath = "//p[contains(text(),'Day selected :')]")
    public WebElement  isFriday;


    @FindBy(xpath = "//select[@id='multi-select']")
    public WebElement  multiSelect;


    @FindBy(xpath = "//button[.='First Selected']")
    public WebElement  firstSelectedButton;

    @FindBy(xpath = "//p[contains(text(),'First selected option is :')]")
    public WebElement  firstSelectedText;



    @FindBy(xpath = "//select[@id='multi-select']/option")
    public List<WebElement>  allCityList;

    @FindBy(xpath = "//button[.='Get All Selected']")
    public WebElement getAllSelectedButton;


    @FindBy(xpath = "//p[contains(text(),'Options selected are :')]")
    public WebElement getAllOption;

}
