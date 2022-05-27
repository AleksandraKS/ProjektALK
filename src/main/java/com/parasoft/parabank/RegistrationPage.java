package com.parasoft.parabank;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.FileReader;
import java.io.IOException;

public class RegistrationPage {

    private final WebDriver driver;
    private final By firstName = By.id("customer.firstName");
    private final By lastName = By.id("customer.lastName");
    private final By address = By.id("customer.address.street");
    private final By city = By.id("customer.address.city");
    private final By state = By.id("customer.address.state");
    private final By zipCode = By.id("customer.address.zipCode");
    private final By phoneNumber = By.id("customer.phoneNumber");
    private final By snn = By.id("customer.ssn");
    private final By username = By.id("customer.username");
    private final By password = By.id("customer.password");
    private final By confirm = By.id("repeatedPassword");
    private final By signInButton = By.xpath("/html/body/div[1]/div[3]/div[2]/form/table/tbody/tr[13]/td[2]/input");
    String CsvPath = "data/registrationData.csv";
    String[] csvCell;
    private CSVReader csvReader;


    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    //dokończyć pobieranie danych z pliku do tej metody
    public RegistrationPage fillRegistrationForm() throws IOException, CsvValidationException {
        csvReader = new CSVReader(new FileReader(CsvPath));
        while ((csvCell = csvReader.readNext()) != null) {
            String FirstName = csvCell[0];
            String LastName = csvCell[1];
            String Address = csvCell[2];
            String City = csvCell[3];
            String State = csvCell[4];
            String ZipCode = csvCell[5];
            String PhoneNumber = csvCell[6];
            String Snn = csvCell[7];
            String UserName = csvCell[8];
            String Password = csvCell[9];

            driver.findElement(firstName).sendKeys(FirstName);
            driver.findElement(lastName).sendKeys(LastName);
            driver.findElement(address).sendKeys(Address);
            driver.findElement(city).sendKeys(City);
            driver.findElement(state).sendKeys(State);
            driver.findElement(zipCode).sendKeys(ZipCode);
            driver.findElement(phoneNumber).sendKeys(PhoneNumber);
            driver.findElement(snn).sendKeys(Snn);

            driver.findElement(username).clear();
            driver.findElement(username).sendKeys(UserName);
            driver.findElement(password).clear();
            driver.findElement(password).sendKeys(Password);
            driver.findElement(confirm).sendKeys(Password);
            break;
        }

        return new RegistrationPage(driver);
    }

    public String getUserNameProvided() {
        String userNameProvided = driver.findElement(username).getAttribute("value");
        return userNameProvided;

    }

    public LandingPage clickRegistrationButton() {
        driver.findElement(signInButton).click();
        return new LandingPage(driver);
    }

    public RegistrationPage fillRegistrationFormFail() {
        driver.findElement(signInButton).click();
        return new RegistrationPage(driver);
    }

    public String firstNameErrorText() {
        String firstNameText = driver.findElement(By.id("customer.firstName.errors")).getText();
        return firstNameText;
    }

    public String lastNameErrorText() {
        String lastNameText = driver.findElement(By.id("customer.lastName.errors")).getText();
        return lastNameText;
    }

    public String addressErrorText() {
        String addressText = driver.findElement(By.id("customer.address.street.errors")).getText();
        return addressText;
    }

    public String cityErrorText() {
        String cityText = driver.findElement(By.id("customer.address.city.errors")).getText();
        return cityText;
    }

    public String stateErrorText() {
        String stateText = driver.findElement(By.id("customer.address.state.errors")).getText();
        return stateText;
    }

    public String zipCodeErrorText() {
        String zipCodeText = driver.findElement(By.id("customer.address.zipCode.errors")).getText();
        return zipCodeText;
    }

    public String ssnErrorText() {
        String ssnText = driver.findElement(By.id("customer.ssn.errors")).getText();
        return ssnText;
    }

    public String usernameErrorText() {
        String usernameText = driver.findElement(By.id("customer.username.errors")).getText();
        return usernameText;
    }

    public String passwordErrorText() {
        String passwordText = driver.findElement(By.id("customer.password.errors")).getText();
        return passwordText;
    }

    public String passwordConfirmationErrorText() {
        String passwordConfirmationText = driver.findElement(By.id("repeatedPassword.errors")).getText();
        return passwordConfirmationText;
    }

}