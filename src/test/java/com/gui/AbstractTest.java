package com.gui;

import com.gui.pages.desktop.HomePage;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.grid.Main;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import org.testng.xml.internal.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.net.PortProber;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public abstract class AbstractTest {
    protected static
    ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();

    protected URL startStandaloneGrid() {
        int port = PortProber.findFreePort();
        try {
            Main.main(
                    new String[] {
                            "standalone",
                            "--port",
                            String.valueOf(port),
                            "--selenium-manager",
                            "true",
                            "--enable-managed-downloads",
                            "true",
                            "--log-level",
                            "WARNING"
                    });
            return new URL("http://localhost:" + port);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }



    @BeforeMethod(alwaysRun = true)
    @Parameters(value = "browser")
    public void setUpTest(String browser){
        WebDriver driver=null;
        URL gridUrl=startStandaloneGrid();
        if(browser.equals("Chrome")){
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--no-sandbox");
            options.setEnableDownloads(true);
            driver = new RemoteWebDriver(gridUrl, options);
        } else if (browser.equals("Firefox")){
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--no-sandbox");
            options.setEnableDownloads(true);
            driver = new RemoteWebDriver(gridUrl, options);
        }
        driver.get("https://automationteststore.com/");
        threadLocalDriver.set(driver);


    }

    public static WebDriver getDriver(){
        return threadLocalDriver.get();
    }

    public static void takeScreenshot(WebDriver driver){
        TakesScreenshot takesScreenshot = (TakesScreenshot)driver;
        File file= takesScreenshot.getScreenshotAs(OutputType.FILE);


        try {
            FileUtils.copyFile(file, new File("./ScreenShot_Folder/test.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String title = driver.getTitle();
        System.out.println("Captured Screenshot for: " +title);

    }


    @AfterMethod(alwaysRun = true)
    public void closeDriver(){
        getDriver().quit();
        threadLocalDriver.remove();
    }
}
