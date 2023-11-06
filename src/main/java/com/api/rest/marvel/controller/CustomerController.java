package com.api.rest.marvel.controller;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
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
	
	@PostMapping("/login")
	public Sesion login(@RequestBody User usuario) { 	
		Sesion sesion = new Sesion();
		
		if(usuario.usuario.equals("kenia") && usuario.pass.equals("1234")) {
			String token = getJWTToken(usuario.usuario);
			sesion.setToken(token);
			sesion.setCodigo("0");
		}else {
			sesion.setCodigo("1");
		}
		return sesion;
	}
	
	private String getJWTToken(String username) {
		String secretKey = "ef48d397ad8de1068af9acd36020108aadc43842fbaaa5fce9535d3c4923aa33d7514b0f28029caa1c5ee3cab3a4a97a3f77c1f708d2a8ce662ff3920dfbb361";
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils
				.commaSeparatedStringToAuthorityList("ROLE_USER");
		
		String token = Jwts
				.builder()
				.setId("softtekJWT")
				.setSubject(username)
				.claim("authorities",
						grantedAuthorities.stream()
								.map(GrantedAuthority::getAuthority)
								.collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 600000))
				.signWith(SignatureAlgorithm.HS512,
						secretKey.getBytes()).compact();

		return "Bearer " + token;
	}

}
