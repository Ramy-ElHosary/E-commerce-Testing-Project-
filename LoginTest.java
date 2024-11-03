package com.example.ecommerce.tests;

import com.example.ecommerce.pages.LoginPage;
import com.example.ecommerce.tests.BaseTest;

import org.testng.annotations.Test;

import org.testng.Assert;

public class LoginTest extends BaseTest {

    @Test(priority = 1)
    public void testLoginSuccess() {
        String expectedUrl = "https://awesomeqa.com/ui/index.php?route=account/account";
        
        driver.get("https://awesomeqa.com/ui/index.php?route=account/login");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("ramy.email@gmail.com");
        loginPage.enterPassword("Test123");
        loginPage.clickLogin();
        
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "Login was not successful, URL mismatch.");
    }

    @Test(priority = 2)
    public void testLoginInvlidPassword() {
        String expectedUrl = "https://awesomeqa.com/ui/index.php?route=account/login";
      
        driver.get("https://awesomeqa.com/ui/index.php?route=account/login");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("invalidUser");
        loginPage.enterPassword("invalidPassword");
        loginPage.clickLogin();
    
        String actualUrl = driver.getCurrentUrl();
        
        Assert.assertEquals(actualUrl, expectedUrl, "Login was successful, expected not to log.");
    }

    @Test(priority = 3)
    public void testLoginInvlidEmail() {
        String expectedUrl = "https://awesomeqa.com/ui/index.php?route=account/login";
      
        driver.get("https://awesomeqa.com/ui/index.php?route=account/login");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("ramy.email@gmail.com");
        loginPage.enterPassword("invalidPassword");
        loginPage.clickLogin();
    
        String actualUrl = driver.getCurrentUrl();
        
        Assert.assertEquals(actualUrl, expectedUrl, "Login was successful, expected not to log.");
    }

}
