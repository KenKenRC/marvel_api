package com.api.rest.marvel.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.rest.marvel.models.Personaje;
import com.api.rest.marvel.models.Personajes;
import com.google.gson.Gson;
import com.marvel.client.models.Character;
import com.marvel.client.models.responses.CharactersResponse;
import com.marvel.client.service.MarvelConnection;

@Service
public class ServicioMarvelImpl implements ServicioMarvel {

	@Autowired
	private ServicioBitacora servicioBitacora;

	private ArrayList<Personaje> lstPersonajes;

	public Personajes conexionMarvel(int id) {
		MarvelConnection connection = new MarvelConnection();
		Personajes personajes = new Personajes();
		CharactersResponse responses = null;
		try {
			if(id==0) {
				responses = connection.getComicCharacters();
			}else {
				responses = connection.getComicCharactersId(id);
			}

			if(responses!=null && responses.getCode().equals("200")) {
				personajes.setCodigo("0");
				lstPersonajes = new ArrayList<Personaje>();

				if(responses.getData().getResults()!=null && responses.getData().getResults().size()>0) {
					Personaje personaje = null;
					ArrayList<Character> lstCharacter = responses.getData().getResults();
					for(int i=0; i<lstCharacter.size();i++) {
						personaje = new Personaje();
						personaje.setId(lstCharacter.get(i).getId());
						personaje.setNombre(lstCharacter.get(i).getName());
						personaje.setDescripcion(lstCharacter.get(i).getDescription());

						if(lstCharacter.get(i).getComics().getItems()!=null && lstCharacter.get(i).getComics().getItems().size()>0) {
							ArrayList<String> lstComics = new ArrayList<String>();
							for(int j=0; j<lstCharacter.get(i).getComics().getItems().size();j++) {
								lstComics.add(lstCharacter.get(i).getComics().getItems().get(j).getName());
							}
							personaje.setLstComics(lstComics);
						}

						lstPersonajes.add(personaje);
					}
				}
				personajes.setResults(lstPersonajes);
			}else {
				personajes.setCodigo("1");
			}

			Gson gson = new Gson();
			String json = gson.toJson(personajes);
			servicioBitacora.guardarBitacora("/characters", json);

		} catch (Exception e) {
			personajes.setCodigo("3");
		}
		return personajes;
	}

}
