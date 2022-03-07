package com.Albert.Userinterface;

/*Imports*/

import javax.swing.JFrame;
import com.Albert.inout.KeyHandler;
import javax.swing.JLabel;


public class Gui {
	
	public static int width =320; // Breite Spielfeld
	public static int height =576; // Hoehe Spielfeld
	
	public static int anzahlbreite = 10; //Anzahl Felder in der Breite	
	public static int anzahlhoehe =18; // Anzahl der Felder in der Höhe
	
	
	JFrame jf; // Jframe
	
	
	public void create() { //Methode zum Erzeugen des GUIS wird in der MAin Klasse aufgerufen
		
		
		jf =new JFrame("TetrisAlbert"); // Titel des Fensters
		jf.setSize(width +217, height + 41); // Groesze des Spielfeldes + Linker Rand fuer Score + Hoehe damit es passt
		
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Rotes X = Fensterschlieszen
		jf.setLocationRelativeTo(null); //Mitte des Bildschirms
		jf.setResizable(false); //Groesze nicht veraenderbar
		
		jf.setLayout(null);  
		
		jf.addKeyListener(new KeyHandler()); //Tastatur
		
		jf.requestFocus();
		
		DrawMenu dm = new DrawMenu(); //  Menu objekts
		setupDraw(dm,0,0,width +200, height); // Ausführen der Methode setup Draw mit dem Draw Menu Objekt
		
		
		DrawGame dg =new DrawGame(); //Objekt zum des DrawGame
		setupDraw(dg,0,0,width+1,height+1); // Ausführen der Methode setup Draw mit dem Draw Game Objekt
		
		DrawInterface di =new DrawInterface(); // InterfaceObjekt
		setupDraw(di,width +1, 1, width ,height); //// Ausführen der Methode setup Draw mit dem Draw Interface Objekt
		
		jf.setVisible(true); //Sichtbar
		
	}
	
	private void setupDraw(JLabel draw, int x, int y, int width, int height) { //Methode zum zeichnen der Objekte mit Jframe
		draw.setBounds(x, y, width, height);
		draw.setVisible(true);
		jf.add(draw);	
	}	
}