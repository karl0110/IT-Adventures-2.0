package com.it.main;

/**
 * @author vincent wiechmann, karl mattes
 *
 */
public abstract class TileObject extends Tile {

	protected Player player;
	
	
	
	public TileObject(float x,float y,BufferedImageLoader imageLoader,TileType type,Player player) {
		super(x,y,imageLoader,type);
		this.player=player;
		isTileEntity=false;
			
		
	}
	
	/**
	 * Es folgen alle Get-und Set Methoden, sowie die abstrakten Methoden f�r die Vererbung
	 */
	

	
}
