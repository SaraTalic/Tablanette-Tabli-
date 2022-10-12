package projekat;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class IgracPise {
	
	private String ime;
	private PrintWriter out;
	private Socket socket;
	
	public IgracPise(String ime,Socket sock) {
		this.ime=ime;
		this.socket=sock;
		
		try {
			this.out=new PrintWriter(new BufferedWriter(new OutputStreamWriter(sock.getOutputStream())),true);
			out.println(this.ime);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	//u sustini bi trebalo da samo posaljem svoju kartu u svakom bacanju
/*	@Override
	public void run() {
		
		try (Scanner scan=new Scanner(System.in)){
			
			System.out.println("Unesite vase ime: ");
			this.ime=scan.nextLine();
			
			while(true) {
				String saljem=scan.nextLine();
				if(saljem.equals("end"))
					break;
				out.println(saljem);
				
			}
		}
	}
	*/
	
	public void posaljiPoruku(String poruka) {
		out.println(poruka);
	}
	
	
}
