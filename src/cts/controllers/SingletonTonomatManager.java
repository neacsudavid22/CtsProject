package cts.controllers;

import cts.interfaces.ISingletonTonomatManager;
import cts.models.Compartiment;
import cts.models.Produs;
import cts.models.Tonomat;

import java.util.ArrayList;
import java.util.List;

public class SingletonTonomatManager implements ISingletonTonomatManager {
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

    @Override
    public Tonomat selectezaTonomat(int id) {
        try{
            Tonomat tonomatCurent = listaTonomate.get(id);
            return tonomatCurent;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void listezaTonomatele(){
        for(Tonomat tonomat : listaTonomate){
            System.out.println(tonomat.toString());
        }
    }

    @Override
    public void creazaTonomat(Compartiment compartiment, double sold, String locatie){
        try{
            Tonomat tonomatNou = new Tonomat(compartiment, sold, locatie);
            listaTonomate.add(tonomatNou);
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void declanseazaCLI(){
        //TO-DO
    }
}
