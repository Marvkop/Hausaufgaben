package Übungsblatt_2_18_10_2017;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Stream;

public class GoldPreis {

    private ArrayList<GoldTagespreis> list = new ArrayList<>();

    /**
     * erzeugt aus einer Datei eine ArrayList<GoldTagespreis> wenn die Datei folgendes Format hat:
     * die ersten zehn Zeichen das Datum nach dem Format: yyyy-mm-dd
     * dann ein leerzeichen und danach der Wert
     * @param dateiname name der einzulesenden Datei
     * @throws FileNotFoundException falls Dateiname/Datei fehlerhaft
     */

    public GoldPreis( String dateiname ) throws FileNotFoundException {

        File f = new File( dateiname );
        Scanner sc = new Scanner( f );

        while ( sc.hasNextLine() ) {

            String line = sc.nextLine();
            String datum = line.substring( 0, 10 );
            String preis = line.substring( 11 );

            if (preis.equals( "kein Nachweis" ) ) {

                list.add( new GoldTagespreis( datum, -1 ) );

            } else {

                char[] helper = preis.toCharArray();

                preis = "";

                for ( int i = 0; i < helper.length; i++ ) {

                    if ( helper[i] == '.') {

                        continue;

                    }

                    if ( helper[i] == ',') {

                        preis += '.';

                    }else {

                        preis += helper[i];

                    }

                }

                list.add( new GoldTagespreis( datum, Double.parseDouble( preis ) ) );

            }

        }

    }

    /**
     * gibt den Preis des Goldes an einem bestimmten Datum zurück.
     * @param datum tag von dem der Preis abgefragt werden soll, im Format yyyy-mm-dd
     * @return double mit Preis-Wert
     */

    public double getPreis( String datum ) {

        for ( GoldTagespreis val : this.list ) {

            if ( val.datum.equals(datum) ) {

                return val.preis;

            }

        }

        throw new NumberFormatException("Datum nicht vorhanden oder falsches Format");

    }

    /**
     * gibt in der Konsole den minimalen Wert und alle Tage mit diesem Wert aus und den maximalen Wert und alle Tage mit diesem Wert.
     */

    public void printMinMax() {

        ArrayList<GoldTagespreis> min = new ArrayList<>();
        ArrayList<GoldTagespreis> max = new ArrayList<>();
        double minWert = 0; // Startwert gegen Compilerfehler, wird direkt beim ersten durchlauf überschrieben
        double maxWert = 0; //

        for ( GoldTagespreis val : this.list ) {

            if ( val.preis == -1 ) {

                continue;

            }

            if ( min.toArray().length == 0 ) {

                min.add( val ); // Startwert setzen
                max.add( val ); //
                minWert = val.preis; //
                maxWert = val.preis; //
                continue;

            }

            if ( val.preis > maxWert ) {

                max.clear();
                maxWert = val.preis;
                max.add( val );
                continue;
            }

            if ( val.preis < minWert ) {

                min.clear();
                minWert = val.preis;
                min.add( val );
                continue;

            }

            if ( val.preis == maxWert ) {

                max.add( val );
                continue;

            }

            if ( val.preis == minWert ) {

                min.add( val );

            }

        }

        System.out.println("Den niedrigsten Goldpreis von " + minWert + " gab es an folgenden Tagen:");

        for ( GoldTagespreis val : min ) {

            System.out.println( val.datum );

        }

        System.out.println("Den hoechsten Goldpreis von " + maxWert + " gab es an folgenden Tagen:");

        for ( GoldTagespreis val : max) {

            System.out.println( val.datum );

        }

    }

}
