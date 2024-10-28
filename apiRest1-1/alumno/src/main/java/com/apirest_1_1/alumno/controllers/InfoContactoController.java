package com.apirest_1_1.alumno.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apirest_1_1.alumno.persistance.models.InfoContacto;
import com.apirest_1_1.alumno.services.InfoContactoServiceI;

//Es responsable de manejar las solicitudes HTTP de entranda y salida.
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/infocontacto")
public class InfoContactoController {
	
	@Autowired
	private InfoContactoServiceI infocontactoServiceI;
	
	//Consultar todos los infocontactos.
	@GetMapping("/list")
    public List<InfoContacto> getAllInfoContactos() {
        return infocontactoServiceI.findAll();
    }
	
	//Crear un InfoContacto
	@PostMapping("/create")
    public InfoContacto postInfoContacto(@RequestBody InfoContacto infocontacto) {
		return infocontactoServiceI.save(infocontacto);
	}
	
	//Editar infocontacto por su id.
	@PutMapping("/edit/{id}")
	public String update(@PathVariable Long id, @RequestBody InfoContacto infocontacto) {
	    try {
	        Optional<InfoContacto> infocontactoOptional = infocontactoServiceI.findById(id);
	        
	        if (infocontactoOptional.isPresent()) {
	        	//infocontactoDB es el objeto que se asignara los valores para actualizar.
	            InfoContacto infocontactoDB = infocontactoOptional.get();
	            infocontactoDB.setDireccion(infocontacto.getDireccion());
	            infocontactoDB.setTelefono(infocontacto.getTelefono());
	            //Guardamos los nuevos valores editados.
	            infocontactoServiceI.save(infocontactoDB);
	            
	            return "InfoContacto actualizado!";
	        } else {
	            return "InfoContacto no encontrado.";
	        }
	    } catch (Exception e) {
	        return "Error al actualizar el infocontacto: " + e.getMessage();
	    }
	}
	
	// Eliminar infocontacto por su id.
	@DeleteMapping("delete/{id}")	
	public String delete(@PathVariable Long id) {
	    try {
	        Optional<InfoContacto> infocontactoOptional = infocontactoServiceI.findById(id);
	        
	        if (infocontactoOptional.isPresent()) {
	            infocontactoServiceI.deleteById(id);
	            return "InfoContacto eliminado exitosamente.";
	        } else {
	            return "InfoContacto no encontrado.";
	        }
	    } catch (Exception e) {
	        return "Error al eliminar el infocontacto: " + e.getMessage();
	    }
	}
	
	
	 
	

}
