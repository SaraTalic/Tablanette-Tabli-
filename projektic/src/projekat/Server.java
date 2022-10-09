package projekat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;






public class Server {
	
	int port=Igrac.port;
	
	public static ArrayList<Karta> sveKarte=new ArrayList<Karta>();
	
	public static ArrayList<Karta> naStolu=new ArrayList<Karta>();
	
	public static ArrayList<ServerThread> igraci=new ArrayList<ServerThread>();
	
	static Random rand=new Random();
	
	Server(){
		
		try(ServerSocket ss=new ServerSocket(port)){
			
			System.err.println("Server radi.");
			
			promijesajKarte();
			
			while(true) {
				
				Socket sock=ss.accept();
				
				ServerThread igrac=new ServerThread(sock,this);
				igraci.add(igrac);
				
				if(igraci.size()==2) {
					
					igraci.get(0).pisi("Igra je Krenula.");
					igraci.get(1).pisi("Igra je Krenula.");
					Igra ig=new Igra(this,igraci.get(0),igraci.get(1));
				}
				
				
				
				
			}
			
			
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void promijesajKarte() {
		
		for(int i=1;i<15;i++) {
			
			if(i==11)
				continue;
			else {
			
			sveKarte.add(new Karta("herc",i));
			sveKarte.add(new Karta("tref",i));
			sveKarte.add(new Karta("pik",i));
			sveKarte.add(new Karta("karo",i));
			
			}
			
		}
		
		Collections.shuffle(sveKarte);
	}
	
	public static void postaviKarteNaSto() {
		
		
		
		for(int i=0;i<4;i++) {
			
		
			
			int broj=rand.nextInt(sveKarte.size());
			naStolu.add(sveKarte.get(broj));
			sveKarte.remove(broj);
			
			
		}
		
	}
	
public static void podijeliKarte(ServerThread st) {
		
		for(int i=0;i<6;i++) {
			int broj=rand.nextInt(sveKarte.size());
			st.karteURuci.add(sveKarte.get(broj));
			sveKarte.remove(broj);
		}
	}

public static void main(String[]args) {
	Server s=new Server();
}
	

}
