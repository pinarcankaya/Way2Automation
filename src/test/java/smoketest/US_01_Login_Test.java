package smoketest;


import org.testng.Assert;
import org.testng.annotations.*;
import pages.US_01_Login_Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.util.concurrent.TimeUnit;

public class US_01_Login_Test {

    US_01_Login_Page us01LoginPage = new US_01_Login_Page();

    @BeforeClass
    public void setup() {
        Driver.getDriver().get(ConfigReader.getProperty("way2Automation_url"));
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.MINUTES);
        ReusableMethods.waitFor(5);
    }

    @Test
    public void TC_001() {
        //1)musteri http://way2automation.com/way2auto_jquery/index.php web sayfasina girebiliyor olmali
        System.out.println(us01LoginPage.RegistrationFormText.getText());
        Assert.assertTrue(us01LoginPage.RegistrationFormText.isDisplayed());
    }

    @Test
    public void TC_02() {
        //2) ENTER TO THE TESTING WEBSIDE ile giris yapilabiliyor olmali
        us01LoginPage.enterGiris.click();
        System.out.println(us01LoginPage.scriptsPlace.getText());
        Assert.assertTrue(us01LoginPage.scriptsPlace.isDisplayed());
    }
    @AfterClass
    public void cloes(){
        Driver.closeDriver();
    }
}

