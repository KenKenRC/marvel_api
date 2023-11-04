package com.api.rest.marvel.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.rest.marvel.entity.Bitacora;
import com.api.rest.marvel.repository.RepositorioBitacora;


@Service
public class ServicioBitacoraImpl implements ServicioBitacora{

	@Autowired
	private RepositorioBitacora repositorioBitacora;

	@Override
	public Bitacora guardarBitacora(Bitacora bitacora) {
		return repositorioBitacora.save(bitacora);
	}

	@Override
	public Optional<Bitacora> obtenerBitacora(Long idBitacora) {
		// TODO Auto-generated method stub
		return repositorioBitacora.findById(idBitacora);
	}

}
