package com.it.main;

/**
 * @author Vincent Wiechmann, Karl Mattes
 *
 */
public abstract class TileObject extends Tile {

	protected Player player;
	
	
	
	public TileObject(float x,float y,BufferedImageLoader imageLoader,TileType type,Player player) {
		super(x,y,imageLoader,type);
		this.player=player;
		isTileEntity=false;
			
		
	}

}
