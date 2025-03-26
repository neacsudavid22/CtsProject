package cts.models;

import cts.enums.TipCompartiment;
import cts.enums.TipProdus;
import cts.exceptions.CompartimentPlinException;
import cts.interfaces.ICompartiment;

import java.util.List;

public class Compartiment implements ICompartiment {
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

    @Override
    public boolean adauga(Produs produs) {
        if (this.listaProduse.size() >= this.capacitate) {
            System.out.println("Capacitate depasita!");
        }
        else if(!this.verificaTip(produs))
            System.out.println("Acest tonomat primeste doar " + this.getTip());
        else {
            this.listaProduse.add(produs);
            return true;
        }
        return false;
    }

    @Override
    public void elimina(int id) {
        this.listaProduse.remove(id);
    }
    @Override
    public Produs getProdusById(int id){
        return this.listaProduse.get(id);
    }

    @Override
    public double getCostProdus(int id){
        try{
            Produs produs = this.getProdusById(id);
            return produs.getCost();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return 0;
    }

    @Override
    public boolean verificaTip(Produs produs) {
        if (produs.getTip() == TipProdus.idc)
            return true;
        if (produs.getTip() == TipProdus.cald && this.getTip() == TipCompartiment.produseCalde)
            return true;
        if (produs.getTip() == TipProdus.rece && this.getTip() == TipCompartiment.produseReci)
            return true;
        return false;
    }

    @Override
    public boolean verificaCapacitate() {
        return listaProduse.size() < this.capacitate;
    }

    @Override
    public void listeaza() {
        for (Produs produs : this.listaProduse) {
            System.out.println(produs.toString());
        }
    }

    @Override
    public void filtreazaProduseleDupaFurnizor(String furnizor) {
        for (Produs produs : this.listaProduse) {
            if (furnizor.equals(produs.getFurnizor()))
                System.out.println(produs.toString());
        }
    }

}
