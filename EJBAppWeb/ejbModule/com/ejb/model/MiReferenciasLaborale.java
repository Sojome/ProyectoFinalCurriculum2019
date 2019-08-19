package com.ejb.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the referencias_laborales database table.
 * 
 */
@Entity
@Table(name="referencias_laborales")
@NamedQuery(name="MiReferenciasLaborale.findAll", query="SELECT m FROM MiReferenciasLaborale m")
public class MiReferenciasLaborale implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_referencias_laborales")
	private Integer idReferenciasLaborales;

	private String institucion;

	@Column(name="jefe_inmediato")
	private String jefeInmediato;

	private String telefono;

	//bi-directional many-to-one association to MiDatosPersonale
	@ManyToOne
	@JoinColumn(name="id_datos_personales")
	private MiDatosPersonale datosPersonale;

	public MiReferenciasLaborale() {
	}

	public Integer getIdReferenciasLaborales() {
		return this.idReferenciasLaborales;
	}

	public void setIdReferenciasLaborales(Integer idReferenciasLaborales) {
		this.idReferenciasLaborales = idReferenciasLaborales;
	}

	public String getInstitucion() {
		return this.institucion;
	}

	public void setInstitucion(String institucion) {
		this.institucion = institucion;
	}

	public String getJefeInmediato() {
		return this.jefeInmediato;
	}

	public void setJefeInmediato(String jefeInmediato) {
		this.jefeInmediato = jefeInmediato;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public MiDatosPersonale getDatosPersonale() {
		return this.datosPersonale;
	}

	public void setDatosPersonale(MiDatosPersonale datosPersonale) {
		this.datosPersonale = datosPersonale;
	}

}