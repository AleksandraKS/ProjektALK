package com.parasoft.parabank;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    private final WebDriver driver;
    WebDriverWait wait;

    public HomePage(WebDriver driver) {

        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public ContactInfoPage contactInfoClick() {
        driver.findElement(By.linkText("Update Contact Info")).click();
        return new ContactInfoPage(driver);
    }

    public OpenAccountPage openNewAccountClick() {
        driver.findElement(By.linkText("Open New Account")).click();
        return new OpenAccountPage(driver);
    }

    public RequestLoanPage requestLoanClick() {
        driver.findElement(By.linkText("Request Loan")).click();
        return new RequestLoanPage(driver);
    }

}
