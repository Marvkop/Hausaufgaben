package Übungsblatt_2_la1_19_10_2017;

import java.lang.reflect.Array;
import java.util.stream.Stream;

public class VectorRn {

    private double[] values;

    public VectorRn( double[] values ) {

        this.values = values.clone();

    }

    public VectorRn( VectorRn vector ) {

        this( vector.values.clone() );

    }

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

    public VectorRn mult ( double d ) {

        VectorRn help = new VectorRn( this.values );

        for ( int i = 0; i < help.values.length; i++ ) {

            help.values[i] *= d;

        }

        return help;

    }

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

    public double getNorm() {

        return Math.sqrt( VectorRn.scalarProd( this, this ) );

    }

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
