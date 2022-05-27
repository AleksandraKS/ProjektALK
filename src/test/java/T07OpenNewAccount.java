import com.opencsv.exceptions.CsvValidationException;
import com.parasoft.parabank.HomePage;
import com.parasoft.parabank.OpenAccountPage;
import com.parasoft.parabank.StartPage;
import com.parasoft.parabank.TransferFundsPage;
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

public class T07OpenNewAccount {
    public WebDriver driver;
    public StartPage startPage;
    public HomePage homePage;
    public OpenAccountPage openAccountPage;
    public TransferFundsPage transferFundsPage;


    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
    }

    @Test(description = "Test założenia nowego konta i przelania środków")
    public void openNewAccountAndTransferFundsTest() throws IOException, CsvValidationException, InterruptedException {
        startPage = new StartPage(driver).openPage();
        homePage = startPage.logInSuccess();
        openAccountPage = homePage.openNewAccountClick();
        openAccountPage.chooseAccountType();
        openAccountPage.chooseAccountForTransfer();
        openAccountPage.openAccountBtn();
        Assert.assertTrue(driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div/div/p[1]")).getText().contains("Congratulations, your account is now open."));
        transferFundsPage = homePage.transferFundsClick();
        Thread.sleep(1000);
        transferFundsPage.amountInput();
        transferFundsPage.chooseAccountFrom();
        transferFundsPage.chooseAccountTo();
        transferFundsPage.clickTransferBtn();
        Thread.sleep(1000);
        Assert.assertTrue(driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div/div/h1")).getText().contains("Transfer Complete!"));
    }

    @AfterClass
    public void tearDown() {

        driver.quit();
    }
}

