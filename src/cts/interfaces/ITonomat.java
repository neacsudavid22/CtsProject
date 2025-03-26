package cts.interfaces;

import cts.models.Produs;
import cts.models.ContBancar;
import cts.models.Tonomat;

public interface ITonomat {
    boolean adaugaProdus(Produs produs);
    void vindeProdus(int idProdus, ContBancar contBancar);
    boolean primirePlata(ContBancar contBancar, double cost);
    void mutaProdus(int idProdus, Tonomat tonomat);
    void filtrareProduseDupaFurnizor(String furnizor);
    void listareProduse();
}
