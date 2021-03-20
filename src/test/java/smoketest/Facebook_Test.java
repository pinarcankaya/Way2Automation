package smoketest;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.Facebook_Page;
import utilities.Driver;

import java.util.concurrent.TimeUnit;

public class Facebook_Test {


    Facebook_Page facebookPage = new Facebook_Page();
    WebDriverWait wait=new WebDriverWait(Driver.getDriver(),5);

    @BeforeClass
    public void setup() {
        Driver.getDriver().get("https://www.facebook.com/");
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        facebookPage.acceptAllButton.click();
    }


    @Test
    public void T01 (){
        wait.until(ExpectedConditions.visibilityOf(facebookPage.createNewAccountButton));
        facebookPage.createNewAccountButton.click();
        facebookPage.firstNameTextBox.sendKeys("Betul");
        wait.until(ExpectedConditions.visibilityOf(facebookPage.signUpButton));
        facebookPage.signUpButton.click();

        wait.until(ExpectedConditions.visibilityOf(facebookPage.mobilorEmailTextBox));
        String mobileNumbercolor=facebookPage.mobilorEmailTextBox.getCssValue("border-color");
        System.out.println("Mobile border color : " + mobileNumbercolor);

        String  passwordColor=facebookPage.passwordTextBox.getCssValue("border-color");
        System.out.println("Password border color : " + mobileNumbercolor);

        Assert.assertEquals(mobileNumbercolor,"rgb(255, 0, 0)");
        Assert.assertEquals(passwordColor,"rgb(255, 0, 0)");

        Driver.getDriver().navigate().refresh();

        //burdaki assertler artirilabilir diger text box'lar icin..// ben sadece ikisi icin yaptim
        //bos birakilan alanlar kirmizi oldu//PASS
    }


    @Test
    public void TC02() {
        wait.until(ExpectedConditions.visibilityOf(facebookPage.createNewAccountButton));
        facebookPage.createNewAccountButton.click();
        facebookPage.firstNameTextBox.sendKeys("Betul");
        facebookPage.lastNameTextBox.sendKeys("nonexistendwomen");
        facebookPage.mobilorEmailTextBox.sendKeys("nonexistendwomen@gmail.com");
        facebookPage.reEnterEmailTextBox.sendKeys("nonexistendwomen@gmail.com");
        facebookPage.passwordTextBox.sendKeys("986532");

        Select month=new Select(facebookPage.month);
        month.selectByVisibleText("Oct");

        Select day=new Select(facebookPage.day);
        day.selectByIndex(11);

        Select year=new Select(facebookPage.year);
        year.selectByVisibleText("1999");
        facebookPage.genderRadioButton.click();
        facebookPage.signUpButton.click();

        //Assert.assertTrue(facebookPage.registrationVerification.isDisplayed());

        Driver.getDriver().navigate().refresh();

        //Harf icermediginde kirmizi uyari vermeli
        //sadece sayilardan olusan sifre kabul edildi//FAIL
    }


    @Test
    public void TC03() {
        wait.until(ExpectedConditions.visibilityOf(facebookPage.createNewAccountButton));
        facebookPage.createNewAccountButton.click();
        facebookPage.firstNameTextBox.sendKeys("?");
        facebookPage.lastNameTextBox.sendKeys("nonexistendwomen");
        facebookPage.mobilorEmailTextBox.sendKeys("nonexistendwomen@gmail.com");
        facebookPage.reEnterEmailTextBox.sendKeys("nonexistendwomen@gmail.com");
        facebookPage.passwordTextBox.sendKeys("986532abC");

        Select month = new Select(facebookPage.month);
        month.selectByVisibleText("Oct");

        Select day = new Select(facebookPage.day);
        day.selectByIndex(11);

        Select year = new Select(facebookPage.year);
        year.selectByVisibleText("1999");
        facebookPage.genderRadioButton.click();
        facebookPage.signUpButton.click();

       // Assert.assertTrue(facebookPage.invalidCharacter.isDisplayed());

        Driver.getDriver().navigate().refresh();

        //isim kismina sayi veya karakter girildiginde uyari mesaji goruntulendi//FAIL

    }
    @Test
    public void TC04() {
        wait.until(ExpectedConditions.visibilityOf(facebookPage.createNewAccountButton));
        facebookPage.createNewAccountButton.click();
        facebookPage.firstNameTextBox.sendKeys("Betul");
        facebookPage.lastNameTextBox.sendKeys("Egeli");
        facebookPage.mobilorEmailTextBox.sendKeys("nonexistendwomen@gmail.com");
        facebookPage.reEnterEmailTextBox.sendKeys("nonexistendwomen@gmail.com");
        facebookPage.passwordTextBox.sendKeys("986532abC");

        Select month = new Select(facebookPage.month);
        month.selectByVisibleText("Oct");
        System.out.println(facebookPage.month.getText());
        Select day = new Select(facebookPage.day);
        day.selectByIndex(11);

        Select year = new Select(facebookPage.year);
        year.selectByVisibleText("1999");
        facebookPage.genderRadioButton.click();
        facebookPage.signUpButton.click();

        //Assert.assertTrue(facebookPage.registrationVerification.isDisplayed());

        Driver.getDriver().navigate().refresh();

        //ayni email ve sifre ile birden fazla hesap acildi//FAIL



}
}