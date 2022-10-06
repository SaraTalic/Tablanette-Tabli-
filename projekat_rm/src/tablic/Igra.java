package tablic;

public class Igra {

	Igra(Igrac ig1,Igrac ig2){
		
		Karte.postaviKarteNaSto();
		
		while(true) {
			
			//podijelimo karte igracima
			if(ig1.karteURuci.size()==0 && ig2.karteURuci.size()==0) {
				Karte.podijeliKarte(ig1);
				Karte.podijeliKarte(ig2);
			}
			//prvi koji se prijavio igra prvi NPR
			Karta k=new Karta("tref",2);
			Karta k1=new Karta("tref",2);
			ig1.kupljenje(k);
			//tabla
			if(Karte.naStolu.size()==0)
				ig1.bodovi+=1;
			ig2.kupljenje(k1);
			//tabla
			if(Karte.naStolu.size()==0)
				ig2.bodovi+=1;
			
			//treba postaviti da kupi zadnje karte onaj ko je zadnji nosio
			
			if(Karte.sveKarte.size()==0 && Karte.naStolu.size()==0 && ig1.karteURuci.size()==0 && ig2.karteURuci.size()==0) {
				break;
			}
		}
		
		
	}
	
	
}
