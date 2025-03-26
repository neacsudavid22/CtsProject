import cts.controllers.SingletonCLI;
import cts.enums.TipCompartiment;
import cts.enums.TipProdus;
import cts.models.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        SingletonCLI CLI = SingletonCLI.getInstance();
        Produs produs1 = new Produs(10, "Coca Cola", "Coca Cola SRL", TipProdus.rece);
        Produs produs2 = new Produs(9, "Pepsi Cola","Pepsi Cola SRL", TipProdus.rece);
        Produs produs3 = new Produs(5, "Biscuiti","Belvita SRL", TipProdus.idc);
        List<Produs> listaProduse = new ArrayList<>();
        listaProduse.add(produs1); listaProduse.add(produs2); listaProduse.add(produs3);

        Compartiment compartiment = new Compartiment(listaProduse, 4, TipCompartiment.produseReci);
        CLI.creazaTonomat(compartiment, 1000, "Bucuresti");

        Produs produs4 = new Produs(10, "Ceai de tei", "Tea SRL", TipProdus.cald);
        Produs produs5 = new Produs(9, "Ceai de musetel","Tea SRL", TipProdus.cald);
        Produs produs6 = new Produs(5, "Sticksuri","Stix SRL", TipProdus.idc);
        List<Produs> listaProduse2 = new ArrayList<>();
        listaProduse2.add(produs4); listaProduse2.add(produs5); listaProduse2.add(produs6);

        Compartiment compartiment2 = new Compartiment(listaProduse2, 5, TipCompartiment.produseCalde);
        CLI.creazaTonomat(compartiment2, 1000, "Valcea");

        CLI.declanseazaCLI();
    }
}