package cts.models;

import cts.enums.TipProdus;

public class Produs {
    private static int count = 0;
    private final int id;
    private double cost;
    private String nume;
    private String furnizor;
    private TipProdus tip;

    public Produs(double cost, String nume, String furnizor, TipProdus tip) {
        this.id = count++;
        this.cost = cost;
        this.nume = nume;
        this.furnizor = furnizor;
        this.tip = tip;
    }

    public String getFurnizor() {
        return furnizor;
    }

    public void setFurnizor(String furnizor) {
        this.furnizor = furnizor;
    }

    public static int getCount() {
        return count;
    }

    public int getId() {
        return id;
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
        return "id: " + id +
                ", cost: " + cost +
                ", nume: '" + nume +
                ", furnizor: '" + furnizor +
                ", tip: " + tip + "\n";
    }
}
