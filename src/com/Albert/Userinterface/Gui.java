package com.Albert.Userinterface;

import javax.swing.JFrame;



public class Gui {

	
	public static int width =320; // Breite Spielfeld
	public static int height =576; //Höhe Spielfeld
	
	JFrame jf;
	
	
	public void create() { // Start was passiert
		
		
		jf =new JFrame("TetrisAlbert");
		jf.setSize(width +217, height + 41); // Größe des Spielf eldes +Linker Rand für Score + Höhe damit es passt
		
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Rotes X = Fensterschließen
		jf.setLocationRelativeTo(null); //Mitte des Bildschirms
		jf.setResizable(false); //Größe nicht veränderbar
		
		jf.setLayout(null);  
		
		jf.addKeyListener(new KeyHandler); //Neues Objekt der Klasse KeyHandler
		
		jf.requestFocus();
		
		
		
	}
	
	
	
	
}
