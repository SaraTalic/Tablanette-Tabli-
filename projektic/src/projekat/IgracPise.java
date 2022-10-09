package projekat;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class IgracPise extends Thread{
	
	private String ime;
	private PrintWriter out;
	private Socket socket;
	
	public IgracPise(String ime,Socket sock) {
		
		this.ime=ime;
		this.socket=sock;
		
		try {
			this.out=new PrintWriter(new BufferedWriter(new OutputStreamWriter(sock.getOutputStream())));
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	//u sustini bi trebalo da samo posaljem svoju kartu u svakom bacanju
	
	public void run() {
		
		try (Scanner scan=new Scanner(System.in)){
			
			for(int i=0;i<24;i++) {
				System.out.println("Koju kartu birate?");
				String saljem=scan.nextLine();
				out.println(saljem);
				
			}
			
			
		}
		
	}
	
	
}
