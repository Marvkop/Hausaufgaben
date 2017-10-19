package Übungsblatt_2_18_10_2017;

import java.io.FileNotFoundException;

public class TestGoldPreis {

    /*
     * Jede der Methoden in der Klasse Goldpreis wird einmal getestet
     */
    public static void main(String[] args) {
        //Eventuell andere Pfadangabe, hier liegt die Datei im Projekt selber, nicht im src!
        try {
            GoldPreis test = new GoldPreis("gold.txt");
            System.out.println(test.getPreis("2009-10-20"));    //22870.0
            System.out.println(test.getPreis("2009-02-07"));    //-1
            test.printMinMax();
        }catch (FileNotFoundException | NumberFormatException e) {
            System.out.println(e.getMessage());
        }
    }

}