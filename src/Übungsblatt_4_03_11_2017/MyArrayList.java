package Übungsblatt_4_03_11_2017;

public class MyArrayList {

    private int[] arr = new int[ 10 ];
    private int size = 0;

    /**
     * Haengt ein Element hinten an die Liste an
     * @param i anzuhängender Wert
     */

    public void add( int i ) {

        if ( size == this.arr.length ) {

            int[] help = new int[ size * 2 ];

            System.arraycopy( this.arr, 0, help, 0, size);

            this.arr = help;

        }

        this.arr[ size ] = i;
        this.size += 1;

    }

    /**
     * Gibt das Element an der angegebenen Stelle zurueck. Wirft
     * eine ArrayIndexOutOfBoundsException, falls pos nicht zwischen 0 und size liegt.
     * @param pos index des Wertes das zurückgegeben werden soll
     * @return der Wert
     */

    public int get( int pos ) {

        this.testPos( pos );

        return this.arr[ pos ];

    }

    /**
     * Gibt eine Stringdarstellung in der Form [1,2,3,..,n] zurueck.
     * @return den String
     */

    public String toString() {

        StringBuilder ret = new StringBuilder();

        ret.append( "[" );

        for ( int i = 0; i < size; i++ ) {

            ret.append( this.arr[ i ] ).append( i < size - 1 ? "," : "" );

        }

        ret.append( "]" );

        return ret.toString();

    }

    /**
     * Loescht das Feld.
     */

    public void clear() {

        this.arr = new int[ 10 ];

        this.size = 0;

    }

    /**
     * Gibt die Anzahl der aufgenommenen Elemente zurueck.
     * @return Anzahl der Elemente
     */

    public int size() {

        return this.size;

    }

    /**
     * Gibt die Groesse des Feldes (einschliesslich freier Elemente) zurueck.
     * @return die Groesse des Feldes
     */

    public int capacity() {

        return this.arr.length;

    }

    /**
     * Erzeugt einen Klon der this-Liste.
     * @return den Klon
     */

    public MyArrayList clone() {

        MyArrayList help = new MyArrayList();

        help.arr = this.arr.clone();
        help.size = this.size;

        return help;

    }

    /**
     * Fuegt ein Element an der Position pos ein. Verschiebt alle folgenden Elemente eine Position nach hinten. Wirft eine
     * ArrayIndexOutOfBoundsException, falls pos nicht zwischen 0 und size liegt.
     * @param i der einzufügende Wert
     * @param pos der index des einzufügenden Wertes
     */

    public void add( int i, int pos ) {

        this.testPos( pos );

        this.arr[ pos ] = i;

    }

    /**
     * Loescht das Element an der Position pos. Verschiebt alle folgenden Elemente eine Position nach vorne. Wirft eine
     * ArrayIndexOutOfBoundsException, falls pos nicht zwischen 0 und size liegt.
     * @param pos position des zu löschenden elements
     */

    public void delete( int pos ) {

        this.testPos( pos );

        System.arraycopy( this.arr, pos + 1, this.arr, pos, size - pos - 1 );

        this.size -= 1;

    }

    /**
     * überprüft ob der Wert zwischen 0 und size liegt, falls nicht wird eine ArrayIndexOutOfBoundsException geworfen
     * @param pos der zu prüfende Wert
     */

    private void testPos( int pos ) {

        if ( pos < 0 || pos > size ) {

            throw new ArrayIndexOutOfBoundsException( pos + " liegt außerhalb [0;" + this.size + "]" );

        }

    }

}
