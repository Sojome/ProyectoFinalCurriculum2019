package com.ejb.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the provincia database table.
 * 
 */
@Entity
@Table(name="provincia")
@NamedQuery(name="MiProvincia.findAll", query="SELECT m FROM MiProvincia m")
public class MiProvincia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_provincia")
	private Integer idProvincia;

	private String nombre;

	//bi-directional many-to-one association to MiCanton
	@OneToMany(mappedBy="provincia")
	private List<MiCanton> cantons;

	//bi-directional many-to-one association to MiPais
	@ManyToOne
	@JoinColumn(name="id_pais")
	private MiPais pai;

	public MiProvincia() {
	}

	public Integer getIdProvincia() {
		return this.idProvincia;
	}

	public void setIdProvincia(Integer idProvincia) {
		this.idProvincia = idProvincia;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<MiCanton> getCantons() {
		return this.cantons;
	}

	public void setCantons(List<MiCanton> cantons) {
		this.cantons = cantons;
	}

	public MiCanton addCanton(MiCanton canton) {
		getCantons().add(canton);
		canton.setProvincia(this);

		return canton;
	}

	public MiCanton removeCanton(MiCanton canton) {
		getCantons().remove(canton);
		canton.setProvincia(null);

		return canton;
	}

	public MiPais getPai() {
		return this.pai;
	}

	public void setPai(MiPais pai) {
		this.pai = pai;
	}

}