package cts.interfaces;

import cts.models.Produs;

import java.util.List;

public interface ICompartiment {
    void adauga(Produs produs);
    void elimina(int id);
    boolean verificaTip(Produs produs);
    void listeaza();
    //TO-DO void filtreaza()
}
