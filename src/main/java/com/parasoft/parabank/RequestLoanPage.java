package com.parasoft.parabank;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class RequestLoanPage {

    WebDriver driver;
    String newAccountId;

    public RequestLoanPage(WebDriver driver) {
        this.driver = driver;
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
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div/div/form/table/tbody/tr[4]/td[2]/input")).submit();
    }

    public String getNewAccountId() {
        newAccountId = driver.findElement(By.id("newAccountId")).getText();
        return newAccountId;
    }

    public void clickAccountOverviewBtn() {
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/ul/li[2]/a")).click();
    }

    public void findNewAccountClick() {
        driver.findElement(By.linkText(newAccountId)).click();
    }

}
