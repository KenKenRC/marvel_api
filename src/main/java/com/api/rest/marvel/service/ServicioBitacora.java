package com.api.rest.marvel.service;

import java.util.List;
import com.api.rest.marvel.entity.Bitacora;

public interface ServicioBitacora {

	void guardarBitacora(String nameServ, String response);

	List<Bitacora> obtenerBitacora();

}
