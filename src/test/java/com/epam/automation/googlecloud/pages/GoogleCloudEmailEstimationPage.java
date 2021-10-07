package com.epam.automation.googlecloud.pages;

import com.epam.automation.googlecloud.model.EmailEstimationForm;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GoogleCloudEmailEstimationPage extends AbstractPage {

    @FindBy(xpath = "//input[@ng-model='emailQuote.user.firstname']")
    private WebElement firstNameField;

    @FindBy(xpath = "//input[@ng-model='emailQuote.user.lastname']")
    private WebElement lastNameField;

    @FindBy(xpath = "//input[@type='email']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@ng-model='appCtrl.CartData.projectName']")
    private WebElement projectNameField;

    @FindBy(xpath = "//button[@aria-label='Send Email']")
    private WebElement sendButton;

    public GoogleCloudEmailEstimationPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public GoogleCloudEmailEstimationPage switchToEmailFormFrame() {
        WebElement emailFormFrame = webDriver.findElements(By.tagName("iframe")).get(0);
        webDriver.switchTo().frame(emailFormFrame);
        webDriver.switchTo().frame("myFrame");
        new WebDriverWait(webDriver, Duration.ofSeconds(15));
        return this;
    }

    public GoogleCloudEmailEstimationPage pasteGeneratedEmail() {
        emailField.click();
        Action keyDown = new Actions(webDriver).keyDown(Keys.LEFT_CONTROL).sendKeys("v").build();
        keyDown.perform();
        new WebDriverWait(webDriver, Duration.ofSeconds(15));
        return this;
    }

    public GoogleCloudEmailEstimationPage enterCredentials(EmailEstimationForm emailEstimationForm) {
        firstNameField.click();
        firstNameField.sendKeys(emailEstimationForm.getFirstName());
        lastNameField.click();
        lastNameField.sendKeys(emailEstimationForm.getLastName());
        projectNameField.click();
        projectNameField.sendKeys(emailEstimationForm.getProjectName());
        return this;
    }

    public TabSwitcher pressSendButton() {
        sendButton.click();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        return new TabSwitcher(webDriver);
    }

    @Override
    public GoogleCloudEmailEstimationPage openPage() {
        throw new RuntimeException("This method is not supposed to be used here");
    }
}
