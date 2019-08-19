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

//import com.ejb.model.Carpeta;
//import com.ejb.session.CarpetaSession;
import com.ejb.model.*;
import com.ejb.session.*;
import com.oracle.wls.shaded.org.apache.bcel.generic.Select;
import com.sun.xml.rpc.processor.modeler.j2ee.xml.string;;

@SuppressWarnings("deprecation")
@ManagedBean(name = "carpetaController")
@SessionScoped
public class CarpetaController implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	//LLAME O CONECTE CON LA CAPA PRESENTACION
	@EJB
	private CarpetaSession ejbCarpetaSession;
	@EJB
	private CantonSession ejbCantonSession;
	@EJB
	private PaisSession ejbPaisSession;
	@EJB
	private ProvinciaSession ejbProvinciaSession;
	@EJB
	private ParroquiaSession ejbParroquiaSession;
	
	//crear un objeto listar
	public Carpeta carpeta;
	public Pais pais;
	public Provincia provincia;
	public Parroquia parroquia;
	public Canton canton;
	
	//objeto para cargar la lista de carpeta
	DataModel<Carpeta> listarC;
	private ArrayList<SelectItem> CantonArray;
	private ArrayList<SelectItem> PaisArray;
	private ArrayList<SelectItem> ParroquiaArray;
	private ArrayList<SelectItem> ProvinciaArray;
	
	//Areas de estudio
	List<String> areaEstudioLista = new ArrayList<String>();
	
	private int estado;
	private String mensaje;
	
	public int varPais=0;
	public int varCanton=0;
	public int varProvincia=0;
	public int varParroquia=0;

	public CarpetaController() {
		if(carpeta !=null)
		{
			carpeta = new Carpeta();
			pais = new Pais();
			ProvinciaArray = new ArrayList<>();
		}
	}
	
	//Objetos para cargarlo en tiempo de ejecucion
	@PostConstruct
	public void init() {
		areaEstudioLista = new ArrayList<String>();
		areaEstudioLista.add("administraccion");
		areaEstudioLista.add("investigacion");
		areaEstudioLista.add("educacion");
		areaEstudioLista.add("sistema");
	}
	
	public List<String> getAreaEstudioLista() {
		return areaEstudioLista;
	}

	public void setAreaEstudioLista(List<String> areaEstudioLista) {
		this.areaEstudioLista = areaEstudioLista;
	}

	public Carpeta getCarpeta() {
		return carpeta;
	}

	public void setCarpeta(Carpeta carpeta) {
		this.carpeta = carpeta;
	}
	
	//modificar el listar con el metodo listar de EJB
	public DataModel<Carpeta> getListarC() {
		listarC = new ListDataModel<Carpeta>(ejbCarpetaSession.listar());
		return listarC;
	}

	public void setListarC(DataModel<Carpeta> listarC) {
		this.listarC = listarC;
	}
	
	//---------------------------PAIS-------------------------------
	public ArrayList<SelectItem> getPaisArray() {
		PaisArray = new ArrayList<SelectItem>();
		for(Pais obj: ejbPaisSession.listar())
		{
			PaisArray.add(new SelectItem(obj.getId().toString(), obj.getDescPais()));
		}
		return PaisArray;
	}

	public void setPaisnArray(ArrayList<SelectItem> paisArray) {
		PaisArray = paisArray;
	}
	//---------------------------PROVINCIA-------------------------------
	public ArrayList<SelectItem> getProvinciaArray() {
		ProvinciaArray = new ArrayList<SelectItem>();
		for(Provincia obj: ejbProvinciaSession.listar(getVarPais()))
		{
			ProvinciaArray.add(new SelectItem(obj.getId().toString(), obj.getDescProvincia()));
		}
		return ProvinciaArray;
	}

	public void setProvinciaArray(ArrayList<SelectItem> provinciaArray) {
		ProvinciaArray = provinciaArray;
	}
	//---------------------------CANTON-------------------------------
	public ArrayList<SelectItem> getCantonArray() {
		CantonArray = new ArrayList<SelectItem>();
		for(Canton obj: ejbCantonSession.listar(getVarProvincia()))
		{
			CantonArray.add(new SelectItem(obj.getId().toString(), obj.getDescCanton()));
		}
		return CantonArray;
	}

	public void setCantonArray(ArrayList<SelectItem> cantonArray) {
		CantonArray = cantonArray;
	}
	//---------------------------PARROQUIA-------------------------------
	public ArrayList<SelectItem> getParroquiaArray() {
		ParroquiaArray = new ArrayList<SelectItem>();
		for(Parroquia obj: ejbParroquiaSession.listar(getVarCanton()))
		{
			ParroquiaArray.add(new SelectItem(obj.getId().toString(), obj.getDescParroquia()));
		}
		return ParroquiaArray;
	}

	public void setParroquiaArray(ArrayList<SelectItem> parroquiaArray) {
		ParroquiaArray = parroquiaArray;
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
	
	public void limpiar() {
		carpeta = new Carpeta();
		estado = 0;
	}
	
	public String grabar() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			if(getEstado()==1)
			{
				mensaje = ejbCarpetaSession.actualizar(carpeta);
				context.addMessage(null, new FacesMessage(mensaje.toString()));
			}
			else
			{
				mensaje = ejbCarpetaSession.grabar(carpeta);
				context.addMessage(null, new FacesMessage(mensaje.toString()));
			}
		} catch (Exception e) {
			mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR, "error",
					e.toString()).toString();
		}
		return null;
	}
	
	public void buscar(ActionEvent e) throws Exception{
		carpeta = new Carpeta();
		carpeta.setId(e.getComponent().getAttributes().get("carpetabuscar").hashCode());
		carpeta = ejbCarpetaSession.buscar(carpeta);
		
		if(carpeta != null)
		{
			carpeta.getId();
			carpeta.getNombre();
			setEstado(1);
		}
	}
	
	public void eliminar(ActionEvent e) throws Exception{
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			//Obejto vacio
			carpeta = new Carpeta();
			//cargamos id
			carpeta.setId(e.getComponent().getAttributes().get("carpetaeliminar").hashCode());
			//eliminar
			mensaje = ejbCarpetaSession.eliminar(carpeta);
			context.addMessage(null, new FacesMessage(mensaje.toString()));
		} catch (Exception e2) {
			mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR,"error",e2.toString()).toString();
			context.addMessage(null, new FacesMessage(mensaje.toString()));
		}
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public Provincia getProvincia() {
		return provincia;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}

	public Parroquia getParroquia() {
		return parroquia;
	}

	public void setParroquia(Parroquia parroquia) {
		this.parroquia = parroquia;
	}

	public Canton getCanton() {
		return canton;
	}

	public void setCanton(Canton canton) {
		this.canton = canton;
	}

	public int getVarPais() {
		return varPais;
	}

	public void setVarPais(int varPais) {
		this.varPais = varPais;
	}

	public int getVarCanton() {
		return varCanton;
	}

	public void setVarCanton(int varCanton) {
		this.varCanton = varCanton;
	}

	public int getVarProvincia() {
		return varProvincia;
	}

	public void setVarProvincia(int varProvincia) {
		this.varProvincia = varProvincia;
	}

	public int getVarParroquia() {
		return varParroquia;
	}

	public void setVarParroquia(int varParroquia) {
		this.varParroquia = varParroquia;
	}
	
}
