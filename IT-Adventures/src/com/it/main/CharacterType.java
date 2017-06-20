package com.it.main;
/**
 * 
 * @author (KarlMatt), Jaime
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
