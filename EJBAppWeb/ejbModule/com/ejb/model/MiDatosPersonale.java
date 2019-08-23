package com.ejb.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the datos_personales database table.
 * 
 */
@Entity
@Table(name="datos_personales")
@NamedQuery(name="MiDatosPersonale.findAll", query="SELECT m FROM MiDatosPersonale m")
public class MiDatosPersonale implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String cedula;

	private String contrasena;

	@Column(name="correo_electronico")
	private String correoElectronico;

	private String direccion;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_de_nacimiento")
	private Date fechaDeNacimiento;

	private String nacionalidad;

	@Column(name="primer_apellido")
	private String primerApellido;

	@Column(name="primer_nombre")
	private String primerNombre;

	@Column(name="segundo_apellido")
	private String segundoApellido;

	@Column(name="segundo_nombre")
	private String segundoNombre;

	private Boolean sesion;

	@Column(name="telefono_celular")
	private String telefonoCelular;

	@Column(name="telefono_convencional")
	private String telefonoConvencional;

	private String usuario;

	//bi-directional many-to-one association to MiCapacitacion
	@OneToMany(mappedBy="datosPersonale")
	private List<MiCapacitacion> capacitacions;

	//bi-directional many-to-one association to MiEstadoCivil
	@ManyToOne
	@JoinColumn(name="id_estado_civil")
	private MiEstadoCivil estadoCivil;

	//bi-directional many-to-one association to MiParroquia
	@ManyToOne
	@JoinColumn(name="id_lugar_de_nacimiento")
	private MiParroquia parroquia;

	//bi-directional many-to-one association to MiTipoDeSangre
	@ManyToOne
	@JoinColumn(name="id_tipo_de_sangre")
	private MiTipoDeSangre tipoDeSangre;

	//bi-directional many-to-one association to MiExperienciaLaboral
	@OneToMany(mappedBy="datosPersonale")
	private List<MiExperienciaLaboral> experienciaLaborals;

	//bi-directional many-to-one association to MiInvestigacionesRealizada
	@OneToMany(mappedBy="datosPersonale")
	private List<MiInvestigacionesRealizada> investigacionesRealizadas;

	//bi-directional many-to-one association to MiPublicacione
	@OneToMany(mappedBy="datosPersonale")
	private List<MiPublicacione> publicaciones;

	//bi-directional many-to-one association to MiReferenciasLaborale
	@OneToMany(mappedBy="datosPersonale")
	private List<MiReferenciasLaborale> referenciasLaborales;

	//bi-directional many-to-one association to MiTitulosObtenido
	@OneToMany(mappedBy="datosPersonale")
	private List<MiTitulosObtenido> titulosObtenidos;

	public MiDatosPersonale() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCedula() {
		return this.cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getContrasena() {
		return this.contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getCorreoElectronico() {
		return this.correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Date getFechaDeNacimiento() {
		return this.fechaDeNacimiento;
	}

	public void setFechaDeNacimiento(Date fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}

	public String getNacionalidad() {
		return this.nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getPrimerApellido() {
		return this.primerApellido;
	}

	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	public String getPrimerNombre() {
		return this.primerNombre;
	}

	public void setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}

	public String getSegundoApellido() {
		return this.segundoApellido;
	}

	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}

	public String getSegundoNombre() {
		return this.segundoNombre;
	}

	public void setSegundoNombre(String segundoNombre) {
		this.segundoNombre = segundoNombre;
	}

	public Boolean getSesion() {
		return this.sesion;
	}

	public void setSesion(Boolean sesion) {
		this.sesion = sesion;
	}

	public String getTelefonoCelular() {
		return this.telefonoCelular;
	}

	public void setTelefonoCelular(String telefonoCelular) {
		this.telefonoCelular = telefonoCelular;
	}

	public String getTelefonoConvencional() {
		return this.telefonoConvencional;
	}

	public void setTelefonoConvencional(String telefonoConvencional) {
		this.telefonoConvencional = telefonoConvencional;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public List<MiCapacitacion> getCapacitacions() {
		return this.capacitacions;
	}

	public void setCapacitacions(List<MiCapacitacion> capacitacions) {
		this.capacitacions = capacitacions;
	}

	public MiCapacitacion addCapacitacion(MiCapacitacion capacitacion) {
		getCapacitacions().add(capacitacion);
		capacitacion.setDatosPersonale(this);

		return capacitacion;
	}

	public MiCapacitacion removeCapacitacion(MiCapacitacion capacitacion) {
		getCapacitacions().remove(capacitacion);
		capacitacion.setDatosPersonale(null);

		return capacitacion;
	}

	public MiEstadoCivil getEstadoCivil() {
		return this.estadoCivil;
	}

	public void setEstadoCivil(MiEstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public MiParroquia getParroquia() {
		return this.parroquia;
	}

	public void setParroquia(MiParroquia parroquia) {
		this.parroquia = parroquia;
	}

	public MiTipoDeSangre getTipoDeSangre() {
		return this.tipoDeSangre;
	}

	public void setTipoDeSangre(MiTipoDeSangre tipoDeSangre) {
		this.tipoDeSangre = tipoDeSangre;
	}

	public List<MiExperienciaLaboral> getExperienciaLaborals() {
		return this.experienciaLaborals;
	}

	public void setExperienciaLaborals(List<MiExperienciaLaboral> experienciaLaborals) {
		this.experienciaLaborals = experienciaLaborals;
	}

	public MiExperienciaLaboral addExperienciaLaboral(MiExperienciaLaboral experienciaLaboral) {
		getExperienciaLaborals().add(experienciaLaboral);
		experienciaLaboral.setDatosPersonale(this);

		return experienciaLaboral;
	}

	public MiExperienciaLaboral removeExperienciaLaboral(MiExperienciaLaboral experienciaLaboral) {
		getExperienciaLaborals().remove(experienciaLaboral);
		experienciaLaboral.setDatosPersonale(null);

		return experienciaLaboral;
	}

	public List<MiInvestigacionesRealizada> getInvestigacionesRealizadas() {
		return this.investigacionesRealizadas;
	}

	public void setInvestigacionesRealizadas(List<MiInvestigacionesRealizada> investigacionesRealizadas) {
		this.investigacionesRealizadas = investigacionesRealizadas;
	}

	public MiInvestigacionesRealizada addInvestigacionesRealizada(MiInvestigacionesRealizada investigacionesRealizada) {
		getInvestigacionesRealizadas().add(investigacionesRealizada);
		investigacionesRealizada.setDatosPersonale(this);

		return investigacionesRealizada;
	}

	public MiInvestigacionesRealizada removeInvestigacionesRealizada(MiInvestigacionesRealizada investigacionesRealizada) {
		getInvestigacionesRealizadas().remove(investigacionesRealizada);
		investigacionesRealizada.setDatosPersonale(null);

		return investigacionesRealizada;
	}

	public List<MiPublicacione> getPublicaciones() {
		return this.publicaciones;
	}

	public void setPublicaciones(List<MiPublicacione> publicaciones) {
		this.publicaciones = publicaciones;
	}

	public MiPublicacione addPublicacione(MiPublicacione publicacione) {
		getPublicaciones().add(publicacione);
		publicacione.setDatosPersonale(this);

		return publicacione;
	}

	public MiPublicacione removePublicacione(MiPublicacione publicacione) {
		getPublicaciones().remove(publicacione);
		publicacione.setDatosPersonale(null);

		return publicacione;
	}

	public List<MiReferenciasLaborale> getReferenciasLaborales() {
		return this.referenciasLaborales;
	}

	public void setReferenciasLaborales(List<MiReferenciasLaborale> referenciasLaborales) {
		this.referenciasLaborales = referenciasLaborales;
	}

	public MiReferenciasLaborale addReferenciasLaborale(MiReferenciasLaborale referenciasLaborale) {
		getReferenciasLaborales().add(referenciasLaborale);
		referenciasLaborale.setDatosPersonale(this);

		return referenciasLaborale;
	}

	public MiReferenciasLaborale removeReferenciasLaborale(MiReferenciasLaborale referenciasLaborale) {
		getReferenciasLaborales().remove(referenciasLaborale);
		referenciasLaborale.setDatosPersonale(null);

		return referenciasLaborale;
	}

	public List<MiTitulosObtenido> getTitulosObtenidos() {
		return this.titulosObtenidos;
	}

	public void setTitulosObtenidos(List<MiTitulosObtenido> titulosObtenidos) {
		this.titulosObtenidos = titulosObtenidos;
	}

	public MiTitulosObtenido addTitulosObtenido(MiTitulosObtenido titulosObtenido) {
		getTitulosObtenidos().add(titulosObtenido);
		titulosObtenido.setDatosPersonale(this);

		return titulosObtenido;
	}

	public MiTitulosObtenido removeTitulosObtenido(MiTitulosObtenido titulosObtenido) {
		getTitulosObtenidos().remove(titulosObtenido);
		titulosObtenido.setDatosPersonale(null);

		return titulosObtenido;
	}

}