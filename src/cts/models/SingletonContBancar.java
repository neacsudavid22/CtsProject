package cts.models;

import cts.enums.TipCardBancar;
import cts.interfaces.IContBancar;
import cts.interfaces.ISingletonContBancar;

public class SingletonContBancar implements ISingletonContBancar, IContBancar {
    private static SingletonContBancar instance = null;
    private ContBancar contBancar;

    private SingletonContBancar() {
        this.contBancar = new ContBancar("Familia Papadocviolentziu", "4000400040004000", TipCardBancar.Visa, 1234);
    }

    public static synchronized SingletonContBancar getInstance() {
        if (instance == null) {
            instance = new SingletonContBancar();
        }
        return instance;
    }

    @Override
    public ContBancar getContBancar() {
        return contBancar;
    }

    @Override
    public Boolean platesteProdus(double cost) {
        return contBancar.platesteProdus(cost);
    }

    @Override
    public Boolean colectareSuma(double suma) {
        return contBancar.colectareSuma(suma);
    }
}