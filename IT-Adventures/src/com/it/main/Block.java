package com.it.main;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

/**
 * 
 * @author Vincent, Karl
 *
 * Klasse zur Spezialisierung der Erstellung aller Blöcke im Spiel; Spezialisierung: Kollision, Aussehen.
 */
public class Block extends TileObject{

	public Block(float x,float y,BufferedImageLoader imageLoader,TileType type,BufferedImage image,Player player){
		super(x,y,imageLoader, type,player);
		this.image=image;
	}


	public void render(Graphics g) {

		if(player.getX()>x-Game.WIDTH &&player.getX()<x+Game.WIDTH){ // Nur die auf dem Bildschirm erkennbaren Blöcke werden geladen
			g.drawImage(image, (int)x, (int)y, (int)width, (int)height, null);
		}
		
	}

	// Alle Kollisionsrechtecke(-methoden) eines Objekts "Block" für die geregelte Kollision zwischen ihm und anderen Spielobjekten
	public Rectangle getUpperBounds() {
		return new Rectangle((int)x,(int)y,(int)width,(int)height);
	}

	
	public Rectangle getBottomBounds() {
		return new Rectangle((int)x,(int)y,(int)width,(int)height);
	}

	
	public Rectangle getLeftBounds() {
		return new Rectangle((int)x,(int)y,(int)width,(int)height);
	}

	
	public Rectangle getRightBounds() {
		return new Rectangle((int)x,(int)y,(int)width,(int)height);
	}

}
