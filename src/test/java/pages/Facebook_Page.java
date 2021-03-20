package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class Facebook_Page {


    public Facebook_Page(){
        PageFactory.initElements(Driver.getDriver(),this);}


    @FindBy(xpath = "//button[.='Accept All']")
    public WebElement  acceptAllButton;

    @FindBy(xpath = "//a[.='Create New Account']")
    public WebElement createNewAccountButton;


    @FindBy(xpath = "//input[@name='firstname']")
    public WebElement firstNameTextBox;

    @FindBy(xpath = "//input[@name='lastname']")
    public WebElement lastNameTextBox;

    @FindBy(xpath = "//input[@name='reg_email__']")
    public WebElement mobilorEmailTextBox;


    @FindBy(xpath = "//input[@name='reg_email_confirmation__']")
    public WebElement reEnterEmailTextBox;

    @FindBy(xpath = "//input[@name='reg_passwd__']")
    public WebElement passwordTextBox;

    @FindBy(xpath = "//select[@name='birthday_month']")
    public WebElement month;

    @FindBy(xpath = "//select[@id='day']")
    public WebElement  day;

    @FindBy(xpath = "//select[@id='year']")
    public WebElement year;

    @FindBy(xpath = "//label[.='Female']")
    public WebElement genderRadioButton;

    @FindBy(xpath = "//button[.='Sign Up']")
    public WebElement  signUpButton;

    @FindBy(xpath = "//div[contains(text(),'This name contains certain characters')]")
    public WebElement invalidCharacter;

    @FindBy(xpath = "(//h2[.='Enter the code from your email'])[2]")
    public WebElement registrationVerification;



}
