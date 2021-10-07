package com.epam.automation.googlecloud.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleCloudSearchPage extends AbstractPage {

    @FindBy(linkText = "Google Cloud Platform Pricing Calculator")
    private WebElement link;

    public GoogleCloudSearchPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public GoogleCloudCalculatorPage followTheLinkToSearch() {
        link.click();
        logger.info("Google Cloud Platform Pricing Calculator page opened.");
        return new GoogleCloudCalculatorPage(webDriver);
    }

    @Override
    public GoogleCloudEmailEstimationPage openPage() {
        throw new RuntimeException("This method is not supposed to be used here");
    }
}
