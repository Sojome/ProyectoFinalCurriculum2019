package com.ejb.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the canton database table.
 * 
 */
@Entity
@Table(name="canton")
@NamedQuery(name="MiCanton.findAll", query="SELECT m FROM MiCanton m")
public class MiCanton implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_canton")
	private Integer idCanton;

	private String nombre;

	//bi-directional many-to-one association to MiProvincia
	@ManyToOne
	@JoinColumn(name="id_provincia")
	private MiProvincia provincia;

	//bi-directional many-to-one association to MiParroquia
	@OneToMany(mappedBy="canton")
	private List<MiParroquia> parroquias;

	//bi-directional many-to-one association to MiTitulosObtenido
	@OneToMany(mappedBy="canton")
	private List<MiTitulosObtenido> titulosObtenidos;

	public MiCanton() {
	}

	public Integer getIdCanton() {
		return this.idCanton;
	}

	public void setIdCanton(Integer idCanton) {
		this.idCanton = idCanton;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public MiProvincia getProvincia() {
		return this.provincia;
	}

	public void setProvincia(MiProvincia provincia) {
		this.provincia = provincia;
	}

	public List<MiParroquia> getParroquias() {
		return this.parroquias;
	}

	public void setParroquias(List<MiParroquia> parroquias) {
		this.parroquias = parroquias;
	}

	public MiParroquia addParroquia(MiParroquia parroquia) {
		getParroquias().add(parroquia);
		parroquia.setCanton(this);

		return parroquia;
	}

	public MiParroquia removeParroquia(MiParroquia parroquia) {
		getParroquias().remove(parroquia);
		parroquia.setCanton(null);

		return parroquia;
	}

	public List<MiTitulosObtenido> getTitulosObtenidos() {
		return this.titulosObtenidos;
	}

	public void setTitulosObtenidos(List<MiTitulosObtenido> titulosObtenidos) {
		this.titulosObtenidos = titulosObtenidos;
	}

	public MiTitulosObtenido addTitulosObtenido(MiTitulosObtenido titulosObtenido) {
		getTitulosObtenidos().add(titulosObtenido);
		titulosObtenido.setCanton(this);

		return titulosObtenido;
	}

	public MiTitulosObtenido removeTitulosObtenido(MiTitulosObtenido titulosObtenido) {
		getTitulosObtenidos().remove(titulosObtenido);
		titulosObtenido.setCanton(null);

		return titulosObtenido;
	}

}