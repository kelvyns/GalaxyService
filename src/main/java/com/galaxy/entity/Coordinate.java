package com.galaxy.entity;

import java.text.DecimalFormat;

import com.galaxy.util.Util;

/**
 * @author Kelvyns
 *
 */
public class Coordinate {
	private int day;
	private double coordX;
	private double coordY;
	
	public Coordinate(int day, double coordX, double coordY) {
		this.day = day;
		this.coordX = coordX;
		this.coordY = coordY;
	}
	
	public Coordinate(Planet planet, int day){
		this.day = day;
		this.coordX = Util.getCoordX(planet, day);
		this.coordY = Util.getCoordY(planet, day);
		
	}
	
	public double[] getPointXY() {
		double[] pointXY = { coordX , coordY };
		return pointXY;
	}

	public int getDay() {
		return day;
	}

	public double getCoordX() {
		return coordX;
	}

	public double getCoordY() {
		return coordY;
	}
	
	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("0.00");
		
		return "" + df.format(this.coordX) +"," + df.format(this.coordY) + "";
	}

}
