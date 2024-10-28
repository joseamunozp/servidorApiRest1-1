package com.apirest_1_1.alumno.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apirest_1_1.alumno.persistance.models.Alumno;

@Repository
public interface AlumnoRepositoryI extends JpaRepository<Alumno, Long>{
    //https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html
    Alumno findByNombre(String nombre);
    Alumno findByApellidos(String apellidos);
    Alumno findByNombreAndApellidos(String nombre, String apellidos);
}
