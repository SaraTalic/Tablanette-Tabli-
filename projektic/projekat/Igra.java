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
			
			ig1.pisi(server.getNaStolu());
			ig2.pisi(server.getNaStolu());
			
			
			if(i%6==0) {
				System.err.println("Dijelim karte!");
				server.podijeliKarte(ig1);
				server.podijeliKarte(ig2);	
			}
			
			
			//Prvi igrac igra
			
			String odabrana="";
			try {
				ig1.pisi("Vi ste na potezu:");
				ig2.pisi("Protivnik je na potezu sacekajte.");
				odabrana = ig1.in.readLine().trim();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println(odabrana);
			String niz[]=odabrana.split(" ");
			Karta k = new Karta(niz[1], Integer.parseInt(niz[0]));
			ig1.kupljenje(k);
			
			//-----------------------------
			//Drugi igrac igra
			
			ig1.pisi(server.getNaStolu());
			ig2.pisi(server.getNaStolu());
			
			
			System.out.println("OPA");
			String odabrana2="";
			try {
				ig2.pisi("Vi ste na potezu:");
				ig1.pisi("Protivnik je na potezu sacekajte.");
				odabrana = ig2.in.readLine().trim();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println(odabrana);
			String niz2[]=odabrana.split(" ");
			Karta k2 = new Karta(niz2[1], Integer.parseInt(niz2[0]));
			ig2.kupljenje(k2);
			
			
				
		}
		ig1.prebrojBodove();
		ig1.pisi("Vas rezultat je: "+ig1.bodovi);
		ig2.prebrojBodove();
		ig2.pisi("Vas rezultat je: "+ig1.bodovi);

	}
	
	
	
}
