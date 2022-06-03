import com.opencsv.exceptions.CsvValidationException;
import com.parasoft.parabank.LoginInfoPage;
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

public class T05GetLoginInfo {

    public StartPage startPage;
    public LoginInfoPage loginInfoPage;
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
    }

    @Test(description = "Test odzyskania danych logowania")
    public void loginInfoTest() throws IOException, CsvValidationException {
        startPage = new StartPage(driver).openPage();
        loginInfoPage = startPage.clickLoginInfo();
        loginInfoPage.fillLoginInfo();
        Assert.assertTrue(driver.findElement(By.cssSelector("[class='title']")).getText().contains("Customer Lookup"), "Dane Użytkownika nie zostały odnalezione");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
