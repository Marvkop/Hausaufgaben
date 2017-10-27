import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Scanner;

public class EMailAdressBuch {
	private HashMap <String, String> buch=new HashMap<>();
	public EMailAdressBuch (){
		
	}
	public void einfuegen(String Name, String email){
		buch.put(Name,email);
		
	}
	public String abfrage(String Name){
		if (buch.containsKey(Name)){
		String ret= buch.get(Name);
		return ret;
		}else{
			throw new UnknownNameException("Name existiert nicht");
		}
	}
	public String toString(){
		String ret="";
		for (int i=0; i<buch.size();i++){
		}
		return ret;
	}
	public void einlesen (String dateiname)throws FileNotFoundException{
		File f = new File (dateiname);
		Scanner sc = new Scanner (f);
		while (sc.hasNextLine()){
			String []temp=sc.nextLine().split(";");
			this.einfuegen(temp[0], temp[1]);
		}sc.close();
	}
	public void mitarbeiterEinlesen(URL url){
		try(Scanner sc = new Scanner(url.openStream());){
			while (sc.hasNextLine()){
				String [] temp= sc.nextLine().split(";");
				this.einfuegen(temp[0], temp[1]);
			}
		}
		catch (IOException e){
			System.out.println(e.getMessage());
		}
	}
}