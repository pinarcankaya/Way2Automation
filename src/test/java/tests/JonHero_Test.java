package tests;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.JonHero_Page;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.concurrent.TimeUnit;

public class JonHero_Test {
    JonHero_Page jobpage = new JonHero_Page();
    Actions action = new Actions(Driver.getDriver());
    //-UA TEST ORNEK
    //www.jobhero.com sitesine gidiniz
    //resumes menusune tiklayiniz
    //resume builder linkine seciniz
    //build your resume butonuna tiklayiniz
    //create my resume butonuna tiklayiniz
    //experience level' a "0-3 years" secenegini seciniz
    //are you student sorusuna "no" seciniz
    //gelen sayfada 3 tane resume ornegi oldugunu dogrulayiniz


    @Test
    public void jobHero() {
        Driver.getDriver().get("https://www.jobhero.com/");
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // action.moveToElement(jobpage.resume);
        action.click(jobpage.resume).perform();
        ReusableMethods.waitFor(1);
        jobpage.resumeBuilder.click();
        jobpage.buildButton.click();
        jobpage.creatmyresume.click();
        ReusableMethods.waitFor(5);
        jobpage.experience.click();
        jobpage.studentQuestion.click();
        System.out.println(jobpage.resumeList.size());
        Assert.assertEquals(jobpage.resumeList.size(), 3);
    }
}
