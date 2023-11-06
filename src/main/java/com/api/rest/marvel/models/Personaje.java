package com.api.rest.marvel.models;

import java.util.ArrayList;

public class Personaje {
	public String id;
	public String nombre;
	public String descripcion;
	public ArrayList<String> lstComics;
	
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}
	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	/**
	 * @return the lstComics
	 */
	public ArrayList<String> getLstComics() {
		return lstComics;
	}
	/**
	 * @param lstComics the lstComics to set
	 */
	public void setLstComics(ArrayList<String> lstComics) {
		this.lstComics = lstComics;
	}
}
