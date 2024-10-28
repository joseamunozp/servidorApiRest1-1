package com.apirest_1_1.alumno.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirest_1_1.alumno.persistance.models.Alumno;
import com.apirest_1_1.alumno.persistance.repository.AlumnoRepositoryI;

@Service
public class AlumnoServiceImpl implements AlumnoServiceI {

    @Autowired
    AlumnoRepositoryI alumnoRepo;

    @Override
    public List<Alumno> showAllAlumnos() {
        return alumnoRepo.findAll();
    }

    @Override
    public Alumno showAlumnoByNombre(String alumnoname) {
        return alumnoRepo.findByNombre(alumnoname);
    }

    @Override
    public Alumno showAlumnoByApellidos(String email) {
        return alumnoRepo.findByApellidos(email);
    }

    @Override
    public Alumno showAlumnoByNombreAndApellidos(String alumnoname, String email) {
        return alumnoRepo.findByNombreAndApellidos(alumnoname, email);
    }

    @Override
    public void saveAlumno(Alumno alumno) {
        alumnoRepo.save(alumno);
    }

    @Override
    public void updateAlumno(Long id, Alumno alumno) {
        alumno.setAlumnoId(id);
        alumnoRepo.save(alumno);
    }
    

    @Override
    public void deleteAlumno(Long id) {
        alumnoRepo.deleteById(id);    
    }
    
}
