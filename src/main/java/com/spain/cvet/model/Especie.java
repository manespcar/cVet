package com.spain.cvet.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(catalog = "cv_bixos_pro", name = "especies")
public class Especie implements Serializable {

	private static final long serialVersionUID = -3092867107432442226L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "usuario_cambio")
	private Integer usuarioCambio;
	
	@Column(name = "fecha_cambio")
	private Date fechaCambio;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getUsuarioCambio() {
		return usuarioCambio;
	}

	public void setUsuarioCambio(Integer usuarioCambio) {
		this.usuarioCambio = usuarioCambio;
	}

	public Date getFechaCambio() {
		return fechaCambio;
	}

	public void setFechaCambio(Date fechaCambio) {
		this.fechaCambio = fechaCambio;
	}

}
