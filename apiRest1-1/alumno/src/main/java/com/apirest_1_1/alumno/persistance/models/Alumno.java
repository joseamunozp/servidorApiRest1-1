package com.apirest_1_1.alumno.persistance.models;

import java.io.Serializable;

import jakarta.persistence.CascadeType;
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

@NoArgsConstructor
@Data
@Entity
@Table(name="alumnos")
public class Alumno implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idalumno")
    private Long alumnoId;

    @Column(name="nombre")
    private String nombre;

    @Column(name="apellidos")
    private String apellidos;
     
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="idinfocontacto", referencedColumnName="idinfocontacto")
    private InfoContacto infoContacto;
}
