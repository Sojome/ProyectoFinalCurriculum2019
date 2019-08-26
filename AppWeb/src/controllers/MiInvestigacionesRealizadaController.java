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
@ManagedBean(name = "miinvestigacionesrealizadaController")
@SessionScoped
public class MiInvestigacionesRealizadaController implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	//
	@EJB
	private MiInvestigacionesRealizadaSession ejbMiInvestigacionesRealizadaSession;
	
	//crear un objeto listar
	public MiInvestigacionesRealizada miinvestigacionesrealizada;
		
	private int estado;
	private String mensaje;
		
	DataModel<MiInvestigacionesRealizada> listarMDP;
	
	//PARA EL CRUD

	public MiInvestigacionesRealizadaController() {
		if(miinvestigacionesrealizada !=null)
		{
			miinvestigacionesrealizada = new MiInvestigacionesRealizada();
		}
	}
	
	public void limpiar() {
		miinvestigacionesrealizada = new MiInvestigacionesRealizada();
		estado = 0;
	}
	
	
	public String grabar() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			if(getEstado()==1)
			{
				mensaje = ejbMiInvestigacionesRealizadaSession.actualizar(miinvestigacionesrealizada);
				context.addMessage(null, new FacesMessage(mensaje.toString()));
			}
			else
			{
				mensaje = ejbMiInvestigacionesRealizadaSession.grabar(miinvestigacionesrealizada);
				context.addMessage(null, new FacesMessage(mensaje.toString()));
			}
		} catch (Exception e) {
			mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR, "error",
					e.toString()).toString();
		}
		return null;
	}
	
	public void buscar(ActionEvent e) throws Exception{
		miinvestigacionesrealizada = new MiInvestigacionesRealizada();
		miinvestigacionesrealizada.setIdInvestigacionesRealizadas(e.getComponent().getAttributes().get("miinvestigacionesrealizadabuscar").hashCode());
		miinvestigacionesrealizada = ejbMiInvestigacionesRealizadaSession.buscar(miinvestigacionesrealizada);
		
		if(miinvestigacionesrealizada != null)
		{
			miinvestigacionesrealizada.getIdInvestigacionesRealizadas();
			miinvestigacionesrealizada.getInstitucion();
			miinvestigacionesrealizada.getTitulo();
			miinvestigacionesrealizada.getAnio();
			setEstado(1);
		}
	}
	
	public void eliminar(ActionEvent e) throws Exception{
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			//Obejto vacio
			miinvestigacionesrealizada = new MiInvestigacionesRealizada();
			//cargamos id
			miinvestigacionesrealizada.setIdInvestigacionesRealizadas(e.getComponent().getAttributes().get("miinvestigacionesrealizadaeliminar").hashCode());
			//eliminar
			mensaje = ejbMiInvestigacionesRealizadaSession.eliminar(miinvestigacionesrealizada);
			context.addMessage(null, new FacesMessage(mensaje.toString()));
		} catch (Exception e2) {
			mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR,"error",e2.toString()).toString();
			context.addMessage(null, new FacesMessage(mensaje.toString()));
		}
	}
	
	//----GETS AND SETTERS
	
	public MiInvestigacionesRealizada getMiinvestigacionesrealizada() {
		return miinvestigacionesrealizada;
	}
	public void setMiinvestigacionesrealizada(MiInvestigacionesRealizada miinvestigacionesrealizada) {
		this.miinvestigacionesrealizada = miinvestigacionesrealizada;
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

	public DataModel<MiInvestigacionesRealizada> getListarMDP() {
		listarMDP = new ListDataModel<MiInvestigacionesRealizada>(ejbMiInvestigacionesRealizadaSession.listar());
		return listarMDP;
	}

	public void setListarMDP(DataModel<MiInvestigacionesRealizada> listarMDP) {
		this.listarMDP = listarMDP;
	}
}
