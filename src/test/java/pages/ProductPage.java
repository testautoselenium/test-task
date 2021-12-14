package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ProductPage extends BasePage {
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    private By acceptButton = By.linkText("Akzeptieren");
    private By shopsList = By.cssSelector(".offer-list .offer-item");
    private By productPrice = By.cssSelector(".price");
    private By productAddToCartButton= By.cssSelector(".qa-marketplace-cta");
    private By toggle = By.xpath("//label[@for='trigger-delivery-cost']");
    private By priceOnCheckOutPage = By.cssSelector(".order-summary-top .el-row .order-summary-top-total-col__price");

    @Step("Accept cookie")
    public ProductPage acceptCookies() {
        List<WebElement> cookiePopUp = driver.findElements(acceptButton);
        if (cookiePopUp.size() > 0) {
            cookiePopUp.get(0).click();
        }
        return this;
    }

    @Step("Switch price with delivery calculation")
    public ProductPage clickToggle() {
        driver.findElement(toggle).click();
        return this;
    }

    @Step("Get product price")
    public String getProductPrice() {
        List<WebElement> shopElements = wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(shopsList));
        String price = shopElements.get(0).findElement(productPrice).getText();
        System.out.println(price);
        return price;
    }

    @Step("Add product to cart")
    public ProductPage addProductToCart() {
        List<WebElement> shopElements = wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(shopsList));
        shopElements.get(0).findElement(productAddToCartButton).click();
        return this;
    }

    @Step("Add product price on checkout page")
    public String getProductPriceOnCheckoutPage() {
        WebElement productPrice = wait.until(
                ExpectedConditions.visibilityOfElementLocated(priceOnCheckOutPage));
        return productPrice.getText();
    }

}
