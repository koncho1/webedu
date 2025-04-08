
package com.gui;

import com.gui.pages.desktop.HomePage;
import com.gui.pages.desktop.ProductsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class HomePageTest extends AbstractTest {

    @Test
    public void test(){
        HomePage homePage =new HomePage(driver);
        ProductsPage productsPage= homePage.searchKeyWord("shirt");
        productsPage.printAllItems();
    }

    @Test(groups = "group1")
    public void testCurrencyChange() {
        HomePage homePage =new HomePage(driver);
        homePage.clickCurrencySelector();
        homePage.clickItemInCurrencySelector(0); //chooses the pound currency
        Assert.assertTrue(homePage.isCurrencyInCartCorrect("£"));
    }

    @Test(groups = "group1")
    public void testCartItemCount(){
        HomePage homePage =new HomePage(driver);
        homePage.clickAddToCartButton();
        homePage.clickAddToCartButton();
        homePage.clickAddToCartButton();
        Assert.assertTrue(homePage.isCartItemCountCorrect("3"));
    }

    @Test(groups = "group1")
    public void testCartTotal(){
        HomePage homePage =new HomePage(driver);
        homePage.clickAddToCartButton();
        Assert.assertTrue(homePage.isCartTotalCorrect("$29.50"));
    }




}
