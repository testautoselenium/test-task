package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    private By acceptButton = By.linkText("Akzeptieren");
    private By passwordField = By.id("cl_pw_login");
    private By checkSafetyPageTitle = By.cssSelector(".c24-uli-title");
    private By messageAfterLogin = By.cssSelector(".c24-uli-lc-text-bottom");
    private By emailField = By.id("cl_login");

    @Step("Accept cookie")
    public LoginPage acceptCookies() {
        List<WebElement> cookiePopUp = driver.findElements(acceptButton);
        if (cookiePopUp.size() > 0) {
            cookiePopUp.get(0).click();
        }
        return this;
    }

    @Step("Enter mail")
    public LoginPage enterEmail(String email) {
        driver.switchTo().frame("c24-uli-iframe");
        WebElement emailElement = wait.until(
                ExpectedConditions.visibilityOfElementLocated(emailField));
        emailElement.sendKeys(email);
        emailElement.submit();
        return this;
    }

    @Step("Enter password")
    public LoginPage enterPassword(String password) {
        WebElement passwordElement = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));
        passwordElement.sendKeys(password);
        passwordElement.submit();
        return this;
    }

    @Step("Get title on safety page")
    public String getCheckSafetyPageTitle() {
      wait.until(
                ExpectedConditions.visibilityOfElementLocated(messageAfterLogin));
     return driver.findElement(checkSafetyPageTitle).getText();
    }


}
