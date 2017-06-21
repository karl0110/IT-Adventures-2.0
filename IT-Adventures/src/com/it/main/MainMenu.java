package com.it.main;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
/**
 * Klasse, die die Hintergründe von dem Anfangsmenü und dem Playmenü lädt
 * @author Karl Mattes, Luke Bourke
 *
 */
public class MainMenu {

	private BufferedImage mainMenuBackground, playMenuBackground;
	private boolean animatingPlay=false;
	private float x,y=0;


	public MainMenu(BufferedImageLoader imageLoader, Game game) {
		mainMenuBackground = imageLoader.loadImage("/images/mainMenuBackground.png");
		playMenuBackground = imageLoader.loadImage("/images/play_Background.png");
		
		

	}

	public void tick(){
		if(animatingPlay){
			
			y+=50f;
			if(y>(-1*(Game.HEIGHT/32))){
				
				animatingPlay=false;
				y=0;
			}
		}
		
	}
	/**
	 * zeichnen der Bilder, wenn man im ricjtigen Gamestate ist.
	 * @param g
	 */
	public void render(Graphics g) {
		if(animatingPlay){
			g.drawImage(mainMenuBackground,0,0,Game.WIDTH,Game.HEIGHT, null);
		}
		if (Game.State == Game.STATE.MainMenu) {
		
			
			g.drawImage(mainMenuBackground,0,0,Game.WIDTH,Game.HEIGHT, null);
			
		} else if (Game.State == Game.STATE.PlayMenu) {
			g.drawImage(playMenuBackground, (int)x,(int)y,Game.WIDTH,Game.HEIGHT, null);
		}
		

	}
	

	public boolean isAnimatingPlay() {
		return animatingPlay;
	}

	public void setAnimatingPlay(boolean animatingPlay) {
		this.animatingPlay = animatingPlay;
	}
	
	/**
	 * Animation starten, mit Anfangs-y-Wert
	 */
	public void startPlayAnimation(){
		
		y=(-1080);
		animatingPlay=true;
		Game.State=Game.STATE.PlayMenu;
	}

}
