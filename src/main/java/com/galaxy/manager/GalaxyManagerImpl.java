package com.galaxy.manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.galaxy.data.PlanetEnum;
import com.galaxy.data.WeatherTypeEnum;
import com.galaxy.entity.Coordinate;
import com.galaxy.entity.Planet;
import com.galaxy.entity.Response;
import com.galaxy.entity.Weather;
import com.galaxy.util.Util;

/**
 * @author Kelvyns
 *
 */
public class GalaxyManagerImpl implements GalaxyManager {

	private static final long serialVersionUID = -443631228566715847L;
	
	private Planet vulcano = new Planet(PlanetEnum.VULCANO.radius(),
			PlanetEnum.VULCANO.velocity(), PlanetEnum.VULCANO.direction());
	private Planet ferengi = new Planet(PlanetEnum.FERENGI.radius(),
			PlanetEnum.FERENGI.velocity(), PlanetEnum.FERENGI.direction());
	private Planet betasoide = new Planet(PlanetEnum.BETASOIDE.radius(),
			PlanetEnum.BETASOIDE.velocity(), PlanetEnum.BETASOIDE.direction());
	
	private final double[] SUN = {0,0};
	
	private List<Integer> rainPeriod = new ArrayList<Integer>();
	private List<Integer> notRain= new ArrayList<Integer>();
	private List<Integer> droughtPeriod = new ArrayList<Integer>();
	private double[] dayMaxRain = {0,0};
	private List<Integer> optimalPeriod = new ArrayList<Integer>();
	Map<Integer, Weather > weatherList = new HashMap<Integer,Weather>();
	
	private List<Integer> getRainPeriod() {
		return rainPeriod;
	}
	private List<Integer> getNotRain() {
		return notRain;
	}
	private List<Integer> getDroughtPeriod() {
		return droughtPeriod;
	}
	private double[] getDayMaxRain() {
		return dayMaxRain;
	}

	public static void main(String[] args) {
		
		GalaxyManagerImpl galaxy = new GalaxyManagerImpl();
		int precision = 1;
		
		galaxy.fullDays(galaxy, precision);
		//galaxy.byDay(galaxy, precision, 894);
		//galaxy.byDay(galaxy, precision, 3479);
		
		System.out.println("FIN");
	}
	
	private void byDay(GalaxyManagerImpl galaxy , int precision, int day){
		
			System.out.println("********************************");
			System.out.println("DIA: "+ day);
			galaxy.interactionGalaxy(galaxy, day, precision);
	}
	
	private void fullDays(GalaxyManagerImpl galaxy, int precision) {
		int totalDays=360*10;
		int day =0;
		for (int i = 0; i < totalDays; i++) {
			System.out.println("********************************");
			day = i;
			System.out.println("DIA: "+ i);
			
			galaxy.interactionGalaxy(galaxy, day, precision);
			
		}
	}
	
	private void interactionGalaxy(GalaxyManagerImpl galaxy, int day, int precision){
		galaxy.loadGalaxy(day);
		if(galaxy.areThePointsAlined(precision)){
			System.out.println("The planets form a line	");
			if(galaxy.isSunAlinedWithPlanets(precision)){
				System.out.println("The planets are in line with the SUN");
				droughtPeriod.add(day);
				weatherList.put(day,new Weather(WeatherTypeEnum.DROUDHT, 0, day));
			} else {
				System.out.println("The planets are not in line with the SUN");
				optimalPeriod.add(day);
				weatherList.put(day,new Weather(WeatherTypeEnum.OPTIMUM, 0, day));
			}
		}else {
			System.out.println("The planets form a triangle");
			if(galaxy.isSunInTheTriangle()){
				System.out.println("The SUN is in the triangle");
				double perimeter = Util.trianglePerimeter(vulcano.getXY(), ferengi.getXY(), betasoide.getXY());
				rainPeriod.add(day);
				weatherList.put(day,new Weather(WeatherTypeEnum.RAIN, perimeter, day));
				if(dayMaxRain[1] < perimeter) {
					dayMaxRain[0] = day;
					dayMaxRain[1] = perimeter;
				}
				
			} else {
				notRain.add(day);
				weatherList.put(day,new Weather(WeatherTypeEnum.NOTRAIN, 0, day));
				System.out.println("The SUN is out the triangle");
			}
		}
	}
	
	private boolean isSunAlinedWithPlanets(int precision){
		boolean op1 = Util.areThePointsAlined(SUN, ferengi.getXY(), betasoide.getXY(), precision);
		boolean op2 = Util.areThePointsAlined(SUN, vulcano.getXY(), ferengi.getXY(), precision);
		return op1 && op2;
		//return op1;
	}
	
	private boolean areThePointsAlined (int precision) {
		return Util.areThePointsAlined( betasoide.getXY(), vulcano.getXY(), ferengi.getXY(), precision);
	}
	
	private boolean isSunInTheTriangle(){
		return Util.triangleInPointByOrientation(ferengi.getXY(), vulcano.getXY(), betasoide.getXY(), SUN);
	}

	public void cor(int day, Planet planet) {
		Util.getCoordX(planet.getRadius(), planet.getVelocity(), day,
				planet.getDirection());
		Util.getCoordY(planet.getRadius(), planet.getVelocity(), day,
				planet.getDirection());
	}

	
	public void loadGalaxy(int day) {
		// Put in the plane the planets
		setCoordinate(day);
		System.out.println("Vulcano, Ferengi, Betasoide");
		System.out.println(vulcano.getCoordinate().toString());
		System.out.println(ferengi.getCoordinate().toString());
		System.out.println(betasoide.getCoordinate().toString());
	}
	
	private void setCoordinate(int day) {
		vulcano.setCoordinate(new Coordinate(vulcano, day));
		ferengi.setCoordinate(new Coordinate(ferengi, day));
		betasoide.setCoordinate(new Coordinate(betasoide, day));
		
	}
	
	@Override
	public Boolean initializeGalaxy(Integer precision) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Weather getWeather(Integer day) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Integer getDroughtDays() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Integer getRainDays() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Weather getDayWithMaxRain() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Integer getOptimalDays() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Integer getNotRainDays() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
