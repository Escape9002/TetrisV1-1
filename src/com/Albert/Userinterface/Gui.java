package com.Albert.Userinterface;

import javax.swing.JFrame;
import com.Albert.inout.KeyHandler;
import javax.swing.JLabel;


public class Gui {

	
	public static int width =320; // Breite Spielfeld
	public static int height =576; //Höhe Spielfeld
	
	public static int anzahlbreite = 10;
	public static int anzahlhöhe =18;
	
	
	JFrame jf;
	
	
	public void create() { // Start was passiert
		
		
		jf =new JFrame("TetrisAlbert");
		jf.setSize(width +217, height + 41); // Größe des Spielf eldes +Linker Rand für Score + Höhe damit es passt
		
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Rotes X = Fensterschließen
		jf.setLocationRelativeTo(null); //Mitte des Bildschirms
		jf.setResizable(false); //Größe nicht veränderbar
		
		jf.setLayout(null);  
		
		jf.addKeyListener(new KeyHandler()); //Neues Objekt der Klasse KeyHandler
		
		jf.requestFocus();
		
		DrawGame dg =new DrawGame(); //Objekt Draw game Obejkt der felderlinien
		setupDraw(dg,0,0,width+1,height+1); //Methode SetupDraw mit den Parametern die übergeben werden
		
		DrawInterface di =new DrawInterface();
		setupDraw(di,width +1, 1, width ,height);
		
		jf.setVisible(true); //Sichtbar
		
	}
	
	private void setupDraw(JLabel draw, int x, int y, int width, int height) { //Benötigt da mehrere Draw-Klassen
		draw.setBounds(x, y, width, height);
		draw.setVisible(true);
		jf.add(draw);
		
	}
	
	
}
