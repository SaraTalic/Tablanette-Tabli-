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
				String saljem="";
				int br=0;
				//ako se zezne posalje pogresan broj dobija sanse nove
				while(true) {
					saljem=scan.nextLine();
					br=Integer.parseInt(saljem);
					if(br>0 && br<igr.karteURuci.size()+1) {
						break;
					}
					else {
						System.out.println("Nemate toliko karata u ruci.");
					}
				}
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
