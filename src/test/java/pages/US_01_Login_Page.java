package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US_01_Login_Page {
    public US_01_Login_Page(){
        PageFactory.initElements(Driver.getDriver(),this);}


    @FindBy(xpath = "(//a[.='ENTER TO THE TESTING WEBSITE'])[2]")
    public WebElement enterGiris;
    @FindBy(xpath ="//h3[.='Dummy Registration Form']")
    public WebElement RegistrationFormText;
    @FindBy(xpath = "//h1[@class='heading']")
    public WebElement scriptsPlace;

}





