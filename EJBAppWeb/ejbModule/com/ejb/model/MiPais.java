package com.ejb.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the pais database table.
 * 
 */
@Entity
@Table(name="pais")
@NamedQuery(name="MiPais.findAll", query="SELECT m FROM MiPais m")
public class MiPais implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_pais")
	private Integer idPais;

	private String nombre;

	//bi-directional many-to-one association to MiProvincia
	@OneToMany(mappedBy="pai")
	private List<MiProvincia> provincias;

	public MiPais() {
	}

	public Integer getIdPais() {
		return this.idPais;
	}

	public void setIdPais(Integer idPais) {
		this.idPais = idPais;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<MiProvincia> getProvincias() {
		return this.provincias;
	}

	public void setProvincias(List<MiProvincia> provincias) {
		this.provincias = provincias;
	}

	public MiProvincia addProvincia(MiProvincia provincia) {
		getProvincias().add(provincia);
		provincia.setPai(this);

		return provincia;
	}

	public MiProvincia removeProvincia(MiProvincia provincia) {
		getProvincias().remove(provincia);
		provincia.setPai(null);

		return provincia;
	}

}