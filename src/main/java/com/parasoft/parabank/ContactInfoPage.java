package com.parasoft.parabank;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class ContactInfoPage {

    private final WebDriver driver;
    private final By firstName = By.id("customer.firstName");
    private final By city = By.id("customer.address.city");
    public String newName = "Jack";
    public String newCity = "Washington";
    WebDriverWait wait;

    public ContactInfoPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void changeData() {
        WebElement element = driver.findElement(By.id("customer.firstName"));
        wait.until(ExpectedConditions.attributeToBeNotEmpty(element, "value"));
        driver.findElement(firstName).clear();
        driver.findElement(firstName).sendKeys(newName);
        driver.findElement(city).clear();
        driver.findElement(city).sendKeys(newCity);

    }

    public void clickUpdateInfo() {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input.button"))).submit();
    }

    public String getFirstNameNew() {
        WebElement element = driver.findElement(firstName);
        wait.until(ExpectedConditions.attributeToBeNotEmpty(element, "value"));
        String firstNameNew = driver.findElement(firstName).getAttribute("value");
        return firstNameNew;
    }

    public String getCityNew() {
        String cityNew = driver.findElement(city).getAttribute("value");
        return cityNew;
    }
}
