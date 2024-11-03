package com.example.ecommerce.tests;

import com.example.ecommerce.pages.ProductSearchPage;
import com.example.ecommerce.tests.BaseTest;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductSearchTest extends BaseTest {
    
    @Test(priority = 1)
    public void testSearchForExistingProduct() {
        ProductSearchPage productSearchPage = new ProductSearchPage(driver);
        
        productSearchPage.loginToExistingAccount();
        
        productSearchPage.enterSearchQuery("iphone");
        
        String resultMessage = productSearchPage.getSearchResultMessage();
        Assert.assertTrue(!resultMessage.contains("no product that matches"), "Product search returned no results for a valid product name.");
    }

    @Test(priority = 2)
    public void testSearchForNonExistentProduct() {
        ProductSearchPage productSearchPage = new ProductSearchPage(driver);
        
        productSearchPage.loginToExistingAccount();
        
        productSearchPage.enterSearchQuery("not exist");
        
        String resultMessage = productSearchPage.getSearchResultMessage();
        Assert.assertEquals(resultMessage, "There is no product that matches the search criteria.", "Expected 'no results' message was not displayed.");
    }

    @Test(priority = 3)
    public void testSearchWithEmptyInput() {
        ProductSearchPage productSearchPage = new ProductSearchPage(driver);
        
        productSearchPage.loginToExistingAccount();
        
        productSearchPage.enterSearchQuery("");
        
        String resultMessage = productSearchPage.getSearchResultMessage();
        Assert.assertEquals(resultMessage, "There is no product that matches the search criteria", "Expected 'empty search' error message was not displayed.");
    }
}