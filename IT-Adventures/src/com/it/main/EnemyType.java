package com.it.main;

/**
 * 
 * @author Karl Mattes, Vincent Wiechmann, Luke Bourke, Filip Vojnovic, Jaime Hall
 *
 */
public enum EnemyType {

	Virus(1,1,32,64);
	
	int ssCol,ssRow;
	float width,height;
	
	EnemyType(int ssCol,int ssRow,float width,float height){
		this.ssCol=ssCol;
		this.ssRow=ssRow;
		this.width=width;
		this.height=height;
	}
	
}
