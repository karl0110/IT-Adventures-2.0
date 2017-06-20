package com.it.main;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Klasse lädt Bilder aus Dateien in dem BufferedImage Format.
 * 
 * @author Jaime Hall
 * @see BufferedImage
 *
 */
public class BufferedImageLoader {

	/**
	 * Methode lädt einzelnes Bild aus einer Datei.
	 * 
	 * 
	 * @param path Position der Datei im Datei-Explorer
	 * @return Das Bild welches aus der Datei geladen wird.
	 * 
	 */
	public BufferedImage loadImage(String path) {
		BufferedImage img=null;
		try {
			img=ImageIO.read(getClass().getResource(path));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return img;
	}
	
	/**
	 * Methode lädt einen Teil eines Bildes aus einer Datei
	 * 
	 * @param ssPath Postion der Datei des Gesamtbildes.
	 * @param ssCol Spalte in der sich das Teilbild befindet.
	 * @param ssRow Zeile in der sich das Teilbild befindet.
	 * @param width Breite des Teilbildes.
	 * @param height Höhe des Teilbildes.
	 * @return Das Teilbild welches aus der Datei geladen wird.
	 */
	public BufferedImage loadImageFromSS(String ssPath,int ssCol,int ssRow,int width,int height){
		BufferedImage img=null;
		
		img=loadImage(ssPath).getSubimage((ssCol*width)-width, (ssRow*height)-height, width, height);
		
		return img;
	}
	
	/**
	 * Methode lädt mehrere Bilder aus einer Zeile einer Bilddatei.
	 * 
	 * @param ssPath Postion der Datei des Gesamtbildes.
	 * @param numberOfImg Anzahl der Bilder welche geladen werden sollen.
	 * @param width Breite der Teilbilder.
	 * @param height Höhe der Teilbilder.
	 * @param ssRow Reihe in der sich die Teilbilder befinden.
	 * @return Ein Array welches alle geladenen Bilder beeinhaltet.
	 */
	public BufferedImage[] getImageSet(String ssPath,int numberOfImg,float width,float height,int ssRow){
		BufferedImage[] imageArray=new BufferedImage[numberOfImg];
		BufferedImage ss=loadImage(ssPath);
		
		
		for(int i=0;i<numberOfImg;i++){//Die Position der Teilbilder wird ermittelt, indem die Spalte mit der Breite der Teilbilder multipliziert wird.
			imageArray[i]=ss.getSubimage(((i+1)*(int)width)-(int)width, (ssRow*(int)height)-(int)height, (int)width, (int)height);
		}
		
		return imageArray;
	}
}
