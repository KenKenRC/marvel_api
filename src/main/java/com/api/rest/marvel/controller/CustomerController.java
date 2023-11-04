package com.api.rest.marvel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.rest.marvel.entity.Bitacora;
import com.api.rest.marvel.service.ServicioBitacora;
import com.marvel.client.models.responses.CharactersResponse;
import com.marvel.client.service.MarvelConnection;

@RestController
public class CustomerController {

	@Autowired
	private ServicioBitacora servicioBitacora;

	@GetMapping("/characters")  
	public CharactersResponse getCharacters() { 	
		Bitacora bitacora = new Bitacora();
		bitacora.setFecha("03/11/2023");
		bitacora.setService("/characters");

		servicioBitacora.guardarBitacora(bitacora);

		MarvelConnection connection = new MarvelConnection();
		CharactersResponse responses = connection.getComicCharacters();
		return  responses;
	}  

	@GetMapping("/characterId")  
	public CharactersResponse getCharactersById(@RequestParam int id ) { 

		MarvelConnection connection = new MarvelConnection();

		CharactersResponse characterResponse = connection.getComicCharactersId(id);

		return  characterResponse;
	}  

}
