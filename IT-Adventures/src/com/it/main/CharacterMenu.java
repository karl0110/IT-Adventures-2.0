package com.it.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 * 
 * @author Jaime Hall, Karl Mattes (Navigator)
 * 
 *Dies ist die Klasse Charaktermenü der Anwendung "IT-Adventures".
 *Hier wird ein Charakter und ein Level ausgewählt.
 *Dazu werden Parameter für ein Bild, den ausgewählten Character (CharacterType) und das ausgewählte Level(int)
 *sowie eine Game-Instanz benötigt.
 */
public class CharacterMenu {

	private BufferedImage image;
	private CharacterType selectedCharacter;
	private int selectedLevel;
	private Game game;

	public CharacterMenu(BufferedImageLoader imageLoader,Game game) {
		this.game=game;
		image = imageLoader.loadImage("/images/characterMenu.png");
	}

	public void tick() {

	}

	/**
	 * Das Bild des Menüs wird erstellt und, wenn Jaime als Charakter angeklickt wird, wird das gekennzeichnet
	 * 
	 * @param g
	 */
	public void render(Graphics g) {
		g.drawImage(image, 0, 0, Game.WIDTH, Game.HEIGHT, null);
		try {
			switch (selectedCharacter) {

			case Jaime:
				g.setColor(Color.RED);
				g.drawRect(0, 0, Game.WIDTH / 4, Game.HEIGHT / 4);
				break;
			}
		} catch (NullPointerException e) {

		}
	}

	public CharacterType getSelectedCharacter() {
		return selectedCharacter;
	}

	public void setSelectedCharacter(CharacterType selectedCharacter) {
		this.selectedCharacter = selectedCharacter;
	}

	public int getSelectedLevel() {
		return selectedLevel;
	}

	/**
	 * wenn ein Level ausgewählt wird, wird das Spiel gestartet
	 * @param selectedLevel
	 */
	public void setSelectedLevel(int selectedLevel) {
		this.selectedLevel = selectedLevel;
		game.setCharacter(selectedCharacter);
		game.setLevelNumber(selectedLevel);
		game.loadNewLevel();
		Game.State=Game.STATE.Game;
	}

}
