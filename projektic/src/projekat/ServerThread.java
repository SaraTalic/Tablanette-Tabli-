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
	
	
	public  ArrayList<Karta> pokupljene=new ArrayList<Karta>();
	public int bodovi;
	
	
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
	            //pokupljeno=false;
	                       
	            for (int j = 0; j < Server.naStolu.size(); j++) {
	                if ((i & (1 << j)) > 0) {
	                	podskupa.add(Server.naStolu.get(j));
	                 }
	            }
	            
	            System.out.println(podskupa);
	            for(Karta juhu: podskupa) {
	            	suma+=juhu.vrijednost;
	            	
	            }	            
	            if(suma==izabrana.vrijednost ) {
	            	for(Karta ka: podskupa) {
	            		System.out.println("odgovara "+ka.vrijednost+", "+ka.znak);
	            		pokupljene.add(ka);
	            		Server.naStolu.remove(ka);
	            		
	            	}
	         //   	karteURuci.remove(izabrana);
	            	pokupljeno=true;
	           }
	      }
		 
		 if(!pokupljeno) {
			 Server.naStolu.add(izabrana);
		//	 karteURuci.remove(izabrana);
		 }
	 else {
			 pokupljene.add(izabrana);
			 //karteURuci.remove(izabrana);
		 }
	}
	
	//bez table
	public void prebrojBodove() {
		
		for(Karta k: pokupljene) {
			//2 mak 
			if(k.znak.equals("tref") && k.vrijednost==2) {
				bodovi+=2;
			}
			//10 i 10 karo
			if(k.vrijednost==10) {
				bodovi+=1;
				if(k.znak.equals("karo"))
					bodovi+=1;
			}
			//slike
			if(k.vrijednost==12 || k.vrijednost==13 ||k.vrijednost==14) {
				bodovi+=1;
			}
			//kec
			if(k.vrijednost==1) {
				bodovi+=1;
			}
			
		}
		if(pokupljene.size()>26)
			bodovi+=3;
	}
	
	
	
}
