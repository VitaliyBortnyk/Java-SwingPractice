package com.company;

import java.io.Serializable;

public class Seller extends People implements Serializable {
    private int experience;

    public Seller(String lastName, String firstName, int experience) {
        super(lastName, firstName);
        this.experience = experience;
    }

    public int getExperience() {
        return experience;
    }
    public void setExperience(int experience) {
        this.experience = experience;
    }

    @Override
    public String toString() {
        return "Прізвище: '" + this.getLastName() + "', Ім'я: '" + this.getFirstName() + "', Стаж: '" + this.experience + "'";
    }
}
