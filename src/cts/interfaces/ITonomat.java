package cts.interfaces;

import cts.models.ContBancar;
import cts.models.Produs;
import cts.models.Tonomat;

import java.util.List;

public interface ITonomat {
    void vindeProdus( int idProdus, ContBancar contBancar);
    void primirePlata( ContBancar contBancar, double cost);
    void mutaProdus(int idProdus, Tonomat tonomat);
    void adaugaProdus( Produs produs);
    void eliminaProdus( int idProdus);
    void filtrareProduseDupaFurnizor( String furnizor);
    void listareProduse();
}

