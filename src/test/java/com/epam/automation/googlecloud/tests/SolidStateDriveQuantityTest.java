package com.epam.automation.googlecloud.tests;

import com.epam.automation.googlecloud.pages.GoogleCloudHomePage;
import org.testng.annotations.Test;

public class SolidStateDriveQuantityTest extends TestConfig {

    String inputText = "Google Cloud Platform Pricing Calculator";
    String amountOfInstances = "4";

    @Test
    public void compareSolidStateDriveQuantities() {
        String actualSsdQuantity = new GoogleCloudHomePage(webDriver)
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
                .findLocalSsd();
        String expectedSsdQuantity = "Local SSD: 2x375 GiB\n" +
                "Committed Use Discount applied";
        assertEquals(actualSsdQuantity, expectedSsdQuantity, "SSD values are not equal");
    }
}
