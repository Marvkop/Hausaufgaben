package Übungsblatt_2_la1_19_10_2017;

public class VectorTest {

    static double[] a = {1, 2, 3, 4};
    static double[] b = {5, 6, 7, 8};
    static double[] c = {1, 2};
    static double d = 3;

    public static void main( String[] args ) {

        VectorRn va = new VectorRn( a );
        VectorRn vb = new VectorRn( b );
        VectorRn vc = new VectorRn( c );

        VectorRn sum1 = va.add( vb );
        System.out.println( sum1.toString() );

        try {

            VectorRn sum2 = va.add( vc );

        }catch ( UnconsistentVectorDimensionException e ) {

            System.out.println( e.getMessage() );

        }

        VectorRn prod = va.mult( d );
        System.out.println( prod.toString() );

    }

}
