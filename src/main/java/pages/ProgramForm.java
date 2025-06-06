package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProgramForm {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public ProgramForm(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    private final By titleInput = By.cssSelector("[data-test-id='create_program_description.input.title']");
    private final By nextButton = By.cssSelector("[data-test-id='create_program.button.continue']");

    public void fillForm(String title) {
        driver.findElement(titleInput).sendKeys(title);

        //Shortcut for filling the form, because no fields were mandatory, hope this won't be a problem :D
        clickContinue();
    }

    public void clickContinue() {
        while (true) {
            WebElement button = wait.until(ExpectedConditions.elementToBeClickable(nextButton));
            String text = button.getText().trim().toLowerCase();

            if (text.equals("create")) {
                button.click();
                break;
            }

            button.click();
        }
    }

    public boolean getInfo(String title) {
        return !driver.findElements(By.xpath("//h1[text() = '" + title + "']")).isEmpty();
    }
}
