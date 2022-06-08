package com.parasoft.parabank;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OpenAccountPage {

    WebDriver driver;
    WebDriverWait wait;

    public OpenAccountPage(WebDriver driver) {

        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void chooseAccountType() {
        Select typeList = new Select(driver.findElement(By.id("type")));
        typeList.selectByVisibleText("SAVINGS");

    }

    public void chooseAccountForTransfer() {
        WebElement element = driver.findElement(By.id("fromAccountId"));
        wait.until(ExpectedConditions.attributeToBeNotEmpty(element, "value"));
        Select transferAccountList = new Select(driver.findElement(By.id("fromAccountId")));
        transferAccountList.selectByIndex(0);
    }

    public void openAccountBtn() {
        driver.findElement(By.cssSelector("input.button")).submit();
    }

    public String getAccountText() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("newAccountId")));
        String accountText = driver.findElement(By.cssSelector("[class='title']")).getText();
        return accountText;
    }
}
