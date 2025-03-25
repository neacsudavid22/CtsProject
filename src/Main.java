import cts.controllers.SingletonTonomatManager;
import cts.enums.TipCompartiment;
import cts.enums.TipProdus;
import cts.interfaces.ISingletonTonomatManager;
import cts.models.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ISingletonTonomatManager tonomatManager = null;
        tonomatManager = SingletonTonomatManager.getInstance();
        Produs produs1 = new Produs(100, "coca cola", "Coca cola srl", TipProdus.rece);
        Produs produs2 = new Produs(90, "pepsi cola","pepsi cola srl", TipProdus.rece);
        Produs produs3 = new Produs(50, "idc","Coca cola srl", TipProdus.idc);
        List<Produs> listaProduse = new ArrayList<>();
        listaProduse.add(produs1); listaProduse.add(produs2); listaProduse.add(produs3);

        Compartiment compartiment = new Compartiment(listaProduse, 4, TipCompartiment.produseReci);
        tonomatManager.creazaTonomat(compartiment, 1000, "Bucuresti");
        Tonomat tonomat = tonomatManager.selectezaTonomat(0);

        tonomatManager.declanseazaCLI();
    }
}