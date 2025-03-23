package cts.interfaces;

import cts.models.ContBancar;
import cts.models.Produs;
import java.util.List;

public interface ITonomat {
    void vindeProdus( Produs produs, ContBancar contBancar);
    void primirePlata( ContBancar contBancar, double cost);
    void stergeProdus( Produs produs);
    void adaugaProdus( Produs produs);
    List<Produs> filtrareProduse( double cost);
    List<Produs> listareProduse();
}

