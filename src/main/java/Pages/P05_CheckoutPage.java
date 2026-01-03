package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class P05_CheckoutPage {
    WebDriver driver;
    public P05_CheckoutPage(WebDriver driver){
        this.driver = driver;
    }

    By AddAddressBtn = By.cssSelector("a[data-csa-c-slot-id='add-new-address-non-mobile-tango-sasp-zero-address']");
    By FullNameFld = By.id("address-ui-widgets-enterAddressFullName");
    By MobileFld = By.id("address-ui-widgets-enterAddressPhoneNumber");
    By StreetNameFld = By.id("address-ui-widgets-enterAddressLine1");
    By BuildingFld = By.id("address-ui-widgets-enter-building-name-or-number");
    By CityAreaFld = By.id("address-ui-widgets-enterAddressCity");
    By CitySelection = By.id("address-ui-widgets-autoCompleteResult-0");
    By DistrictFld = By.id("address-ui-widgets-enterAddressDistrictOrCounty");
    By DistrictSelection = By.id("address-ui-widgets-autoCompleteResult-0");
    By UseAddressBtn = By.cssSelector("input[data-csa-c-slot-id='address-ui-widgets-continue-address-btn-bottom']");


    public WebElement Add_Address_Button(){
        return driver.findElement(AddAddressBtn);
    }
    public WebElement Full_Name_Field(){
        return driver.findElement(FullNameFld);
    }
    public WebElement Mobile_Number_Field(){
        return driver.findElement(MobileFld);
    }
    public WebElement Street_Name(){
        return driver.findElement(StreetNameFld);
    }
    public WebElement Building_Name(){
        return driver.findElement(BuildingFld);
    }
    public WebElement City_Area_Menu(){
        return driver.findElement(CityAreaFld);
    }
    public WebElement City_Area_Option(){
        return driver.findElement(CitySelection);
    }
    public WebElement DistrictMenu(){
        return driver.findElement(DistrictFld);
    }
    public WebElement District_Option(){
        return driver.findElement(DistrictSelection);
    }
    public WebElement Use_Address_Button(){
        return driver.findElement(UseAddressBtn);
    }
}
