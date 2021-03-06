package com.parasoft.parabank;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {

    private final WebDriver driver;

    public LandingPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getWelcomeText() {
        String welcomeText = driver.findElement(By.className("title")).getText();
        return welcomeText;
    }

}
