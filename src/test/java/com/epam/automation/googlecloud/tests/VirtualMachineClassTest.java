package com.epam.automation.googlecloud.tests;

import com.epam.automation.googlecloud.pages.GoogleCloudHomePage;
import org.testng.annotations.Test;

public class VirtualMachineClassTest extends TestConfig {

    String inputText = "Google Cloud Platform Pricing Calculator";
    String amountOfInstances = "4";

    @Test
    public void compareVirtualMachineClasses() {
        String actualVmClass = new GoogleCloudHomePage(webDriver)
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
                .findVmClass();
        String expectedVmClass = "VM class: regular";
        assertEquals(actualVmClass, expectedVmClass, "Virtual Machine class values are not equal");
    }
}
