package com.epam.automation.googlecloud.model;

import java.util.Objects;

public class EmailEstimationForm {

    private String firstName;
    private String lastName;
    private String projectName;

    public EmailEstimationForm(String firstName, String lastName, String projectName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.projectName = projectName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    @Override
    public String toString() {
        return "EmailEstimationForm{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", projectName='" + projectName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmailEstimationForm)) return false;
        EmailEstimationForm that = (EmailEstimationForm) o;
        return Objects.equals(firstName, that.firstName)
                && Objects.equals(lastName, that.lastName)
                && Objects.equals(projectName, that.projectName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, projectName);
    }
}
