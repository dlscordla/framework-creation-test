package com.epam.automation.googlecloud.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class GoogleCloudHomePage extends AbstractPage {

    private static final String HOMEPAGE_URL = "https://cloud.google.com/";

    @FindBy(xpath = "//input[@name='q']")
    private WebElement searchButton;

    public GoogleCloudHomePage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public GoogleCloudHomePage openPage() {
        webDriver.get(HOMEPAGE_URL);
        logger.info(HOMEPAGE_URL + " page opened.");
        return this;
    }

    public GoogleCloudSearchPage fillSearchField(String inputText) {
        searchButton.sendKeys(inputText);
        searchButton.sendKeys(Keys.ENTER);
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        logger.info("Proceeded to the search page.");
        return new GoogleCloudSearchPage(webDriver);
    }
}