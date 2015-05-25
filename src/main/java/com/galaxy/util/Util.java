package com.galaxy.util;

import com.galaxy.entity.Planet;

/**
 * @author Kelvyns
 * This class has the util methods for the application
 *
 */

public class Util {
	
	/**
	 * This method returns the coordinate in X about the plane
	 * @param planet
	 * @param day
	 * @return coordX
	 */
	public static double getCoordX (Planet planet, int day) {
		// x = r * cons ( g& )  => g& = v& * t& =>  x= r* cons ( v& * t& )
		return getCoordX (planet.getRadius(), planet.getVelocity(), planet.getDirection(), day);
	}
	/**
	 * This method returns the coordinate in X about the plane
	 * @param radio
	 * @param velocity
	 * @param direction
	 * @param day
	 * @return coordX
	 */
	public static double getCoordX (int radio, int velocity, int direction, int day) {
		// x = r * cons ( g& )  => g& = v& * t& =>  x= r* cons ( v& * t& )
		double x = radio * Math.cos(velocity * day * direction);
		return x;
	}
	
	/**
	 *  This method returns the coordinate in Y about the plane
	 * @param planet
	 * @param day
	 * @return coordY
	 */
	public static double getCoordY (Planet planet, int day) {
		// x = r * sin ( g& )  => g& = v& * t& =>  x= r* sen ( v& * t& )
		return getCoordY (planet.getRadius(), planet.getVelocity(), planet.getDirection(), day);
	}
	/**
	 *  This method returns the coordinate in Y about the plane
	 * @param radio
	 * @param velocity
	 * @param direction
	 * @param day
	 * @return coordY
	 */
	public static double getCoordY (int radio, int velocity, int direction, int day) {
		// x = r * sin ( g& )  => g& = v& * t& =>  x= r* sen ( v& * t& )
		double x = radio * Math.sin(velocity * day * direction);
		return x;
	}

	
	/**
	 * This method returns the triangle Area
	 * @param a
	 * @param b
	 * @param c
	 * @return area
	 */
	public static double triangleArea(double[] a, double[] b, double[] c){
		// area = 0.5 * | D - I | => D = a*Y2 + b*Y3 + c*Y1 => I = Y1*b + Y2*c + Y3*a
		double dD = a[0]*b[1] + b[0]*c[1] + c[0]*a[1];
		double dI = a[1]*b[0] + b[1]*c[0] + c[1]*a[0];
		double area = 0.5 * Math.abs( dD - dI);
		return area;
	}
	
	public static void main(String[] args) {
		double[] a = {0 , 0 };
		double[] b = {4 , 0 };
		double[] c  = {4 , 5 };
		double area = triangleArea(a, b, c);
		double perimetro = trianglePerimeter(a, b, c);
		System.out.println(area);
		System.out.println(perimetro);
		
	}
	/**
	 * This methods returns the triangle perimeter
	 * @param a
	 * @param b
	 * @param c
	 * @return perimeter
	 */
	public static double trianglePerimeter(double[] a, double[] b, double[] c){
		// P = L1 + L2 + L3
		double ab = distanceBetweenPoints(a,b);
		double bc = distanceBetweenPoints(b,c);
		double ca = distanceBetweenPoints(c,a);
		double perimeter = ab + bc + ca;
		return perimeter;
	}
	
	/**
	 * This method returns the distance between two points
	 * @param a
	 * @param b
	 * @return distance
	 */
	public static double distanceBetweenPoints(double[] a, double[] b){
		// d^2 = (xa-xb)^2 + (ya-yb)^2 
		return Math.sqrt( Math.pow( (a[0] - b[0]), 2 ) + Math.pow( (a[1] - b[1]), 2 ) );
	}
	
	
	/**
	 * This method returns the orientation in a triangle
	 * @param a
	 * @param b
	 * @param c
	 * @return
	 */
	public static int triangleOrientation(double[] a, double[] b, double[] c){
		// (A1.x - A3.x) * (A2.y - A3.y) - (A1.y - A3.y) * (A2.x - A3.x)
		double x = (a[0]-c[0])*(b[1]-c[1]) - (a[1]-c[1])*(b[0]-c[0]);
		return (x >= 0.0 ? 1:-1);
	}
	
	/**
	 * This method returns true if the point p is in area
	 * @param a
	 * @param b
	 * @param c
	 * @param p
	 * @return true or false
	 */
	public static boolean triangleInPointByOrientation(double[] a, double[] b, double[] c, double[] p){
		int abc = triangleOrientation(a, b, c);
		int abp = triangleOrientation(a, b, p);
		int bcp = triangleOrientation(b, c, p);
		int cap = triangleOrientation(c, a, p);
		if(abc==1 && abp==1 && bcp==1 && cap==1) {
			return true;
		} else if (abc==-1 && abp==-1 && bcp==-1 && cap==-1) {
			return true;
		}
		
		return false;
	}
	
	/**
	 * This method returns true if the point p is in area
	 * @param a
	 * @param b
	 * @param c
	 * @param p
	 * @return true or false
	 */
	public static boolean triangleInPointWithoutArea(double[] a, double[] b, double[] c, double[] p){
		double area = triangleArea(a, b, c);
		return triangleInPointWithArea(a,b,c,p, area);
	}
	
	/**
	 * This method returns true if the point p is in area
	 * @param a
	 * @param b
	 * @param c
	 * @param p
	 * @param area
	 * @return true or false
	 */
	public static boolean triangleInPointWithArea(double[] a, double[] b, double[] c, double[] p, double area){
		// if the sum t1+t2+t3 = area  => It is in triangle area else it is out
		double t1 = triangleArea(a, b, p);
		double t2 = triangleArea(b, c, p);
		double t3 = triangleArea(c, a, p);
		return (t1 + t2 + t3) == area;
	}
	
	/**
	 * This method return true if the points are alined
	 * @param a
	 * @param b
	 * @param c
	 * @return true or false
	 */
	public static boolean areThePointsAlined(double[] a, double[] b, double[] c, int precision) {
		// P1 = bx - ax / by - ay   ^   P2 = cx - bx / cy - by  => P1 = P2
		// 
		double ba= b[1]-a[1];
		double cb = c[1]-b[1];
		if(ba==0 || cb==0) {
			return (ba==0 && cb==0) ;
		}
		double p1 = (b[0]-a[0])/ba;
		double p2 = (c[0]-b[0])/cb;
		int decimals = 10;
		if(precision >= 0 && precision < 4) {
			decimals = (int) Math.pow(10,precision);
		} 
		System.out.println("p1:"+ p1 + ", p2:"+p2);
		p1 = Math.rint(p1*decimals)/decimals;
        p2 = Math.rint(p2*decimals)/decimals;
		System.out.println("p1:"+  p1 + ", p2:"+ p2);
		return  p1 == p2; 
	}
}
