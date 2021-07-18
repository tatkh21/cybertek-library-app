package com.cybertek.library.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Driver {
    private Driver(){
    }
    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            String browserType = ConfigurationReader.getProperty("browser");
            /*
            Depending on the browser type our switch statment will determine to
            open specific type of browser/driver
             */
            switch (browserType) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
            }
        }
        // Same driver instance will be returned every time we call Driver.getDriver();method
        return driver;
    }
    /*

     */
    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
