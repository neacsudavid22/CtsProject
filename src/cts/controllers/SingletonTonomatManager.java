package cts.controllers;

import cts.models.Tonomat;

import java.util.ArrayList;
import java.util.List;

public class SingletonTonomatManager {
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
}
