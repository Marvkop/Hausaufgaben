package Übungsblatt_5_09_11_2017;
/**
 *  Zweck: Test der Klasse PositiveNumber
 */

public class PositiveNumberTest {

    public static void main( String[] args ) {

        PositiveNumber pn = new PositiveNumber( Integer.MAX_VALUE );

        System.out.println( pn.getBinary() );
        System.out.println( pn.getDecimal() );
        System.out.println( pn.getHexadecimal() );


        // Die folgenden Zeilen stammen aus dem Aufgabentext:
        PositiveNumber zs = new PositiveNumber();
        zs.setDecimal("144");
        System.out.println("Binaer: " + zs.getBinary());           // 10010000
        zs.setHexadecimal("affe");
        System.out.println("Dezimal: " + zs.getDecimal());         // 45054
        zs.setBinary("1000101011");
        System.out.println("Hexadezimal: " + zs.getHexadecimal()); // 22B

        try {

            // Negative Zahl
            zs.setHexadecimal( "-1" );

        }catch ( NumberFormatException e ) {

            System.out.println( e.getMessage() );

        }

        try {

            // Falsches Zahlensystem
            pn.setBinary( "2" );

        }catch ( NumberFormatException e ) {

            System.out.println( e.getMessage() );

        }

        try {

            // Integer-Überlauf
            PositiveNumber test = new PositiveNumber();
            test.setHexadecimal("FFFFFFFFFFFFF");

        }catch ( NumberFormatException e ) {

            System.out.println( e.getMessage() );

        }

    }

}
