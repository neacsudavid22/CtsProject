package cts.interfaces;

import cts.models.Compartiment;

public interface ISingletonCLI {
    void declanseazaCLI();
    void creazaTonomat(Compartiment compartiment, double sold, String locatie);
}
