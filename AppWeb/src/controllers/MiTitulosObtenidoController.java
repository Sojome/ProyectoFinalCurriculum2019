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
@ManagedBean(name = "mititulosobtenidoController")
@SessionScoped
public class MiTitulosObtenidoController implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	//
	@EJB
	private MiTitulosObtenidoSession ejbMiTitulosObtenidoSession;
	@EJB
	private MiNivelTituloSession ejbMiNivelTituloSession;
	
	//crear un objeto listar
	public MiTitulosObtenido mititulosobtenido;
	
	//listar datos
	public MiNivelTitulo miniveltitulo;
	
	private int estado;
	private String mensaje;
	
	public String nombreMiNivelTitulo="";
		
	DataModel<MiTitulosObtenido> listarMDP;
	
	private ArrayList<SelectItem> MiNivelTituloArray;
	
	//PARA EL CRUD

	public MiTitulosObtenidoController() {
		if(mititulosobtenido !=null)
		{
			mititulosobtenido = new MiTitulosObtenido();
		}
	}
	
	public void limpiar() {
		mititulosobtenido = new MiTitulosObtenido();
		estado = 0;
	}
	
	
	public String grabar() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			if(getEstado()==1)
			{
				mensaje = ejbMiTitulosObtenidoSession.actualizar(mititulosobtenido);
				context.addMessage(null, new FacesMessage(mensaje.toString()));
			}
			else
			{
				mensaje = ejbMiTitulosObtenidoSession.grabar(mititulosobtenido);
				context.addMessage(null, new FacesMessage(mensaje.toString()));
			}
		} catch (Exception e) {
			mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR, "error",
					e.toString()).toString();
		}
		return null;
	}
	
	public void buscar(ActionEvent e) throws Exception{
		mititulosobtenido = new MiTitulosObtenido();
		mititulosobtenido.setIdTitulosObtenidos(e.getComponent().getAttributes().get("mititulosobtenidobuscar").hashCode());
		mititulosobtenido = ejbMiTitulosObtenidoSession.buscar(mititulosobtenido);
		
		if(mititulosobtenido != null)
		{
			mititulosobtenido.getIdTitulosObtenidos();
			mititulosobtenido.getCiudad();
			//mititulosobtenido.getDatosPersonale().getId();
			mititulosobtenido.getFechaDeGrado();
			//mititulosobtenido.getNivelTitulo().getIdNivelTitulo();
			mititulosobtenido.getNivelTituloTexto();
			mititulosobtenido.getTitulo();
			mititulosobtenido.getUniversidad();
			setEstado(1);
		}
	}
	
	public void eliminar(ActionEvent e) throws Exception{
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			//Obejto vacio
			mititulosobtenido = new MiTitulosObtenido();
			//cargamos id
			mititulosobtenido.setIdTitulosObtenidos(e.getComponent().getAttributes().get("mititulosobtenidoeliminar").hashCode());
			//eliminar
			mensaje = ejbMiTitulosObtenidoSession.eliminar(mititulosobtenido);
			context.addMessage(null, new FacesMessage(mensaje.toString()));
		} catch (Exception e2) {
			mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR,"error",e2.toString()).toString();
			context.addMessage(null, new FacesMessage(mensaje.toString()));
		}
	}
	
	//----GETS AND SETTERS
	
	public MiTitulosObtenido getMititulosobtenido() {
		return mititulosobtenido;
	}
	public void setMititulosobtenido(MiTitulosObtenido mititulosobtenido) {
		this.mititulosobtenido = mititulosobtenido;
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
	public String getNombreMiNivelTitulo() {
		return nombreMiNivelTitulo;
	}

	public void setNombreMiNivelTitulo(String nombreMiNivelTitulo) {
		this.nombreMiNivelTitulo = nombreMiNivelTitulo;
	}

	public DataModel<MiTitulosObtenido> getListarMDP() {
		listarMDP = new ListDataModel<MiTitulosObtenido>(ejbMiTitulosObtenidoSession.listar());
		return listarMDP;
	}

	public void setListarMDP(DataModel<MiTitulosObtenido> listarMDP) {
		this.listarMDP = listarMDP;
	}

	public ArrayList<SelectItem> getMiNivelTituloArray() {
		MiNivelTituloArray = new ArrayList<SelectItem>();
		for(MiNivelTitulo obj: ejbMiNivelTituloSession.listar())
		{
			MiNivelTituloArray.add(new SelectItem(obj.getNombre()));
		}
		return MiNivelTituloArray;
	}

	public void setMiNivelTituloArray(ArrayList<SelectItem> miNivelTituloArray) {
		MiNivelTituloArray = miNivelTituloArray;
	}
}
