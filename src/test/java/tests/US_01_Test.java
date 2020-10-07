package tests;

import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class US_01_Test {

    @Test
    public void TC_001() {
        //deneme testi
        Driver.getDriver().get(ConfigReader.getProperty("way2Automation_url"));
    }
}
