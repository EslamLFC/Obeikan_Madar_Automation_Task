package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class P02_HomePage {
    // Constructor
    WebDriver driver;

    public P02_HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    By AllMenu = By.id("nav-hamburger-menu");
    By SeeAllBtn = By.cssSelector("a[class='hmenu-item hmenu-compressed-btn']");
    By VideoGamesBtn = By.cssSelector("a[data-menu-id='16']");
    By AllVideoGamesBtn = By.cssSelector("a[href*='=nav_em_vg_all']");


    // Actions
    public WebElement All_Hamburger_Menu(){
        return driver.findElement(AllMenu);
    }
    public WebElement See_all_button(){
        return driver.findElement(SeeAllBtn);
    }
    public WebElement Video_Games_Category(){
        return driver.findElement(VideoGamesBtn);
    }
    public WebElement All_Video_Games_Button(){
        return driver.findElement(AllVideoGamesBtn);
    }
}
