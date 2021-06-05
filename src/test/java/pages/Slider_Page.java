package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class Slider_Page {

    public Slider_Page() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//h2[.='Slider']")
    public WebElement sliderLink;

    @FindBy(xpath = "//span[@class='ui-slider-handle ui-state-default ui-corner-all']")
    public WebElement sliderButton;


    @FindBy(xpath = "//input[@id='amount']")
    public WebElement numberOfBeddooms;



    @FindBy(xpath = "//img[@src='images/slider.jpg']")
    public WebElement sliderImg;


    @FindBy(xpath = "//span[@style='left: 55.5556%;']")
    public WebElement sliderTarget;
}
