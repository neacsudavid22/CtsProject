package cts.interfaces;

import cts.models.Produs;

import java.util.List;

public interface ICompartiment {
    void adauga(Produs produs);
    void elimina(int id);
    boolean verificaTip(Produs produs);
    void listeaza();
    void filtreazaProduseleDupaFurnizor(String furnizor);
    boolean verificaCapacitate();
    Produs getProdusById(int id);
    double getCostProdus(int id);
}
