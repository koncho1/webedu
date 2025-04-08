package com.gui.pages.common;

import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public abstract class AbstractPage {

    private static Logger logger = LoggerFactory.getLogger(AbstractPage.class);

    protected WebDriver driver;

    Wait<WebDriver> wait =
            new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(2))
                    .pollingEvery(Duration.ofMillis(300))
                    .ignoring(ElementNotInteractableException.class);

    public void clickElement(WebElement element){
        wait.until(driver->element.isDisplayed());
        element.click();
        logger.info("clicked {}",element);
    }

    public void sendKeysElement(WebElement element, String text){
        wait.until(driver->element.isDisplayed());
        element.sendKeys(text);
        logger.info("sent {} to {}",text,element);
    }

    public void submitElement(WebElement element){
        wait.until(driver->element.isDisplayed());
        element.submit();
        logger.info("submitted to {}", element);
    }

    public AbstractPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
}
