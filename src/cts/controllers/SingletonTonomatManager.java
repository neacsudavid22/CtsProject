package cts.controllers;

import cts.enums.TipProdus;
import cts.interfaces.ISingletonTonomatManager;
import cts.models.Compartiment;
import cts.models.Produs;
import cts.models.Tonomat;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SingletonTonomatManager implements ISingletonTonomatManager {
    private static SingletonTonomatManager instance = null;
    private List<Tonomat> listaTonomate;

    private SingletonTonomatManager() {
        this.listaTonomate = new ArrayList<>();
    }

    public static synchronized SingletonTonomatManager getInstance() {
        if (instance == null) {
            instance = new SingletonTonomatManager();
        }
        return instance;
    }

    public List<Tonomat> getTonomate() {
        return this.listaTonomate;
    }

    @Override
    public Tonomat selectezaTonomat(int id) {
        try {
            Tonomat tonomatCurent = listaTonomate.get(id);
            return tonomatCurent;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void listezaTonomatele() {
        for (Tonomat tonomat : listaTonomate) {
            System.out.println(tonomat.toString());
        }
    }

    @Override
    public void creazaTonomat(Compartiment compartiment, double sold, String locatie) {
        try {
            Tonomat tonomatNou = new Tonomat(compartiment, sold, locatie);
            listaTonomate.add(tonomatNou);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
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
                    this.listezaTonomatele();

                    int idTonomatSelectat;
                    while (!scanner.hasNextInt()) {
                        System.out.println("Invalid input! Please enter a number.");
                        scanner.next();
                    }
                    idTonomatSelectat = scanner.nextInt();
                    this.administreazaTonomat(this.selectezaTonomat(idTonomatSelectat), scanner);
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
        int raspuns;
        while (scanner.hasNextInt()) {
            System.out.println("Invalid input! Please enter a number.");
            scanner.next();
        }
        raspuns = scanner.nextInt();

        switch (raspuns) {
            case 1: {
                Produs produsDeAdaugat = this.creazaProdusNou(scanner);
                tonomatCurent.adaugaProdus(produsDeAdaugat);
                break;
            }
            default: {
                break;
            }
        }
    }

    Produs creazaProdusNou(Scanner scanner) {
        // ONGOING
        System.out.println("Introdu denumire Produs: ");
        String nume = scanner.next();
        System.out.println("Introdu cost produs: ");
        double cost = scanner.nextDouble();
        System.out.println("Introdu furnizor");
        String furnizor = scanner.next();
        System.out.println("Alege tipul produsului");
        System.out.println("1 - rece");
        System.out.println("2 - cald");
        System.out.println("3 - idc/oricare");
        int optiuneTip = scanner.nextInt();
        TipProdus tip = TipProdus.idc;
        return new Produs(cost, nume, furnizor, tip);
    }
}