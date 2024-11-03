package com.example.ecommerce.tests;

import com.example.ecommerce.pages.RegistrationPage;
import com.example.ecommerce.tests.BaseTest;

import org.testng.annotations.Test;

import org.testng.Assert;

public class RegistrationTest extends BaseTest {
    
    @Test(priority = 1)
    public void testRegistrationSuccess() {
        driver.get("https://awesomeqa.com/ui/index.php?route=account/register");
        RegistrationPage registerPage = new RegistrationPage(driver);

        registerPage.enterFirstName("Ramy");
        registerPage.enterLastName("Hosary");
        registerPage.enterEmail("ramy.automation@gmail.com");
        registerPage.enterTelephone("+201066120055");
        registerPage.enterPassword("Test123");
        registerPage.enterConfirmation("Test123");
        registerPage.clickPolicyButton();

        String expectedURL = "https://awesomeqa.com/ui/index.php?route=account/account";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(expectedURL, actualURL, "Registartion was not successful, URL mismatch.");
    }

    @Test(priority = 2)
    public void testRegistrationExitedEmail() {
        driver.get("https://awesomeqa.com/ui/index.php?route=account/register");
        RegistrationPage registerPage = new RegistrationPage(driver);

        registerPage.enterFirstName("Ramy");
        registerPage.enterLastName("Hosary");
        registerPage.enterEmail("ramy.automation@gmail.com");
        registerPage.enterTelephone("+201066120055");
        registerPage.enterPassword("Test123");
        registerPage.enterConfirmation("Test123");
        registerPage.clickPolicyButton();

        String expectedURL = "https://awesomeqa.com/ui/index.php?route=account/register";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(expectedURL, actualURL, "Registartion was successful, URL mismatch.");
    }

    @Test(priority = 3)
    public void testRegistrationPasswordLessThanLength() {
        driver.get("https://awesomeqa.com/ui/index.php?route=account/register");
        RegistrationPage registerPage = new RegistrationPage(driver);

        registerPage.enterFirstName("Ramy");
        registerPage.enterLastName("Hosary");
        registerPage.enterEmail("ramy.lessPassword@gmail.com");
        registerPage.enterTelephone("+201066120055");
        registerPage.enterPassword("1");
        registerPage.enterConfirmation("1");
        registerPage.clickPolicyButton();

        String expectedURL = "https://awesomeqa.com/ui/index.php?route=account/register";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(expectedURL, actualURL, "Registartion was successful, URL mismatch.");
    }
    
    @Test(priority = 4)
    public void testRegistrationPasswordMoreThanLength() {
        driver.get("https://awesomeqa.com/ui/index.php?route=account/register");
        RegistrationPage registerPage = new RegistrationPage(driver);

        registerPage.enterFirstName("Ramy");
        registerPage.enterLastName("Hosary");
        registerPage.enterEmail("ramy.morePasswordLength@gmail.com");
        registerPage.enterTelephone("+201066120055");
        registerPage.enterPassword("MoreThanTwentyCharacters");
        registerPage.enterConfirmation("MoreThanTwentyCharacters");
        registerPage.clickPolicyButton();

        String expectedURL = "https://awesomeqa.com/ui/index.php?route=account/register";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(expectedURL, actualURL, "Registartion was successful, URL mismatch.");
    }
}