package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class US_16_Resizable_Page {

    public US_16_Resizable_Page() {

        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//h2[.='Resizable']")
    public WebElement resizable;

    @FindBy(xpath = "//div[@class='ui-resizable-handle ui-resizable-se ui-icon ui-icon-gripsmall-diagonal-se']")
    public List<WebElement> resiableBox;

    @FindBy(xpath = "//div[@id='resizable']")
    public List<WebElement> resizable2;

    @FindBy(xpath = "//a[.='Animate']")
    public  WebElement animateBox;


}
