
package com.it.main;

import java.awt.Graphics;
import java.util.LinkedList;

/**
 * Das Objekt dieser Klasse beeinhaltet alle Objekte des aktuellen Levels in
 * einer Liste. Von diesen werden dann alle Grafiken gemalt und alle Objekte die
 * dies benötigen, werden aktualisiert.
 * 
 * @author Jaime Hall
 *
 */
public class TileHandler {

	public LinkedList<Tile> object = new LinkedList<Tile>();// Alle Spielobjekte
	public LinkedList<TileEntity> tickObject = new LinkedList<TileEntity>();// Alle
																			// zu
																			// aktualisierenden
																			// Objekte

	public void tick() {
		for (int i = 0; i < tickObject.size(); i++) {
			TileEntity tempObject = tickObject.get(i);

			tempObject.tick();

		}
	}

	public void render(Graphics g) {
		for (int i = 0; i < object.size(); i++) {
			Tile tempObject = object.get(i);

			tempObject.render(g);
		}
	}

	/**
	 * Methode fügt den Listen ein neues Objekt hinzu.
	 * 
	 * @param object
	 *            Das neue Spielobjekt
	 */
	public void addObject(Tile object) {
		this.object.add(object);
		if (object.isTileEntity()) {
			this.tickObject.add((TileEntity) object);
		}
	}

	/**
	 * Methode entfernt ein Objekt aus den Listen.
	 * 
	 * @param object Das zu entfernende Objekt.
	 */
	public void removeObject(Tile object) {
		this.object.remove(object);
		if (object.isTileEntity()) {
			this.tickObject.remove((TileEntity) object);
		}
	}

	/**
	 * Entfernt alle Objekte aus den Listen.
	 */
	public void removeAllObjects() {
		object = new LinkedList<Tile>();
		tickObject = new LinkedList<TileEntity>();
	}
}
