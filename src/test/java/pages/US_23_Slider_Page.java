package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US_23_Slider_Page {
    public US_23_Slider_Page() {

        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//h2[.='Slider']")
    public WebElement sliderLink;

    @FindBy(xpath = "//span[@class='ui-slider-handle ui-state-default ui-corner-all']")
    public WebElement sliderButton;
}
