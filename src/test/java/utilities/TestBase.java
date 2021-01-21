package utilities;

//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import pages.US_01_Login_Page;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestBase {
//    public ExtentReports extentReports;
//    public ExtentTest extentTest;
//    public ExtentHtmlReporter extentHtmlReporter;

    protected US_01_Login_Page us01Page;
    protected Actions actions;
    protected WebDriverWait wait;

    @BeforeMethod
    public void setup() {
        Driver.getDriver().get(ConfigReader.getProperty("way2Automation_url"));
        us01Page = new US_01_Login_Page();
        actions = new Actions(Driver.getDriver());
        wait = new WebDriverWait(Driver.getDriver(),20);
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


    }





//    @BeforeTest
//    public void setUpTest(){
//        extentReports = new ExtentReports();// ExtentReports objesi üretelim
//        String filePath = System.getProperty("user.dir") + "/reports/myprojectreport.html";// rapor için adresi belirleyelim.
//        extentHtmlReporter = new ExtentHtmlReporter(filePath);//extenthtmlreporter objesi üretelim
//        extentReports.attachReporter(extentHtmlReporter);//extentHtmlReporter objesini extentReports objesinin içine ekleyelim
//        //Rapor ile ilgili bilgileri artık buraya ekleyebiliriz
//        extentReports.setSystemInfo("Environment", "Environment İsim");
//        extentReports.setSystemInfo("Browser", ConfigReader.getProperty("browser"));
//        extentReports.setSystemInfo("Automation Engineer", "Girls Team");
//        extentHtmlReporter.config().setDocumentTitle("way2Automation Reports");
//        extentHtmlReporter.config().setReportName("way2Automation Reports");
//    }
//    @AfterTest
//    public void tearDownTest(){
//        extentReports.flush();
//    }
//    @AfterMethod
//    public void tearDownMethod(ITestResult result) throws IOException {
//        if (result.getStatus() == ITestResult.FAILURE) {//When test case fails, then take the screenshot and attached the report
//            String screenshotLocation = ReusableMethods.getScreenshot(result.getName());//getScreenshot is coming from ReusableMethods
//            extentTest.fail(result.getName());
//            extentTest.addScreenCaptureFromPath(screenshotLocation);//adding the screenshot to the report
//            extentTest.fail(result.getThrowable());
//        } else if (result.getStatus() == ITestResult.SKIP) {
//            extentTest.skip("Test Case is skipped: " + result.getName());
//        }
   // }
}
