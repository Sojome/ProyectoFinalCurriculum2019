package com.ejb.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the estado_civil database table.
 * 
 */
@Entity
@Table(name="estado_civil")
@NamedQuery(name="MiEstadoCivil.findAll", query="SELECT m FROM MiEstadoCivil m")
public class MiEstadoCivil implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_estado_civil")
	private Integer idEstadoCivil;

	private String nombre;

	//bi-directional many-to-one association to MiDatosPersonale
	@OneToMany(mappedBy="estadoCivil")
	private List<MiDatosPersonale> datosPersonales;

	public MiEstadoCivil() {
	}

	public Integer getIdEstadoCivil() {
		return this.idEstadoCivil;
	}

	public void setIdEstadoCivil(Integer idEstadoCivil) {
		this.idEstadoCivil = idEstadoCivil;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<MiDatosPersonale> getDatosPersonales() {
		return this.datosPersonales;
	}

	public void setDatosPersonales(List<MiDatosPersonale> datosPersonales) {
		this.datosPersonales = datosPersonales;
	}

	public MiDatosPersonale addDatosPersonale(MiDatosPersonale datosPersonale) {
		getDatosPersonales().add(datosPersonale);
		datosPersonale.setEstadoCivil(this);

		return datosPersonale;
	}

	public MiDatosPersonale removeDatosPersonale(MiDatosPersonale datosPersonale) {
		getDatosPersonales().remove(datosPersonale);
		datosPersonale.setEstadoCivil(null);

		return datosPersonale;
	}

}