package com.epam.automation.googlecloud.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverSingleton {

    private static WebDriver webDriver;

    private DriverSingleton() {
    }

    public static WebDriver getDriver() {
        if (null == webDriver) {
            if (System.getProperty("browser").equalsIgnoreCase("chrome")) {
                WebDriverManager.chromedriver().setup();
                webDriver = new ChromeDriver();
            }
            if (System.getProperty("browser").equalsIgnoreCase("MicrosoftEdge")) {
                WebDriverManager.edgedriver().setup();
                webDriver = new EdgeDriver();
            }
            if (System.getProperty("browser").equalsIgnoreCase("firefox")) {
                WebDriverManager.firefoxdriver().setup();
                webDriver = new FirefoxDriver();
            }
            webDriver.manage().window().maximize();
        }
        return webDriver;
    }

    public static void closeDriver() {
        webDriver.quit();
        webDriver = null;
    }
}
