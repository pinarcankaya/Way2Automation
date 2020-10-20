package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class TC_003page {

    public TC_003page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//a[.='Registration']")
    public WebElement registrationHome;
    @FindBy(name = "name")
    public WebElement firstname;
    @FindBy(xpath = "(//input['@type=text'])[2]")
    public WebElement lastname;
    @FindBy(xpath = "(//input[@name='m_status'])[1]")
    public WebElement singlTextBox;
    @FindBy(xpath = "(//input[@name='m_status'])[2]")
    public WebElement mariedTextBox;
    @FindBy(xpath = "(//input[@name='m_status'])[3]")
    public WebElement divorcedTextBox;
    @FindBy(xpath = "(//input[@name='hobby'])[1]")
    public WebElement hobyDance;
    @FindBy(xpath = "(//input[@name='hobby'])[1]")
    public WebElement hobyReading;
    @FindBy(xpath = "(//input[@name='hobby'])[1]")
    public WebElement hobyCricket;
    @FindBy(xpath = "(//select)[1]")
    public WebElement countryBox;
    @FindBy(xpath = "(//select)[2]")
    public WebElement month;
    @FindBy(xpath = "(//select)[3]")
    public WebElement day;
    @FindBy(xpath = "(//select)[4]")
    public WebElement year;
    @FindBy(xpath = "//input[@type='file']")
    public WebElement cooseFile;
    @FindBy(name = "phone")
    public WebElement phoneNumber;
    @FindBy(name = "username")
    public WebElement usernameSecond;
    @FindBy(xpath = "//input[@name='email']")
    public WebElement email;
    @FindBy(xpath= "//textarea[@name='']")
    public WebElement aboutYourself;
    @FindBy(xpath = "//input[@name='password']")
    public WebElement password;
    @FindBy(name = "c_password")
    public WebElement confirmPassword;
    @FindBy(xpath = "//input['@value=submit']")
    public WebElement submitBottun;


}
