package cts.controllers;

import cts.enums.TipProdus;
import cts.models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SingletonCLI {
    private static SingletonCLI instance = null;
    private List<Tonomat> listaTonomate;
    private Banca banca;

    private SingletonCLI() {
        this.listaTonomate = new ArrayList<>();
        this.banca = new Banca();
    }

    public static synchronized SingletonCLI getInstance() {
        if (instance == null) {
            instance = new SingletonCLI();
        }
        return instance;
    }

    public Tonomat getTonomatById(int id) {
        try {
            return listaTonomate.get(id);
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
        int raspuns;
        do {
            System.out.println("Pentru client apasa 1");
            System.out.println("Pentru administrator apasa 2");
            System.out.println("Pentru a parasi aplicatia apasa 3");

            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number.");
                scanner.next();
            }
            raspuns = scanner.nextInt();

            if (raspuns == 1 || raspuns == 2) {
                boolean ESTE_MANAGER = raspuns == 2;
                this.lanseazaMeniu(scanner, ESTE_MANAGER);
            }
            else if(raspuns != 3)
                System.out.println("Introdu un numar dintre optiunile disponibile");

        } while (raspuns != 3);
    }

    public void lanseazaMeniu(Scanner scanner, boolean ESTE_MANAGER) {
        int raspuns;
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
                    if(ESTE_MANAGER)
                        this.administreazaTonomat(tonomatCurent, scanner);
                    else
                        this.cumparaProdus(tonomatCurent, scanner);
                    break;
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
        } while (raspuns != 2);
    }
    public void cumparaProdus(Tonomat tonomatCurent, Scanner scanner) {
        int raspuns;
        do{
            int idProdusSelectat = this.selecteazaProdus(scanner, tonomatCurent);
            ContBancar contClient = this.selecteazaContBancar(scanner);
            tonomatCurent.vindeProdus(idProdusSelectat, contClient);

            System.out.println("Vrei sa continui cumparaturile?");
            System.out.println("DA - Apasa 1");
            System.out.println("NU - Apasa alt NUMAR");

            while(!scanner.hasNextInt()){
                System.out.println("Invalid input!");
                scanner.next();
            }
            raspuns = scanner.nextInt();
        } while(raspuns == 1);
    }

    public ContBancar selecteazaContBancar(Scanner scanner){
        int raspuns;
        do{
            System.out.println("Pentru a folosi un cont existent apasa - 1");
            System.out.println("Pentru a crea un cont nou apasa contacteaza banca apasand - 2");
            System.out.println("Pentru a renunta la achizitie apasa - 3");

            while(!scanner.hasNextInt()){
                System.out.println("Selecteaza un numar valid!");
                scanner.next();
            }

            raspuns = scanner.nextInt();

            switch (raspuns) {
                case 1 : {
                    ContBancar contBancar = this.banca.getContBancar(scanner);
                    if(contBancar != null)
                        return contBancar;
                    raspuns = 4;
                    break;
                }
                case 2: {
                    ContBancar contBancar = this.banca.creazaContBancar(scanner);
                    if(contBancar != null)
                        return contBancar;
                    System.out.println("Datele introduse au fost incorecte!");
                    break;
                }
                case 3: {
                    return null;
                }
                default: {
                    System.out.println("Alege un nr valid");
                    break;
                }
            }
        } while(raspuns < 0 || raspuns > 3);
        return null;
    }

    public void administreazaTonomat(Tonomat tonomatCurent, Scanner scanner) {
        int raspuns;
        do {
            System.out.println("Pentru a adauga un produs apasa 1");
            System.out.println("Pentru a muta un produs apasa 2");
            System.out.println("Pentru a lista produsele din tonomat apasa 3");
            System.out.println("Pentru a filtra produsele din tonomat dupa furnizor apasa 4");
            System.out.println("Pentru a te intoarce inapoi apasa 5");

            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number.");
                scanner.next();
            }
            raspuns = scanner.nextInt();

            switch (raspuns) {
                case 1: {
                    Produs produsDeAdaugat = this.creazaProdusNou(scanner);
                    boolean rezultat = tonomatCurent.adaugaProdus(produsDeAdaugat);
                    if(rezultat) System.out.println("Produsul a fost adaugat!");
                    else  System.out.println("Produsul nu a putut fi adaugat!");
                    break;
                }
                case 2: {
                    if(this.listaTonomate.size() < 2){
                        System.out.println("Ai doar un tonomat..");
                        break;
                    }

                    if(tonomatCurent.getCompartiment().getListaProduse().isEmpty()){
                        System.out.println("Nu ai produse in tonomatul curent, nu poti muta din el nimic..");
                        break;
                    }

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
                    this.filtreazaProdusele(scanner, tonomatCurent);
                    break;
                }
                case 5: {
                    System.out.println("Am iesit!");
                    break;
                }
                default: {
                    System.out.println("Alege o optiune valida!");
                    break;
                }
            }
        } while(raspuns != 5);
    }
    public void filtreazaProdusele(Scanner scanner, Tonomat tonomat){
        System.out.println("Introdu furnizorul: ");
        String furnizor = scanner.next();
        System.out.println("Lista Produse a caror furnizor sunt " + furnizor + ":");
        tonomat.filtrareProduseDupaFurnizor(furnizor);
        System.out.println();
    }
    public int selecteazaProdus(Scanner scanner, Tonomat tonomatCurent){
        System.out.println("Alege produsul");
        tonomatCurent.listareProduse();
        int idProdus;
        boolean AI_ALES_UN_NR_VALID;
        do {
            AI_ALES_UN_NR_VALID = false;
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number.");
                scanner.next();
            }
            idProdus = scanner.nextInt();
            if(tonomatCurent.getCompartiment().getIdProduse().contains(idProdus)) {
                AI_ALES_UN_NR_VALID = true;
            }
            else{
                System.out.println("Trebuie sa alegi un numar dintre id-urile listate!");
            }

        } while(!AI_ALES_UN_NR_VALID);
        return idProdus;
    }

    public Tonomat selecteazaTonomat(Scanner scanner){
        int idTonomat;
        boolean AI_ALES_UN_NR_VALID;
        do {
            AI_ALES_UN_NR_VALID = false;
            this.listezaTonomatele();
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number.");
                scanner.next();
            }
            idTonomat = scanner.nextInt();
            if(this.getTonomateId().contains(idTonomat)) {
                AI_ALES_UN_NR_VALID = true;
            }
            else{
                System.out.println("Trebuie sa alegi un numar dintre id-urile listate!");
            }

        } while(!AI_ALES_UN_NR_VALID);

        return this.getTonomatById(idTonomat);
    }

    public List<Integer> getTonomateId(){
        List<Integer> listaId = new ArrayList<>();
        for(Tonomat tonomat : this.listaTonomate){
            listaId.add(tonomat.getId());
        }
        return listaId;
    }
    public Produs creazaProdusNou(Scanner scanner) {
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

        int optiuneTip;
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
    }
}