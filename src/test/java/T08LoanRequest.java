import com.opencsv.exceptions.CsvValidationException;
import com.parasoft.parabank.HomePage;
import com.parasoft.parabank.RequestLoanPage;
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

public class T08LoanRequest {

    public WebDriver driver;
    public StartPage startPage;
    public HomePage homePage;
    public RequestLoanPage requestLoanPage;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
    }

    @Test(description = "Test złożenia wniosku o udzielenie pożyczki")
    public void requestLoanTest() throws IOException, CsvValidationException, InterruptedException {
        startPage = new StartPage(driver).openPage();
        homePage = startPage.logInSuccess();
        requestLoanPage = homePage.requestLoanClick();
        requestLoanPage.fillLoanAmount();
        requestLoanPage.fillDownPaymentAmount();
        requestLoanPage.chooseAccountForLoan();
        requestLoanPage.clickApplyNowBtn();
        Assert.assertTrue(driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div/div/div/p[1]")).getText().contains("Congratulations, your loan has been approved."));
        requestLoanPage.getNewAccountId();
        requestLoanPage.clickAccountOverviewBtn();
        requestLoanPage.findNewAccountClick();
        Thread.sleep(1000);
        Assert.assertTrue(driver.findElement(By.id("accountType")).getText().contains("LOAN"));
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
