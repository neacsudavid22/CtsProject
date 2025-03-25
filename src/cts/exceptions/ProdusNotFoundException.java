package cts.exceptions;

public class ProdusNotFoundException extends Exception {
    public ProdusNotFoundException() {
        super("Produsul nu a fost gasit!");
    }
}
