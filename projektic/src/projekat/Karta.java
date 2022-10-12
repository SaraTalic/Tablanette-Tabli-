package projekat;

public class Karta {
	
	String znak;
	int vrijednost;
	
	Karta(String z, int v) {
		this.znak=z;
		this.vrijednost=v;
	}

	@Override
	public String toString() {
		return vrijednost+" "+znak;
	}

}
