package com.epam.automation.googlecloud.tests;

import com.epam.automation.googlecloud.pages.GoogleCloudHomePage;
import org.testng.annotations.Test;

public class CommitmentTermTest extends TestConfig {

    String inputText = "Google Cloud Platform Pricing Calculator";
    String amountOfInstances = "4";

    @Test
    public void compareCommitmentTerms() {
        String actualTerm = new GoogleCloudHomePage(webDriver)
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
                .findCommitmentTerm();
        String expectedTerm = "Commitment term: 1 Year";
        assertEquals(actualTerm, expectedTerm, "Commitment term values are not equal");
    }
}
