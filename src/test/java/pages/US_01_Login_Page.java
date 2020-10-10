package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US_01_Login_Page {
    public US_01_Login_Page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//a[.='Signin']")
    public WebElement signinButton;

    @FindBy(xpath = "(//input[@name='username'])[2]")
    public WebElement usernameTextBox;

    @FindBy(xpath = "(//input[@name='password'])[2]")
    public WebElement passwordTextBox;

    @FindBy(xpath = "(//input[@class='button'])[2]")
    public WebElement submitButton;


}
