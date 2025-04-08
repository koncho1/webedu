package com.gui;

import com.gui.pages.desktop.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public abstract class AbstractTest {
    protected WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void setUpTest(){
        driver = new ChromeDriver();
        driver.get("https://automationteststore.com/");
    }

    @AfterMethod(alwaysRun = true)
    public void closeDriver(){
        driver.quit();
    }
}
