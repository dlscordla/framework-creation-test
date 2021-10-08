package com.epam.automation.googlecloud.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MailBoxPage extends AbstractPage {

    private static final String MAILBOX_URL = "https://yopmail.com/";

    @FindBy(xpath = "//a[@href='email-generator']")
    private WebElement emailGeneratorLink;

    @FindBy(xpath = "//button[@id='cprnd']")
    private WebElement copyEmailButton;

    @FindBy(xpath = "/html/body/div/div[2]/main/div/div[2]/div/div/div[2]/button[2]")
    private WebElement enterMailBoxButton;

    @FindBy(xpath = "//button[@id='refresh']")
    private WebElement refreshButton;

    @FindBy(xpath = "//td/h3[contains(text(),'USD')]")
    private WebElement totalEstimatedMonthlyCost;

    public MailBoxPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    @Override
    public MailBoxPage openPage() {
        webDriver.get(MAILBOX_URL);
        logger.info(MAILBOX_URL + " page opened.");
        return this;
    }

    public TabSwitcher getRandomEmail() {
        emailGeneratorLink.click();
        copyEmailButton.click();
        logger.info("Random e-mail generated and copied to clipboard.");
        return new TabSwitcher(webDriver);
    }

    public MailBoxPage enterMailBox() {
        enterMailBoxButton.click();
        logger.info("Entered to mailbox.");
        return this;
    }

    public MailBoxPage refreshMailBox() throws InterruptedException {
        Thread.sleep(5000);
        refreshButton.click();
        webDriver.switchTo().frame(webDriver.findElement(By.id("ifmail")));
        new WebDriverWait(webDriver, Duration.ofSeconds(30))
                .until(ExpectedConditions.visibilityOfElementLocated(By
                        .xpath("//td/h3[contains(text(),'USD')]")));
        logger.info("Received the total cost value.");
        return this;
    }

    public String findTotalEstimatedMonthlyCost() {
        return totalEstimatedMonthlyCost.getText();
    }
}
