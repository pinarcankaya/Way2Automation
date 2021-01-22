package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US_01_Login_Page {
    public US_01_Login_Page(){
        PageFactory.initElements(Driver.getDriver(),this);}


    @FindBy(xpath ="//h3[.='Registration Form']")
    public WebElement RegistrationFormText;

    @FindBy(xpath ="//a[.='Home']")
    public WebElement homeText;

    @FindBy(xpath = "//a[.='Home']")
    public WebElement HomeText;

    @FindBy(xpath = "//a[.='Signin']")
    public WebElement signinButton;

    @FindBy(xpath = "(//input[@name='username'])[2]")
    public WebElement usernameTextBox;


    @FindBy(xpath = "(//input[@name='password'])[2]")
    public WebElement passwordTextBox;

    @FindBy(xpath = "(//input[@class='button'])[2]")
    public WebElement submitButton;

    @FindBy(xpath = "//p[@id='alert1']")
    public WebElement loginErrorMesaj;
}





