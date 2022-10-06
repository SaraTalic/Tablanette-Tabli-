package tablic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import javafx.scene.control.Button;

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
		for(int i=0;i<sveKarte.size();i++) {

			System.out.println("["+sveKarte.get(i).znak+", "+sveKarte.get(i).vrijednost+"]");
		
		}
		postaviKarteNaSto();
		
		for(int i=0;i<naStolu.size();i++) {

			System.out.println("sto["+naStolu.get(i).znak+", "+naStolu.get(i).vrijednost+"]");
		
		}
	
		
	}
	
	public static void postaviKarteNaSto() {
		
		for(int i=0;i<4;i++) {
			
			int broj=rand.nextInt(sveKarte.size());
			naStolu.add(sveKarte.get(broj));
			sveKarte.remove(broj);
			
			
		}
		
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
