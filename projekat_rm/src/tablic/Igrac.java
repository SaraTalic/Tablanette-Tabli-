package tablic;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Set;

import javax.swing.JFrame;

import javafx.application.Application;
import javafx.stage.Stage;

public class Igrac extends Application {
	
	String ime;
	public static ArrayList<Karta> karteURuci=new ArrayList<Karta>();
	public static ArrayList<Karta> pokupljene=new ArrayList<Karta>();
	int karte;
	int slike;
	int mak=0;
	int karo=0;
	
	Karta izabrana;
	
	public static int bodovi=0;
	
	public static int port=12345;
	
	
	Igrac(String ime){
		this.ime=ime;
		this.karteURuci=null;
		this.pokupljene=null;
		this.bodovi=0;
		
		try(Socket sock=new Socket("localhost",port)){
			
			IgracIgra igra=new IgracIgra(ime,sock);
			IgracCita cita=new IgracCita(ime,sock);
			
			igra.start();
			cita.start();
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void dodijeliRezultat() {
		
		karte=pokupljene.size();
		for(Karta k: pokupljene) {
			if(k.vrijednost==12 || k.vrijednost==13 || k.vrijednost==14)
				slike++;
			if(k.vrijednost==2 && k.znak.equals("tref"))
				mak=1;
			if(k.vrijednost==10 && k.znak.equals("karo"))
				karo=1;
		}
		bodovi+=slike+karte+2*mak+2*karo;
		
	}
	
	public static void kupljenje(Karta izabrana) {
		
		boolean pokupljeno=false;
		
		
		 for (int i = 0; i < (1<<Karte.naStolu.size()); i++){
	            //System.out.print("{ ");
	            ArrayList<Karta> podskupa=new ArrayList<Karta>();
	            int suma=0;
	            pokupljeno=false;
	            for (int j = 0; j < Karte.naStolu.size(); j++) {
	            	
	                if ((i & (1 << j)) > 0) {
	                	podskupa.add(Karte.naStolu.get(j));
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
	            		Karte.naStolu.remove(ka);
	            	}
	            	pokupljeno=true;
	           }
	      }
		 
		 //ako nemamo sta pokupiti, stavljamo kartu na sto
		 if(!pokupljeno) {
			 Karte.naStolu.add(izabrana);
			 karteURuci.remove(izabrana);
		 }
		 //inace ako smo pokupili samo dodamo i nasu kartu u pokupljene
		 else {
			 pokupljene.add(izabrana);
		 }

	}

	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		
	}
}
