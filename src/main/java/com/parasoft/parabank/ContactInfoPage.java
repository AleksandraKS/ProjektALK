package com.parasoft.parabank;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class ContactInfoPage {

    private final WebDriver driver;
    private final By firstName = By.id("customer.firstName");
    private final By city = By.id("customer.address.city");
    public String newName = "Jack";
    public String newCity = "Washington";

    public ContactInfoPage(WebDriver driver) {
        this.driver = driver;
    }

    public void changeData() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(firstName).clear();
        driver.findElement(firstName).sendKeys(newName);
        driver.findElement(city).clear();
        driver.findElement(city).sendKeys(newCity);

    }

    public void clickUpdateInfo() {
        driver.findElement(By.cssSelector("input.button")).click();
    }

    public String getFirstNameNew() {
        String firstNameNew = driver.findElement(firstName).getAttribute("value");
        return firstNameNew;
    }

    public String getCityNew() {
        String cityNew = driver.findElement(city).getAttribute("value");
        return cityNew;
    }
}
