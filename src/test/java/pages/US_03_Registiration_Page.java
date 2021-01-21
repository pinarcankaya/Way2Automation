package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import utilities.Driver;

public class US_03_Registiration_Page {
    public US_03_Registiration_Page() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//a[.='Registration']")
    public WebElement registrationMenu;

    @FindBy(xpath = "//input[@name='name']")
    public WebElement firstname;

    @FindBy(xpath = "(//input[@type='text'])[2]")
    public WebElement lastname;

    @FindBy(xpath = "(//input[@type='radio'])[2]")
    public WebElement radioButton;

    @FindBy(xpath = "(//input[@type='checkbox'])[3]")
    public WebElement checkBox;

    @FindBy(xpath = "(//select)[1]")
    public WebElement countryDropDown;

    @FindBy(xpath = "(//select)[2]")
    public WebElement monthyDropDown;

    @FindBy(xpath = "(//select)[3]")
    public WebElement dayDropDown;

    @FindBy(xpath = "(//select)[4]")
    public WebElement yearDropDown;

    @FindBy(xpath = "//input[@name='phone']")
    public WebElement phoneTextBox;

    @FindBy(xpath = "//input[@name='username']")
    public WebElement usernameTextBox;

    @FindBy(xpath = "//input[@name='email']")
    public WebElement emailTextBox;

    @FindBy(xpath = "//input[@type='file']")
    public WebElement chooseFileButton;

    @FindBy(xpath = "//textarea[@name='']")
    public WebElement aboutYourselfBox;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement passwordTextBox;

    @FindBy(xpath = "//input[@name='c_password']")
    public WebElement confirimPasswordBox;

    @FindBy(xpath = "//input[@value='submit']")
    public WebElement submitButton;

}
