package cts.models;

import cts.interfaces.ITonomat;

public class Tonomat implements ITonomat {
    private static int count = 0;
    int id;
    Compartiment compartiment;
    double sold;
    String locatie;
    public static SingletonContBancar contFirma = SingletonContBancar.getInstance();

    public Tonomat(Compartiment compartiment, double sold, String locatie) {
        this.id = count++;
        this.compartiment = compartiment;
        this.sold = sold;
        this.locatie = locatie;
    }

    public static int getCount() {
        return count;
    }

    public int getId() {
        return id;
    }

    public Compartiment getCompartiment() {
        return compartiment;
    }

    public void setCompartiment(Compartiment compartiment) {
        this.compartiment = compartiment;
    }

    public double getSold() {
        return sold;
    }

    public String getLocatie() {
        return locatie;
    }

    public void setLocatie(String locatie) {
        this.locatie = locatie;
    }

    @Override
    public void adaugaProdus(Produs produs) {
        this.compartiment.adauga(produs);
    }

    @Override
    public void eliminaProdus(int idProdus) {
        this.compartiment.elimina(idProdus);
    }

    @Override
    public void vindeProdus(int idProdus, ContBancar contBancar) {


    }

    @Override
    public void primirePlata(ContBancar contBancar, double cost) {
        if (contBancar.platesteProdus(cost)) {
            contFirma.colectareSuma(cost);
            System.out.println("Plată efectuată cu succes.");
        } else {
            System.out.println("Fonduri insuficiente.");
        }
    }

    @Override
    public void mutaProdus(int idProdus, Tonomat tonomat) {

    }

    @Override
    public void filtrareProduseDupaFurnizor(String furnizor) {
        this.compartiment.filtreazaProduseleDupaFurnizor(furnizor);
    }

    @Override
    public void listareProduse() {
        this.compartiment.listeaza();
    }

    @Override
    public String toString() {
        return "Tonomat{" +
                "id=" + id +
                ", compartiment=" + compartiment +
                ", sold=" + sold +
                ", locatie='" + locatie + '\'' +
                '}';
    }
}
