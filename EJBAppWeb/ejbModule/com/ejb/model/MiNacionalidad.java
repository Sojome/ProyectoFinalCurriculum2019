package com.ejb.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the nacionalidad database table.
 * 
 */
@Entity
@Table(name="nacionalidad")
@NamedQuery(name="MiNacionalidad.findAll", query="SELECT m FROM MiNacionalidad m")
public class MiNacionalidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_nacionalidad")
	private Integer idNacionalidad;

	private String nombre;

	//bi-directional many-to-one association to MiDatosPersonale
	@OneToMany(mappedBy="nacionalidad")
	private List<MiDatosPersonale> datosPersonales;

	//bi-directional many-to-one association to MiPais
	@ManyToOne
	@JoinColumn(name="id_pais")
	private MiPais pai;

	public MiNacionalidad() {
	}

	public Integer getIdNacionalidad() {
		return this.idNacionalidad;
	}

	public void setIdNacionalidad(Integer idNacionalidad) {
		this.idNacionalidad = idNacionalidad;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<MiDatosPersonale> getDatosPersonales() {
		return this.datosPersonales;
	}

	public void setDatosPersonales(List<MiDatosPersonale> datosPersonales) {
		this.datosPersonales = datosPersonales;
	}

	public MiDatosPersonale addDatosPersonale(MiDatosPersonale datosPersonale) {
		getDatosPersonales().add(datosPersonale);
		datosPersonale.setNacionalidad(this);

		return datosPersonale;
	}

	public MiDatosPersonale removeDatosPersonale(MiDatosPersonale datosPersonale) {
		getDatosPersonales().remove(datosPersonale);
		datosPersonale.setNacionalidad(null);

		return datosPersonale;
	}

	public MiPais getPai() {
		return this.pai;
	}

	public void setPai(MiPais pai) {
		this.pai = pai;
	}

}