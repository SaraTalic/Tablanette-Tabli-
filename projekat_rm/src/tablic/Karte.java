package tablic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class Karte {
	
	public static ArrayList<Karta> sveKarte=new ArrayList<Karta>();
	static Random rand=new Random();
	
	public static ArrayList<Karta> naStolu=new ArrayList<Karta>();
	
	ArrayList<Integer> zbiroviNaStolu=new ArrayList<Integer>();
	

	
	
	
	
	
	//dodavanje svih karata
	public Karte() {
		

		
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
	
	public static ArrayList<Karta> postaviKarteNaSto() {
		
		ArrayList<Karta> kk=new ArrayList<Karta>();
		
		for(int i=0;i<4;i++) {
			
		
			
			int broj=rand.nextInt(sveKarte.size());
			naStolu.add(sveKarte.get(broj));
			kk.add(sveKarte.get(broj));
					
			sveKarte.remove(broj);
			
			
		}
		return kk;
		
	}
	
	public static void podijeliKarte(Igrac igrac) {
		
		for(int i=0;i<4;i++) {
			int broj=rand.nextInt(sveKarte.size());
			igrac.karteURuci.add(sveKarte.get(broj));
			sveKarte.remove(broj);
		}
	}
	
	/*public void zbiroviNaStolu(int[] arr, int l, int r, int sum) {
		
		
		if (l > r) {
            zbiroviNaStolu.add(sum);
            return;
        }
 
        // Subset including arr[l]
        zbiroviNaStolu(arr, l + 1, r, sum + arr[l]);
 
        // Subset excluding arr[l]
        zbiroviNaStolu(arr, l + 1, r, sum);
		
		
		
		
	}*/
	
	public static void main(String[]args) {
		Karte k=new Karte();
	}
	
	
	
}
