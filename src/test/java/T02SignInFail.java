import com.parasoft.parabank.RegistrationPage;
import com.parasoft.parabank.StartPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class T02SignInFail {

    public WebDriver driver;
    public StartPage startPage;
    public RegistrationPage registrationPage;


    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }


    @Test(description = "Test błędnej rejestracji/Weryfikacja walidacji pól")
    public void registrationFailTest() {
        startPage = new StartPage(driver).openPage();
        registrationPage = startPage.clickRegisterButton();
        Assert.assertTrue(driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/form/table")).isDisplayed());
        registrationPage = registrationPage.fillRegistrationFormFail();
        Assert.assertEquals(registrationPage.firstNameErrorText(), "First name is required.");
        Assert.assertEquals(registrationPage.lastNameErrorText(), "Last name is required.");
        Assert.assertEquals(registrationPage.addressErrorText(), "Address is required.");
        Assert.assertEquals(registrationPage.cityErrorText(), "City is required.");
        Assert.assertEquals(registrationPage.stateErrorText(), "State is required.");
        Assert.assertEquals(registrationPage.zipCodeErrorText(), "Zip Code is required.");
        Assert.assertEquals(registrationPage.ssnErrorText(), "Social Security Number is required.");
        Assert.assertEquals(registrationPage.usernameErrorText(), "Username is required.");
        Assert.assertEquals(registrationPage.passwordErrorText(), "Password is required.");
        Assert.assertEquals(registrationPage.passwordConfirmationErrorText(), "Password confirmation is required.");
    }

    @AfterClass
    public void tearDown() {

        driver.quit();
    }

}

