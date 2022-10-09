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
	
	public static ArrayList<Karta> karteURuci=new ArrayList<Karta>();
	public static ArrayList<Karta> pokupljene=new ArrayList<Karta>();
	
	
	ServerThread(Socket socket, Server server){
		this.server=server;
		this.socket=socket;
		
		try {
			this.in= new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
			this.out=new PrintWriter(new BufferedWriter(new OutputStreamWriter(this.socket.getOutputStream())));
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}

	public void pisi(String poruka) {
		this.out.println(poruka);
	}
	
public static void kupljenje(Karta izabrana) {
		
		boolean pokupljeno=false;
		
		
		 for (int i = 0; i < (1<<Server.naStolu.size()); i++){
	            //System.out.print("{ ");
	            ArrayList<Karta> podskupa=new ArrayList<Karta>();
	            int suma=0;
	            pokupljeno=false;
	            for (int j = 0; j < Server.naStolu.size(); j++) {
	            	
	                if ((i & (1 << j)) > 0) {
	                	podskupa.add(Server.naStolu.get(j));
	                   // System.out.print(Karte.naStolu.get(j).vrijednost + " ");
	                 }
	            }
	          //  System.out.println("}");
	            
	            for(Karta juhu: podskupa) {
	            	suma+=juhu.vrijednost;
	            	
	            }
	           // System.out.println("suma  "+suma);
	            
	            if(suma==izabrana.vrijednost) {
	            	for(Karta ka: podskupa) {
	            		System.out.println("odgovara "+ka.vrijednost+", "+ka.znak);
	            		pokupljene.add(ka);
	            		Server.naStolu.remove(ka);
	            	}
	            	pokupljeno=true;
	           }
	      }
		 
		 //ako nemamo sta pokupiti, stavljamo kartu na sto
		 if(!pokupljeno) {
			 Server.naStolu.add(izabrana);
			 karteURuci.remove(izabrana);
		 }
		 //inace ako smo pokupili samo dodamo i nasu kartu u pokupljene
		 else {
			 pokupljene.add(izabrana);
		 }

	}
	
}
