package com.ejb.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the nivel_titulo database table.
 * 
 */
@Entity
@Table(name="nivel_titulo")
@NamedQuery(name="MiNivelTitulo.findAll", query="SELECT m FROM MiNivelTitulo m")
public class MiNivelTitulo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_nivel_titulo")
	private Integer idNivelTitulo;

	private String nombre;

	//bi-directional many-to-one association to MiTitulosObtenido
	@OneToMany(mappedBy="nivelTitulo")
	private List<MiTitulosObtenido> titulosObtenidos;

	public MiNivelTitulo() {
	}

	public Integer getIdNivelTitulo() {
		return this.idNivelTitulo;
	}

	public void setIdNivelTitulo(Integer idNivelTitulo) {
		this.idNivelTitulo = idNivelTitulo;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<MiTitulosObtenido> getTitulosObtenidos() {
		return this.titulosObtenidos;
	}

	public void setTitulosObtenidos(List<MiTitulosObtenido> titulosObtenidos) {
		this.titulosObtenidos = titulosObtenidos;
	}

	public MiTitulosObtenido addTitulosObtenido(MiTitulosObtenido titulosObtenido) {
		getTitulosObtenidos().add(titulosObtenido);
		titulosObtenido.setNivelTitulo(this);

		return titulosObtenido;
	}

	public MiTitulosObtenido removeTitulosObtenido(MiTitulosObtenido titulosObtenido) {
		getTitulosObtenidos().remove(titulosObtenido);
		titulosObtenido.setNivelTitulo(null);

		return titulosObtenido;
	}

}