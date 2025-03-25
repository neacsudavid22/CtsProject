package cts.exceptions;

public class SoldInsuficientException extends Exception {
    public SoldInsuficientException() {
        super("Fonduri insuficiente!");
    }
}