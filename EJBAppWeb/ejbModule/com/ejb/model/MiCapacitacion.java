package com.ejb.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the capacitacion database table.
 * 
 */
@Entity
@Table(name="capacitacion")
@NamedQuery(name="MiCapacitacion.findAll", query="SELECT m FROM MiCapacitacion m")
public class MiCapacitacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_capacitacion")
	private Integer idCapacitacion;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_final")
	private Date fechaFinal;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_inicial")
	private Date fechaInicial;

	private String institucion;

	@Column(name="numero_de_horas")
	private Integer numeroDeHoras;

	@Column(name="tipo_de_evento")
	private String tipoDeEvento;

	//bi-directional many-to-one association to MiDatosPersonale
	@ManyToOne
	@JoinColumn(name="id_datos_personales")
	private MiDatosPersonale datosPersonale;

	//bi-directional many-to-one association to MiTipoDeCapacitacion
	@ManyToOne
	@JoinColumn(name="id_tipo_de_capacitacion")
	private MiTipoDeCapacitacion tipoDeCapacitacion;

	public MiCapacitacion() {
	}

	public Integer getIdCapacitacion() {
		return this.idCapacitacion;
	}

	public void setIdCapacitacion(Integer idCapacitacion) {
		this.idCapacitacion = idCapacitacion;
	}

	public Date getFechaFinal() {
		return this.fechaFinal;
	}

	public void setFechaFinal(Date fechaFinal) {
		this.fechaFinal = fechaFinal;
	}

	public Date getFechaInicial() {
		return this.fechaInicial;
	}

	public void setFechaInicial(Date fechaInicial) {
		this.fechaInicial = fechaInicial;
	}

	public String getInstitucion() {
		return this.institucion;
	}

	public void setInstitucion(String institucion) {
		this.institucion = institucion;
	}

	public Integer getNumeroDeHoras() {
		return this.numeroDeHoras;
	}

	public void setNumeroDeHoras(Integer numeroDeHoras) {
		this.numeroDeHoras = numeroDeHoras;
	}

	public String getTipoDeEvento() {
		return this.tipoDeEvento;
	}

	public void setTipoDeEvento(String tipoDeEvento) {
		this.tipoDeEvento = tipoDeEvento;
	}

	public MiDatosPersonale getDatosPersonale() {
		return this.datosPersonale;
	}

	public void setDatosPersonale(MiDatosPersonale datosPersonale) {
		this.datosPersonale = datosPersonale;
	}

	public MiTipoDeCapacitacion getTipoDeCapacitacion() {
		return this.tipoDeCapacitacion;
	}

	public void setTipoDeCapacitacion(MiTipoDeCapacitacion tipoDeCapacitacion) {
		this.tipoDeCapacitacion = tipoDeCapacitacion;
	}

}