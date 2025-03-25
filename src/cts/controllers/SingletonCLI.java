package cts.controllers;

import cts.enums.TipProdus;
import cts.interfaces.ISingletonCLI;
import cts.models.Compartiment;
import cts.models.Produs;
import cts.models.Tonomat;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SingletonCLI implements ISingletonCLI {
    private static SingletonCLI instance = null;
    private List<Tonomat> listaTonomate;

    private SingletonCLI() {
        this.listaTonomate = new ArrayList<>();
    }

    public static synchronized SingletonCLI getInstance() {
        if (instance == null) {
            instance = new SingletonCLI();
        }
        return instance;
    }

    public List<Tonomat> getTonomate() {
        return this.listaTonomate;
    }

    public Tonomat getTonomatById(int id) {
        try {
            Tonomat tonomatCurent = listaTonomate.get(id);
            return tonomatCurent;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public void listezaTonomatele() {
        for (Tonomat tonomat : listaTonomate) {
            System.out.println(tonomat.toString());
        }
    }

    public void creazaTonomat(Compartiment compartiment, double sold, String locatie) {
        try {
            Tonomat tonomatNou = new Tonomat(compartiment, sold, locatie);
            listaTonomate.add(tonomatNou);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    public void declanseazaCLI() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Pentru client apasa 1");
        System.out.println("Pentru administrator apasa 2");
        int raspuns = 0;
        do {
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number.");
                scanner.next();
            }
            raspuns = scanner.nextInt();

            switch (raspuns) {
                case 1: {
                    this.clientCLI(scanner);
                    break;
                }
                case 2: {
                    this.managerCLI(scanner);
                    break;
                }
                default: {
                    System.out.println("Introdu un numar dintre optiuni");
                    break;
                }
            }
        } while (raspuns <= 0 || raspuns > 2);
    }

    public void clientCLI(Scanner scanner) {

    }

    public void managerCLI(Scanner scanner) {
        int raspuns = 0;
        do {
            System.out.println("Pentru a selecta un tonomat apasa 1");
            System.out.println("Pentru a te intoarce inapoi apasa 2");

            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number.");
                scanner.next();
            }

            raspuns = scanner.nextInt();

            switch (raspuns) {
                case 1: {
                    System.out.println("Selecteaza tonomatul, apasa id-ul acestuia:");
                    Tonomat tonomatCurent = this.selecteazaTonomat(scanner);
                    this.administreazaTonomat(tonomatCurent, scanner);
                }
                case 2: {
                    System.out.println("EXIT");
                    break;
                }
                default: {
                    System.out.println("Nu ai ales o optiune valida..");
                    break;
                }
            }
        } while (raspuns <= 0 || raspuns > 2);
    }

    public void administreazaTonomat(Tonomat tonomatCurent, Scanner scanner) {
        System.out.println("Pentru a adauga un produs apasa 1");
        System.out.println("Pentru a muta un produs apasa 2");
        System.out.println("Pentru a lista produsele din tonomat apasa 3");
        System.out.println("Pentru a filtra produsele din tonomat dupa furnizor apasa 5");

        int raspuns = 0;
        do {
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number.");
                scanner.next();
            }
            raspuns = scanner.nextInt();

            switch (raspuns) {
                case 1: {
                    Produs produsDeAdaugat = this.creazaProdusNou(scanner);
                    tonomatCurent.adaugaProdus(produsDeAdaugat);
                    System.out.println("Produsul a fost adaugat!");
                    break;
                }
                case 2: {
                    Tonomat tonomatPentruMutat = this.selecteazaTonomat(scanner);

                    int idProdusDeMutat = this.selecteazaProdus(scanner, tonomatCurent);

                    tonomatCurent.mutaProdus(idProdusDeMutat, tonomatPentruMutat);

                    System.out.println("Produsul a fost mutat!");
                    break;
                }
                case 3: {
                    tonomatCurent.listareProduse();
                    break;
                }
                case 4: {
                    //TO-DO: tonomatCurent.filtrareProduseDupaFurnizor();
                }
                default: {
                    System.out.println("Alege o optiune valida!");
                    break;
                }
            }
        } while(raspuns <= 0 || raspuns > 5);
    }
    public int selecteazaProdus(Scanner scanner, Tonomat tonomatCurent){
        System.out.println("Alege produsul pe care doresti sa il muti");
        tonomatCurent.listareProduse();
        int idProdus = -1;
        boolean AI_ALES_UN_NR_VALID;
        do {
            AI_ALES_UN_NR_VALID = false;
            this.listezaTonomatele();
            while (scanner.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number.");
                scanner.next();
            }
            if(idProdus >= 0 && idProdus < tonomatCurent.getCompartiment().getListaProduse().size()) {
                AI_ALES_UN_NR_VALID = true;
            }
            else{
                System.out.println("Trebuie sa alegi un numar dintre id-urile listate!");
            }

        } while(!AI_ALES_UN_NR_VALID);
        return idProdus;
    }

    public Tonomat selecteazaTonomat(Scanner scanner){
        System.out.println("Selecteaza tonomatul:");
        int idTonomat = -1;
        boolean AI_ALES_UN_NR_VALID;
        do {
            AI_ALES_UN_NR_VALID = false;
            this.listezaTonomatele();
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number.");
                scanner.next();
            }
            idTonomat = scanner.nextInt();
            if(idTonomat >= 0 && idTonomat < this.listaTonomate.size()) {
                AI_ALES_UN_NR_VALID = true;
            }
            else{
                System.out.println("Trebuie sa alegi un numar dintre id-urile listate!");
            }

        } while(!AI_ALES_UN_NR_VALID);

        return this.getTonomatById(idTonomat);
    }

    public Produs creazaProdusNou(Scanner scanner) {
        do {
            System.out.println("Introdu denumire Produs: ");
            String nume = scanner.next();

            System.out.println("Introdu cost produs: ");
            while(!scanner.hasNextDouble()){
                System.out.println("Introdu input valid!");
                scanner.next();
            }
            double cost = scanner.nextDouble();

            System.out.println("Introdu furnizor");
            String furnizor = scanner.next();

            int optiuneTip = -1;
            boolean AI_ALES_UN_NR_VALID;
            do {
                AI_ALES_UN_NR_VALID = false;
                System.out.println("Alege tipul produsului:");
                System.out.println("1 - rece");
                System.out.println("2 - cald");
                System.out.println("3 - idc/oricare");

                while (!scanner.hasNextInt()) {
                    System.out.println("Introdu un numar valid!");
                    scanner.next();
                }
                optiuneTip = scanner.nextInt();

                if(optiuneTip == 1 || optiuneTip == 2 || optiuneTip == 3) {
                    AI_ALES_UN_NR_VALID = true;
                }
                else{
                    System.out.println("Trebuie sa alegi un numar dintre optiunile listate!");
                }

            } while (!AI_ALES_UN_NR_VALID);

            TipProdus tip = (optiuneTip == 1) ? TipProdus.rece : (optiuneTip == 2 ? TipProdus.cald : TipProdus.idc);

            return new Produs(cost, nume, furnizor, tip);
        } while(true);
    }
}