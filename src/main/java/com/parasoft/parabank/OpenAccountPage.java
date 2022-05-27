package com.parasoft.parabank;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class OpenAccountPage {

    WebDriver driver;

    public OpenAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public void chooseAccountType() {
        Select typeList = new Select(driver.findElement(By.xpath("//*[@id=\"type\"]")));
        typeList.selectByVisibleText("SAVINGS");

    }

    public void chooseAccountForTransfer() {
        Select transferAccountList = new Select(driver.findElement(By.id("fromAccountId")));
        transferAccountList.selectByIndex(0);
    }

    public void openAccountBtn() {
        driver.findElement(By.cssSelector("input.button")).submit();
    }
}
