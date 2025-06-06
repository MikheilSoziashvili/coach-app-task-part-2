package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By signInButton = By.cssSelector("[data-test-id='auth.button.sign_in']");
    private final By emailInput = By.cssSelector("[data-test-id='auth.input.email']");
    private final By sendCodeButton = By.cssSelector("[data-test-id='auth.button.send_code']");

    public void open(String Url) {
        driver.get(Url);
    }

    public void enterEmail(String email) {
        driver.findElement(signInButton).click();
        driver.findElement(emailInput).sendKeys(email);
        driver.findElement(sendCodeButton).click();
    }
}
