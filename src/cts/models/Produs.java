package cts.models;

import cts.enums.TipProdus;

public class Produs {
    private static int count = 0;
    private int id;
    private double cost;
    private String nume;
    private TipProdus tip;

    public Produs(double cost, String nume, TipProdus tip) {
        this.id = count++;
        this.cost = cost;
        this.nume = nume;
        this.tip = tip;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Produs.count = count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public TipProdus getTip() {
        return tip;
    }

    public void setTip(TipProdus tip) {
        this.tip = tip;
    }

    @Override
    public String toString() {
        return "Produs{" +
                "id=" + id +
                ", cost=" + cost +
                ", nume='" + nume + '\'' +
                ", tip=" + tip +
                '}';
    }
}
