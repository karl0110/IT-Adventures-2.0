package com.it.main;
/**
 * 
 * @author Karl Mattes, Vincent Wiechmann, Luke Bourke, Filip Vojnovic, Jaime Hall
 * Klasse zur Zuweisung diverser Grafiken (bisher nur eine).
 */
public enum CharacterType {

	Jaime(1,0);
	
	int ssCol,characterNumber;
	
	CharacterType(int ssCol,int characterNumber){
		this.ssCol=ssCol;
		this.characterNumber=characterNumber;
	}
}
