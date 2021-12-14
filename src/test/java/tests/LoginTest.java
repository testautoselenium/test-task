package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.LoginPage;

import static config.Credentials.credentials;


public class LoginTest extends BaseTest {
    private String email = credentials.loginEmail();
    private String password = credentials.loginPassword();

    @Test
    @DisplayName("Check login")
    void verifyLogin() {
        String expectedPageTitle = "Kurze Sicherheitsprüfung";
        driver.get("https://kundenbereich.check24.de/user/login.html");
        LoginPage loginPage = new LoginPage(driver);
        loginPage
                .acceptCookies()
                .enterEmail(email)
                .enterPassword(password);

        String registrationPageTitle = loginPage.getCheckSafetyPageTitle();
        Assertions.assertEquals(registrationPageTitle, expectedPageTitle);
    }
}
