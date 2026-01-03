package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class P04_CartPage {
    WebDriver driver;

    public P04_CartPage(WebDriver driver) {
        this.driver = driver;
    }

    By CartItems = By.cssSelector("h4[class='a-text-normal']");
    By ProceedBtn = By.id("sc-buy-box-ptc-button");

    public int Cart_items(){
    return driver.findElements(CartItems).size();
}

    public WebElement Proceed_Button(){
        return driver.findElement(ProceedBtn);
    }
}
