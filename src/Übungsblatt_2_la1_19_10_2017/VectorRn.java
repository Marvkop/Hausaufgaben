package Übungsblatt_2_la1_19_10_2017;

public class VectorRn {

    private double[] values;

    /**
     * erzeugt aus einem double array einen Vector mit der Dimension der Arraylänge
     * @param values ein double-array
     */
    public VectorRn( double[] values ) {

        this.values = values.clone();

    }

    /**
     * Copy-Constructor
     * @param vector zu kopierender Vector
     */

    public VectorRn( VectorRn vector ) {

        this( vector.values.clone() );

    }

    /**
     * addiert zwei Vektoren und gibt einen neuen Vektor zurück
     * @param v2 der zu addierende Vektor
     * @return der neu erzeugte Vektor
     */

    public VectorRn add ( VectorRn v2 ) {

        VectorRn help = new VectorRn( v2 );

        if ( v2.values.length == this.values.length ) {

            for ( int i = 0; i < v2.values.length; i++ ) {

                help.values[i] += this.values[i];

            }

        }else {

            throw new UnconsistentVectorDimensionException("Vektordimension fehlerhaft");

        }

        return help;

    }

    /**
     * multipliziert den Vektor mit dem übergebenen Wert und gibt einen neu erzeugten Vektor zurück
     * @param d der faktor mit dem der Vektor multipliziert werden soll
     * @return der neu erzeugte Vektor
     */

    public VectorRn mult ( double d ) {

        VectorRn help = new VectorRn( this.values );

        for ( int i = 0; i < help.values.length; i++ ) {

            help.values[i] *= d;

        }

        return help;

    }

    /**
     * führt mit dem zwei übergebenen Vektoren das Skalarprodukt aus und gibt das ergebnis zurück
     * @param v1 der erste Vektor
     * @param v2 der zweite Vektor
     * @return das Ergebnis des Skalarproduktes
     */

    public static double scalarProd ( VectorRn v1 , VectorRn v2 ) {

        if ( v1.values.length != v2.values.length ) {

            throw new UnconsistentVectorDimensionException("Vektordimension fehlerhaft");

        }

        double ret = 0;

        for ( int i = 0; i < v1.values.length; i++ ) {

            ret += ( v1.values[i] * v2.values[i] );

        }

        return ret;

    }

    /**
     * gibt die Norm des Vektors zurück
     * @return der Norm-Wert
     */

    public double getNorm() {

        return Math.sqrt( VectorRn.scalarProd( this, this ) );

    }

    /**
     * gibt den Vektor im String-Format zurück
     * @return String mit Vektor
     */

    @Override
    public String toString() {

        String ret = "( ";

        for ( int i = 0; i < this.values.length; i++ ) {

            ret += this.values[i];

            if ( i < this.values.length -1 ) {

                ret += ", ";

            }

        }

        ret += " )";

        return ret;

    }

}
