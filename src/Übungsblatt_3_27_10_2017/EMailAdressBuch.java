package Übungsblatt_3_27_10_2017;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Scanner;

public class EMailAdressBuch {

	private HashMap <String, String> buch = new HashMap<>();

	public EMailAdressBuch () {
		
	}

	public void einfuegen ( String Name, String email ) {

		buch.put( Name, email );
		
	}

	public String abfrage ( String Name ) {

		if ( buch.containsKey( Name ) ) {

            return buch.get( Name );

		} else {

			throw new UnknownNameException( "Name existiert nicht" );

		}

	}

	public String toString() {

		String ret = "{ ";
		String[] tempName = new String[ buch.size() ];
		String[] tempEmail = new String[ buch.size() ];
		int i = 0;

		for ( String k : buch.keySet() ) {

			tempName[ i ] = k;
			i++;

		}

		i = 0;

		for ( String l : buch.values() ) {

			tempEmail[ i ] = l;
			i++;

		}

		for ( int j = 0; j < tempName.length; j++ ) {

			ret += tempName[ j ] + "=" + tempEmail[ j ] + ", ";

		}

		return ret + " }";

	}

	public void einlesen ( String dateiname ) throws FileNotFoundException {

		File f = new File ( dateiname );
		Scanner sc = new Scanner ( f );

		while ( sc.hasNextLine() ) {

			String[] temp = sc.nextLine().split( ";" );
			this.einfuegen( temp[ 0 ], temp[ 1 ] );

		}

		sc.close();

	}

	public void mitarbeiterEinlesen( URL url ) {

		try( Scanner sc = new Scanner( url.openStream() ) ) {

			while ( sc.hasNextLine() ) {

				String[] temp = sc.nextLine().split( ";" );
				this.einfuegen( temp[ 0 ], temp[ 1 ] );

			}

		}

		catch ( IOException e ) {

			System.out.println( e.getMessage() );

		}

	}

}