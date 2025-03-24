package cts.models;

public class Tonomat {
    private static int count = 0;
    int id;
    Compartiment compartiment;
    double sold;
    String locatie;
    public static SingletonContBancar contFirma = SingletonContBancar.getInstance();

    public Tonomat(Compartiment compartiment, double sold, String locatie) {
        this.id = count++;
        this.compartiment = compartiment;
        this.sold = sold;
        this.locatie = locatie;
    }

    public static int getCount() {
        return count;
    }

    public int getId() {
        return id;
    }

    public Compartiment getCompartiment() {
        return compartiment;
    }

    public void setCompartiment(Compartiment compartiment) {
        this.compartiment = compartiment;
    }

    public double getSold() {
        return sold;
    }

    public void setSold(double sold) {
        this.sold = sold;
    }

    public String getLocatie() {
        return locatie;
    }

    public void setLocatie(String locatie) {
        this.locatie = locatie;
    }

    @Override
    public String toString() {
        return "Tonomat{" +
                "id=" + id +
                ", compartiment=" + compartiment +
                ", sold=" + sold +
                ", locatie='" + locatie + '\'' +
                '}';
    }
}
