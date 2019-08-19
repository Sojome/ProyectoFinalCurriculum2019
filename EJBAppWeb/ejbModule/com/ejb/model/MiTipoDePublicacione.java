package com.ejb.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipo_de_publicaciones database table.
 * 
 */
@Entity
@Table(name="tipo_de_publicaciones")
@NamedQuery(name="MiTipoDePublicacione.findAll", query="SELECT m FROM MiTipoDePublicacione m")
public class MiTipoDePublicacione implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_tipo_de_publicacion")
	private Integer idTipoDePublicacion;

	private String nombre;

	//bi-directional many-to-one association to MiPublicacione
	@OneToMany(mappedBy="tipoDePublicacione")
	private List<MiPublicacione> publicaciones;

	public MiTipoDePublicacione() {
	}

	public Integer getIdTipoDePublicacion() {
		return this.idTipoDePublicacion;
	}

	public void setIdTipoDePublicacion(Integer idTipoDePublicacion) {
		this.idTipoDePublicacion = idTipoDePublicacion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<MiPublicacione> getPublicaciones() {
		return this.publicaciones;
	}

	public void setPublicaciones(List<MiPublicacione> publicaciones) {
		this.publicaciones = publicaciones;
	}

	public MiPublicacione addPublicacione(MiPublicacione publicacione) {
		getPublicaciones().add(publicacione);
		publicacione.setTipoDePublicacione(this);

		return publicacione;
	}

	public MiPublicacione removePublicacione(MiPublicacione publicacione) {
		getPublicaciones().remove(publicacione);
		publicacione.setTipoDePublicacione(null);

		return publicacione;
	}

}