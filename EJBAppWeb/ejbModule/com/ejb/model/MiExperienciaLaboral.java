package com.ejb.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the experiencia_laboral database table.
 * 
 */
@Entity
@Table(name="experiencia_laboral")
@NamedQuery(name="MiExperienciaLaboral.findAll", query="SELECT m FROM MiExperienciaLaboral m")
public class MiExperienciaLaboral implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_experiencia_laboral")
	private Integer idExperienciaLaboral;

	private String catedraa;

	@Temporal(TemporalType.DATE)
	private Date desde;

	private String funcion;

	@Temporal(TemporalType.DATE)
	private Date hasta;

	private String institucion;

	//bi-directional many-to-one association to MiDatosPersonale
	@ManyToOne
	@JoinColumn(name="id_datos_personales")
	private MiDatosPersonale datosPersonale;

	//bi-directional many-to-one association to MiTipoDeExperiencia
	@ManyToOne
	@JoinColumn(name="id_tipo_de_experiencia")
	private MiTipoDeExperiencia tipoDeExperiencia;

	public MiExperienciaLaboral() {
	}

	public Integer getIdExperienciaLaboral() {
		return this.idExperienciaLaboral;
	}

	public void setIdExperienciaLaboral(Integer idExperienciaLaboral) {
		this.idExperienciaLaboral = idExperienciaLaboral;
	}

	public String getCatedraa() {
		return this.catedraa;
	}

	public void setCatedraa(String catedraa) {
		this.catedraa = catedraa;
	}

	public Date getDesde() {
		return this.desde;
	}

	public void setDesde(Date desde) {
		this.desde = desde;
	}

	public String getFuncion() {
		return this.funcion;
	}

	public void setFuncion(String funcion) {
		this.funcion = funcion;
	}

	public Date getHasta() {
		return this.hasta;
	}

	public void setHasta(Date hasta) {
		this.hasta = hasta;
	}

	public String getInstitucion() {
		return this.institucion;
	}

	public void setInstitucion(String institucion) {
		this.institucion = institucion;
	}

	public MiDatosPersonale getDatosPersonale() {
		return this.datosPersonale;
	}

	public void setDatosPersonale(MiDatosPersonale datosPersonale) {
		this.datosPersonale = datosPersonale;
	}

	public MiTipoDeExperiencia getTipoDeExperiencia() {
		return this.tipoDeExperiencia;
	}

	public void setTipoDeExperiencia(MiTipoDeExperiencia tipoDeExperiencia) {
		this.tipoDeExperiencia = tipoDeExperiencia;
	}

}