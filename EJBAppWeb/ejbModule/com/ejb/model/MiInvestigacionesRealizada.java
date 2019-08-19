package com.ejb.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the investigaciones_realizadas database table.
 * 
 */
@Entity
@Table(name="investigaciones_realizadas")
@NamedQuery(name="MiInvestigacionesRealizada.findAll", query="SELECT m FROM MiInvestigacionesRealizada m")
public class MiInvestigacionesRealizada implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_investigaciones_realizadas")
	private Integer idInvestigacionesRealizadas;

	private Integer anio;

	private String institucion;

	private String titulo;

	//bi-directional many-to-one association to MiDatosPersonale
	@ManyToOne
	@JoinColumn(name="id_datos_personales")
	private MiDatosPersonale datosPersonale;

	public MiInvestigacionesRealizada() {
	}

	public Integer getIdInvestigacionesRealizadas() {
		return this.idInvestigacionesRealizadas;
	}

	public void setIdInvestigacionesRealizadas(Integer idInvestigacionesRealizadas) {
		this.idInvestigacionesRealizadas = idInvestigacionesRealizadas;
	}

	public Integer getAnio() {
		return this.anio;
	}

	public void setAnio(Integer anio) {
		this.anio = anio;
	}

	public String getInstitucion() {
		return this.institucion;
	}

	public void setInstitucion(String institucion) {
		this.institucion = institucion;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public MiDatosPersonale getDatosPersonale() {
		return this.datosPersonale;
	}

	public void setDatosPersonale(MiDatosPersonale datosPersonale) {
		this.datosPersonale = datosPersonale;
	}

}