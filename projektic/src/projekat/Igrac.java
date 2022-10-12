package projekat;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;


public class Igrac {
	
	String ime;
	public static int port=12345;
	static Scanner scan=new Scanner(System.in);
	
	
	public Igrac(){
				
		try(Socket sock=new Socket("localhost",port)){
			
			IgracPise ipise=new IgracPise(sock);
			IgracCita icita=new IgracCita(sock);
			
			
			icita.start();
			

			icita.join();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
