package com.api.rest.marvel.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.marvel.client.models.responses.CharactersResponse;
import com.marvel.client.service.MarvelConnection;



@RestController
public class CustomerController {

	//private static Map<Integer, Customer> customers = new HashMap<>(); 

	@GetMapping("/characters")  
	public CharactersResponse getCustomers() { 

		MarvelConnection connection = new MarvelConnection();
		CharactersResponse responses = connection.getComicCharacters();
		return  responses;
	}  

	@GetMapping("/characterId")  
	public CharactersResponse getCustomersById(@RequestParam int id ) { 

		MarvelConnection connection = new MarvelConnection();

		CharactersResponse characterResponse = connection.getComicCharactersId(id);

		return  characterResponse;
	}  

}
