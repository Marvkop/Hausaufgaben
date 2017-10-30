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
     * @param Name der Name der Person
     * @param email die E-Mail-Adresse der Person
     */

	public void einfuegen ( String Name, String email ) {

		buch.put( Name, email );
		
	}

    /**
     * gibt die E-Mail-Adresse einer Person zurück
     * @param Name der Name der Person
     * @return die E-Mail-Adresse der Person
     */

	public String abfrage ( String Name ) {

		if ( buch.containsKey( Name ) ) {

            return buch.get( Name );

		} else {

			throw new UnknownNameException( "Name existiert nicht" );

		}

	}

    /**
     * gibt das gesamte Adressbuch als String zurück
     * @return das gesamte Adressbuch
     */

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

    /**
     * liest Namen und E-Mail-Adressen aus einer Datei ein
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

            while (sc.hasNextLine()) {

                String[] temp = sc.nextLine().split(";");
                this.einfuegen( temp[ 0 ], temp[ 1 ] );

            }

        } catch ( IOException e ) {

			System.out.println( e.getMessage() );

		}

	}

}