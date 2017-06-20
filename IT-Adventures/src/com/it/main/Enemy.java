package com.it.main;

import java.awt.Graphics;

/**
 * Die Objekte dieser Klasse sind Gegner, welche sich in der Spielwelt bewegen und den Spieler mithilfe von Schüssen angreifen, falls dieser sich in einem bestimmten Radius befindet. Dies wird mithilfe einer künstlichen Intelligenz erreicht.
 * 
 * @author Jaime Hall
 * 
 */
public class Enemy extends LivingTileEntity{

	private float leftPatrolCoordinate,rightPatrolCoordinate;
	private Player player;
	
	
	public Enemy(float x, float y, BufferedImageLoader imageLoader, TileType type,TileHandler handler,EnemyType enemyType,Player player) {
		super(x, y, imageLoader, type,handler);
		//image=imageLoader.loadImageFromSS("images/enemy_sprite_sheet.png",  enemyType.ssCol,enemyType.ssRow, 32, 32);
		image=imageLoader.loadImage("/images/enemy1.png");
		leftPatrolCoordinate=x;
		rightPatrolCoordinate=x+600;
		facingRight=true;
		this.player=player;
		handler.addObject(healthBar=new HealthBar(0,0, imageLoader, TileType.HealthBar, handler, this));
		health=Player.MAXHEALTH;
	}

	
	
	@Override
	public void render(Graphics g) {
		g.drawImage(image, (int)x, (int)y,(int)width,(int)height, null);
		
	}

	@Override
	public void tick() {
		
		x+=velX;
		y+=velY;
		
		if(falling || jumping){ 
			
			velY += 0.981f; // Y-Wert steigt immer (wird durch Kollision unterbrochen)
		}	
		
		if(facingRight==true){//Wenn der Gegner nach Rechts guckt
			if(x<rightPatrolCoordinate){//Und er seinen Umkehrpunkt noch nicht erreicht hat
				velX=2;
			}
			else{
				facingRight=false;
			}
		}
		else{
			if(x>leftPatrolCoordinate){
				velX=-2;
			}
			else{
				facingRight=true;
			}
		}
		
		if(y-player.getY()>20 && y-player.getY() >0 || player.getY()-y>20 && player.getY()-y >0){// Falls der Spieler sich bis zu 20 Pixel nach oben/unten befindet.
			if(cooldown==0){
				if(x-player.getX()<400&&x-player.getX()>0){//Und der Spieler weniger als 400 Pixel weit weg ist.
					handler.addObject(new Shot(x-width-TileType.Shot.width,y+height/2, imageLoader, TileType.Shot, handler, 600, 20, false, 1, 6));//wird ein Schuss erstellt, welcher in die Richtung des Spielers geht.
					cooldown=60;
				}
				else if(player.getX()-x<400&&player.getX()-x>0){
					handler.addObject(new Shot(x+width,y+height/2, imageLoader, TileType.Shot, handler, 600, 20, true, 1, 6));
					cooldown=60;
				}
			}
			
		}
		if(cooldown>0){
			cooldown--;
		}
		
		if(health==0){
			handler.removeObject(this);
			handler.removeObject(healthBar);
		}
		collision();
		
		healthBar.reloadCoordinates(x, y);
	}


	@Override
	public void leftCollisionReaction(Tile tempObject) {
		velY=(-10);
		falling=true;
		jumping=true;
		
	}

	@Override
	public void rightCollisionReaction(Tile tempObject) {
		velY=(-10);
		falling=true;
		jumping=true;
		
	}

	@Override
	public void upperCollisionReaction(Tile tempObject) {
		y=tempObject.getY()+tempObject.getHeight()+1;
		velY=0;
		
	}

	@Override
	public void bottomCollisionReaction(Tile tempObject) {
		y=(tempObject.getY()-(int)height);
		falling = false;
		if(jumping==true)jumping = false;
		velY=0;
		
	}




}
