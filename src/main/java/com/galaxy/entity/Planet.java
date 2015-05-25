package com.galaxy.entity;

/**
 * @author Kelvyns
 * This class represent a planet
 *
 */
public class Planet {
	
	private int radius;
	private int velocity;
	private int direction;
	private Coordinate coordinate;
	
	public Planet(int radius, int velocity, int direction) {
		this.radius = radius;
		this.velocity = velocity;
		this.direction = direction;
	}
	
	public int getDirection() {
		return direction;
	}
	public int getRadius() {
		return radius;
	}
	public int getVelocity() {
		return velocity;
	}
	
	public void setCoordinate(Coordinate coordinate) {
		this.coordinate = coordinate;
	}
	
	public Coordinate getCoordinate() {
		return coordinate;
	}
	
	public double[] getXY() {
		return coordinate.getPointXY();
	}
}
