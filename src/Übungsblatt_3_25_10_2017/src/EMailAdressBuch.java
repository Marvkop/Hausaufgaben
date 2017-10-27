import java.util.HashMap;

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
			ret+=buch.get
		}
	}
}
