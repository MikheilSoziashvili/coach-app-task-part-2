import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import pages.OtpPage;
import pages.ProgramForm;

import java.time.Duration;

public class CreateProgramTest {
    private WebDriver driver;
    private LoginPage loginPage;
    private OtpPage otpPage;
    private DashboardPage dashboardPage;
    private ProgramForm programForm;

    //This could go in configs/properties
    private final String baseUrl = "https://app.stage1.yourcoach.health";
    private final String coachEmail = "coach10@example.com";
    private final String otpCode = "123456";
    private final String programTitle = "My Automation Program";

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        loginPage = new LoginPage(driver);
        otpPage = new OtpPage(driver);
        dashboardPage = new DashboardPage(driver);
        programForm = new ProgramForm(driver);
    }

    //This is a 1 positive scenario for creating a program via coach account
    @Test
    public void createProgramTest() {
        loginPage.open(baseUrl);
        loginPage.enterEmail(coachEmail);

        otpPage.enterOtpAndSubmit(otpCode);
        dashboardPage.clickCreateProgram();
        programForm.fillForm(programTitle);

        //mimic of getting whole info after filling out a form, in the real world this would be more complex
        Assert.assertTrue(programForm.getInfo(programTitle));
    }

    @AfterClass
    public void tearDown() {
        // could not locate logout button so cleared cookies to re-login after each test execution
        driver.manage().deleteAllCookies();

        if (driver != null) {
            driver.quit();
        }
    }
}
