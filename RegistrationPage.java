package com.example.ecommerce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {
    private WebDriver driver;

    private By firstNameField = By.id("input-firstname");
    private By lastNameField = By.id("input-lastname");
    private By emailField = By.id("input-email");
    private By telephoneField = By.id("input-telephone");
    private By passwordField = By.id("input-password");
    private By passwordConfirmationField = By.id("input-confirm");
    private By privacyPolicyButton = By.xpath("//*[@id=\"content\"]/form/div/div/input[1]");


    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterFirstName(String firstName) {
        driver.findElement(firstNameField).sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        driver.findElement(lastNameField).sendKeys(lastName);
    }

    public void enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }
    
    public void enterTelephone(String telephone) {
        driver.findElement(telephoneField).sendKeys(telephone);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }
    
    public void enterConfirmation(String password) {
        driver.findElement(passwordConfirmationField).sendKeys(password);
    }

    public void clickPolicyButton() {
        driver.findElement(privacyPolicyButton).click();
    }
}