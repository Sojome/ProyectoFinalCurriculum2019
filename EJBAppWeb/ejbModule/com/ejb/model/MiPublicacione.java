package com.ejb.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the publicaciones database table.
 * 
 */
@Entity
@Table(name="publicaciones")
@NamedQuery(name="MiPublicacione.findAll", query="SELECT m FROM MiPublicacione m")
public class MiPublicacione implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_publicaciones")
	private Integer idPublicaciones;

	private String anio;

	private String editorial;

	private String institucion;

	@Column(name="tipo_de_publicacion_texto")
	private String tipoDePublicacionTexto;

	private String titulo;

	//bi-directional many-to-one association to MiDatosPersonale
	@ManyToOne
	@JoinColumn(name="id_datos_personales")
	private MiDatosPersonale datosPersonale;

	//bi-directional many-to-one association to MiTipoDePublicacione
	@ManyToOne
	@JoinColumn(name="id_tipo_de_publicacion")
	private MiTipoDePublicacione tipoDePublicacione;

	public MiPublicacione() {
	}

	public Integer getIdPublicaciones() {
		return this.idPublicaciones;
	}

	public void setIdPublicaciones(Integer idPublicaciones) {
		this.idPublicaciones = idPublicaciones;
	}

	public String getAnio() {
		return this.anio;
	}

	public void setAnio(String anio) {
		this.anio = anio;
	}

	public String getEditorial() {
		return this.editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public String getInstitucion() {
		return this.institucion;
	}

	public void setInstitucion(String institucion) {
		this.institucion = institucion;
	}

	public String getTipoDePublicacionTexto() {
		return this.tipoDePublicacionTexto;
	}

	public void setTipoDePublicacionTexto(String tipoDePublicacionTexto) {
		this.tipoDePublicacionTexto = tipoDePublicacionTexto;
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

	public MiTipoDePublicacione getTipoDePublicacione() {
		return this.tipoDePublicacione;
	}

	public void setTipoDePublicacione(MiTipoDePublicacione tipoDePublicacione) {
		this.tipoDePublicacione = tipoDePublicacione;
	}

}