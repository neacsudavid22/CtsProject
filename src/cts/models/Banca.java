package cts.models;

import cts.enums.TipCardBancar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Banca {
    private List<ContBancar> listaConturiBancare;
    public Banca() {
        this.listaConturiBancare = new ArrayList<>();
    }
    public ContBancar getContBancar(Scanner scanner) {
        System.out.println("Introdu datele cardului: ");
        String numar;
        do {
            System.out.println("Introdu numarul cardului: ");
            while (!scanner.hasNext()) {
                System.out.println("Introdu un numar de card valid!");
                scanner.next();
            }
            numar = scanner.next();
        } while(numar.matches("[0-9]") && numar.length() == 16);

        String pin;
        do {
            System.out.println("Introdu pin-ul cardului: ");
            while (!scanner.hasNext()) {
                System.out.println("Introdu un pin valid(4 cifre)!");
                scanner.next();
            }
            pin = scanner.next();
        } while(pin.matches("[0-9]") && pin.length() == 4);
        int pinCard = Integer.parseInt(pin);

        return this.cautaCont(pinCard, numar);
    }

    private ContBancar cautaCont(int pin, String numar){
        for(ContBancar contBancar : this.listaConturiBancare){
            if(contBancar.getPin() == pin && contBancar.getNumar().equals(numar))
                return contBancar;
        }
        return null;
    }

    public ContBancar creazaContBancar(Scanner scanner){
        System.out.println("Introdu datele contului bancar pentru a efectua plata: ");

        String proprietar;
        System.out.println("Introdu proprietarul cardului: ");
        proprietar = scanner.nextLine();

        String numar;
        do {
            System.out.println("Introdu numarul cardului: ");
            numar = scanner.next();
            if (!numar.matches("\\d{16}")) {
                System.out.println("Număr invalid! Introdu un număr format din 16 cifre.");
            }
        } while (!numar.matches("\\d{16}"));


        int optiuneTip;
        do {
            System.out.println("Alege tipul cardului:");
            System.out.println("1. MasterCard");
            System.out.println("2. Visa");
            while(!scanner.hasNextInt()){
                System.out.println("Introdu 1 sau 2!");
                scanner.next();
            }
            optiuneTip = scanner.nextInt();

        } while(optiuneTip != 1 && optiuneTip != 2);
        TipCardBancar tipCard = optiuneTip == 1 ? TipCardBancar.Mastercard : TipCardBancar.Visa;

        int pinCard = (int)(Math.random() * 9000) + 1000;

        ContBancar contNou = new ContBancar(proprietar, numar, tipCard, pinCard);
        listaConturiBancare.add(contNou);
        System.out.println("Contul tau a fost adaugat: " + contNou.toString());
        return contNou;
    }
}
