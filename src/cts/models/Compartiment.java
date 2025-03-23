package cts.models;

import cts.enums.TipCompartiment;

import java.util.List;

public class Compartiment {
    List<Produs> listaProduse;
    int capacitate;
    TipCompartiment tip;

    public Compartiment(List<Produs> listaProduse, int capacitate, TipCompartiment tip) {
        this.listaProduse = listaProduse;
        this.capacitate = capacitate;
        this.tip = tip;
    }

    public List<Produs> getListaProduse() {
        return listaProduse;
    }

    public void setListaProduse(List<Produs> listaProduse) {
        this.listaProduse = listaProduse;
    }

    public int getCapacitate() {
        return capacitate;
    }

    public void setCapacitate(int capacitate) {
        this.capacitate = capacitate;
    }

    public TipCompartiment getTip() {
        return tip;
    }

    public void setTip(TipCompartiment tip) {
        this.tip = tip;
    }

    @Override
    public String toString() {
        return "Compartiment{" +
                "listaProduse=" + listaProduse +
                ", capacitate=" + capacitate +
                ", tip=" + tip +
                '}';
    }
}
