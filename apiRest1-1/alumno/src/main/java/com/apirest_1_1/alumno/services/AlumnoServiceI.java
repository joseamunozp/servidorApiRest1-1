package com.apirest_1_1.alumno.services;

import java.util.List;

import com.apirest_1_1.alumno.persistance.models.Alumno;

public interface AlumnoServiceI {
    List<Alumno> showAllAlumnos();
    Alumno showAlumnoByNombre(String alumnoname);
    Alumno showAlumnoByApellidos(String apeelidos);
    Alumno showAlumnoByNombreAndApellidos(String alumnoname, String alumnoapellidos);
    void saveAlumno(Alumno alumno);
    void updateAlumno(Long id,Alumno alumno);
    void deleteAlumno(Long id);
}
