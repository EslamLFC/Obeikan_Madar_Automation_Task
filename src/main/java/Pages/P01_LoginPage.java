package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class P01_LoginPage {
    // Constructor
    WebDriver driver;
    public P01_LoginPage(WebDriver driver){
        this.driver = driver;
    }

    // Locators
    By SignInPageBtn = By.cssSelector("a[data-nav-ref='nav_ya_signin']");
    By EmailFld = By.id("ap_email_login");
    By ContinueBtn = By.cssSelector("input[type='submit']");
    By PasswordFld = By.id("ap_password");
    By SingInBtn = By.id("auth-signin-button");

    // Actions
    public WebElement Sign_in_Page_Button(){
        return driver.findElement(SignInPageBtn);
    }
    public WebElement Email_Field(){
        return driver.findElement(EmailFld);
    }
    public WebElement Continue_Button(){
        return driver.findElement(ContinueBtn);
    }
    public WebElement Password_Field(){
        return driver.findElement(PasswordFld);
    }
    public WebElement Sing_in_Button(){
        return driver.findElement(SingInBtn);
    }
}
