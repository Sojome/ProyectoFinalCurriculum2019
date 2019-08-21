package com.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.ejb.model.MiInvestigacionesRealizada;

@Stateless(name="ejbMiInvestigacionesRealizadaDao")
public class EjbMiInvestigacionesRealizadaDao implements MiInvestigacionesRealizadaDao {
	
	//unir con mi persistencia
	@PersistenceContext(name="persistencia")
	private EntityManager em;
	
	@Override
	public MiInvestigacionesRealizada buscar(MiInvestigacionesRealizada miinvestigacionesrealizada) {
		MiInvestigacionesRealizada obj = null;
		try {
			obj = em.find(MiInvestigacionesRealizada.class, miinvestigacionesrealizada.getIdInvestigacionesRealizadas());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public String grabar(MiInvestigacionesRealizada miinvestigacionesrealizada) {
		String msg= "";
		try {
			em.persist(miinvestigacionesrealizada);
			msg="Se grabo correctamente";
		} catch (Exception e) {
			//System.out.println("ERROR DAO"+e.getMessage());
			msg="ERROR DAO OBJ NO GUARDADO"+e.getMessage();
		}
		return msg;
	}

	@Override
	public String actualizar(MiInvestigacionesRealizada c) {
		String msg= "";
		try {
			em.merge(c);
			msg="Se actualizo correctamente";
		} catch (Exception e) {
			//System.out.println("ERROR DAO"+e.getMessage());
			msg="ERROR DAO OBJ NO GUARDADO"+e.getMessage();
		}
		return msg;
	}

	@Override
	public String eliminar(MiInvestigacionesRealizada c) {
		String msg= "";
		try {
			MiInvestigacionesRealizada buscar = em.find(MiInvestigacionesRealizada.class, c.getIdInvestigacionesRealizadas());
			em.remove(buscar);
			em.flush();//realiza de manera forzada el comando anterior
			msg="Se elimino correctamente";
		} catch (Exception e) {
			//System.out.println("ERROR DAO"+e.getMessage());
			msg="ERROR DAO ELIMINAR"+e.getMessage();
		}
		return msg;
	}

	@Override
	public List<MiInvestigacionesRealizada> listar() {
		List<MiInvestigacionesRealizada> lista = null;
		try {
			Query q = em.createQuery("Select u from MiInvestigacionesRealizada u");
			lista = q.getResultList();
		} catch (Exception e) {
			System.out.println("error ejbdao listar");
			e.printStackTrace();
		}
		return lista;
	}

	@Override
	public MiInvestigacionesRealizada buscarporId(int id) {
		//int id = 0;
		MiInvestigacionesRealizada p = null;
		try {
			p = (MiInvestigacionesRealizada)em.createQuery("Select u from MiInvestigacionesRealizada u"
					+ "where u.user_id = :id")
					.setParameter("id", id)
					.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return p;
	}

}
