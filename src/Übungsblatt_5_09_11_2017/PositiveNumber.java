package Übungsblatt_5_09_11_2017;

import com.sun.org.apache.bcel.internal.generic.RET;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PositiveNumber {

    private int value;

    public PositiveNumber( int value ) {

        this.value = value;

    }

    public PositiveNumber() {

        this.value = 0;

    }

    public void setDecimal( String s ) {

        this.value = convertToInt( s , 10 );

    }

    public void setHexadecimal( String s ) {

        this.value = convertToInt( s , 16 );

    }

    public void setBinary( String s ) {

        this.value = convertToInt( s , 2 );

    }

    private int convertToInt( String s , int zahlensystem ) {

        char[] chars = s.toCharArray();

        int ret = 0;

        for( int i = 0; i < chars.length; i++ ) {

            int pot = chars.length - i - 1;

            ret += getToAdd( zahlensystem, pot, getMult( chars[ i ] ) );

        }

        return ret;

    }

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

    private int getToAdd( int zahlensystem , int pot, int mult ) {

        if( mult >= zahlensystem ) {

            throw new NumberFormatException( "Zahl nicht im " + zahlensystem + "er System" );

        }

        return ( int ) Math.pow( zahlensystem, pot ) * mult;

    }

    public String getDecimal() {

        return String.valueOf( this.value );

    }

    public String getHexadecimal() {

        return this.convertToString( 16 );

    }

    public String getBinary() {

        return this.convertToString( 2 );

    }

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
