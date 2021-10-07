package com.epam.automation.googlecloud.tests;

import com.epam.automation.googlecloud.pages.GoogleCloudHomePage;
import org.testng.annotations.Test;

public class InstanceTypeTest extends TestConfig {

    String inputText = "Google Cloud Platform Pricing Calculator";
    String amountOfInstances = "4";

    @Test
    public void compareInstanceTypes() {
        String actualInstanceType = new GoogleCloudHomePage(webDriver)
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
                .findInstanceType();
        String expectedInstanceType = "Instance type: n1-standard-8\n" +
                "Committed Use Discount applied";
        assertEquals(actualInstanceType, expectedInstanceType,"Instance type values are not equal");
    }
}
