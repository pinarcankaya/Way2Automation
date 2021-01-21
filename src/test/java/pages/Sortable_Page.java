package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class Sortable_Page {
    public Sortable_Page() {

        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//h2[.='Sortable']")
    public WebElement sortable;

    @FindBy(xpath = "//li[@class='ui-state-default ui-sortable-handle']")
    public List<WebElement> defaultfonkList;
}
