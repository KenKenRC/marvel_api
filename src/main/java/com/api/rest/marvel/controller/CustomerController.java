package com.api.rest.marvel.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.rest.marvel.entity.Bitacora;
import com.api.rest.marvel.models.Personajes;
import com.api.rest.marvel.models.Sesion;
import com.api.rest.marvel.models.User;
import com.api.rest.marvel.service.ServicioBitacora;
import com.api.rest.marvel.service.ServicioMarvel;

@RestController
public class CustomerController {

	@Autowired
	private ServicioBitacora servicioBitacora;

	@Autowired
	private ServicioMarvel servicioMarvel;

	@GetMapping("/api/characters")  
	public Personajes getCharacters() { 	
		Personajes personajes = servicioMarvel.conexionMarvel(0);
		return  personajes;
	}  

	@GetMapping("/api/characterId")  
	public Personajes getCharactersById(@RequestParam int id ) { 
		Personajes personaje = servicioMarvel.conexionMarvel(id);
		return  personaje;
	} 

	@GetMapping("/api/bitacora")  
	public List<Bitacora> getBitacora() { 	
		List<Bitacora> listBitacora = servicioBitacora.obtenerBitacora();
		return  listBitacora;
	}
	
	@PostMapping("/api/login")  
	public Sesion login(@RequestBody User usuario) { 	
		Sesion sesion = new Sesion();;
		if(usuario.usuario.equals("kenia") && usuario.pass.equals("1234")) {
			Date fecha = new Date();
			sesion.setCodigo("0");
			sesion.setSesion(fecha.toString());
		}else {
			sesion.setCodigo("1");
		}
		return sesion;
	}

}
