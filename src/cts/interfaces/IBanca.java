package cts.interfaces;

import cts.models.ContBancar;
import java.util.Scanner;

public interface IBanca {
    ContBancar getContBancar(Scanner scanner);
    ContBancar creazaContBancar(Scanner scanner);
    ContBancar cautaCont(int pin, String numar);

}
