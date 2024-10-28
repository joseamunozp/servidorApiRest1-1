package com.apirest_1_1.alumno.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirest_1_1.alumno.persistance.models.InfoContacto;
import com.apirest_1_1.alumno.persistance.repository.InfoContactoRepositoryI;

@Service
public class InfoContactoServiceImpl implements InfoContactoServiceI {
	
	@Autowired
	private InfoContactoRepositoryI infocontactoRepository;

	@Override
	public List<InfoContacto> findAll() {
		return infocontactoRepository.findAll();
	}

	@Override
	public InfoContacto save(InfoContacto infocontacto) {
		return infocontactoRepository.save(infocontacto);
	}

	@Override
	public Optional<InfoContacto> findById(Long id) {
		return infocontactoRepository.findById(id);
	}
	
	@Override
	public void deleteById(Long id) {
		infocontactoRepository.deleteById(id);	
	}

}
