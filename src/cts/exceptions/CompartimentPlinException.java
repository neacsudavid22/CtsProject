package cts.exceptions;

public class CompartimentPlinException extends Exception {
    public CompartimentPlinException() {
        super("Nu mai există spațiu disponibil în compartiment!");
    }
}