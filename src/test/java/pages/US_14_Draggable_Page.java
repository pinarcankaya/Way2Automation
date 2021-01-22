package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US_14_Draggable_Page {
    public US_14_Draggable_Page() {

        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//h2[.='Draggable']")
    public WebElement draggableLink;

    @FindBy(xpath = "//h3[.='Registration Form']")
    public WebElement RegistrationFormText;

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
    public  WebElement loginErrorMesaj;

    ////
    @FindBy(xpath = "//div[@id='draggable']")
    public WebElement dragbox;


    @FindBy(xpath = "//p[.='I can be dragged only vertically']")
    public WebElement verticalBox;


    @FindBy(xpath = "//a[.='Constrain movement']")
    public WebElement constrain;

    @FindBy(xpath = "//a[.='Cursor style' ]")
    public  WebElement cursorStyleTab;


    @FindBy(xpath = "//p[.='I will always stick to the center (relative to the mouse)']")
    public  WebElement cursorBox1;

    @FindBy(xpath = "//p[.='My cursor is at left -5 and top -5']")
    public WebElement  cursorBox2;
    //p[.='My cursor is at left -5 and top -5']
}
