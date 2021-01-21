package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class JonHero_Page {


    public JonHero_Page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//span[@class='jh-arrow']")
    public WebElement resume;

    //a[@href='/resume/builder']
    @FindBy(xpath = "//a[@href='/resume/builder']")
    public WebElement resumeBuilder;


    @FindBy(xpath = "//div[.='Build Your Resume']")
    public WebElement buildButton;


    @FindBy(xpath = "//a[@class='btn btn-primary']")
    public WebElement creatmyresume;

    @FindBy(xpath = "//button[@value='0-3 Years']")
    public WebElement experience;

    @FindBy(xpath = "//button[.='No']")
    public WebElement studentQuestion;

    @FindBy(xpath = "//div[@class='card-img-overlay']")
    public List<WebElement> resumeList;

}
