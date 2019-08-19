package com.ejb.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the parroquia database table.
 * 
 */
@Entity
@Table(name="parroquia")
@NamedQuery(name="MiParroquia.findAll", query="SELECT m FROM MiParroquia m")
public class MiParroquia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_parroquia")
	private Integer idParroquia;

	private String nombre;

	//bi-directional many-to-one association to MiDatosPersonale
	@OneToMany(mappedBy="parroquia")
	private List<MiDatosPersonale> datosPersonales;

	//bi-directional many-to-one association to MiCanton
	@ManyToOne
	@JoinColumn(name="id_canton")
	private MiCanton canton;

	public MiParroquia() {
	}

	public Integer getIdParroquia() {
		return this.idParroquia;
	}

	public void setIdParroquia(Integer idParroquia) {
		this.idParroquia = idParroquia;
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
		datosPersonale.setParroquia(this);

		return datosPersonale;
	}

	public MiDatosPersonale removeDatosPersonale(MiDatosPersonale datosPersonale) {
		getDatosPersonales().remove(datosPersonale);
		datosPersonale.setParroquia(null);

		return datosPersonale;
	}

	public MiCanton getCanton() {
		return this.canton;
	}

	public void setCanton(MiCanton canton) {
		this.canton = canton;
	}

}