package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OtpPage {
    private final WebDriver driver;

    public OtpPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By otpInput = By.xpath("//*[@data-test-id='auth.input.code']//input");

    public void enterOtpAndSubmit(String code) {
        driver.findElement(otpInput).sendKeys(code);
    }
}
