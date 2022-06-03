import com.opencsv.exceptions.CsvValidationException;
import com.parasoft.parabank.LandingPage;
import com.parasoft.parabank.RegistrationPage;
import com.parasoft.parabank.StartPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class T01SignInSuccess {

    public WebDriver driver;
    public StartPage startPage;
    public RegistrationPage registrationPage;
    public LandingPage landingPage;


    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
    }

    @Test(description = "Test poprawnej rejestracji")
    public void registerTest() throws IOException, CsvValidationException {
        startPage = new StartPage(driver).openPage();
        registrationPage = startPage.clickRegisterButton();
        registrationPage = registrationPage.fillRegistrationForm();
        String userNameProvided = registrationPage.getUserNameProvided();
        landingPage = registrationPage.clickRegistrationButton();
        Assert.assertEquals(landingPage.getWelcomeText(), "Welcome " + userNameProvided, "Rejestracja zakończyła się niepowodzeniem");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}