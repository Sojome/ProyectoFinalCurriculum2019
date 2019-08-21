package com.ejb.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the titulos_obtenidos database table.
 * 
 */
@Entity
@Table(name="titulos_obtenidos")
@NamedQuery(name="MiTitulosObtenido.findAll", query="SELECT m FROM MiTitulosObtenido m")
public class MiTitulosObtenido implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_titulos_obtenidos")
	private Integer idTitulosObtenidos;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_de_grado")
	private Date fechaDeGrado;

	private String titulo;

	private String universidad;

	//bi-directional many-to-one association to MiCanton
	@ManyToOne
	@JoinColumn(name="id_ciudad")
	private MiCanton canton;

	//bi-directional many-to-one association to MiDatosPersonale
	@ManyToOne
	@JoinColumn(name="id_datos_personales")
	private MiDatosPersonale datosPersonale;

	//bi-directional many-to-one association to MiNivelTitulo
	@ManyToOne
	@JoinColumn(name="id_nivel_titulo")
	private MiNivelTitulo nivelTitulo;

	//bi-directional many-to-one association to MiParroquia
	@ManyToOne
	@JoinColumn(name="id_ciudad")
	private MiParroquia parroquia;

	public MiTitulosObtenido() {
	}

	public Integer getIdTitulosObtenidos() {
		return this.idTitulosObtenidos;
	}

	public void setIdTitulosObtenidos(Integer idTitulosObtenidos) {
		this.idTitulosObtenidos = idTitulosObtenidos;
	}

	public Date getFechaDeGrado() {
		return this.fechaDeGrado;
	}

	public void setFechaDeGrado(Date fechaDeGrado) {
		this.fechaDeGrado = fechaDeGrado;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getUniversidad() {
		return this.universidad;
	}

	public void setUniversidad(String universidad) {
		this.universidad = universidad;
	}

	public MiCanton getCanton() {
		return this.canton;
	}

	public void setCanton(MiCanton canton) {
		this.canton = canton;
	}

	public MiDatosPersonale getDatosPersonale() {
		return this.datosPersonale;
	}

	public void setDatosPersonale(MiDatosPersonale datosPersonale) {
		this.datosPersonale = datosPersonale;
	}

	public MiNivelTitulo getNivelTitulo() {
		return this.nivelTitulo;
	}

	public void setNivelTitulo(MiNivelTitulo nivelTitulo) {
		this.nivelTitulo = nivelTitulo;
	}

	public MiParroquia getParroquia() {
		return this.parroquia;
	}

	public void setParroquia(MiParroquia parroquia) {
		this.parroquia = parroquia;
	}

}