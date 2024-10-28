package com.apirest_1_1.alumno.persistance.models;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

// Una entidad es una clase que se utiliza para mapear una tabla de la base de datos a un objeto en la aplicación.
@NoArgsConstructor
@Data
@Entity
@Table(name="infocontacto")
public class InfoContacto implements Serializable {

		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name="idinfocontacto")
	    private Long  infoContactoId;

	    @Column(name="direccion")
	    private String direccion;

	    @Column(name="telefono")
	    private int telefono;
	    
	   /**
		 * 
		 */
		private static final long serialVersionUID = 1L;

}
