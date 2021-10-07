package com.epam.automation.googlecloud.tests;

import com.epam.automation.googlecloud.model.EmailEstimationForm;
import com.epam.automation.googlecloud.pages.GoogleCloudHomePage;
import com.epam.automation.googlecloud.service.EmailEstimationFormCreator;
import org.testng.annotations.Test;

public class EmailEstimationTest extends TestConfig {

    String inputText = "Google Cloud Platform Pricing Calculator";
    String amountOfInstances = "4";

    @Test
    public void compareTotalEstimatedMonthlyCost() {

        EmailEstimationForm testCredentials = EmailEstimationFormCreator.setCredentials();
        String actualPrice = new GoogleCloudHomePage(webDriver)
                .openPage()
                .fillSearchField(inputText)
                .followTheLinkToSearch()
                .switchToComputeEngineFrame()
                .fillInstancesField(amountOfInstances)
                .selectMachineSeries()
                .selectMachineType()
                .activateGpuCheckbox()
                .selectGpusQuantity()
                .selectGpusType()
                .selectSsdQuantity()
                .selectDatacenterRegion()
                .selectCommittedUsage()
                .pressAddToEstimateButton()
                .pressEmailEstimateButton()
                .openNewWindow()
                .switchToNewTab()
                .openPage()
                .getRandomEmail()
                .switchToPreviousTab()
                .switchToEmailFormFrame()
                .enterCredentials(testCredentials)
                .pasteGeneratedEmail()
                .pressSendButton()
                .switchToNewTab()
                .enterMailBox()
                .refreshMailBox()
                .findTotalEstimatedMonthlyCost();
        String expectedPrice = "USD 1,842.53";
        assertEquals(actualPrice, expectedPrice, "Total price values are not equal");
    }
}
