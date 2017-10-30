package Übungsblatt_3_27_10_2017;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Scanner;

public class EMailAdressBuch {

	private HashMap <String, String> buch = new HashMap<>();

    /**
     * erzeugt ein neues leeres Adressbuch
     */

	public EMailAdressBuch () {
		
	}

    /**
     * fügt dem Adressbuch einen neuen Eintrag hinzu
     * @param name der Name der Person
     * @param email die E-Mail-Adresse der Person
     */

	public void einfuegen ( String name, String email ) {

		buch.put( name, email );
		
	}

    /**
     * gibt die E-Mail-Adresse einer Person zurück
     * @param name der Name der Person
     * @return die E-Mail-Adresse der Person
     */

	public String abfrage ( String name ) {

		if ( buch.containsKey( name ) ) {

            return buch.get( name );

		} else {

			throw new UnknownNameException( "Name existiert nicht" );

		}

	}

    /**
     * gibt das gesamte Adressbuch als String zurück
     * @return das gesamte Adressbuch
     */

	public String toString() {

	    StringBuilder ret = new StringBuilder();
		String[] tempName = buch.keySet().toArray( new String[]{} );
		String[] tempEmail = buch.values().toArray( new String[]{} );

        ret.append( "{ " );

		for ( int j = 0; j < buch.size(); j++ ) {

			ret.append( tempName[ j ] )
                    .append( " = " )
                    .append( tempEmail[ j ] )
                    .append( ( j < buch.size() - 1 ?  ", " : "" ) ); // beim letzten element soll kein komma angehängt werden

		}

		return ret.append( " }" ).toString();

	}

    /**
     * liest die Namen und E-Mail-Adressen aus einer Datei ein
     * @param dateiname der Name der Datei
     * @throws FileNotFoundException falls Name fehlerhaft
     */

	public void einlesen ( String dateiname ) throws FileNotFoundException {

		File f = new File ( dateiname );
		Scanner sc = new Scanner ( f );

		while ( sc.hasNextLine() ) {

			String[] temp = sc.nextLine().split( ";" );
			this.einfuegen( temp[ 0 ], temp[ 1 ] );

		}

		sc.close();

	}

    /**
     * liest die Namen und E-Mail-Adressen aus einer URL ein
     * @param url die URL auf der sich die einzulesende Datei befindet
     */

	public void mitarbeiterEinlesen ( URL url ) {

		try( Scanner sc = new Scanner( url.openStream() ) ) {

            while ( sc.hasNextLine() ) {

                String[] temp = sc.nextLine().split(";");
                this.einfuegen( temp[ 0 ], temp[ 1 ] );

            }

        } catch ( IOException e ) {

			System.out.println( e.getMessage() );

		}

	}

}