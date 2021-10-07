package com.epam.automation.googlecloud.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public abstract class AbstractPage {

    static final Logger logger = LogManager.getRootLogger();

    public WebDriver webDriver;

    public AbstractPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public abstract AbstractPage openPage();
}
