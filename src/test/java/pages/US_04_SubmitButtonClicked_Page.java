package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class US_04_SubmitButtonClicked_Page {
    public US_04_SubmitButtonClicked_Page() {
        PageFactory.initElements(Driver.getDriver(), this);

    }
    @FindBy(xpath = "(//a[.='ENTER TO THE TESTING WEBSITE'])[2]")
    public WebElement enterGiris;

    @FindBy(xpath = "//a[.='Dynamic Elements']")
    public WebElement dynamicElements;

    @FindBy(xpath = "//h2[.='Submit Button Clicked']")
    public WebElement submitButtonMenu;

    @FindBy(xpath = "//ul[@class='responsive-tabs']/li")
    public List<WebElement> tabList;

    //@FindBy(xpath = "//a[@target='_self']")
    //public List<WebElement> submitButtonList2;

    @FindBy(xpath = "//input[@type='text']")
    public WebElement startsWithTestBox;

    @FindBy(xpath= "//input[@name='submit']")
    public WebElement startsWithsubmitButton;

  @FindBy(xpath = "//a[.='Ends With']")
    public WebElement endsWith;

  @FindBy(xpath = "//a[.='Complete id Dynamic']")
    public WebElement completeIdDynamic;
}


