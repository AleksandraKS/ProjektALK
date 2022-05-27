import com.parasoft.parabank.StartPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class T04LogInFail {

    public StartPage startPage;
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
    }

    @Test(description = "Test wymagalności pól logowania")
    public void logInFailedTest() {
        startPage = new StartPage(driver).openPage();
        startPage.logInFailed();
        Assert.assertEquals(startPage.getLogInErrorText(), "Please enter a username and password.");
    }

    @AfterClass

    public void tearDown() {

        driver.quit();
    }

}

