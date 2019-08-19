package com.ejb.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipo_de_sangre database table.
 * 
 */
@Entity
@Table(name="tipo_de_sangre")
@NamedQuery(name="MiTipoDeSangre.findAll", query="SELECT m FROM MiTipoDeSangre m")
public class MiTipoDeSangre implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_tipo_de_sangre")
	private Integer idTipoDeSangre;

	private String nombre;

	//bi-directional many-to-one association to MiDatosPersonale
	@OneToMany(mappedBy="tipoDeSangre")
	private List<MiDatosPersonale> datosPersonales;

	public MiTipoDeSangre() {
	}

	public Integer getIdTipoDeSangre() {
		return this.idTipoDeSangre;
	}

	public void setIdTipoDeSangre(Integer idTipoDeSangre) {
		this.idTipoDeSangre = idTipoDeSangre;
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
		datosPersonale.setTipoDeSangre(this);

		return datosPersonale;
	}

	public MiDatosPersonale removeDatosPersonale(MiDatosPersonale datosPersonale) {
		getDatosPersonales().remove(datosPersonale);
		datosPersonale.setTipoDeSangre(null);

		return datosPersonale;
	}

}