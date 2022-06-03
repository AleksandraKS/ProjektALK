import com.opencsv.exceptions.CsvValidationException;
import com.parasoft.parabank.HomePage;
import com.parasoft.parabank.OpenAccountPage;
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

public class T07OpenNewAccount {
    public WebDriver driver;
    public StartPage startPage;
    public HomePage homePage;
    public OpenAccountPage openAccountPage;


    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();

    }

    @Test(description = "Test założenia nowego konta")
    public void openNewAccountTest() throws IOException, CsvValidationException {
        startPage = new StartPage(driver).openPage();
        homePage = startPage.logInSuccess();
        openAccountPage = homePage.openNewAccountClick();
        openAccountPage.chooseAccountType();
        openAccountPage.chooseAccountForTransfer();
        openAccountPage.openAccountBtn();
        Assert.assertEquals(openAccountPage.getAccountText(), "Account Opened!");

    }

    @AfterClass
    public void tearDown() {

        driver.quit();
    }
}

