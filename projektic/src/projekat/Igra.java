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
			
		/*	for(int j=0;j<server.naStolu.size();j++) {
				ig1.pisi("Karte na stolu: "+server.naStolu.get(j));
				ig2.pisi("Karte na stolu: "+server.naStolu.get(j));
			}
			*/
			
			if(ig1.karteURuci.size()==0 && ig2.karteURuci.size()==0) {
				System.err.println("helo");
				server.podijeliKarte(ig1);
				server.podijeliKarte(ig2);	
			}
			
			
			ig1.isipisiKarteURuci();
			ig2.isipisiKarteURuci();
			
			//Prvi igrac igra
			
			String odabrana="";
			try {
				ig1.pisi("Vi ste na potezu:");
				ig2.pisi("Protivnik je na potezu sacekajte.");
				odabrana = ig1.in.readLine().trim();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			String[] niz=odabrana.split(" ");
			Karta k = ig1.vratiKartuIzRuke(niz[1],Integer.parseInt(niz[0]));
			ig1.kupljenje(k);
			
			for(int j=0;j<server.naStolu.size();j++) {
				ig1.pisi("Karte na stolu: "+server.naStolu.get(j));
				ig2.pisi("Karte na stolu: "+server.naStolu.get(j));
			}
			
			ig1.isipisiKarteURuci();
			ig2.isipisiKarteURuci();
			
			//Drugi igrac igra
			
			String odabrana1="";
			try {
				ig2.pisi("Vi ste na potezu:");
				ig1.pisi("Protivnik je na potezu sacekajte.");
				odabrana1 = ig2.in.readLine().trim();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println(odabrana1);
			String[] niz1=odabrana1.split(" ");
			Karta k1 = ig2.vratiKartuIzRuke(niz1[1],Integer.parseInt(niz1[0]));
			ig2.kupljenje(k1);
			
				
		}
		ig1.prebrojBodove();
		ig1.pisi("Vas rezultat je: "+ig1.bodovi);
		ig2.prebrojBodove();
		ig2.pisi("Vas rezultat je: "+ig1.bodovi);

	}
}
