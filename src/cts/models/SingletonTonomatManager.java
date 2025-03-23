package cts.models;

import java.util.ArrayList;
import java.util.List;

public class SingletonTonomatManager {
    private static SingletonTonomatManager instance = null;
    private List<Tonomat> tonomate;

    private SingletonTonomatManager() {
        this.tonomate = new ArrayList<>();
    }

    public static synchronized SingletonTonomatManager getInstance() {
        if (instance == null) {
            instance = new SingletonTonomatManager();
        }
        return instance;
    }

    public List<Tonomat> getTonomate() {
        return this.tonomate;
    }
}
