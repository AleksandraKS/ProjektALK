package com.parasoft.parabank;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RequestLoanPage {

    WebDriver driver;
    WebDriverWait wait;
    String newAccountId;

    public RequestLoanPage(WebDriver driver) {

        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void fillLoanAmount() {
        String loanAmount = "1000";
        driver.findElement(By.id("amount")).sendKeys(loanAmount);
    }

    public void fillDownPaymentAmount() {
        String downPaymentAmount = "100";
        driver.findElement(By.id("downPayment")).sendKeys(downPaymentAmount);
    }

    public void chooseAccountForLoan() {
        Select accountFrom = new Select(driver.findElement(By.id("fromAccountId")));
        accountFrom.selectByIndex(0);
    }

    public void clickApplyNowBtn() {
        driver.findElement(By.cssSelector("input.button")).submit();
    }

    public String getLoanText() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loanProviderName")));
        String loanText = driver.findElement(By.className("title")).getText();
        return loanText;
    }

}
