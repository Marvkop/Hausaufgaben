import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;

public class EMailTest {

	public static void main(String[] args) {
		EMailAdressBuch test = new EMailAdressBuch();
		EMailAdressBuch matseExtern =new EMailAdressBuch();
		EMailAdressBuch matseIntern=new EMailAdressBuch();
		try{
		test.einlesen("emailadressbuch.txt");
		matseExtern.einlesen("mitarbeiter_matse_extern.txt");
		matseIntern.mitarbeiterEinlesen(new URL("https://doc.itc.rwth-aachen.de/download/attachments/5800183/mitarbeiter_matse_intern.txt"));
		}catch (FileNotFoundException | MalformedURLException e){
			System.out.println(e.getMessage());
		}
		System.out.println(test.abfrage("Jan-Niklas Belunjak"));
		System.out.println(matseExtern.abfrage("Yvonne Albrecht"));
		System.out.println(matseIntern.abfrage("Hans Joachim Pflug"));
		System.out.println(matseIntern.toString());
	}

}
