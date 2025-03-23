package cts.interfaces;

import cts.models.Produs;
import cts.models.Tonomat;

import java.util.List;

public interface ISingletonTonomatManager {
    Tonomat selectezaTonomat(int id);
    List<Produs> listeazaToateProdusele();
    List<Produs> adaugaTonomat(Tonomat tonomatNou);
}
