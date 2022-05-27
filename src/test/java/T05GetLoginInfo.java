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
    public void loginInfoTest() throws IOException, CsvValidationException, InterruptedException {
        startPage = new StartPage(driver).openPage();
        loginInfoPage = startPage.clickLoginInfo();
        Assert.assertTrue(driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/form/table")).isDisplayed());
        loginInfoPage.fillLoginInfo();
        Thread.sleep(1000);
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"rightPanel\"]/p[1]")).getText().contains("Your login information was located successfully. You are now logged in."));
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
