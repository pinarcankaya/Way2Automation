package tests;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;
import utilities.Driver;

import java.io.File;
import java.io.IOException;

public class ScreenShot {


    @Test
    public void test01(){

        Driver.getDriver().get("http://way2automation.com/way2auto_jquery/index.php");

        screenShot();
    }
    @Test
    public void screenShot(){
        //Hamza hocanin notlarindan methoda parametre verip  screenshot alamak istedigimiz yerde method adinida yazabiliriz

        TakesScreenshot takesScreenshot= (TakesScreenshot) Driver.getDriver();
        File source= takesScreenshot.getScreenshotAs(OutputType.FILE);

        File image= new File(System.getProperty("user.dir")+"/image.png");

        try {
            FileUtils.copyFile(source,image);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
