package com.parasoft.parabank;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private final WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public ContactInfoPage contactInfoClick() {
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/ul/li[6]/a")).click();
        return new ContactInfoPage(driver);
    }

    public OpenAccountPage openNewAccountClick() {
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/ul/li[1]/a")).click();
        return new OpenAccountPage(driver);
    }

    public TransferFundsPage transferFundsClick() {
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/ul/li[3]/a")).click();
        return new TransferFundsPage(driver);
    }

    public RequestLoanPage requestLoanClick() {
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/ul/li[7]/a")).click();
        return new RequestLoanPage(driver);
    }

}
