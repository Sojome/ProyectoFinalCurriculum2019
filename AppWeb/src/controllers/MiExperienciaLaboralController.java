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
@ManagedBean(name = "miexperiencialaboralController")
@SessionScoped
public class MiExperienciaLaboralController implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	//
	@EJB
	private MiExperienciaLaboralSession ejbMiExperienciaLaboralSession;
	@EJB
	private MiTipoDeExperienciaSession ejbMiTipoDeExperienciaSession;
	
	//crear un objeto listar
	public MiExperienciaLaboral miexperiencialaboral;
	
	//listar datos
	public MiTipoDeExperiencia mitipodeexperiencia;
	
	private int estado;
	private String mensaje;
	
	public int varMiTipoDeExperiencia=0;
		
	DataModel<MiExperienciaLaboral> listarMDP;
	
	private ArrayList<SelectItem> MiTipoDeExperienciaArray;
	
	//PARA EL CRUD

	public MiExperienciaLaboralController() {
		if(miexperiencialaboral !=null)
		{
			miexperiencialaboral = new MiExperienciaLaboral();
		}
	}
	
	public void limpiar() {
		miexperiencialaboral = new MiExperienciaLaboral();
		estado = 0;
	}
	
	
	public String grabar() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			if(getEstado()==1)
			{
				mensaje = ejbMiExperienciaLaboralSession.actualizar(miexperiencialaboral);
				context.addMessage(null, new FacesMessage(mensaje.toString()));
			}
			else
			{
				mensaje = ejbMiExperienciaLaboralSession.grabar(miexperiencialaboral);
				context.addMessage(null, new FacesMessage(mensaje.toString()));
			}
		} catch (Exception e) {
			mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR, "error",
					e.toString()).toString();
		}
		return null;
	}
	
	public void buscar(ActionEvent e) throws Exception{
		miexperiencialaboral = new MiExperienciaLaboral();
		miexperiencialaboral.setIdExperienciaLaboral(e.getComponent().getAttributes().get("miexperiencialaboralbuscar").hashCode());
		miexperiencialaboral = ejbMiExperienciaLaboralSession.buscar(miexperiencialaboral);
		
		if(miexperiencialaboral != null)
		{
			miexperiencialaboral.getIdExperienciaLaboral();
			miexperiencialaboral.getCatedraa();
			//miexperiencialaboral.getDatosPersonale().getId();
			miexperiencialaboral.getDesde();
			miexperiencialaboral.getFuncion();
			miexperiencialaboral.getHasta();
			miexperiencialaboral.getInstitucion();
			//miexperiencialaboral.getTipoDeExperiencia().getIdTipoDeExperiencia();
			miexperiencialaboral.getTipoDeExperienciaTexto();
			setEstado(1);
		}
	}
	
	public void eliminar(ActionEvent e) throws Exception{
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			//Obejto vacio
			miexperiencialaboral = new MiExperienciaLaboral();
			//cargamos id
			miexperiencialaboral.setIdExperienciaLaboral(e.getComponent().getAttributes().get("miexperiencialaboraleliminar").hashCode());
			//eliminar
			mensaje = ejbMiExperienciaLaboralSession.eliminar(miexperiencialaboral);
			context.addMessage(null, new FacesMessage(mensaje.toString()));
		} catch (Exception e2) {
			mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR,"error",e2.toString()).toString();
			context.addMessage(null, new FacesMessage(mensaje.toString()));
		}
	}
	
	//----GETS AND SETTERS
	
	public MiExperienciaLaboral getMiexperiencialaboral() {
		return miexperiencialaboral;
	}
	public void setMiexperiencialaboral(MiExperienciaLaboral miexperiencialaboral) {
		this.miexperiencialaboral = miexperiencialaboral;
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

	public int getVarMiTipoDeExperiencia() {
		return varMiTipoDeExperiencia;
	}

	public void setVarMiTipoDeExperiencia(int varMiTipoDeExperiencia) {
		this.varMiTipoDeExperiencia = varMiTipoDeExperiencia;
	}

	public DataModel<MiExperienciaLaboral> getListarMDP() {
		listarMDP = new ListDataModel<MiExperienciaLaboral>(ejbMiExperienciaLaboralSession.listar());
		return listarMDP;
	}

	public void setListarMDP(DataModel<MiExperienciaLaboral> listarMDP) {
		this.listarMDP = listarMDP;
	}

	public ArrayList<SelectItem> getMiTipoDeExperienciaArray() {
		MiTipoDeExperienciaArray = new ArrayList<SelectItem>();
		for(MiTipoDeExperiencia obj: ejbMiTipoDeExperienciaSession.listar())
		{
			MiTipoDeExperienciaArray.add(new SelectItem(obj.getIdTipoDeExperiencia().toString(), obj.getNombre()));
		}
		return MiTipoDeExperienciaArray;
	}

	public void setMiTipoDeExperienciaArray(ArrayList<SelectItem> miTipoDeExperienciaArray) {
		MiTipoDeExperienciaArray = miTipoDeExperienciaArray;
	}
}
