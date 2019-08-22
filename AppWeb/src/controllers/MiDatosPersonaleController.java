package controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.Dependent;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;

import com.ejb.model.*;
import com.ejb.session.*;
import com.oracle.wls.shaded.org.apache.bcel.generic.Select;
import com.sun.xml.rpc.processor.modeler.j2ee.xml.string;;

@SuppressWarnings("deprecation")
@ManagedBean(name = "midatospersonaleController")
@SessionScoped
public class MiDatosPersonaleController implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	//
	@EJB
	private MiDatosPersonaleSession ejbMiDatosPersonaleSession;
	@EJB
	private MiCantonSession ejbMiCantonSession;
	@EJB
	private MiPaisSession ejbMiPaisSession;
	@EJB
	private MiProvinciaSession ejbMiProvinciaSession;
	@EJB
	private MiParroquiaSession ejbMiParroquiaSession;
	@EJB
	private MiNacionalidadSession ejbMiNacionalidadSession;
	@EJB
	private MiEstadoCivilSession ejbMiEstadoCivilSession;
	@EJB
	private MiTipoDeSangreSession ejbMiTipoDeSangreSession;
	
	//crear un objeto listar
	public MiDatosPersonale midatospersonale;
	public MiPais mipais;
	public MiProvincia miprovincia;
	public MiParroquia miparroquia;
	public MiCanton micanton;
	
	private int estado;
	private String mensaje;
	
	public int varMiPais=0;
	public int varMiCanton=0;
	public int varMiProvincia=0;
	public int varMiParroquia=0;
	public int varMiNacionalidad=0;
	public int varMiEstadoCivil=0;
	public int varMiTipoDeSangre=0;
	
	DataModel<MiDatosPersonale> listarMDP;
	
	private ArrayList<SelectItem> MiCantonArray;
	private ArrayList<SelectItem> MiPaisArray;
	private ArrayList<SelectItem> MiParroquiaArray;
	private ArrayList<SelectItem> MiProvinciaArray;
	private ArrayList<SelectItem> MiNacionalidadArray;
	private ArrayList<SelectItem> MiEstadoCivilArray;
	private ArrayList<SelectItem> MiTipoDeSangreArray;
	
	//PARA EL CRUD

	public MiDatosPersonaleController() {
		if(midatospersonale !=null)
		{
			midatospersonale = new MiDatosPersonale();
		}
	}
	
	public void limpiar() {
		midatospersonale = new MiDatosPersonale();
		estado = 0;
	}
	
	
	public String grabar() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			if(getEstado()==1)
			{
				mensaje = ejbMiDatosPersonaleSession.actualizar(midatospersonale);
				context.addMessage(null, new FacesMessage(mensaje.toString()));
			}
			else
			{
				mensaje = ejbMiDatosPersonaleSession.grabar(midatospersonale);
				context.addMessage(null, new FacesMessage(mensaje.toString()));
			}
		} catch (Exception e) {
			mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR, "error",
					e.toString()).toString();
		}
		return null;
	}
	
	public void buscar(ActionEvent e) throws Exception{
		midatospersonale = new MiDatosPersonale();
		midatospersonale.setId(e.getComponent().getAttributes().get("midatospersonalebuscar").hashCode());
		midatospersonale = ejbMiDatosPersonaleSession.buscar(midatospersonale);
		
		if(midatospersonale != null)
		{
			midatospersonale.getId();
			midatospersonale.getPrimerNombre();
			midatospersonale.getSegundoNombre();
			midatospersonale.getPrimerApellido();
			midatospersonale.getSegundoApellido();
			midatospersonale.getFechaDeNacimiento();
			midatospersonale.getCedula();
			midatospersonale.getNacionalidad().getNombre();
			midatospersonale.getEstadoCivil().getNombre();
			midatospersonale.getTipoDeSangre().getNombre();
			midatospersonale.getParroquia().getNombre();
			midatospersonale.getTelefonoCelular();
			midatospersonale.getTelefonoConvencional();
			midatospersonale.getCorreoElectronico();
			setEstado(1);
		}
	}
	
	public void eliminar(ActionEvent e) throws Exception{
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			//Obejto vacio
			midatospersonale = new MiDatosPersonale();
			//cargamos id
			midatospersonale.setId(e.getComponent().getAttributes().get("midatospersonaleeliminar").hashCode());
			//eliminar
			mensaje = ejbMiDatosPersonaleSession.eliminar(midatospersonale);
			context.addMessage(null, new FacesMessage(mensaje.toString()));
		} catch (Exception e2) {
			mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR,"error",e2.toString()).toString();
			context.addMessage(null, new FacesMessage(mensaje.toString()));
		}
	}
	
	//----GETS AND SETTERS
	
	public MiDatosPersonale getMidatospersonale() {
		return midatospersonale;
	}
	public void setMidatospersonale(MiDatosPersonale midatospersonale) {
		this.midatospersonale = midatospersonale;
	}
	public MiPais getMipais() {
		return mipais;
	}
	public void setMipais(MiPais mipais) {
		this.mipais = mipais;
	}
	public MiProvincia getMiprovincia() {
		return miprovincia;
	}
	public void setMiprovincia(MiProvincia miprovincia) {
		this.miprovincia = miprovincia;
	}
	public MiParroquia getMiparroquia() {
		return miparroquia;
	}
	public void setMiparroquia(MiParroquia miparroquia) {
		this.miparroquia = miparroquia;
	}
	public MiCanton getMicanton() {
		return micanton;
	}
	public void setMicanton(MiCanton micanton) {
		this.micanton = micanton;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public int getVarMiPais() {
		return varMiPais;
	}
	public void setVarMiPais(int varMiPais) {
		this.varMiPais = varMiPais;
	}
	public int getVarMiCanton() {
		return varMiCanton;
	}
	public void setVarMiCanton(int varMiCanton) {
		this.varMiCanton = varMiCanton;
	}
	public int getVarMiProvincia() {
		return varMiProvincia;
	}
	public void setVarMiProvincia(int varMiProvincia) {
		this.varMiProvincia = varMiProvincia;
	}
	public int getVarMiParroquia() {
		return varMiParroquia;
	}
	public void setVarMiParroquia(int varMiParroquia) {
		this.varMiParroquia = varMiParroquia;
	}
	public int getVarMiNacionalidad() {
		return varMiNacionalidad;
	}
	public void setVarMiNacionalidad(int varMiNacionalidad) {
		this.varMiNacionalidad = varMiNacionalidad;
	}
	public int getVarMiEstadoCivil() {
		return varMiEstadoCivil;
	}

	public void setVarMiEstadoCivil(int varMiEstadoCivil) {
		this.varMiEstadoCivil = varMiEstadoCivil;
	}

	public int getVarMiTipoDeSangre() {
		return varMiTipoDeSangre;
	}

	public void setVarMiTipoDeSangre(int varMiTipoDeSangre) {
		this.varMiTipoDeSangre = varMiTipoDeSangre;
	}

	public DataModel<MiDatosPersonale> getListarMDP() {
		listarMDP = new ListDataModel<MiDatosPersonale>(ejbMiDatosPersonaleSession.listar());
		return listarMDP;
	}
	public void setListarMDP(DataModel<MiDatosPersonale> listarMDP) {
		this.listarMDP = listarMDP;
	}
	//---------------------------CANTON-------------------------------
	public ArrayList<SelectItem> getMiCantonArray() {
		MiCantonArray = new ArrayList<SelectItem>();
		for(MiCanton obj: ejbMiCantonSession.listar(getVarMiProvincia()))
		{
			MiCantonArray.add(new SelectItem(obj.getIdCanton().toString(), obj.getNombre()));
		}
		return MiCantonArray;
	}
	public void setMiCantonArray(ArrayList<SelectItem> miCantonArray) {
		MiCantonArray = miCantonArray;
	}
	//---------------------------PAIS-------------------------------
	public ArrayList<SelectItem> getMiPaisArray() {
		MiPaisArray = new ArrayList<SelectItem>();
		for(MiPais obj: ejbMiPaisSession.listar())
		{
			MiPaisArray.add(new SelectItem(obj.getIdPais().toString(), obj.getNombre()));
		}
		return MiPaisArray;
	}
	public void setMiPaisArray(ArrayList<SelectItem> miPaisArray) {
		MiPaisArray = miPaisArray;
	}
	//---------------------------PARROQUIA-------------------------------
	public ArrayList<SelectItem> getMiParroquiaArray() {
		MiParroquiaArray = new ArrayList<SelectItem>();
		for(MiParroquia obj: ejbMiParroquiaSession.listar(getVarMiCanton()))
		{
			MiParroquiaArray.add(new SelectItem(obj.getIdParroquia().toString(), obj.getNombre()));
		}
		return MiParroquiaArray;
	}
	public void setMiParroquiaArray(ArrayList<SelectItem> miParroquiaArray) {
		MiParroquiaArray = miParroquiaArray;
	}
	//---------------------------PROVINCIA-------------------------------
	public ArrayList<SelectItem> getMiProvinciaArray() {
		MiProvinciaArray = new ArrayList<SelectItem>();
		for(MiProvincia obj: ejbMiProvinciaSession.listar(getVarMiPais()))
		{
			MiProvinciaArray.add(new SelectItem(obj.getIdProvincia().toString(), obj.getNombre()));
		}
		return MiProvinciaArray;
	}
	public void setMiProvinciaArray(ArrayList<SelectItem> miProvinciaArray) {
		MiProvinciaArray = miProvinciaArray;
	}
	//---------------------------NACIONALIDAD-------------------------------
	public ArrayList<SelectItem> getMiNacionalidadArray() {
		MiNacionalidadArray = new ArrayList<SelectItem>();
		for(MiNacionalidad obj: ejbMiNacionalidadSession.listar(getVarMiPais()))
		{
			MiNacionalidadArray.add(new SelectItem(obj.getIdNacionalidad().toString(), obj.getNombre()));
		}
		return MiNacionalidadArray;
	}
	public void setMiNacionalidadArray(ArrayList<SelectItem> miNacionalidadArray) {
		MiNacionalidadArray = miNacionalidadArray;
	}
	//---------------------------ESTADO CIVIL-------------------------------
	public ArrayList<SelectItem> getMiEstadoCivilArray() {
		MiEstadoCivilArray = new ArrayList<SelectItem>();
		for(MiEstadoCivil obj: ejbMiEstadoCivilSession.listar())
		{
			MiEstadoCivilArray.add(new SelectItem(obj.getIdEstadoCivil().toString(), obj.getNombre()));
		}
		return MiEstadoCivilArray;
	}

	public void setMiEstadoCivilArray(ArrayList<SelectItem> miEstadoCivilArray) {
		MiEstadoCivilArray = miEstadoCivilArray;
	}
	//---------------------------TIPO DE SANGRE-------------------------------
	public ArrayList<SelectItem> getMiTipoDeSangreArray() {
		MiTipoDeSangreArray = new ArrayList<SelectItem>();
		for(MiTipoDeSangre obj: ejbMiTipoDeSangreSession.listar())
		{
			MiTipoDeSangreArray.add(new SelectItem(obj.getIdTipoDeSangre().toString(), obj.getNombre()));
		}
		return MiTipoDeSangreArray;
	}

	public void setMiTipoDeSangreArray(ArrayList<SelectItem> miTipoDeSangreArray) {
		MiTipoDeSangreArray = miTipoDeSangreArray;
	}
	
}
