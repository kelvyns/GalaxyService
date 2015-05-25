/**
 * 
 */
package com.galaxy.entity;


/**
 * @author Kelvyns
 *
 */
public class ResponseWeather {
	private Integer dia;
	private String clima;
	public ResponseWeather(Integer i, String clima) {
		super();
		this.dia = i;
		this.clima = clima;
	}
	/**
	 * @return the dia
	 */
	public Integer getDia() {
		return dia;
	}
	/**
	 * @return the clima
	 */
	public String getClima() {
		return clima;
	}
	
	
}