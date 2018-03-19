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
@Table(catalog = "cv_bixos_pro", name = "recordatorios")
public class Recordatorios implements Serializable {

	private static final long serialVersionUID = -213800207329776623L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "mascota_id")
	private Mascotas mascotas;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "vacuna_id")
	private Vacunas vacunas;
	
	@Column(name = "fecha_vacunacion")
	private Date fechaVacunacion;

	@Column(name = "fecha_prox_vacunacion")
	private Date fechaProxVacunacion;
	
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

	public Mascotas getMascotas() {
		return mascotas;
	}

	public void setMascotas(Mascotas mascotas) {
		this.mascotas = mascotas;
	}

	public Vacunas getVacunas() {
		return vacunas;
	}

	public void setVacunas(Vacunas vacunas) {
		this.vacunas = vacunas;
	}

	public Date getFechaVacunacion() {
		return fechaVacunacion;
	}

	public void setFechaVacunacion(Date fechaVacunacion) {
		this.fechaVacunacion = fechaVacunacion;
	}

	public Date getFechaProxVacunacion() {
		return fechaProxVacunacion;
	}

	public void setFechaProxVacunacion(Date fechaProxVacunacion) {
		this.fechaProxVacunacion = fechaProxVacunacion;
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fechaCambio == null) ? 0 : fechaCambio.hashCode());
		result = prime * result + ((fechaProxVacunacion == null) ? 0 : fechaProxVacunacion.hashCode());
		result = prime * result + ((fechaVacunacion == null) ? 0 : fechaVacunacion.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((mascotas == null) ? 0 : mascotas.hashCode());
		result = prime * result + ((usuarioCambio == null) ? 0 : usuarioCambio.hashCode());
		result = prime * result + ((vacunas == null) ? 0 : vacunas.hashCode());
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
		Recordatorios other = (Recordatorios) obj;
		if (fechaCambio == null) {
			if (other.fechaCambio != null)
				return false;
		} else if (!fechaCambio.equals(other.fechaCambio))
			return false;
		if (fechaProxVacunacion == null) {
			if (other.fechaProxVacunacion != null)
				return false;
		} else if (!fechaProxVacunacion.equals(other.fechaProxVacunacion))
			return false;
		if (fechaVacunacion == null) {
			if (other.fechaVacunacion != null)
				return false;
		} else if (!fechaVacunacion.equals(other.fechaVacunacion))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (mascotas == null) {
			if (other.mascotas != null)
				return false;
		} else if (!mascotas.equals(other.mascotas))
			return false;
		if (usuarioCambio == null) {
			if (other.usuarioCambio != null)
				return false;
		} else if (!usuarioCambio.equals(other.usuarioCambio))
			return false;
		if (vacunas == null) {
			if (other.vacunas != null)
				return false;
		} else if (!vacunas.equals(other.vacunas))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Recordatorios [id=" + id + ", mascotas=" + mascotas + ", vacunas=" + vacunas + ", fechaVacunacion="
				+ fechaVacunacion + ", fechaProxVacunacion=" + fechaProxVacunacion + ", usuarioCambio=" + usuarioCambio
				+ ", fechaCambio=" + fechaCambio + "]";
	}

}
