package com.it.main;

import java.awt.Graphics;


/**
 * TileEntity ist die Oberklasse aller Spielobjekte, welche aktualisiert werden müssen, da sie ihren Zustand über die Zeit ändern.
 * 
 * @author Jaime Hall
 *
 */
public abstract class TileEntity extends Tile {

	protected TileHandler handler;

	public TileEntity(float x, float y, BufferedImageLoader imageLoader, TileType type, TileHandler handler) {
		super(x, y, imageLoader, type);
		this.handler = handler;
		isTileEntity = true;
	}

	/**
	 * Diese Methode nutzt Kollisionrechtecke, um zu überprüfen, ob ein Objekt einer Subklasse mit einem anderen kollidiert. Die Reaktion auf diese Kollidierung wird mithilfe von abstrakten Methoden absolviert.
	 */
	protected void collision() {
		for (int i = 0; i < handler.object.size(); i++) {
			Tile tempObject = handler.object.get(i);
			if (tempObject.isPassable() == false) {
				if (getBottomBounds().intersects(tempObject.getUpperBounds())) {

					bottomCollisionReaction(tempObject);

				} else {
					falling = true;
				}

				if (getUpperBounds().intersects(tempObject.getBottomBounds())) {

					upperCollisionReaction(tempObject);

				}

				if (getLeftBounds().intersects(tempObject.getRightBounds())) {

					leftCollisionReaction(tempObject);

				}
				if (getRightBounds().intersects(tempObject.getLeftBounds())) {

					rightCollisionReaction(tempObject);

				}
			}
		}
	}
	/**
	 * Reaktion auf die kollidierung mit einem anderen Spielobjekt.
	 * @param tempObject Das Objekt mit dem kollidiert wurde.
	 */
	public abstract void leftCollisionReaction(Tile tempObject);
	/**
	 * Reaktion auf die kollidierung mit einem anderen Spielobjekt.
	 * @param tempObject Das Objekt mit dem kollidiert wurde.
	 */
	public abstract void rightCollisionReaction(Tile tempObject);
	/**
	 * Reaktion auf die kollidierung mit einem anderen Spielobjekt.
	 * @param tempObject Das Objekt mit dem kollidiert wurde.
	 */
	public abstract void upperCollisionReaction(Tile tempObject);
	/**
	 * Reaktion auf die kollidierung mit einem anderen Spielobjekt.
	 * @param tempObject Das Objekt mit dem kollidiert wurde.
	 */
	public abstract void bottomCollisionReaction(Tile tempObject);

	public abstract void render(Graphics g);

	public abstract void tick();

}
