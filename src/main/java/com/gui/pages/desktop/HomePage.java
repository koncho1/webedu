
package com.gui.pages.desktop;

import java.lang.invoke.MethodHandles;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class HomePage {

    protected WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy (id="filter_keyword")
    private WebElement searchField;

    @FindBy (xpath = "//i[contains(@class, 'fa fa-search')]")
    private WebElement searchButton;


    public ProductsPage searchKeyWord(String keyword){
        searchField.click();
        searchField.sendKeys(keyword);
        searchButton.click();
         return new ProductsPage(driver);
    }





}
