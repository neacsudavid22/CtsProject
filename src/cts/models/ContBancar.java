package cts.models;

import cts.enums.TipCardBancar;

public class ContBancar {
    private static int count = 0;
    private int id;
    private String nume;
    private double sold;
    private TipCardBancar tip;

    public ContBancar(String nume, double sold, TipCardBancar tip) {
        this.id = count++;
        this.nume = nume;
        this.sold = sold;
        this.tip = tip;
    }

    public static int getCount() {
        return count;
    }

    public int getId() {
        return id;
    }


    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public double getSold() {
        return sold;
    }

    public void setSold(double sold) {
        this.sold = sold;
    }

    public TipCardBancar getTip() {
        return tip;
    }

    public void setTip(TipCardBancar tip) {
        this.tip = tip;
    }

    @Override
    public String toString() {
        return "ContBancar{" +
                "id=" + id +
                ", nume='" + nume + '\'' +
                ", sold=" + sold +
                ", tip=" + tip +
                '}';
    }
}
