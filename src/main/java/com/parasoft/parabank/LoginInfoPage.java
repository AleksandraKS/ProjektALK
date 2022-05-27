package com.parasoft.parabank;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.FileReader;
import java.io.IOException;

public class LoginInfoPage {

    private final WebDriver driver;
    private final By firstName = By.id("firstName");
    private final By lastName = By.id("lastName");
    private final By address = By.id("address.street");
    private final By city = By.id("address.city");
    private final By state = By.id("address.state");
    private final By zipCode = By.id("address.zipCode");
    private final By snn = By.id("ssn");
    private final By getInfoButton = By.xpath("/html/body/div[1]/div[3]/div[2]/form/table/tbody/tr[8]/td[2]/input");
    String CsvPath = "data/registrationData.csv";
    String[] csvCell;
    private CSVReader csvReader;

    public LoginInfoPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillLoginInfo() throws IOException, CsvValidationException {
        csvReader = new CSVReader(new FileReader(CsvPath));
        while ((csvCell = csvReader.readNext()) != null) {
            String FirstName = csvCell[0];
            String LastName = csvCell[1];
            String Address = csvCell[2];
            String City = csvCell[3];
            String State = csvCell[4];
            String ZipCode = csvCell[5];
            String Snn = csvCell[7];

            driver.findElement(firstName).sendKeys(FirstName);
            driver.findElement(lastName).sendKeys(LastName);
            driver.findElement(address).sendKeys(Address);
            driver.findElement(city).sendKeys(City);
            driver.findElement(state).sendKeys(State);
            driver.findElement(zipCode).sendKeys(ZipCode);
            driver.findElement(snn).sendKeys(Snn);
            driver.findElement(getInfoButton).click();
            break;
        }
    }

}
