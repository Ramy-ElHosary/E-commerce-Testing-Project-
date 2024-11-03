package com.example.ecommerce.tests;

import com.example.ecommerce.pages.ForgotPasswordPage;
import com.example.ecommerce.tests.BaseTest;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import org.testng.Assert;

public class ForgotPasswordTest extends BaseTest {

    @Test(priority = 10)
    public void testForgotPasswordSuccess() {
        driver.get("https://awesomeqa.com/ui/index.php?route=account/forgotten");
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);
        forgotPasswordPage.enterEmail("ramy.email@gmail.com");
        forgotPasswordPage.clickContinue();
        
        String expectedMessage = "An email with a confirmation link has been sent your email address.";
        String actualMessage = driver.findElement(By.xpath("//*[@id=\"account-login\"]/div[1]/text()")).getText();
        Assert.assertEquals(actualMessage, expectedMessage, "Forgot Password was not successful, text mismatch.");
    }

    @Test(priority = 11)
    public void testForgotPasswordUnexistedEmail() {
        driver.get("https://awesomeqa.com/ui/index.php?route=account/forgotten");
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);
        forgotPasswordPage.enterEmail("unexisted@gmail.com");
        forgotPasswordPage.clickContinue();
        
        String expectedMessage = "Warning: The E-Mail Address was not found in our records, please try again!";
        String actualMessage = driver.findElement(By.xpath("//*[@id=\"account-forgotten\"]/div[1]/text()")).getText();
        Assert.assertEquals(actualMessage, expectedMessage, "Forgot Password was not successful, text mismatch.");
    }
}
