package com.spain.cvet.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(catalog = "cv_bixos_pro", name = "vacunas")
public class Vacunas implements Serializable {

	private static final long serialVersionUID = 3297516617871778457L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "nombre")
	private String nombre;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "especie_id")
	private Especie especies;

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

	public Especie getEspecies() {
		return especies;
	}

	public void setEspecies(Especie especies) {
		this.especies = especies;
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

	@Override
	public String toString() {
		return "Vacunas [id=" + id + ", nombre=" + nombre + ", especies=" + especies + ", usuarioCambio="
				+ usuarioCambio + ", fechaCambio=" + fechaCambio + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((especies == null) ? 0 : especies.hashCode());
		result = prime * result + ((fechaCambio == null) ? 0 : fechaCambio.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((usuarioCambio == null) ? 0 : usuarioCambio.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vacunas other = (Vacunas) obj;
		if (especies == null) {
			if (other.especies != null)
				return false;
		} else if (!especies.equals(other.especies))
			return false;
		if (fechaCambio == null) {
			if (other.fechaCambio != null)
				return false;
		} else if (!fechaCambio.equals(other.fechaCambio))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (usuarioCambio == null) {
			if (other.usuarioCambio != null)
				return false;
		} else if (!usuarioCambio.equals(other.usuarioCambio))
			return false;
		return true;
	}

}
