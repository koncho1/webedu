package com.gui.pages.desktop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductsPage {
    protected WebDriver driver;

    @FindBy (xpath = "//div[contains(@class, 'thumbnails grid row list-inline')]//a[contains(@class, 'prdocutname')]")
    private List<WebElement> itemContainerList;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void printAllItems(){
        for (WebElement item : itemContainerList){
            System.out.println(item.getText());
        }
    }
}
