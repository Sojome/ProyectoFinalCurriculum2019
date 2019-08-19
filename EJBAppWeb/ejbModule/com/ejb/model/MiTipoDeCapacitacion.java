package com.ejb.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipo_de_capacitacion database table.
 * 
 */
@Entity
@Table(name="tipo_de_capacitacion")
@NamedQuery(name="MiTipoDeCapacitacion.findAll", query="SELECT m FROM MiTipoDeCapacitacion m")
public class MiTipoDeCapacitacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_tipo_de_capacitacion")
	private Integer idTipoDeCapacitacion;

	private String nombre;

	//bi-directional many-to-one association to MiCapacitacion
	@OneToMany(mappedBy="tipoDeCapacitacion")
	private List<MiCapacitacion> capacitacions;

	public MiTipoDeCapacitacion() {
	}

	public Integer getIdTipoDeCapacitacion() {
		return this.idTipoDeCapacitacion;
	}

	public void setIdTipoDeCapacitacion(Integer idTipoDeCapacitacion) {
		this.idTipoDeCapacitacion = idTipoDeCapacitacion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<MiCapacitacion> getCapacitacions() {
		return this.capacitacions;
	}

	public void setCapacitacions(List<MiCapacitacion> capacitacions) {
		this.capacitacions = capacitacions;
	}

	public MiCapacitacion addCapacitacion(MiCapacitacion capacitacion) {
		getCapacitacions().add(capacitacion);
		capacitacion.setTipoDeCapacitacion(this);

		return capacitacion;
	}

	public MiCapacitacion removeCapacitacion(MiCapacitacion capacitacion) {
		getCapacitacions().remove(capacitacion);
		capacitacion.setTipoDeCapacitacion(null);

		return capacitacion;
	}

}