package com.company;

import java.io.Serializable;

public class People implements Serializable {
    private String lastName;
    private String firstName;

    public People(String lastName, String firstName) {
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String toString() {
        return "Прізвище: '" + this.lastName + "', Ім'я: '" + this.firstName + "'";
    }
}
