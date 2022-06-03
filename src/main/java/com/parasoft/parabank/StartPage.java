package com.parasoft.parabank;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.FileReader;
import java.io.IOException;

public class StartPage {

    private final WebDriver driver;
    private final By registerButton = By.linkText("Register");
    private final By usernameField = By.name("username");
    private final By passwordField = By.name("password");
    private final By loginButton = By.cssSelector("input.button");
    private final By loginInfoButton = By.linkText("Forgot login info?");
    String CsvPath = "data/registrationData.csv";
    String[] csvCell;
    private CSVReader csvReader;


    public StartPage(WebDriver driver) {
        this.driver = driver;
    }

    public StartPage openPage() {
        driver.get("https://parabank.parasoft.com");
        return new StartPage(driver);
    }

    public RegistrationPage clickRegisterButton() {
        driver.findElement(registerButton).click();
        return new RegistrationPage(driver);

    }

    public HomePage logInSuccess() throws IOException, CsvValidationException {
        csvReader = new CSVReader(new FileReader(CsvPath));
        while ((csvCell = csvReader.readNext()) != null) {

            String UserName = csvCell[8];
            String Password = csvCell[9];

            driver.findElement(usernameField).clear();
            driver.findElement(usernameField).sendKeys(UserName);
            driver.findElement(passwordField).clear();
            driver.findElement(passwordField).sendKeys(Password);
            driver.findElement(loginButton).click();
            break;
        }

        return new HomePage(driver);
    }

    public StartPage logInFailed() {
        driver.findElement(usernameField).clear();
        driver.findElement(passwordField).clear();
        driver.findElement(loginButton).click();
        return new StartPage(driver);
    }

    public String getLogInErrorText() {
        String logInErrorText = driver.findElement(By.className("error")).getText();
        return logInErrorText;
    }

    public LoginInfoPage clickLoginInfo() {
        driver.findElement(loginInfoButton).click();
        return new LoginInfoPage(driver);
    }
}
