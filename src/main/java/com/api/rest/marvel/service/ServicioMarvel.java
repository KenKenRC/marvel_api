package com.api.rest.marvel.service;

import com.api.rest.marvel.models.Personajes;

public interface ServicioMarvel {
	
	Personajes conexionMarvel(int id);
	
}
