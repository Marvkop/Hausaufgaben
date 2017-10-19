package Übungsblatt_1_14_10_2017;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.Scanner;

public class Messreihe {

    private double[] liste;

    /**
     * Erzeugt eine Messreihe aus einem Double-Array
     *
     * @param liste Array mit double-Werten
     */

    public Messreihe(double[] liste) {

        this.liste = liste;

    }

    /**
     * erzeugt eine Messreihe aus einer Datei (Format Details siehe convert())
     *
     * @param dateiname volständiger Name der Datei
     * @throws FileNotFoundException wenn dateiname fehlerhaft
     */

    public Messreihe(String dateiname) throws FileNotFoundException {

        File data = new File(dateiname);
        this.liste = Messreihe.convert(data);

    }

    /**
     *  Konvertiert die Datei in ein Double-Array mit allen Messwerten und gibt dieses zurück.
     *  die Datei kann mit "%" markierte Kommentare und leerzeilen haben.
     *
     * @param data die Input-Datei
     * @return das Double-Array mit den Messwerten
     * @throws FileNotFoundException  wenn dateiname fehlerhaft
     * @throws ArithmeticException falls Anzahl fehlerhaft
     */

    public static double[] convert(File data) throws FileNotFoundException {

        Scanner sc = new Scanner(data);
        double[] ret = {};
        int counter = 0;
        int length = 0;

        while(sc.hasNextLine()) {

            String currentline = sc.nextLine();
            char[] chars = currentline.toCharArray();

            if (chars.length != 0) {

                if (chars[0] == '%') {

                    continue;

                }

            }

            if (chars.length == 0) {

                continue;

            }

            if (length == 0) {

                length = Integer.parseInt(currentline);
                ret = new double[length];
                continue;

            }

            if (counter == length) {

                throw new ArithmeticException("Anzahl fehlerhaft");

            }

            ret[counter] = Double.parseDouble(currentline);
            counter += 1;

        }

        if (counter < length) {

            throw new ArithmeticException("Anzahl fehlerhaft");

        }

        sc.close();
        return ret;

    }

    /**
     * gibt den maximalen Wert der Liste als double zurück
     *
     * @return den maximalen Wert
     */

    public double getMax() {

        double ret = this.liste[0];

        for (double val : this.liste) {

            if (val > ret){

                ret = val;

            }

        }

        return ret;

    }

    /**
     * gibt den Minimalen Wert der Liste als double zurück
     *
     * @return den minimalen Wert
     */

    public double getMin() {

        double ret = this.liste[0];

        for (double val : this.liste) {

            if (val < ret){

                ret = val;

            }

        }

        return ret;

    }

    /**
     * Überprüft ob alle Werte in der Liste gleich sind und gibt abhängig davon true oder false zurück.
     *
     * @return gibt true oder false zurück
     */

    public boolean isEinheitlich() {

        double check = this.liste[0];

        for (double val : this.liste) {

            if (val != check) {

                return false;

            }

        }

        return true;

    }

    /**
     * gibt die Anzahl der Werte die über dem angegebenen Limit liegen zurück
     *
     * @param lim grenze in Form eines Integers
     * @return anzahl der Werte als int
     */

    public int zaehleGroessere(int lim) {

        int counter = 0;

        for (double val : this.liste) {

            if (val > lim) {

                counter += 1;

            }

        }

        return counter;

    }

    /**
     * gibt den ersten Index des Maximalen Werts aus der Liste zurück
     *
     * @return der index des max-Werts als int
     */

    public int getMaxIndex() {

        double max = this.getMax();

        for (int i = 0; i < this.liste.length; i++) {

            if (max == this.liste[i]) {

                return i;

            }

        }

        throw new ArithmeticException("could not find max value");

    }

    /**
     * gibt Minimal- und Maximal-Wert der Liste in einem Array zurück
     *
     * @return double-Array mit min- und max-Wert
     */

    public double[] getBereich() {

        double[] ret = {getMin(), getMax()};

        return ret;

    }

    /**
     * gibt die Anzahl der Messwerte in der Akutellen Liste zurück
     *
     * @return int mit Anzahl der Werte
     */

    public int getAnzahl() {

        return this.liste.length;

    }

    /**
     * gibt den Mittelwert der Liste zurück
     *
     * @return den Mittelwert als double
     */

    public double getMittelwert() {

        double sum = 0;

        for (double val : this.liste) {

            sum += val;

        }

        return sum / this.getAnzahl();

    }

    /**
     * schreibt in eine Datei mit dem Übergebenen Dateinamen den Dateinamen, die Anzahl der Daten, den Mittelwert, den Datenbereich und sämtliche Messwerte aus der Liste auf drei Nachkommastellen genau
     *
     * @param dateiname den Namen der Datei
     * @throws FileNotFoundException  wenn dateiname fehlerhaft
     */

    public void speichereInfo(String dateiname) throws FileNotFoundException {

        PrintWriter writer = new PrintWriter(dateiname);

        writer.printf("Dateiname: " + dateiname + "\n");
        writer.printf("Anzahl der Daten: %d\n", this.getAnzahl());
        writer.printf("Mittelwert: %.4f\n", this. getMittelwert());
        writer.printf("Datenbereich: %.3f - %.3f\n", this.getMin(), this.getMax());

        for (double val : this.liste) {

            writer.printf(Locale.US, "%.3f\n", val); // falls Locale.US benutzt wird werden die zahlen im Format 0.0 bei Locale.GERMAN 0,0

        }

        writer.close();

    }

}
