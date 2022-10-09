package projekat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class ServerThread {
	
	String ime;
	Server server;
	Socket socket;
	BufferedReader in;
	PrintWriter out;
	
	public  ArrayList<Karta> karteURuci=new ArrayList<Karta>();
	public  ArrayList<Karta> pokupljene=new ArrayList<Karta>();
	
	
	ServerThread(Socket socket, Server server){
		this.server=server;
		this.socket=socket;
		
		try {
			this.in= new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
			this.out=new PrintWriter(new BufferedWriter(new OutputStreamWriter(this.socket.getOutputStream())),true);
			this.ime=in.readLine();
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}

	public void pisi(String poruka) {
		this.out.println(poruka);
	}
	
	public void kupljenje(Karta izabrana) {
		
		boolean pokupljeno=false;
		 for (int i = 0; i < (1<<Server.naStolu.size()); i++){
	          
	            ArrayList<Karta> podskupa=new ArrayList<Karta>();
	            int suma=0;
	            pokupljeno=false;
	            for (int j = 0; j < Server.naStolu.size(); j++) {
	                if ((i & (1 << j)) > 0) {
	                	podskupa.add(Server.naStolu.get(j));
	                 }
	            }
	            
	            System.out.println(podskupa);
	            for(Karta juhu: podskupa) {
	            	suma+=juhu.vrijednost;
	            	
	            }	            
	            if(suma==izabrana.vrijednost) {
	            	for(Karta ka: podskupa) {
	            		System.out.println("odgovara "+ka.vrijednost+", "+ka.znak);
	            		pokupljene.add(ka);
	            		Server.naStolu.remove(ka);
	            	}
	            	pokupljeno=true;
	           }
	      }
		 
		 if(!pokupljeno) {
			 Server.naStolu.add(izabrana);
			 karteURuci.remove(izabrana);
		 }
		 else {
			 pokupljene.add(izabrana);
			 karteURuci.remove(izabrana);
		 }
	}

	public Karta vratiKartuIzRuke(String znak,int vrijednost) {
		
		for(Karta k :karteURuci)
			if(k.vrijednost==vrijednost && k.znak.equals(znak))
				return k;
		return null;
	}
	
	public void obrisiKartuIzRuke(String znak,int vrijednost) {
		
		for(Karta k :karteURuci)
			if(k.vrijednost==vrijednost && k.znak.equals(znak))
				karteURuci.remove(k);
	}

	public void isipisiKarteURuci() {
		this.pisi("Vase karte: ");
		this.pisi("---------------------------");
		String karte="";
		for(Karta k:karteURuci)
			karte+=k+"|";
		this.pisi(karte);
		this.pisi("---------------------------");
	}
	
	
}
