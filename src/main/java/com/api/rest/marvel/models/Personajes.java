package com.api.rest.marvel.models;

import java.util.ArrayList;

public class Personajes {
	public String codigo;
	public ArrayList<Personaje> lstPersonajes;
	
	/**
	 * @return the codigo
	 */
	public String getCodigo() {
		return codigo;
	}
	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	/**
	 * @return the lstPersonajes
	 */
	public ArrayList<Personaje> getResults() {
		return lstPersonajes;
	}
	/**
	 * @param lstPersonajes the results to set
	 */
	public void setResults(ArrayList<Personaje> lstPersonajes) {
		this.lstPersonajes = lstPersonajes;
	}
}
