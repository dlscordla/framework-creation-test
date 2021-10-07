package com.epam.automation.googlecloud.tests;

import com.epam.automation.googlecloud.driver.DriverSingleton;
import com.epam.automation.googlecloud.utils.TestListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Listeners({TestListener.class})
public class TestConfig extends Assert {

    static final Logger logger = LogManager.getRootLogger();

    protected WebDriver webDriver;

    @BeforeMethod()
    public void setUp() {
        webDriver = DriverSingleton.getDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void stopBrowser() {
        DriverSingleton.closeDriver();
    }
}
