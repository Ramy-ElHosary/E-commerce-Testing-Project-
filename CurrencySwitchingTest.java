package com.example.ecommerce.tests;

import com.example.ecommerce.pages.CurrencySwitchingPage;
import com.example.ecommerce.tests.BaseTest;

import org.openqa.selenium.By;

import org.testng.annotations.Test;

import org.testng.Assert;

public class CurrencySwitchingTest extends BaseTest {

    @Test(priority = 1)
    public void testSwitchingToDollar() {
        CurrencySwitchingPage currencySwitchingPage = new CurrencySwitchingPage(driver);
        currencySwitchingPage.loginToExistingAccount();
        currencySwitchingPage.switchToDollar();

        String actualCurrency = driver.findElement(By.xpath("//*[@id=\"form-currency\"]/div/button/strong")).getText();
        String expectedCurrency = "$";
        Assert.assertEquals(actualCurrency, expectedCurrency, "Currency was not changed successfully.");
    }

    @Test(priority = 2)
    public void testSwitchingToPound() {
        CurrencySwitchingPage currencySwitchingPage = new CurrencySwitchingPage(driver);
        currencySwitchingPage.loginToExistingAccount();
        currencySwitchingPage.switchToPound();

        String actualCurrency = driver.findElement(By.xpath("//*[@id=\"form-currency\"]/div/button/strong")).getText();
        String expectedCurrency = "£";
        Assert.assertEquals(actualCurrency, expectedCurrency, "Currency was not changed successfully.");
    }

    @Test(priority = 3)
    public void testSwitchingToEuro() {
        CurrencySwitchingPage currencySwitchingPage = new CurrencySwitchingPage(driver);
        currencySwitchingPage.loginToExistingAccount();
        currencySwitchingPage.switchToEuro();

        String actualCurrency = driver.findElement(By.xpath("//*[@id=\"form-currency\"]/div/button/strong")).getText();
        String expectedCurrency = "€";
        Assert.assertEquals(actualCurrency, expectedCurrency, "Currency was not changed successfully.");
    }
}
