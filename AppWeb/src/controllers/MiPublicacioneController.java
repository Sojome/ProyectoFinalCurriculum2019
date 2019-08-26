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
@ManagedBean(name = "mipublicacioneController")
@SessionScoped
public class MiPublicacioneController implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	//
	@EJB
	private MiPublicacioneSession ejbMiPublicacioneSession;
	@EJB
	private MiTipoDePublicacioneSession ejbMiTipoDePublicacioneSession;
	
	//crear un objeto listar
	public MiPublicacione mipublicacione;
	
	//listar datos
	public MiTipoDePublicacione mitipodepublicacione;
	
	private int estado;
	private String mensaje;
	
	public int varMiTipoDePublicacione=0;
	public String nombreMiTipoDePublicacione="";
		
	DataModel<MiPublicacione> listarMDP;
	
	private ArrayList<SelectItem> MiTipoDePublicacioneArray;
	
	//PARA EL CRUD

	public MiPublicacioneController() {
		if(mipublicacione !=null)
		{
			mipublicacione = new MiPublicacione();
		}
	}
	
	public void limpiar() {
		mipublicacione = new MiPublicacione();
		estado = 0;
	}
	
	
	public String grabar() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			if(getEstado()==1)
			{
				mensaje = ejbMiPublicacioneSession.actualizar(mipublicacione);
				context.addMessage(null, new FacesMessage(mensaje.toString()));
			}
			else
			{
				mensaje = ejbMiPublicacioneSession.grabar(mipublicacione);
				context.addMessage(null, new FacesMessage(mensaje.toString()));
			}
		} catch (Exception e) {
			mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR, "error",
					e.toString()).toString();
		}
		return null;
	}
	
	public void buscar(ActionEvent e) throws Exception{
		mipublicacione = new MiPublicacione();
		mipublicacione.setIdPublicaciones(e.getComponent().getAttributes().get("mipublicacionebuscar").hashCode());
		mipublicacione = ejbMiPublicacioneSession.buscar(mipublicacione);
		
		if(mipublicacione != null)
		{
			mipublicacione.getIdPublicaciones();
			setEstado(1);
		}
	}
	
	public void eliminar(ActionEvent e) throws Exception{
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			//Obejto vacio
			mipublicacione = new MiPublicacione();
			//cargamos id
			mipublicacione.setIdPublicaciones(e.getComponent().getAttributes().get("mipublicacioneeliminar").hashCode());
			//eliminar
			mensaje = ejbMiPublicacioneSession.eliminar(mipublicacione);
			context.addMessage(null, new FacesMessage(mensaje.toString()));
		} catch (Exception e2) {
			mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR,"error",e2.toString()).toString();
			context.addMessage(null, new FacesMessage(mensaje.toString()));
		}
	}
	
	//----GETS AND SETTERS
	
	public MiPublicacione getMipublicacione() {
		return mipublicacione;
	}
	public void setMipublicacione(MiPublicacione mipublicacione) {
		this.mipublicacione = mipublicacione;
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

	public String getNombreMiTipoDePublicacione() {
		return nombreMiTipoDePublicacione;
	}

	public void setNombreMiTipoDePublicacione(String nombreMiTipoDePublicacione) {
		this.nombreMiTipoDePublicacione = nombreMiTipoDePublicacione;
	}

	public int getVarMiTipoDePublicacione() {
		return varMiTipoDePublicacione;
	}

	public void setVarMiTipoDePublicacione(int varMiTipoDePublicacione) {
		this.varMiTipoDePublicacione = varMiTipoDePublicacione;
	}

	public DataModel<MiPublicacione> getListarMDP() {
		listarMDP = new ListDataModel<MiPublicacione>(ejbMiPublicacioneSession.listar());
		return listarMDP;
	}

	public void setListarMDP(DataModel<MiPublicacione> listarMDP) {
		this.listarMDP = listarMDP;
	}

	public ArrayList<SelectItem> getMiTipoDePublicacioneArray() {
		MiTipoDePublicacioneArray = new ArrayList<SelectItem>();
		for(MiTipoDePublicacione obj: ejbMiTipoDePublicacioneSession.listar())
		{
			MiTipoDePublicacioneArray.add(new SelectItem(obj.getNombre()));
		}
		return MiTipoDePublicacioneArray;
	}

	public void setMiTipoDePublicacioneArray(ArrayList<SelectItem> miMiTipoDePublicacioneArray) {
		MiTipoDePublicacioneArray = miMiTipoDePublicacioneArray;
	}
}
