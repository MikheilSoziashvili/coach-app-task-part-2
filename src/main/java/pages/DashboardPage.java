package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {
    private final WebDriver driver;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By createProgram = By.xpath("//*[text() = 'Create new program']/ancestor::button");

    public void clickCreateProgram() {
        driver.findElement(createProgram).click();
    }
}
