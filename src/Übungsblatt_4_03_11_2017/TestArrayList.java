package Übungsblatt_4_03_11_2017;

public class TestArrayList {

    public static void main( String[] args ) {

        // Testbeispiel vom Aufgabenblatt
        MyArrayList myArrayList = new MyArrayList();

        // fuege die Zahlen 0-9 zur Liste hinzu
        for ( int i = 0; i < 10; i++ ) {

            myArrayList.add( i );

        }

        System.out.println( myArrayList );// [0,1,2,3,4,5,6,7,8,9]
        System.out.println( myArrayList.size() ); // 10

        // fuege die Zahl 5 an der Position 2 der Liste hinzu
        myArrayList.add( 5, 2 );
        System.out.println( myArrayList );// [0,1,5,2,3,4,5,6,7,8,9]

        // entferne die Elemente 1-6
        for (int i = 6; i > 0; i--) {

            myArrayList.delete( i );
            System.out.print( myArrayList.capacity() + "/" );
            System.out.println( myArrayList.size() );

        }

        //Musterloesung Fehlerhaft: es werden 6 elemente entfernt 1,2,3,4,5,6 es bleibt also nur [0,7,8,9] übrig und nicht [0,6,7,8,9]
        System.out.println( myArrayList );// [0,7,8,9] // korrigiert
        System.out.println( myArrayList.get( 2 ) );// 8 // korrigiert

        MyArrayList myArrayList2 = myArrayList.clone();
        myArrayList.clear();

        System.out.println( myArrayList );// []
        System.out.println( myArrayList2 );// [0,7,8,9] // korrigiert

    }

}