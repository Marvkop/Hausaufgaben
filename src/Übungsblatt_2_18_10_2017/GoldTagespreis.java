package Übungsblatt_2_18_10_2017;

public class GoldTagespreis {

    public String datum;

    public double preis;

    /**
     * erzeugt aus einem datum und einem Preis ein Gold-Tagespreis Objekt
     * @param datum datum in String-form
     * @param preis preis
     */

    public GoldTagespreis(String datum, double preis) {

        this.datum = datum;
        this.preis = preis;

    }

    /**
     * gibt den Gold-Tagespreis in Stringform zurück
     * @return
     */

    @Override
    public String toString() {

        return "Der Gold Tagespreis am " + this.datum + " beträgt: " + this.preis;

    }

    /**
     * gibt das aktuelle Datum zurück
     * @return das Datum
     */

    public String getDatum() {

        return this.datum;

    }

    /**
     * setzt das datum auf den übergebenen Wert
     * @param datum das zu setzende Datum
     */

    public void setDatum(String datum) {

        this.datum = datum;

    }

    /**
     * gibt den aktuellen Preis zurück
     * @return den Preis
     */

    public double getPreis() {

        return this.preis;

    }

    /**
     * setzt den Preis auf den übergebenen Wert
     * @param preis der zu setzende Preis
     */

    public void setPreis(double preis) {

        this.preis = preis;

    }

}
