package cts.models;

import cts.interfaces.ITonomat;

public class Tonomat implements ITonomat {
    private static int count = 0;
    private int id;
    private Compartiment compartiment;
    private double sold;
    private String locatie;
    private static final SingletonContBancar contFirma = SingletonContBancar.getInstance();

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
    public boolean adaugaProdus(Produs produs) {
        return this.compartiment.adauga(produs);
    }

    @Override
    public void vindeProdus(int idProdus, ContBancar contBancar) {
        if(this.primirePlata(contBancar, this.compartiment.getCostProdus(idProdus))) {
            this.compartiment.elimina(idProdus);
        }
        else System.out.println("Produsul nu a putut fi eliminat din Tonomat");
    }

    @Override
    public boolean primirePlata(ContBancar contBancar, double cost) {
        if(cost <= 0){
            System.out.println("Probleme la furnizarea costului produsului.");
            return false;
        }
        if (contBancar.platesteProdus(cost)) {
            contFirma.colectareSuma(cost);

            System.out.println("Plată efectuată cu succes.");
            return true;
        }
        System.out.println("Fonduri insuficiente.");
        return false;
    }

    @Override
    public void mutaProdus(int idProdus, Tonomat tonomat) {
        try{
            Produs produsMutat = this.compartiment.getProdusById(idProdus);

            if(tonomat.adaugaProdus(produsMutat))
                this.compartiment.elimina(idProdus);

        } catch(Exception e){
            System.out.println(e.getMessage());
        }
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
        return "id: " + id +
                ", locatie: " + locatie + "\n";
    }
}
