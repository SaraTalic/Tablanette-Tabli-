package projekat;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;


public class Igrac {
	
	String ime;
	public static int port=12345;
	static Scanner scan=new Scanner(System.in);
	
	
	Igrac(String ime){
		
		
		this.ime=ime;
		
		try(Socket sock=new Socket("localhost",port)){
			
			IgracPise ipise=new IgracPise(this.ime,sock);
			IgracCita icita=new IgracCita(this.ime,sock);
			
			ipise.start();
			icita.start();
			
			ipise.join();
			icita.join();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[]args) {
		System.out.println("Unesite Vase ime:");
		String ime=scan.nextLine();
		Igrac ig=new Igrac(ime);
		
	}

}
