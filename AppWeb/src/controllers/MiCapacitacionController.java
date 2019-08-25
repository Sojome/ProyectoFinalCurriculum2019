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
@ManagedBean(name = "micapacitacionController")
@SessionScoped
public class MiCapacitacionController implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	//
	@EJB
	private MiCapacitacionSession ejbMiCapacitacionSession;
	@EJB
	private MiTipoDeCapacitacionSession ejbMiTipoDeCapacitacionSession;
	
	//crear un objeto listar
	public MiCapacitacion micapacitacion;
	
	//listar datos
	public MiTipoDeCapacitacion mitipodecapacitacion;
	
	private int estado;
	private String mensaje;
	
	public int varMiTipoDeCapacitacion=0;
		
	DataModel<MiCapacitacion> listarMDP;
	
	private ArrayList<SelectItem> MiTipoDeCapacitacionArray;
	
	//PARA EL CRUD

	public MiCapacitacionController() {
		if(micapacitacion !=null)
		{
			micapacitacion = new MiCapacitacion();
		}
	}
	
	public void limpiar() {
		micapacitacion = new MiCapacitacion();
		estado = 0;
	}
	
	
	public String grabar() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			if(getEstado()==1)
			{
				mensaje = ejbMiCapacitacionSession.actualizar(micapacitacion);
				context.addMessage(null, new FacesMessage(mensaje.toString()));
			}
			else
			{
				mensaje = ejbMiCapacitacionSession.grabar(micapacitacion);
				context.addMessage(null, new FacesMessage(mensaje.toString()));
			}
		} catch (Exception e) {
			mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR, "error",
					e.toString()).toString();
		}
		return null;
	}
	
	public void buscar(ActionEvent e) throws Exception{
		micapacitacion = new MiCapacitacion();
		micapacitacion.setIdCapacitacion(e.getComponent().getAttributes().get("micapacitacionbuscar").hashCode());
		micapacitacion = ejbMiCapacitacionSession.buscar(micapacitacion);
		
		if(micapacitacion != null)
		{
			micapacitacion.getIdCapacitacion();
			micapacitacion.getFechaInicial();
			micapacitacion.getFechaFinal();
			micapacitacion.getInstitucion();
			micapacitacion.getNumeroDeHoras();
			micapacitacion.getTipoDeEvento();
			micapacitacion.getDatosPersonale().getId();
			micapacitacion.getTipoDeCapacitacionTexto();
			//micapacitacion.getTipoDeCapacitacion().getIdTipoDeCapacitacion();
			setEstado(1);
		}
	}
	
	public void eliminar(ActionEvent e) throws Exception{
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			//Obejto vacio
			micapacitacion = new MiCapacitacion();
			//cargamos id
			micapacitacion.setIdCapacitacion(e.getComponent().getAttributes().get("micapacitacioneliminar").hashCode());
			//eliminar
			mensaje = ejbMiCapacitacionSession.eliminar(micapacitacion);
			context.addMessage(null, new FacesMessage(mensaje.toString()));
		} catch (Exception e2) {
			mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR,"error",e2.toString()).toString();
			context.addMessage(null, new FacesMessage(mensaje.toString()));
		}
	}
	
	//----GETS AND SETTERS
	
	public MiCapacitacion getMicapacitacion() {
		return micapacitacion;
	}
	public void setMicapacitacion(MiCapacitacion micapacitacion) {
		this.micapacitacion = micapacitacion;
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

	public int getVarMiTipoDeCapacitacion() {
		return varMiTipoDeCapacitacion;
	}

	public void setVarMiTipoDeCapacitacion(int varMiTipoDeCapacitacion) {
		this.varMiTipoDeCapacitacion = varMiTipoDeCapacitacion;
	}

	public DataModel<MiCapacitacion> getListarMDP() {
		listarMDP = new ListDataModel<MiCapacitacion>(ejbMiCapacitacionSession.listar());
		return listarMDP;
	}

	public void setListarMDP(DataModel<MiCapacitacion> listarMDP) {
		this.listarMDP = listarMDP;
	}

	public ArrayList<SelectItem> getMiTipoDeCapacitacionArray() {
		MiTipoDeCapacitacionArray = new ArrayList<SelectItem>();
		for(MiTipoDeCapacitacion obj: ejbMiTipoDeCapacitacionSession.listar())
		{
			MiTipoDeCapacitacionArray.add(new SelectItem(obj.getIdTipoDeCapacitacion().toString(), obj.getNombre()));
		}
		return MiTipoDeCapacitacionArray;
	}

	public void setMiTipoDeCapacitacionArray(ArrayList<SelectItem> miTipoDeCapacitacionArray) {
		MiTipoDeCapacitacionArray = miTipoDeCapacitacionArray;
	}
}
