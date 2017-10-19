package Übungsblatt_2_18_10_2017;

public class GoldTagespreis {

    public String datum;

    public double preis;

    public GoldTagespreis(String datum, double preis) {

        this.datum = datum;
        this.preis = preis;

    }

    @Override
    public String toString() {

        return "Der Gold Tagespreis am " + this.datum + " beträgt: " + this.preis;

    }

    public String getDatum() {

        return this.datum;

    }

    public void setDatum(String datum) {

        this.datum = datum;

    }

    public double getPreis() {

        return this.preis;

    }

    public void setPreis(double preis) {

        this.preis = preis;

    }
}
