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
@ManagedBean(name = "mireferenciaslaboraleController")
@SessionScoped
public class MiReferenciasLaboraleController implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	//
	@EJB
	private MiReferenciasLaboraleSession ejbMiReferenciasLaboraleSession;
	
	//crear un objeto listar
	public MiReferenciasLaborale mireferenciaslaborale;
		
	private int estado;
	private String mensaje;
		
	DataModel<MiReferenciasLaborale> listarMDP;
	
	//PARA EL CRUD

	public MiReferenciasLaboraleController() {
		if(mireferenciaslaborale !=null)
		{
			mireferenciaslaborale = new MiReferenciasLaborale();
		}
	}
	
	public void limpiar() {
		mireferenciaslaborale = new MiReferenciasLaborale();
		estado = 0;
	}
	
	
	public String grabar() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			if(getEstado()==1)
			{
				mensaje = ejbMiReferenciasLaboraleSession.actualizar(mireferenciaslaborale);
				context.addMessage(null, new FacesMessage(mensaje.toString()));
			}
			else
			{
				mensaje = ejbMiReferenciasLaboraleSession.grabar(mireferenciaslaborale);
				context.addMessage(null, new FacesMessage(mensaje.toString()));
			}
		} catch (Exception e) {
			mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR, "error",
					e.toString()).toString();
		}
		return null;
	}
	
	public void buscar(ActionEvent e) throws Exception{
		mireferenciaslaborale = new MiReferenciasLaborale();
		mireferenciaslaborale.setIdReferenciasLaborales(e.getComponent().getAttributes().get("mireferenciaslaboralebuscar").hashCode());
		mireferenciaslaborale = ejbMiReferenciasLaboraleSession.buscar(mireferenciaslaborale);
		
		if(mireferenciaslaborale != null)
		{
			mireferenciaslaborale.getIdReferenciasLaborales();
			//mireferenciaslaborale.getDatosPersonale().getId();
			mireferenciaslaborale.getInstitucion();
			mireferenciaslaborale.getJefeInmediato();
			mireferenciaslaborale.getTelefono();
			setEstado(1);
		}
	}
	
	public void eliminar(ActionEvent e) throws Exception{
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			//Obejto vacio
			mireferenciaslaborale = new MiReferenciasLaborale();
			//cargamos id
			mireferenciaslaborale.setIdReferenciasLaborales(e.getComponent().getAttributes().get("mireferenciaslaboraleeliminar").hashCode());
			//eliminar
			mensaje = ejbMiReferenciasLaboraleSession.eliminar(mireferenciaslaborale);
			context.addMessage(null, new FacesMessage(mensaje.toString()));
		} catch (Exception e2) {
			mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR,"error",e2.toString()).toString();
			context.addMessage(null, new FacesMessage(mensaje.toString()));
		}
	}
	
	//----GETS AND SETTERS
	
	public MiReferenciasLaborale getMireferenciaslaborale() {
		return mireferenciaslaborale;
	}
	public void setMireferenciaslaborale(MiReferenciasLaborale mireferenciaslaborale) {
		this.mireferenciaslaborale = mireferenciaslaborale;
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

	public DataModel<MiReferenciasLaborale> getListarMDP() {
		listarMDP = new ListDataModel<MiReferenciasLaborale>(ejbMiReferenciasLaboraleSession.listar());
		return listarMDP;
	}

	public void setListarMDP(DataModel<MiReferenciasLaborale> listarMDP) {
		this.listarMDP = listarMDP;
	}
}
