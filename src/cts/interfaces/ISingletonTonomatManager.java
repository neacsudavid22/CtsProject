package cts.interfaces;

import cts.models.Compartiment;
import cts.models.Produs;
import cts.models.Tonomat;

import java.util.List;

public interface ISingletonTonomatManager {
    public Tonomat selectezaTonomat(int id);
    public void listezaTonomatele();
    public void creazaTonomat(Compartiment compartiment, double sold, String locatie);
    public void declanseazaCLI();
}
