package com.company;

import java.io.Serializable;

public class Purchase implements Serializable, Comparable<Purchase> {
    private int id;
    private double totalCost;
    private Store store;
    private Seller seller;

    public Purchase(int id, double totalCost, Store store, Seller seller) {
        this.id = id;
        this.totalCost = totalCost;
        this.store = store;
        this.seller = seller;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    @Override
    public int compareTo(Purchase o) {
        return Double.compare(this.totalCost, o.totalCost);
    }

    @Override
    public String toString() {
        return "ID: '" + this.id + "', Сума покупки: '" + this.totalCost + "'";
    }
}
