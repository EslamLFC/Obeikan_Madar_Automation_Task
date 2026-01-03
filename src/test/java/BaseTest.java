import Pages.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import javax.swing.*;
import java.time.Duration;

public class BaseTest {
    WebDriver driver;
    WebDriverWait wait;
    Actions actions;
    JavascriptExecutor js;
    Select select;
    P01_LoginPage loginPage;
    P02_HomePage homepage;
    P03_VideoGamesPage videoGamesPage;
    P04_CartPage cartPage;
    P05_CheckoutPage checkoutPage;

    @BeforeClass
    public void Setup(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        actions = new Actions(driver);
        js = (JavascriptExecutor) driver;
        loginPage = new P01_LoginPage(driver);
        homepage = new P02_HomePage(driver);
        videoGamesPage = new P03_VideoGamesPage(driver);
        cartPage = new P04_CartPage(driver);
        checkoutPage = new P05_CheckoutPage(driver);
    }

    @AfterClass
    public void TearDown(){
//        driver.quit();
        System.out.println("Finished");
    }
}
