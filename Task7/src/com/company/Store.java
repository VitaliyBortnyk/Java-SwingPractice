package com.company;

import java.io.Serializable;
import java.util.ArrayList;

public class Store implements Serializable{
    private int storeN;
    private String city;
    private ArrayList<Seller> sellers = new ArrayList<>();

    public Store(int storeN, String city, Seller seller) {
        this.storeN = storeN;
        this.city = city;
        this.sellers.add(seller);
    }

    public int getStoreN() {
        return storeN;
    }
    public void setStoreN(int storeN) {
        this.storeN = storeN;
    }

    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }

    public ArrayList<Seller> getSellers() {
        return sellers;
    }
    public void setSellers(Seller sellers) {
        this.sellers.add(sellers);
    }

    public void EditStore(int storeN, String city) {
        this.storeN = storeN;
        this.city = city;
    }

    @Override
    public String toString() {
        return "Магазин №: '" + this.storeN + "', Місто: '" + this.city +
                "', Кількість продавців: '" + this.sellers.size() + " '";
    }
}
