package com.epam.automation.googlecloud.tests;

import com.epam.automation.googlecloud.pages.GoogleCloudHomePage;
import org.testng.annotations.Test;

public class DatacenterRegionTest extends TestConfig {

    String inputText = "Google Cloud Platform Pricing Calculator";
    String amountOfInstances = "4";

    @Test
    public void compareDatacenterRegions() {
        String actualDatacenterRegion = new GoogleCloudHomePage(webDriver)
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
                .findDatacenterRegion();
        String expectedDatacenterRegion = "Region: Frankfurt";
        assertEquals(actualDatacenterRegion, expectedDatacenterRegion, "Datacenter region values are not equal");
    }
}
