import com.opencsv.exceptions.CsvValidationException;
import com.parasoft.parabank.ContactInfoPage;
import com.parasoft.parabank.HomePage;
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

public class T06ContactInfoUpdate {

    public StartPage startPage;
    public HomePage homePage;
    public ContactInfoPage contactInfoPage;
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
    }

    @Test(description = "Test zmiany danych kontaktowych")
    public void updateContactInfoTest() throws IOException, CsvValidationException, InterruptedException {
        startPage = new StartPage(driver).openPage();
        homePage = startPage.logInSuccess();
        contactInfoPage = homePage.contactInfoClick();
        contactInfoPage.changeData();
        contactInfoPage.clickUpdateInfo();
        Assert.assertTrue(driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div/div/p")).getText().contains("Your updated address and phone number have been added to the system."));
        homePage.contactInfoClick();
        Thread.sleep(1000);
        Assert.assertEquals(contactInfoPage.getFirstNameNew(), contactInfoPage.newName);
        Assert.assertEquals(contactInfoPage.getCityNew(), contactInfoPage.newCity);

    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
