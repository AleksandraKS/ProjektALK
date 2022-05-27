package com.parasoft.parabank;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TransferFundsPage {
    WebDriver driver;
    WebDriverWait wait;

    public TransferFundsPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void amountInput() {
        String amount = "100";
        driver.findElement(By.id("amount")).sendKeys(amount);
    }

    public void chooseAccountFrom() {
        Select accountList1 = new Select(driver.findElement(By.id("fromAccountId")));
        accountList1.selectByIndex(0);
    }

    public void chooseAccountTo() {
        Select accountList2 = new Select(driver.findElement(By.id("toAccountId")));
        accountList2.selectByIndex(1);
    }

    public void clickTransferBtn() {
        driver.findElement(By.cssSelector("input.button")).submit();
    }
}
