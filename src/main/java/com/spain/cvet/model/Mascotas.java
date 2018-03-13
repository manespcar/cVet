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
@Table(catalog = "cv_bixos_pro", name = "mascotas")
public class Mascotas implements Serializable{

	private static final long serialVersionUID = -1301566799619146625L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "chip")
	private String chip;
	
	@Column(name = "sexo")
	private String sexo;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "raza")
	private Razas raza;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "especie")
	private Especie especie;
	
	@Column(name = "capa")
	private String capa;
	
	@Column(name = "fecha_nacimiento")
	private Date fechaNacimiento;
	
	@Column(name = "cliente_id")
	private Integer clienteId;

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

	public String getChip() {
		return chip;
	}

	public void setChip(String chip) {
		this.chip = chip;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Razas getRaza() {
		return raza;
	}

	public void setRaza(Razas raza) {
		this.raza = raza;
	}

	public Especie getEspecie() {
		return especie;
	}

	public void setEspecie(Especie especie) {
		this.especie = especie;
	}

	public String getCapa() {
		return capa;
	}

	public void setCapa(String capa) {
		this.capa = capa;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Integer getClienteId() {
		return clienteId;
	}

	public void setClienteId(Integer clienteId) {
		this.clienteId = clienteId;
	}

	@Override
	public String toString() {
		return "Mascotas [id=" + id + ", nombre=" + nombre + ", chip=" + chip + ", sexo=" + sexo + ", raza=" + raza
				+ ", especie=" + especie + ", capa=" + capa + ", fechaNacimiento=" + fechaNacimiento + ", clienteId="
				+ clienteId + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((capa == null) ? 0 : capa.hashCode());
		result = prime * result + ((chip == null) ? 0 : chip.hashCode());
		result = prime * result + ((clienteId == null) ? 0 : clienteId.hashCode());
		result = prime * result + ((especie == null) ? 0 : especie.hashCode());
		result = prime * result + ((fechaNacimiento == null) ? 0 : fechaNacimiento.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((raza == null) ? 0 : raza.hashCode());
		result = prime * result + ((sexo == null) ? 0 : sexo.hashCode());
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
		Mascotas other = (Mascotas) obj;
		if (capa == null) {
			if (other.capa != null)
				return false;
		} else if (!capa.equals(other.capa))
			return false;
		if (chip == null) {
			if (other.chip != null)
				return false;
		} else if (!chip.equals(other.chip))
			return false;
		if (clienteId == null) {
			if (other.clienteId != null)
				return false;
		} else if (!clienteId.equals(other.clienteId))
			return false;
		if (especie == null) {
			if (other.especie != null)
				return false;
		} else if (!especie.equals(other.especie))
			return false;
		if (fechaNacimiento == null) {
			if (other.fechaNacimiento != null)
				return false;
		} else if (!fechaNacimiento.equals(other.fechaNacimiento))
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
		if (raza == null) {
			if (other.raza != null)
				return false;
		} else if (!raza.equals(other.raza))
			return false;
		if (sexo == null) {
			if (other.sexo != null)
				return false;
		} else if (!sexo.equals(other.sexo))
			return false;
		return true;
	}

}
