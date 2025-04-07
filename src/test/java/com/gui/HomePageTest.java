
package com.gui;

import com.gui.pages.desktop.HomePage;
import com.gui.pages.desktop.ProductsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class HomePageTest  {
    WebDriver driver = new ChromeDriver();

    @Test
    public void test(){
        driver.get("https://automationteststore.com/");
        HomePage homePage =new HomePage(driver);
        ProductsPage productsPage= homePage.searchKeyWord("shirt");
        productsPage.printAllItems();
    }


}
