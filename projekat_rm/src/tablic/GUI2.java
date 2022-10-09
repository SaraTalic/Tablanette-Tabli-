package tablic;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class GUI2 extends JFrame{
	
	Karte k=new Karte();
	Igrac igrac=new Igrac("stojan");
	
	Font fontCard = new Font("Times New Roman", Font.PLAIN, 40);
	Font fontQuest = new Font("Times New Roman", Font.BOLD, 40);
	
	ArrayList<Karta> sveKarte=k.sveKarte;
	
	ArrayList<Karta> karteNaStolu=k.naStolu;
	
	ArrayList<Karta> karteURuci=igrac.karteURuci;
	
	Color colorBackground = new Color(39,119,20);
	
	//screen resolution
	int sW = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	int sH = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		
	//window resolution
	int aW = 1300;
	int aH = 800;
		
	//card grid position and dimensions
	int gridX = 50;
	int gridY = 50;
	int gridW = 900;
	int gridH = 400;
		
	//card spacing and dimensions
	int spacing = 10;
	int rounding = 10;
	int tCardW = (int) gridW/6;
	int tCardH = (int) gridH/2;
	int cardW = tCardW - spacing*2;
	int cardH = tCardH - spacing*2;
	
	public GUI2() {
		
		this.setTitle("Tablic");
		this.setBounds((sW-aW-6)/2, (sH-aH-29)/2, aW+6, aH+29);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		
		
	}
	
	
	

}
