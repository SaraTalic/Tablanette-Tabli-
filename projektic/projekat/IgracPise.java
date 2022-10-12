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
	Igrac igr;
	
	public IgracPise(Igrac i,String ime,Socket sock) {
		
		this.ime=ime;
		this.socket=sock;
		this.igr=i;
		try {
			this.out=new PrintWriter(new BufferedWriter(new OutputStreamWriter(sock.getOutputStream())),true);
			out.println(this.ime);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	//u sustini bi trebalo da samo posaljem svoju kartu u svakom bacanju
	@Override
	public void run() {
		
		try (Scanner scan=new Scanner(System.in)){
			
			while(true) {
				String saljem=scan.nextLine();
				int br=Integer.parseInt(saljem);
				Karta k= this.igr.vratiKartuIzRuke(br);
				this.igr.obrisiKartuIzRuke(br);
				
				if(saljem.equals("end"))
					break;
				out.println(k.toString());
				
			}
		}
	}
	
	public void posaljiPoruku(String poruka) {
		out.println(poruka);
	}
	
	
}
