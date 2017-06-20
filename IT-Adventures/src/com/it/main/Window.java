package com.it.main;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Window extends Canvas {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	
	public Window(String title,int width,int height){
		frame = new JFrame(title);
		
		setMinimumSize(new Dimension(width,height));
		setPreferredSize(new Dimension(width,height));
		setMaximumSize(new Dimension(width,height));
		
		frame.add(this);//Das Spiel wird dem JFrame hinzugef�gt um Fensterpreferenzen zu �bernehmen.
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Erm�glicht das Beenden des Programmes durch Schlie�en des Fensters.
		frame.setUndecorated(true);//Entfernt die Men�leiste oben am Bildschirm (Vollbild)
		frame.pack();
		frame.setResizable(false);//Fenster kann nicht vergr��ert oder verkleinert werden, f�r korrekt Skalierung notwendig.
		frame.setLocationRelativeTo(null);//Bewegt Fenster in die Mitte des Bildschirms.
		frame.setVisible(true);//Macht das Fenster sichtbar.
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	
	
}
