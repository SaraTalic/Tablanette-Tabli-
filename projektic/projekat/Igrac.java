package projekat;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;


public class Igrac {
	
	String ime;
	public static int port=12345;
	static Scanner scan=new Scanner(System.in);
	public ArrayList<Karta> karteURuci=new ArrayList<Karta>();
	public ArrayList<Karta> karteNaStolu=new ArrayList<Karta>();
	
	public Igrac(String ime){
		
		this.ime=ime;
		
		try(Socket sock=new Socket("localhost",port)){
			
			IgracPise ipise=new IgracPise(this,this.ime,sock);
			IgracCita icita=new IgracCita(this,this.ime,sock);
			
			ipise.start();
			icita.start();
			
			ipise.join();
			icita.join();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public Karta vratiKartuIzRuke(int ind) {
		if(ind>this.karteURuci.size())
			return null;
		return this.karteURuci.get(ind-1);
	}
	
	public void obrisiKartuIzRuke(int ind) {
		this.karteURuci.remove(ind-1);
	}

	public void isipisiKarteURuci() {
		System.out.println("Vase karte: ");
		System.out.println("---------------------------");
		String karte="";
		for(Karta k:this.karteURuci)
			karte+=k+"|";
		System.out.println(karte);
		System.out.println("---------------------------");
	}
	
	public void isipisiKarteSaStola() {
		System.err.println("Karte na stolu: ");
		System.err.println("---------------------------");
		String karte="";
		for(Karta k:this.karteNaStolu)
			karte+=k+"|";
		System.err.println(karte);
		System.err.println("---------------------------");
	}
	
	public static void main(String[]args) {
		System.out.println("Unesite Vase ime:");
		String ime=scan.nextLine();
		Igrac ig=new Igrac(ime);
		
	}

}
