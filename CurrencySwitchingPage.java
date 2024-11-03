package com.example.ecommerce.pages;

import com.example.ecommerce.pages.LoginPage;
import com.example.ecommerce.tests.BaseTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CurrencySwitchingPage {
    private WebDriver driver;

    private By euroButton = By.xpath("//*[@id=\"form-currency\"]/div/ul/li[1]/button");
    private By poundButton = By.xpath("//*[@id=\"form-currency\"]/div/ul/li[2]/button");
    private By usButton = By.xpath("//*[@id=\"form-currency\"]/div/ul/li[3]/button");

    public CurrencySwitchingPage(WebDriver driver) {
        this.driver = driver;
    }

    public void loginToExistingAccount() {
        String expectedUrl = "https://awesomeqa.com/ui/index.php?route=account/account";
        
        driver.get("https://awesomeqa.com/ui/index.php?route=account/login");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("ramy.email@gmail.com");
        loginPage.enterPassword("Test123");
        loginPage.clickLogin();

    }

    public void switchToEuro() {
        driver.findElement(euroButton).click();
    }

    public void switchToPound() {
        driver.findElement(poundButton).click();
    }

    public void switchToDollar() {
        driver.findElement(usButton).click();
    }
}

