package projekat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import application.Main;

public class IgracCita extends Thread{
	

	private BufferedReader in;
	Main igrac;
	
	public IgracCita(Main m,Socket sock) {

		try {
			
			this.in=new BufferedReader(new InputStreamReader(sock.getInputStream()));
			this.igrac=m;
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public String procitaj() {
		try {
			return this.in.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public void run() {
		int i=0;
		
		
		while(true) {
			
			try {
				
				for(int b=0;b<6;b++) {
					String odg=in.readLine().trim();
					dodajUKarte(odg);
					Thread.sleep(30);
					if(odg==null)
						return;
				}
				this.igrac.updateURuci();
				
				
				for(int b=0;b<12;b++) {
					String odg=in.readLine().trim();
					dodajNaSto(odg);
					
					if(odg==null)
						return;
				}
				this.igrac.updateNaStolu();
				
			}catch(Exception e) {
				e.printStackTrace();
				break;
			}
		i++;
		}
	}
	
	public void dodajUKarte(String odg) {
		
		String niz[]=odg.split(" ");
		Karta k = new Karta(niz[1],Integer.parseInt(niz[0]));
		this.igrac.karteURuci.add(k);
	}
	public void dodajNaSto(String odg) {
		
		String niz[]=odg.split("#");
		
		for(int i =0;i<niz.length-1;i++) {
			String niz1[]=niz[i].split(" ");
			Karta k = new Karta(niz1[1],Integer.parseInt(niz1[0]));
			this.igrac.karteNaStolu.add(k);
		}
	}
	
}
