package com.galaxy.data;

/**
 * @author Kelvyns
 *
 */
public enum PlanetEnum {
	VULCANO   (5, 1000, +1),// 5 g/d, 1000 km, anticlockwise
	FERENGI   (1,  500, -1),// 1 g/d, 500 km, clockwise
	BETASOIDE (3, 2000, -1);// 3 g/d, 2000 km, anticlockwise 
	
	private final int velocity;
	private final int radius;
	private final int direction; // clockwise: -1, anticlockwise +1
	
	private PlanetEnum(int velocity, int radius, int direction) {
		this.velocity = velocity;
		this.radius = radius;
		this.direction = direction;
	}
	
	public int velocity() {
		return this.velocity;
	}
	
	public int radius() {
		return this.radius;
	}
	
	public int direction(){
		return this.direction;
	}
	
	
}
