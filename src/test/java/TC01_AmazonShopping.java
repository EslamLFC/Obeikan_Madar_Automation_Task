import Pages.P03_VideoGamesPage;
import Utilities.DataUtil;
import Utilities.Utility;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC01_AmazonShopping extends BaseTest {
    @Test
    public void Login() throws IOException {
        // Login to Amazon
        driver.navigate().to(DataUtil.getPropertyValue("Config", "URL"));
        Utility.ClickOnElement(driver, loginPage.Sign_in_Page_Button());
        Utility.SendData(driver, loginPage.Email_Field(), DataUtil.getPropertyValue("Config", "Email"));
        Utility.ClickOnElement(driver, loginPage.Continue_Button());
        Utility.SendData(driver, loginPage.Password_Field(), DataUtil.getPropertyValue("Config", "Password"));
        Utility.ClickOnElement(driver, loginPage.Sing_in_Button());
    }

    @Test(priority = 1)
    public void OpenAllVideoGames() {
        // Navigate to All video Games page
        Utility.ClickOnElement(driver, homepage.All_Hamburger_Menu());
        Utility.ClickOnElement(driver, homepage.See_all_button());
        Utility.ClickOnElement(driver, homepage.Video_Games_Category());
        driver.navigate().to(homepage.All_Video_Games_Button().getAttribute("href"));
    }

    @Test(priority = 2)
    public void ApplyFilters() {
        wait.until(ExpectedConditions.visibilityOf(videoGamesPage.Free_Shipping_Checkbox()));
        videoGamesPage.Free_Shipping_Checkbox().click();
        js.executeScript("window.scrollBy(0,500)");
        wait.until(ExpectedConditions.visibilityOf(videoGamesPage.Condition_New_Checkbox()));
        videoGamesPage.Condition_New_Checkbox().click();
        wait.until(ExpectedConditions.visibilityOf(videoGamesPage.Sort_Option()));
        Select sort_Option = new Select(videoGamesPage.Sort_Option());
        sort_Option.selectByIndex(2);
    }

    @Test(priority = 3)
    public void AddProducts() {
        videoGamesPage.Add_Products_To_Cart();
        js.executeScript("window.scrollBy(0,-2000)");
        Utility.ClickOnElement(driver, videoGamesPage.Cart_Nav_Button());
    }

    @Test(priority = 4)
    public void CheckCart() throws IOException {
        wait.until(ExpectedConditions.urlContains(DataUtil.getPropertyValue("Config", "ExpectedCartUrl")));
        Assert.assertNotEquals(cartPage.Cart_items(), 0);
        Utility.ClickOnElement(driver, cartPage.Proceed_Button());
    }

    @Test(priority = 5)
    public void Checkout() throws IOException {
        Utility.ClickOnElement(driver, checkoutPage.Add_Address_Button());
        Utility.SendData(driver, checkoutPage.Full_Name_Field(), DataUtil.getPropertyValue("Config", "FullName"));
        Utility.SendData(driver, checkoutPage.Mobile_Number_Field(), DataUtil.getPropertyValue("Config", "MobileNumber"));
        Utility.SendData(driver, checkoutPage.Street_Name(), DataUtil.getPropertyValue("Config", "StreetName"));
        Utility.SendData(driver, checkoutPage.Building_Name(), DataUtil.getPropertyValue("Config", "BuildingName"));
        wait.until(ExpectedConditions.elementToBeClickable(checkoutPage.City_Area_Menu()));
        checkoutPage.City_Area_Menu().sendKeys(DataUtil.getPropertyValue("Config","City_District"));
        checkoutPage.City_Area_Menu().sendKeys(Keys.ARROW_DOWN);
        Utility.ClickOnElement(driver, checkoutPage.City_Area_Option());
        wait.until(ExpectedConditions.elementToBeClickable(checkoutPage.DistrictMenu()));
        checkoutPage.DistrictMenu().sendKeys(DataUtil.getPropertyValue("Config","City_District"));
        checkoutPage.DistrictMenu().sendKeys(Keys.ARROW_DOWN);
        Utility.ClickOnElement(driver, checkoutPage.District_Option());
        Utility.ClickOnElement(driver,checkoutPage.Use_Address_Button());
    }

}
