package com.example.ecommerce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductSearchPage {
    private WebDriver driver;

    private By searchBar = By.xpath("//*[@id=\"search\"]/input");
    private By searchButton = By.xpath("//*[@id=\"search\"]/span/button");
    private By searchResultMessage = By.xpath("//*[@id=\"content\"]/p[2]");
    
    public ProductSearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public void loginToExistingAccount() {
        driver.get("https://awesomeqa.com/ui/index.php?route=account/login");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("ramy.email@gmail.com");
        loginPage.enterPassword("Test123");
        loginPage.clickLogin();
    }

    public void enterSearchQuery(String query) {
        driver.findElement(searchBar).clear();
        driver.findElement(searchBar).sendKeys(query);
        driver.findElement(searchButton).click();
    }

    public String getSearchResultMessage() {
        return driver.findElement(searchResultMessage).getText();
    }
}
