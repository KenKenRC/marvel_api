package com.api.rest.marvel.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marvel.client.conect.Connection;

@RestController
public class CustomerController {

	//private static Map<Integer, Customer> customers = new HashMap<>(); 
	
	   @GetMapping("/customer")  
	    public String getCustomers() { 
		   
		  Connection connection = new Connection();
		  connection.getComicCharacters();
		   
	        return  connection.getComicCharacters(); 
	    }  
	   
}
