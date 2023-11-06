package com.api.rest.marvel.service;

import java.io.Console;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.rest.marvel.entity.Bitacora;
import com.api.rest.marvel.repository.RepositorioBitacora;

import lombok.extern.java.Log;


@Service
public class ServicioBitacoraImpl implements ServicioBitacora{

	@Autowired
	private RepositorioBitacora repositorioBitacora;

	@Override
	public void guardarBitacora(String nameService, String response) {
		try {		
			Bitacora bitacora = new Bitacora();
			Date fecha = new Date();
			bitacora.setFecha(fecha.toString());
			bitacora.setService(nameService);
			bitacora.setResponse(response);
			repositorioBitacora.save(bitacora);
		} catch (Exception e) {
			Logger log = Logger.getLogger(ServicioBitacoraImpl.class.getName());
			log.setLevel(Level.WARNING);
			log.warning("Ocurrió un problema al guardar en bitácora"+e.getMessage());
		}
	}

	@Override
	public List<Bitacora> obtenerBitacora() {
		return repositorioBitacora.findAll();
	}

}
