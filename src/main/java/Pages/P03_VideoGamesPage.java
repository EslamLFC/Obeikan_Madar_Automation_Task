package Pages;

import Utilities.DataUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class P03_VideoGamesPage {
    WebDriver driver;

    public P03_VideoGamesPage(WebDriver driver) {
        this.driver = driver;
    }

    By FreeShipping = By.cssSelector("label[for='apb-browse-refinements-checkbox_0'] i[class='a-icon a-icon-checkbox']");
    By ConditionNew = By.cssSelector("a[aria-label='Apply the filter New to narrow results'] i[class='a-icon a-icon-checkbox']");
    By SortOptionsMenu = By.id("s-result-sort-select");
    By AllProducts = By.cssSelector("h2[class='a-size-medium a-spacing-none a-color-base a-text-normal']");
    By ProductPrice = By.cssSelector("span[class='a-price-whole']");
    By AddToCartBtn = By.id("add-to-cart-button");
    By NextPageBtn = By.cssSelector("a[aria-label*='Go to next page']");
    By CloseWarranty = By.id("attachSiNoCoverage");
    By CartIcon = By.id("nav-cart");

    public WebElement Free_Shipping_Checkbox() {
        return driver.findElement(FreeShipping);
    }

    public WebElement Condition_New_Checkbox() {
        return driver.findElement(ConditionNew);
    }

    public WebElement Sort_Option() {
        return driver.findElement(SortOptionsMenu);
    }
    public WebElement Cart_Nav_Button(){
        return driver.findElement(CartIcon);
    }

    public void Add_Products_To_Cart() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(NextPageBtn));
        driver.findElement(NextPageBtn).click();
        for (int i = 1; i < 18; i++) {
//            WebElement FirstPageLastProduct = driver.findElements(AllProducts).get(18);
//            String FirstPageLastProductPrice = driver.findElements(ProductPrice).get(17).getText();
//            int FirstPageLastProductPriceValue = Integer.parseInt(FirstPageLastProductPrice);
//            if (FirstPageLastProductPriceValue <= 15000) {
//                FirstPageLastProduct.click();
//                new WebDriverWait(driver, Duration.ofSeconds(5))
//                        .until(ExpectedConditions.elementToBeClickable(AddToCartBtn));
//                driver.findElement(AddToCartBtn).click();
//                driver.navigate().back();
//            }
            new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.elementToBeClickable(AllProducts));
            WebElement Product = driver.findElements(AllProducts).get(i - 1);
            new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.elementToBeClickable(AllProducts));
            String Price = driver.findElements(ProductPrice).get(i - 1).getText();
            String cleanPrice = Price.replaceAll("[,\\s]", "");
            int ProductPrice = Integer.parseInt(cleanPrice);
            System.out.println(ProductPrice);
            if (ProductPrice <= 15000) {
                new WebDriverWait(driver, Duration.ofSeconds(10))
                        .until(ExpectedConditions.elementToBeClickable(AllProducts));
                Product.click();
                try {
                    new WebDriverWait(driver, Duration.ofSeconds(10))
                            .until(ExpectedConditions.elementToBeClickable(AddToCartBtn));
                    driver.findElement(AddToCartBtn).click();
                    new WebDriverWait(driver, Duration.ofSeconds(10))
                            .until(ExpectedConditions.elementToBeClickable(CloseWarranty));
                    driver.findElement(CloseWarranty).click();
                    new WebDriverWait(driver, Duration.ofSeconds(10))
                            .until(ExpectedConditions.invisibilityOfElementLocated(CloseWarranty));
                    driver.navigate().back();
                    driver.navigate().back();
                } catch (Exception e) {
                    driver.navigate().back();
                }
            }
            else{
                continue;
            }
        }
    }
}

