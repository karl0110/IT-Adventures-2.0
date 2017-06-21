package com.it.main;

/**
 * Dies ist die abstrakte Oberklasse aller lebenden TileEntities. Subklassen erhalten von dieser Klasse Informationen �ber ihre Leben und ihren Aktions-Cooldown. Zus�tzlich speichert die Klasse auch eine HealthBar, welche �ber aller Objekte Subklassen angezeigt wird.
 * 
 * @author Jaime Hall, Filip Vojnovic
 *
 */
public abstract class LivingTileEntity extends TileEntity {

	protected float health;
	protected boolean facingRight;
	protected HealthBar healthBar;
	protected int cooldown;
	
	public LivingTileEntity(float x, float y, BufferedImageLoader imageLoader, TileType type, TileHandler handler) {
		super(x, y, imageLoader, type, handler);
		isLivingTileEntity=true;
		cooldown=0;
	}

	
	public void addHealth(int healthToAdd){
		health+=healthToAdd;
		
	}

	public void removeHealth(int healthToRemove){
		health-=healthToRemove;
	}


	public float getHealth(){
		return health;
	}


	public int getCooldown() {
		return cooldown;
	}


	public void setCooldown(int cooldown) {
		this.cooldown = cooldown;
	}

	
}
