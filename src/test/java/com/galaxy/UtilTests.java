package com.galaxy;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import com.galaxy.data.PlanetEnum;
import com.galaxy.entity.Coordinate;
import com.galaxy.entity.Planet;
import com.galaxy.util.Util;

public class UtilTests extends Util {
	
	private Planet vulcano = new Planet(PlanetEnum.VULCANO.radius(),
			PlanetEnum.VULCANO.velocity(), PlanetEnum.VULCANO.direction());
	private Planet ferengi = new Planet(PlanetEnum.FERENGI.radius(),
			PlanetEnum.FERENGI.velocity(), PlanetEnum.FERENGI.direction());
	private Planet betasoide = new Planet(PlanetEnum.BETASOIDE.radius(),
			PlanetEnum.BETASOIDE.velocity(), PlanetEnum.BETASOIDE.direction());

	@Test
	public void test() {
		double[] sol = {0 , 0 };
		double[] a = {0 , 0 };
		double[] b = {4 , 0 };
		double[] c  = {4 , 5 };
		double perimetro = trianglePerimeter(a, b, c);
		assertTrue(perimetro==15.403124237432849);
		int precision = 1;
		System.out.println(perimetro);
		
		boolean alined = Util.areThePointsAlined(a, b, c, precision);
		Assert.assertEquals(alined, false);
		
		double vulcanoX = Util.getCoordX(vulcano, 0);
		double ferengiX = Util.getCoordX(ferengi, 0);
		double betasoideX = Util.getCoordX(betasoide, 0);
		double vulcanoY = Util.getCoordY(vulcano, 0);
		double ferengiY = Util.getCoordY(ferengi, 0);
		double betasoideY = Util.getCoordY(betasoide, 0);
		Coordinate coordinateA = new Coordinate(0, vulcanoX, vulcanoY);
		Coordinate coordinateB = new Coordinate(0, ferengiX, ferengiY);
		Coordinate coordinateC = new Coordinate(0, betasoideX, betasoideY);
		boolean alinedP = Util.areThePointsAlined(coordinateA.getPointXY(), coordinateB.getPointXY(), coordinateC.getPointXY(), precision);
		assertTrue(alinedP);
		
		boolean inSol = Util.triangleInPointByOrientation(a, b, c, sol);	
        Assert.assertEquals(inSol, true);
	}
}
