import cts.controllers.SingletonCLI;
import cts.enums.TipCompartiment;
import cts.enums.TipProdus;
import cts.models.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        SingletonCLI CLI = SingletonCLI.getInstance();
        Produs produs1 = new Produs(100, "coca cola", "Coca cola srl", TipProdus.rece);
        Produs produs2 = new Produs(90, "pepsi cola","pepsi cola srl", TipProdus.rece);
        Produs produs3 = new Produs(50, "idc","Coca cola srl", TipProdus.idc);
        List<Produs> listaProduse = new ArrayList<>();
        listaProduse.add(produs1); listaProduse.add(produs2); listaProduse.add(produs3);

        Compartiment compartiment = new Compartiment(listaProduse, 4, TipCompartiment.produseReci);
        CLI.creazaTonomat(compartiment, 1000, "Bucuresti");

        Produs produs4 = new Produs(100, "ceai de tei", "Coca cola srl", TipProdus.cald);
        Produs produs5 = new Produs(90, "ceai de musetel","pepsi cola srl", TipProdus.cald);
        Produs produs6 = new Produs(50, "idc","Coca cola srl", TipProdus.idc);
        List<Produs> listaProduse2 = new ArrayList<>();
        listaProduse2.add(produs4); listaProduse2.add(produs5); listaProduse2.add(produs6);

        Compartiment compartiment2 = new Compartiment(listaProduse2, 5, TipCompartiment.produseCalde);
        CLI.creazaTonomat(compartiment2, 1000, "Valcea");

        CLI.declanseazaCLI();
    }
}