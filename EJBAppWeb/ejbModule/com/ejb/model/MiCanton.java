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

}