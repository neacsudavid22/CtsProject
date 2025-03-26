package cts.models;

import cts.enums.TipCardBancar;
import cts.interfaces.IBanca;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Banca implements IBanca {
    private List<ContBancar> listaConturiBancare;
    public Banca() {
        this.listaConturiBancare = new ArrayList<>();
    }
    public ContBancar getContBancar(Scanner scanner) {
        System.out.println("Introdu datele cardului \n");
        String numar;
        do {
            System.out.println("Introdu numarul cardului: ");
            while (!scanner.hasNext()) {
                System.out.println("Introdu un numar de card valid!");
                scanner.next();
            }
            numar = scanner.next();
            if (!numar.matches("\\d{16}")) {
                System.out.println("Număr invalid! Introdu un număr format din exact 16 cifre.");
            }
        } while(!numar.matches("\\d{16}"));

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

    @Override
    public ContBancar cautaCont(int pin, String numar){
        for(ContBancar contBancar : this.listaConturiBancare){
            if(contBancar.getPin() == pin && contBancar.getNumar().equals(numar))
                return contBancar;
        }
        System.out.println("Nu exista un cont bancar cu datele furnizate.");
        return null;
    }

    @Override
    public ContBancar creazaContBancar(Scanner scanner){
        System.out.println("Introdu datele contului bancar pentru a efectua plata: ");

        String proprietar;
        System.out.println("Introdu proprietarul cardului: ");
        proprietar = scanner.nextLine();
        scanner.next();

        String numar = new String();
        for(int i = 0; i < 4; i++)
            numar += (int)((Math.random() * 9000) + 1000);

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
        System.out.println("Pin-ul tau este: " + pinCard + ". Nu-l arata!");
        System.out.println("Numarul cardului este: " + numar + ".");
        ContBancar contNou = new ContBancar(proprietar, numar, tipCard, pinCard);
        listaConturiBancare.add(contNou);
        System.out.println("Contul tau a fost adaugat: " + contNou.toString());
        return contNou;
    }
}
