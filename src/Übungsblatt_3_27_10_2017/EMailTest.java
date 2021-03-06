package Übungsblatt_3_27_10_2017;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;

public class EMailTest {

    public static void main(String[] args) {

        EMailAdressBuch test = new EMailAdressBuch();
        EMailAdressBuch matse = new EMailAdressBuch();

        try {

            test.einlesen("emailadressbuch.txt");

            matse.mitarbeiterEinlesen(new URL("https://doc.itc.rwth-aachen.de/download/attachments/5800183/mitarbeiter_matse_intern.txt"));
            matse.mitarbeiterEinlesen(new URL("https://doc.itc.rwth-aachen.de/download/attachments/5800183/mitarbeiter_matse_extern.txt"));

        } catch (FileNotFoundException | MalformedURLException e) {

            System.out.println(e.getMessage());

        }

        System.out.println(matse.abfrage("Hans Joachim Pflug"));
        System.out.println(matse);
        System.out.println();
        System.out.println(test.abfrage("Jan-Niklas Belunjak"));
        System.out.println(test);



    }

}
