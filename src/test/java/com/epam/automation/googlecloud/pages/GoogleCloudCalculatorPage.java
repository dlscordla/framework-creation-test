package com.epam.automation.googlecloud.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleCloudCalculatorPage extends AbstractPage {

    public GoogleCloudCalculatorPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(id = "input_71")
    private WebElement instanceId;

    @FindBy(xpath = "//md-select[@id='select_96']")
    private WebElement seriesDropdown;

    @FindBy(xpath = "//md-option[@id='select_option_208']")
    private WebElement seriesType;

    @FindBy(xpath = "//md-select[@placeholder='Instance type']")
    private WebElement machineTypeDropdown;

    @FindBy(xpath = "//md-option[@value='CP-COMPUTEENGINE-VMIMAGE-N1-STANDARD-8']")
    private WebElement machineType;

    @FindBy(xpath = "//md-checkbox[@aria-label='Add GPUs']")
    private WebElement gpuCheckbox;

    @FindBy(xpath = "//md-select[@placeholder='Number of GPUs']")
    private WebElement gpusQuantityDropdown;

    @FindBy(xpath = "//md-option[@id='select_option_443']")
    private WebElement gpusQuantity;

    @FindBy(xpath = "//md-select[@placeholder='GPU type']")
    private WebElement gpusTypeDropdown;

    @FindBy(xpath = "//md-option[@value='NVIDIA_TESLA_T4']")
    private WebElement gpusType;

    @FindBy(xpath = "//md-select[@placeholder='Local SSD']")
    private WebElement ssdQuantityDropdown;

    @FindBy(xpath = "//md-option[@id='select_option_425']")
    private WebElement ssdQuantity;

    @FindBy(xpath = "//md-select[@placeholder='Datacenter location']")
    private WebElement datacenterRegionDropdown;

    @FindBy(xpath = "//md-option[@id='select_option_225']")
    private WebElement datacenterRegion;

    @FindBy(xpath = "//md-select[@placeholder='Committed usage']")
    private WebElement committedUsageDropdown;

    @FindBy(xpath = "//md-option[@id='select_option_106']")
    private WebElement committedUsage;

    @FindBy(xpath = "//button[@aria-label='Add to Estimate']")
    private WebElement addToEstimateButton;

    @FindBy(xpath = "//button[@aria-label='Email Estimate']")
    private WebElement emailEstimateButton;

    @FindBy(xpath = "//*[@id='compute']/md-list/md-list-item[4]/div")
    private WebElement virtualMachineClass;

    @FindBy(xpath = "//*[@id='compute']/md-list/md-list-item[5]/div[1]")
    private WebElement instanceType;

    @FindBy(xpath = "//*[@id='compute']/md-list/md-list-item[1]/div")
    private WebElement region;

    @FindBy(xpath = "//*[@id='compute']/md-list/md-list-item[8]/div[1]")
    private WebElement ssd;

    @FindBy(xpath = "//*[@id='compute']/md-list/md-list-item[3]/div")
    private WebElement term;

    public GoogleCloudCalculatorPage switchToComputeEngineFrame() {
        WebElement computeEngineFrame = webDriver.findElements(By.tagName("iframe")).get(0);
        webDriver.switchTo().frame(computeEngineFrame);
        webDriver.switchTo().frame("myFrame");
        logger.info("Switched to Compute Engine frame.");
        return this;
    }

    public GoogleCloudCalculatorPage fillInstancesField(String amountOfInstances) {
        instanceId.sendKeys(amountOfInstances);
        logger.info("Entered amount of Instances.");
        return this;
    }

    public GoogleCloudCalculatorPage selectMachineSeries() {
        seriesDropdown.click();
        seriesType.sendKeys(Keys.ENTER);
        logger.info("Selected Machine series.");
        return this;
    }

    public GoogleCloudCalculatorPage selectMachineType() {
        machineTypeDropdown.click();
        machineType.sendKeys(Keys.ENTER);
        logger.info("Selected Machine type.");
        return this;
    }

    public GoogleCloudCalculatorPage activateGpuCheckbox() {
        gpuCheckbox.click();
        logger.info("Add GPU's checkbox activated.");
        return this;
    }

    public GoogleCloudCalculatorPage selectGpusQuantity() {
        gpusQuantityDropdown.click();
        gpusQuantity.sendKeys(Keys.ENTER);
        logger.info("Selected GPU's quantity.");
        return this;
    }

    public GoogleCloudCalculatorPage selectGpusType() {
        gpusTypeDropdown.click();
        gpusType.sendKeys(Keys.ENTER);
        logger.info("Selected GPU's type.");
        return this;
    }

    public GoogleCloudCalculatorPage selectSsdQuantity() {
        ssdQuantityDropdown.click();
        ssdQuantity.sendKeys(Keys.ENTER);
        logger.info("Selected SSD quantity.");
        return this;
    }

    public GoogleCloudCalculatorPage selectDatacenterRegion() {
        datacenterRegionDropdown.click();
        datacenterRegion.sendKeys(Keys.ENTER);
        logger.info("Selected Datacenter region.");
        return this;
    }

    public GoogleCloudCalculatorPage selectCommittedUsage() {
        committedUsageDropdown.click();
        committedUsage.sendKeys(Keys.ENTER);
        logger.info("Selected Committed usage.");
        return this;
    }

    public GoogleCloudCalculatorPage pressAddToEstimateButton() {
        addToEstimateButton.click();
        logger.info("Added to Estimate.");
        return this;
    }

    public TabSwitcher pressEmailEstimateButton() {
        emailEstimateButton.click();
        logger.info("Email Estimation Form opened.");
        return new TabSwitcher(webDriver);
    }

    public String findVmClass() {
        return virtualMachineClass.getText();
    }

    public String findInstanceType() {
        return instanceType.getText();
    }

    public String findDatacenterRegion() {
        return region.getText();
    }

    public String findLocalSsd() {
        return ssd.getText();
    }

    public String findCommitmentTerm() {
        return term.getText();
    }

    @Override
    public GoogleCloudCalculatorPage openPage() {
        throw new RuntimeException("This method is not supposed to be used here");
    }
}
