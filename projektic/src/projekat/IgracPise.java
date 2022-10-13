package projekat;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class IgracPise extends Thread{
	
	private String ime;
	public PrintWriter out;
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
			int i=0;
			while(true) {
				String saljem="";
				int br=0;
				
			
				while(true) {
					saljem=scan.nextLine();
					boolean isNumeric = saljem.chars().allMatch( Character::isDigit );
					if(!isNumeric) {
						System.out.println("Nepravilan unos! Unesite redni broj karte.");
					}
					else {
						br=Integer.parseInt(saljem);
						if(br>0 && br<igr.karteURuci.size()+1) {
							break;
						}
						else {
							System.out.println("Nemate toliko karata u ruci.");
						}
					}
					
				}
				Karta k= this.igr.vratiKartuIzRuke(br);
				this.igr.obrisiKartuIzRuke(br);
				
				if(saljem.equals("end"))
					break;
				out.println(k.toString());
				
			    i++;
				if(i==24)
					break;
			}
		}
	}
	
	public void posaljiPoruku(String poruka) {
		out.println(poruka);
	}
	
	
}
