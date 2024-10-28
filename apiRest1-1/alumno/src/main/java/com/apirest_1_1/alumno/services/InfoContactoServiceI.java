package com.apirest_1_1.alumno.services;

import java.util.List;
import java.util.Optional;

import com.apirest_1_1.alumno.persistance.models.InfoContacto;

public interface InfoContactoServiceI {
	
	List<InfoContacto> findAll();
	InfoContacto save(InfoContacto infocontacto);
	Optional<InfoContacto> findById(Long id);
	void deleteById(Long id);
	
}
