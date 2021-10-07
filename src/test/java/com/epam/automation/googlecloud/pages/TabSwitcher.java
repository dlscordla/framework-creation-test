package com.epam.automation.googlecloud.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class TabSwitcher extends AbstractPage {

    ArrayList<String> tabs;

    public TabSwitcher(WebDriver webDriver) {
        super(webDriver);
    }

    public TabSwitcher openNewWindow() {
        ((JavascriptExecutor) webDriver).executeScript("window.open();");
        logger.info("New tab opened.");
        return this;
    }

    public MailBoxPage switchToNewTab() {
        tabs = new ArrayList<>(webDriver.getWindowHandles());
        webDriver.switchTo().window(tabs.get(1));
        logger.info("Switched to new tab.");
        return new MailBoxPage(webDriver);
    }

    public GoogleCloudEmailEstimationPage switchToPreviousTab() {
        tabs = new ArrayList<>(webDriver.getWindowHandles());
        webDriver.switchTo().window(tabs.get(0));
        logger.info("Switched to previous tab.");
        return new GoogleCloudEmailEstimationPage(webDriver);
    }

    @Override
    public TabSwitcher openPage() {
        throw new RuntimeException("This method is not supposed to be used here");
    }
}
