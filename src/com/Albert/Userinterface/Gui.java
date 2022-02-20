package com.Albert.Userinterface;

import javax.swing.JFrame;
import com.Albert.inout.KeyHandler;
import javax.swing.JLabel;


public class Gui {
	
	public static int width =320; // Breite Spielfeld
	public static int height =576; // Hoehe Spielfeld
	
	public static int anzahlbreite = 10; //Anzahl Felder in der Breite	
	public static int anzahlhoehe =18; // Anzahl der Felder in der Höhe
	
	
	JFrame jf;
	
	
	public void create() { //Methode zum Erzeugen des GUIS
		
		
		jf =new JFrame("TetrisAlbert");
		jf.setSize(width +217, height + 41); // Groesze des Spielfeldes + Linker Rand fuer Score + Hoehe damit es passt
		
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Rotes X = Fensterschlieszen
		jf.setLocationRelativeTo(null); //Mitte des Bildschirms
		jf.setResizable(false); //Groesze nicht veraenderbar
		
		jf.setLayout(null);  
		
		jf.addKeyListener(new KeyHandler()); //Neues Objekt der Klasse KeyHandler
		
		jf.requestFocus();
		
		DrawMenu dm = new DrawMenu();
		setupDraw(dm,0,0,width +200, height);
		
		
		DrawGame dg =new DrawGame(); //Objekt zum  zeichnen der Kaestchend des Spielfelds
		setupDraw(dg,0,0,width+1,height+1); 
		
		DrawInterface di =new DrawInterface(); //Zeichnen des Felds für den nächsten Block
		setupDraw(di,width +1, 1, width ,height);
		
		jf.setVisible(true); //Sichtbar
		
	}
	
	private void setupDraw(JLabel draw, int x, int y, int width, int height) { //Methode zum zeichnen 
		draw.setBounds(x, y, width, height);
		draw.setVisible(true);
		jf.add(draw);
		
	}
	
	
}
