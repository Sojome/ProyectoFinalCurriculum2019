package com.ejb.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipo_de_experiencia database table.
 * 
 */
@Entity
@Table(name="tipo_de_experiencia")
@NamedQuery(name="MiTipoDeExperiencia.findAll", query="SELECT m FROM MiTipoDeExperiencia m")
public class MiTipoDeExperiencia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_tipo_de_experiencia")
	private Integer idTipoDeExperiencia;

	private String nombre;

	//bi-directional many-to-one association to MiExperienciaLaboral
	@OneToMany(mappedBy="tipoDeExperiencia")
	private List<MiExperienciaLaboral> experienciaLaborals;

	public MiTipoDeExperiencia() {
	}

	public Integer getIdTipoDeExperiencia() {
		return this.idTipoDeExperiencia;
	}

	public void setIdTipoDeExperiencia(Integer idTipoDeExperiencia) {
		this.idTipoDeExperiencia = idTipoDeExperiencia;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<MiExperienciaLaboral> getExperienciaLaborals() {
		return this.experienciaLaborals;
	}

	public void setExperienciaLaborals(List<MiExperienciaLaboral> experienciaLaborals) {
		this.experienciaLaborals = experienciaLaborals;
	}

	public MiExperienciaLaboral addExperienciaLaboral(MiExperienciaLaboral experienciaLaboral) {
		getExperienciaLaborals().add(experienciaLaboral);
		experienciaLaboral.setTipoDeExperiencia(this);

		return experienciaLaboral;
	}

	public MiExperienciaLaboral removeExperienciaLaboral(MiExperienciaLaboral experienciaLaboral) {
		getExperienciaLaborals().remove(experienciaLaboral);
		experienciaLaboral.setTipoDeExperiencia(null);

		return experienciaLaboral;
	}

}