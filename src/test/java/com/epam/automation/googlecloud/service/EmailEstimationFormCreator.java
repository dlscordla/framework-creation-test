package com.epam.automation.googlecloud.service;

import com.epam.automation.googlecloud.model.EmailEstimationForm;

public class EmailEstimationFormCreator {

    public static final String TEST_DATA_FIRST_NAME = "testdata.emailform.firstname";
    public static final String TEST_DATA_LAST_NAME = "testdata.emailform.lastname";
    public static final String TEST_DATA_PROJECT_NAME = "testdata.emailform.projectname";

    public static EmailEstimationForm setCredentials() {
        return new EmailEstimationForm(
                TestDataReader
                        .getTestData(TEST_DATA_FIRST_NAME),
                TestDataReader
                        .getTestData(TEST_DATA_LAST_NAME),
                TestDataReader
                        .getTestData(TEST_DATA_PROJECT_NAME)
        );
    }
}
