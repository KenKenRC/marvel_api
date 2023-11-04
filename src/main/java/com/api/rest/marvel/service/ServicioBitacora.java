package com.api.rest.marvel.service;

import java.util.Optional;

import com.api.rest.marvel.entity.Bitacora;

public interface ServicioBitacora {

	Bitacora guardarBitacora(Bitacora bitacora);

	Optional<Bitacora> obtenerBitacora(Long idBitacora);

}
