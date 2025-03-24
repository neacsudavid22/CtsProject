package cts.models;

import cts.enums.TipCardBancar;
import cts.interfaces.ISingletonContBancar;

public class SingletonContBancar implements ISingletonContBancar {
    private static SingletonContBancar instance = null;
    private ContBancar contBancar;

    private SingletonContBancar() {
        this.contBancar = new ContBancar("Familia Papadocviolentziu", 100.0, TipCardBancar.Visa);
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
}
