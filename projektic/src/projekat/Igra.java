package projekat;

import java.io.IOException;

public class Igra {
	
	Server server;
	ServerThread igrac1,igrac2;
	
	Igra(Server server, ServerThread ig1, ServerThread ig2){
		this.server=server;
		
		this.igrac1=ig1;
		this.igrac2=ig2;
		
		server.postaviKarteNaSto();

		//bice 8 krugova
		for(int i=0;i<24;i++) {
			
			for(int j=0;j<server.naStolu.size();j++) {
				ig1.pisi("Karte na stolu: "+server.naStolu.get(j));
				ig2.pisi("Karte na stolu: "+server.naStolu.get(j));
			}
			
			if(ig1.karteURuci.size()==0 && ig2.karteURuci.size()==0) {
				server.podijeliKarte(ig1);
				server.podijeliKarte(ig2);
				
				ig1.isipisiKarteURuci();
				ig2.isipisiKarteURuci();
			}
			
			
			
			String odabrana="";
			try {
				odabrana = ig1.in.readLine().trim();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String[] niz=odabrana.split(" ");
			Karta iz=new Karta(niz[0],Integer.parseInt(niz[1]));
			
			ig1.kupljenje(iz);
			
			for(int j=0;j<server.naStolu.size();j++) {
				ig2.pisi("Karte na stolu: "+server.naStolu.get(j));
			}
			
			String odabrana1="";
			try {
				odabrana1 = ig2.in.readLine().trim();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String[] niz1=odabrana.split(" ");
			Karta iz1=new Karta(niz1[0],Integer.parseInt(niz1[1]));
			
			ig2.kupljenje(iz1);
			
		}
		
		
		
	}

}
