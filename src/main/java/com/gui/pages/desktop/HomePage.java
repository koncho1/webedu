
package com.gui.pages.desktop;

import java.lang.invoke.MethodHandles;
import java.util.List;
import java.util.Objects;

import com.gui.pages.common.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class HomePage extends AbstractPage {

    public HomePage(WebDriver driver){
        super(driver);
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy (id="filter_keyword")
    private WebElement searchField;

    @FindBy (xpath = "//i[contains(@class, 'fa fa-search')]")
    private WebElement searchButton;

    @FindBy(xpath = "//ul[contains(@class, 'dropdown-menu currency')]")
    private List<WebElement> currencyList;

    @FindBy (xpath = "//span[contains(@class, 'cart_total')]")
    private WebElement cartTotalText;

    @FindBy(xpath = "//a[contains(@class, 'dropdown-toggle')]")
    private WebElement currencySelector;

    @FindBy (xpath = "//i[contains(@class, 'fa fa-cart-plus fa-fw')]")
    private WebElement addToCartButton;

    @FindBy (xpath = "//div[contains(@class, 'block_7')]//span[contains(@class , 'label label-orange font14')]")
    private WebElement cartItemCountLabel;

    public boolean isCartTotalCorrect(String correctCartTotal){
        return Objects.equals(cartTotalText.getText(),correctCartTotal);
    }

    public void clickCurrencySelector(){
        currencySelector.click();
    }

    public void clickItemInCurrencySelector(Integer item){
        currencyList.get(item).click();
    }


    public boolean isCartItemCountCorrect(String correctItemCount){
        return Objects.equals(cartItemCountLabel.getText(), correctItemCount);
    }


    public void clickAddToCartButton(){
        super.clickElement(addToCartButton);
    }


    public boolean isCurrencyInCartCorrect(String currencySign){
        return cartTotalText.getText().contains(currencySign);
    }

    public ProductsPage searchKeyWord(String keyword){
        super.clickElement(searchField);
        super.sendKeysElement(searchField,keyword);
        super.clickElement(searchButton);
        return new ProductsPage(driver);
    }





}
