package cts.models;

import cts.enums.TipCardBancar;
import cts.exceptions.SoldInsuficientException;
import cts.interfaces.IContBancar;

public class ContBancar implements IContBancar {
    private static int count = 0;
    private int id;
    private String proprietar;
    private String numar;
    private double sold;
    private TipCardBancar tip;
    private int pin;

    public ContBancar(String proprietar, String numar, TipCardBancar tip, int pin) {
        this.id = count++;
        this.proprietar = proprietar;
        this.numar = numar;
        this.sold = 100;
        this.tip = tip;
        this.pin = pin;
    }
    public int getPin() {
        return pin;
    }

    public String getNumar() {
        return numar;
    }

    public static int getCount() {
        return count;
    }

    public int getId() {
        return id;
    }

    public String getProprietar() {
        return proprietar;
    }

    public void setProprietar(String nume) {
        this.proprietar = nume;
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
    public Boolean platesteProdus(double cost) {
        if (this.sold >= cost) {
            this.sold -= cost;
            return true;
        }
        System.out.println("Sold insuficient, nu s-a putut efectua plata.");
        return false;
    }

    @Override
    public Boolean colectareSuma(double suma) {
        if (suma > 0) {
            this.sold += suma;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "ContBancar{" +
                "id=" + id +
                ", proprietar='" + proprietar + '\'' +
                ", numar=" + numar +
                ", sold=" + sold +
                ", tip=" + tip +
                '}';
    }
}
