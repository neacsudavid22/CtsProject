package cts.interfaces;

import cts.models.Produs;
import cts.enums.TipProdus;
import cts.enums.TipCompartiment;

import java.util.List;

public interface ICompartiment {
    boolean adauga(Produs produs);
    void elimina(int id);
    Produs getProdusById(int id);
    double getCostProdus(int id);
    boolean verificaTip(Produs produs);
    boolean verificaCapacitate();
    void listeaza();
    void filtreazaProduseleDupaFurnizor(String furnizor);
    List<Produs> getListaProduse();
    List<Integer> getIdProduse();
}
