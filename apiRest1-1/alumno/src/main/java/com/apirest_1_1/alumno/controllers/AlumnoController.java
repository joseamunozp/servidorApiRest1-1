package com.apirest_1_1.alumno.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apirest_1_1.alumno.persistance.models.Alumno;
import com.apirest_1_1.alumno.services.AlumnoServiceI;
import com.apirest_1_1.alumno.services.InfoContactoServiceI;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/alumno")
public class AlumnoController {

    @Autowired
    private AlumnoServiceI alumnoMngmnt;
    
    @GetMapping
    public List<Alumno> getAllAlumnos() {
        return alumnoMngmnt.showAllAlumnos();
    }

    @GetMapping("/name/{nombre}")
    public Alumno showAlumnoByNombre(@PathVariable String nombre) {
        return alumnoMngmnt.showAlumnoByNombre(nombre);
    }

    @GetMapping("/apellidos/{apellidos}")
    public Alumno showAlumnoByEmail(@PathVariable String apellidos) {
        return alumnoMngmnt.showAlumnoByApellidos(apellidos);
    }

    @PostMapping("/insert")
    public String postAlumno(@RequestBody Alumno alumno) {
        alumnoMngmnt.saveAlumno(alumno);

        return "Alumno saved";
    }
    
    @PutMapping("edit/{id}")
    public String editAlumno(@PathVariable Long id, @RequestBody Alumno alumno) {
        alumnoMngmnt.updateAlumno(id, alumno);
        
        return "Alumno modified";
    }
    
    @DeleteMapping("delete/{id}")
    public String deleteAlumno(@PathVariable Long id) {
        alumnoMngmnt.deleteAlumno(id);
        
        return "Alumno deleted";
    }

}
