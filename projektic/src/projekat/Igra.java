package projekat;

import java.io.IOException;

public class Igra {
	
	Server server;
	ServerThread igrac1,igrac2;
	boolean zadnjiIg2,zadnjiIg1,tablic;
	
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
			zadnjiIg1=ig1.kupljenje(k);
			tablic=tablic();
			
			if(zadnjiIg1)
				zadnjiIg2=false;
			if(tablic)
				ig1.bodovi+=1;
			
			
			//-----------------------------
			//Drugi igrac igra
			
			ig1.pisi(server.getNaStolu());
			ig2.pisi(server.getNaStolu());
			
			
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
			zadnjiIg2=ig2.kupljenje(k2);
			tablic=tablic();
			
			if(zadnjiIg2)
				zadnjiIg1=false;
			if(tablic)
				ig2.bodovi+=1;
			
			System.out.println(zadnjiIg2);
		}
		
		
		if(zadnjiIg1)
			dodajSaStola(ig1);
		else
			dodajSaStola(ig2);
		
		
		ig1.prebrojBodove();
		ig2.prebrojBodove();
		
		System.out.println(ig1.ime+" "+ig1.bodovi);
		System.out.println(ig2.ime+" "+ig2.bodovi);
	
		ig1.pisi("REZULTAT:");
		ig1.pisi("=========");
		ig1.pisi(ig1.ime+" : "+ig1.bodovi);
		ig1.pisi(ig2.ime+" : "+ig2.bodovi);
		ig1.pisi("=========");
		
		ig2.pisi("REZULTAT:");
		ig2.pisi("=========");
		ig2.pisi(ig2.ime+" : "+ig2.bodovi);
		ig2.pisi(ig1.ime+" : "+ig1.bodovi);
		ig1.pisi("=========");
	
		if(ig1.bodovi>ig2.bodovi) {
			ig1.pisi("POBIJEDILI STE! Cestitamo.");
			ig2.pisi("Izgubili ste. Vise srece drugi put!");
			
		}
		else if(ig1.bodovi<ig2.bodovi){
			ig2.pisi("POBIJEDILI STE! Cestitamo.");
			ig1.pisi("Izgubili ste. Vise srece drugi put!");
		}
		else {
			ig1.pisi("IZJEDNACENO!");
			ig2.pisi("IZJEDNACENO!");		
		}
		
		
		
	}
	
	public boolean tablic() {
		return server.getNaStolu().isEmpty();
	}
	
	public void dodajSaStola(ServerThread st) {
		for(Karta k :server.naStolu)
			st.pokupljene.add(k);	
	}
}
