package Übungsblatt_5_09_11_2017;

import java.util.ArrayList;

public class PositiveNumber {

    private int value;

    /**
     * erzeugt eine PositiveNumber mit dem uebergebenen int-Wert
     * @param value
     */

    public PositiveNumber( int value ) {

        this.value = value;

    }

    /**
     * erzeugt eine PositiveNumber aus einem String im übergebenen Zahlensystem 2-16
     * @param s die Zahl als String
     * @param zahlensystem das Zahlensystem der Zahl im String
     */

    public PositiveNumber( String s , int zahlensystem ) {

        // Sonderfall für zahlensystem = 1;
        if ( zahlensystem == 1 ) {

            throw new NumberFormatException( "1er System ist gein gültiges Zahlensystem" );

        }

        this.value = this.convertToInt( s, zahlensystem );

    }

    /**
     * erzuegt eine PositiveNumber mit dem Wert 0
     */

    public PositiveNumber() {

        this.value = 0;

    }

    /**
     * setzt den Wert der Value auf im String stehenden Wert.
     * Zahl muss im Dezimalsystem sein.
     * @param s der zu setzende Wert im Dezimalsystem
     */

    public void setDecimal( String s ) {

        this.value = this.convertToInt( s , 10 );

    }

    /**
     * setzt den Wert der Value auf im String stehenden Wert.
     * Zahl muss im Hexadezimalsystem sein.
     * @param s der zu setzende Wert im Hexadezimalsystem
     */

    public void setHexadecimal( String s ) {

        this.value = this.convertToInt( s , 16 );

    }

    /**
     * setzt den Wert der Value auf im String stehenden Wert.
     * Zahl muss im Binaersystem sein.
     * @param s der zu setzende Wert im Binaersystem
     */

    public void setBinary( String s ) {

        this.value = this.convertToInt( s , 2 );

    }

    /**
     * gibt den aktuellen Wert als Dezimalzahl zurück
     * @return aktueller Wert als Dezimalzahl
     */

    public String getDecimal() {

        return this.convertToString( 10 );

    }

    /**
     * gibt den aktuellen Wert als Hexadezimalzahl zurueck
     * @return aktuellen Wert als Hexadezimalzahl
     */

    public String getHexadecimal() {

        return this.convertToString( 16 );

    }

    /**
     * gibt den aktuellen Wert als Binaerzahl zurueck
     * @return aktuellen Wert als Binaerrzahl
     */

    public String getBinary() {

        return this.convertToString( 2 );

    }

    /**
     * konvertiert die im String stehende Zahl aus dem übergebenen Zahlensystem in enen Integerwert und gibt ihn zurück
     * @param s der zu setzende Wert im übergebenen zahlensystem
     * @param zahlensystem zahlensystem der zahl die im String übergeben wurde
     * @return
     */

    private int convertToInt( String s , int zahlensystem ) {

        char[] chars = s.toCharArray();

        int retold = 0;
        int ret = 0;

        for( int i = 0; i < chars.length; i++ ) {

            int pot = chars.length - i - 1;

            retold = ret;
            ret += this.getToAdd( zahlensystem, pot, getMult( chars[ i ] ) );

            if( retold > ret ) {

                throw new NumberFormatException( "Zahl größer INTEGER_MAX_VALUE" );

            }

        }

        return ret;

    }

    /**
     * rechnet den übergebenen Character in seinen Dezimalwert um
     * falls der Wert nicht zwischen 0 und F liegt oder ein unbekanntes zeichen enthält wird eine NumberFormatException ausgelöst
     * @param c der umzurechnende Character
     * @return den int Wert der dem Character zugwiesen ist
     */

    private int getMult( char c ) {

        switch ( c ) {

            case '0' : { return 0; }
            case '1' : { return 1; }
            case '2' : { return 2; }
            case '3' : { return 3; }
            case '4' : { return 4; }
            case '5' : { return 5; }
            case '6' : { return 6; }
            case '7' : { return 7; }
            case '8' : { return 8; }
            case '9' : { return 9; }
            case 'a' :
            case 'A' : { return 10; }
            case 'b' :
            case 'B' : { return 11; }
            case 'c' :
            case 'C' : { return 12; }
            case 'd' :
            case 'D' : { return 13; }
            case 'e' :
            case 'E' : { return 14; }
            case 'f' :
            case 'F' : { return 15; }
            default: throw new NumberFormatException( "Zahl nicht in unterstützten Systemen" ); // sollte eine Zahl kleiner Null gesetzt werden wird durch das "-" automatisch eine Exception geworfen

        }

    }

    /**
     * berechnet den zu addierenden Wert aus der aktuellen Potenz dem Zahlensystem und dem Faktor
     * sollte der Faktor nicht im Zahlensystem liegen wird eine NumberFormatException ausgelöst
     * @param zahlensystem das aktuelle Zahlensystem
     * @param pot aktuelle Potenz
     * @param mult Faktor
     * @return Zahlensystem hoch Potenz mal Faktor als int
     */

    private int getToAdd( int zahlensystem , int pot, int mult ) {

        if( mult >= zahlensystem ) {

            throw new NumberFormatException( "Zahl nicht im " + zahlensystem + "er System" );

        }

        return ( int ) Math.pow( zahlensystem, pot ) * mult;

    }

    /**
     * konvertiert den aktuellen Wert in das übergebene Zahlensystem in einen String und gibt ihn zurueck
     * @param zahlensystem das aktuelle zahlensystem
     * @return aktuellen Wert im übergebenen Zahlensystem
     */

    private String convertToString( int zahlensystem ) {

        ArrayList<String> helper = new ArrayList<>();
        int copyvalue = this.value;

        while ( copyvalue != 0 ) {

            if( copyvalue % zahlensystem < 10 ) {

                helper.add(0, String.valueOf( copyvalue % zahlensystem ) );

            }else {

                switch ( copyvalue % zahlensystem ) {

                    case 10 : { helper.add(0,"A"); break;}
                    case 11 : { helper.add(0,"B"); break;}
                    case 12 : { helper.add(0,"C"); break;}
                    case 13 : { helper.add(0,"D"); break;}
                    case 14 : { helper.add(0,"E"); break;}
                    case 15 : { helper.add(0,"F"); break;}

                }

            }

            copyvalue /= zahlensystem;

        }

        StringBuilder ret = new StringBuilder();

        for ( String val : helper ) {

            ret.append( val );

        }

        if ( ret.length() == 0 ) {

            ret.append( 0 );

        }

        return ret.toString();

    }

}
