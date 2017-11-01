package Übungsblatt_2_la1_19_10_2017;

public class VectorTest2 {

    static double[] a = {1, 2, 3, 4};
    static double[] b = {5, 6, 7, 8};
    static double[] c = {1, 2};
    static double[] d = {15, 18, 21, 24};

    public static void main( String[] args ) {

        VectorRn va = new VectorRn( a );
        VectorRn vb = new VectorRn( b );
        VectorRn vc = new VectorRn( c );
        VectorRn vd = new VectorRn( d );

        System.out.println( va.isParallel( vb ) );

        try {

            System.out.println( va.isParallel( vc ) );

        } catch ( UnconsistentVectorDimensionException e ) {

            System.out.println( e.getMessage() );

        }

        System.out.println( vb.isParallel( vd ) );

    }

}
