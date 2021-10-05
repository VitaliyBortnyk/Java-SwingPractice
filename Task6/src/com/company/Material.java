package com.company;

import java.time.LocalDate;
import java.util.Scanner;
import java.io.Serializable;

public class Material implements Serializable, Comparable<Material> {

    private String name;
    private String provider;
    private String unitOfMeasurement;
    private LocalDate buyDate;
    private int year, month, day;
    private int amount;
    private double priceOfOne;
    private double cost;

    public Material()
    {
        name = "";
        provider = "";
        unitOfMeasurement = "";
        buyDate = null;
        year = 0;
        month = 0;
        day = 0;
        amount = 0;
        priceOfOne = 0;
        cost = 0;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getProvider() { return provider; }
    public void setProvider(String provider) { this.provider = provider; }

    public String getUnitOfMeasurement() { return unitOfMeasurement; }
    public void setUnitOfMeasurement(String unitOfMeasurement) { this.unitOfMeasurement = unitOfMeasurement; }

    public LocalDate getBuyDate() { return buyDate; }
    public void setBuyDate(LocalDate buyDate) { this.buyDate = buyDate; }

    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }

    public int getMonth() { return month; }
    public void setMonth(int month) { this.month = month; }

    public int getDay() { return day; }
    public void setDay(int day) { this.day = day; }

    public int getAmount() { return amount; }
    public void setAmount(int amount) { this.amount = amount; }

    public double getPriceOfOne() { return priceOfOne; }
    public void setPriceOfOne(double priceOfOne) { this.priceOfOne = priceOfOne; }

    public double getCost() { return cost; }

    public void Input()
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Назва метеріалу: ");
        name = sc.nextLine();

        System.out.print("Постачальник: ");
        provider = sc.nextLine();

        System.out.print("Одиниція виміру: ");
        unitOfMeasurement = sc.nextLine();

        System.out.println("Дата покупки:");
        System.out.print("День: ");
        day = sc.nextInt();
        System.out.print("Місяць: ");
        month = sc.nextInt();
        System.out.print("Рік: ");
        year = sc.nextInt();
        buyDate = LocalDate.of(year, month, day);

        System.out.print("Кількість: ");
        amount = sc.nextInt();

        System.out.print("Ціна за одиницю: ");
        priceOfOne = sc.nextDouble();

        cost = amount * priceOfOne;
    }

    public void Show()
    {
        System.out.printf("%-20s\t %-25s\t %-16s %-15s\t %-15s %-15s\t %-20s%n",
                name, provider, unitOfMeasurement, buyDate,  amount, priceOfOne, cost);
    }

    @Override
    public int compareTo(Material o) {
        return this.name.compareTo(o.name);
    }
}
