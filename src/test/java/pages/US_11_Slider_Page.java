package pages;

import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US_11_Slider_Page {
    public US_11_Slider_Page() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
}
