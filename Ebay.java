import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Ebay {

    WebDriver driver;

    @BeforeMethod
    public void openEbayPage() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.ebay.com/");
        Thread.sleep(3000);

    }

    @Test
    public void  ebayTest() throws InterruptedException {


        //Click Electronics
        WebElement clickElectronics = driver.findElement(By.xpath("//li[@data-currenttabindex='0']"));
        clickElectronics.click();
        Thread.sleep(3000);


        //Click Cell Phones & Accessories
        WebElement goCellPhonesAndAccessories = driver.findElement(By.linkText("Cell Phones & Accessories"));
        goCellPhonesAndAccessories.click();
        Thread.sleep(3000);


        //Click See All
        WebElement clickSeeAll = driver.findElement(By.linkText("See All"));
        clickSeeAll.click();
        Thread.sleep(3000);


        //Select the Phone
        WebElement selectPhone = driver.findElement(By.xpath("//img[@alt='Samsung Galaxy S22 Ultra - 128 GB - Burgundy (Unlocked)']"));
        selectPhone.click();
        Thread.sleep(3000);


        //Click button Add to cart
        WebElement clickButton = driver.findElement(By.xpath("//a[@id='atcBtn_btn_1']"));
        clickButton.click();
        Thread.sleep(3000);

        //Sign in to google account
        WebElement clickSignIn = driver.findElement(By.xpath("//button[@data-test-id='SIGN_IN']"));
        clickSignIn.click();
        Thread.sleep(3000);

        //Create account
        WebElement clickCreateAccount = driver.findElement(By.linkText("Create account"));
        clickCreateAccount.click();
        Thread.sleep(3000);

        // Type my first name
        driver.findElement(By.id("firstname")).sendKeys("Ishini ");
        Thread.sleep(3000);

        // Type my last name
        driver.findElement(By.id("lastname")).sendKeys("Dulanjali ");
        Thread.sleep(3000);

        // Type my email
        driver.findElement(By.id("Email")).sendKeys("Ishini25@gmail.com ");
        Thread.sleep(3000);

        // Type my password
        driver.findElement(By.id("password")).sendKeys("Ishini123# ");
        Thread.sleep(3000);

    }
}
