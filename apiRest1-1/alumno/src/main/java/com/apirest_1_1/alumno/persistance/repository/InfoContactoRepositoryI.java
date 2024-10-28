package com.apirest_1_1.alumno.persistance.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apirest_1_1.alumno.persistance.models.Alumno;
import com.apirest_1_1.alumno.persistance.models.InfoContacto;

// Es una interfaz que actúa como un mecanismo de acceso a los datos, 
// permitiendo realizar operaciones CRUD (Crear, Leer, Actualizar y Eliminar) 
// sobre las entidades que representan las tablas de la base de datos.
@Repository
public interface InfoContactoRepositoryI extends JpaRepository<InfoContacto, Long> {
	
	List<InfoContacto> findAll();
	InfoContacto save(InfoContacto infocontacto);
}
