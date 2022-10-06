package tablic;

import java.util.ArrayList;

public class Testic {
	
	private static ArrayList<Karta> naStolu=new ArrayList<Karta>();
	private static ArrayList<Karta> pokupljeno=new ArrayList<Karta>();
	
	static void printSubsets(ArrayList<Karta> set, Karta k)
    {
     
 
        // Run a loop for printing all 2^n
        // subsets one by one
        for (int i = 0; i < (1<<set.size()); i++)
        {
            System.out.print("{ ");
            ArrayList<Karta> podskupa=new ArrayList<Karta>();
            int suma=0;
            // Print current subset
            for (int j = 0; j < set.size(); j++) {
            	
                if ((i & (1 << j)) > 0) {
                	podskupa.add(naStolu.get(j));
                    System.out.print(set.get(j).vrijednost + " ");
                
                }
           
            }
            System.out.println("}");
            
            for(Karta juhu: podskupa) {
            	suma+=juhu.vrijednost;
            	
            }
            System.out.println("suma  "+suma);
            while(true) {
            if(suma==k.vrijednost) {
            	for(Karta ka: podskupa) {
            		System.out.println("odgovara "+ka.vrijednost+", "+ka.znak);
            		pokupljeno.add(ka);
            		naStolu.remove(ka);
            		set.remove(ka);
            		
            	}
            	//break;
            }
            else
            	break;
            
            }
          
            
        }
    }
 
 
    public static void main(String[] args)
    {
        Karta k=new Karta("tref",7);
        
        naStolu.add(new Karta("herc",2));
        naStolu.add(new Karta("karo",4));
        naStolu.add(new Karta("karo",5));
        naStolu.add(new Karta("tref",3));
        
        printSubsets(naStolu,k);
       // printSubsets(naStolu,k);
        
    }

}
