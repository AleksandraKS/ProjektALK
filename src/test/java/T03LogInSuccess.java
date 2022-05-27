import com.opencsv.exceptions.CsvValidationException;
import com.parasoft.parabank.StartPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class T03LogInSuccess {

    public StartPage startPage;
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
    }

    @Test(description = "Test poprawnego logowania")
    public void logInSuccessTest() throws IOException, CsvValidationException {
        startPage = new StartPage(driver).openPage();
        startPage.logInSuccess();
        Assert.assertTrue(driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div/div")).isDisplayed());
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
