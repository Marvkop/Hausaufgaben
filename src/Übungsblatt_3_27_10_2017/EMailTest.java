import java.io.FileNotFoundException;

public class EMailTest {

	public static void main(String[] args) {
		EMailAdressBuch test = new EMailAdressBuch();
		EMailAdressBuch matseExtern =new EMailAdressBuch();
		try{
		test.einlesen("emailadressbuch.txt");
		matseExtern.einlesen("mitarbeiter_matse_extern.txt");
		}catch (FileNotFoundException e){
			System.out.println(e.getMessage());
		}
		System.out.println(test.abfrage("Jan-Niklas Belunjak"));
		System.out.println(matseExtern.abfrage("Yvonne Albrecht"));
		
	}

}
