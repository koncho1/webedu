package com.gui;

import com.gui.pages.desktop.HomePage;
import com.gui.pages.desktop.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchPageTest extends AbstractTest {

    @Test(groups = "group2")
    public void testSearchShirt(){
        HomePage homePage =new HomePage(getDriver());
        ProductsPage productsPage= homePage.searchKeyWord("Shirt");
        Assert.assertTrue(productsPage.isSearchTextCorrect("Shirt"));
    }

    @Test(groups = "group2")
    public void testUnsuccessfulSearch(){
        HomePage homePage =new HomePage(getDriver());
        ProductsPage productsPage= homePage.searchKeyWord("Apple");
        Assert.assertTrue(productsPage.isNoProductMessagePresent());
    }
}
