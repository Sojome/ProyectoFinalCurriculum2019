package com.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.ejb.model.MiTipoDeCapacitacion;

@Stateless(name="ejbMiTipoDeCapacitacionDao")
public class EjbMiTipoDeCapacitacionDao implements MiTipoDeCapacitacionDao {
	
	//unir con mi persistencia
	@PersistenceContext(name="persistencia")
	private EntityManager em;
	
	@Override
	public MiTipoDeCapacitacion buscar(MiTipoDeCapacitacion mitipodecapacitacion) {
		MiTipoDeCapacitacion obj = null;
		try {
			obj = em.find(MiTipoDeCapacitacion.class, mitipodecapacitacion.getIdTipoDeCapacitacion());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public String grabar(MiTipoDeCapacitacion mitipodecapacitacion) {
		String msg= "";
		try {
			em.persist(mitipodecapacitacion);
			msg="Se grabo correctamente";
		} catch (Exception e) {
			//System.out.println("ERROR DAO"+e.getMessage());
			msg="ERROR DAO OBJ NO GUARDADO"+e.getMessage();
		}
		return msg;
	}

	@Override
	public String actualizar(MiTipoDeCapacitacion c) {
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
	public String eliminar(MiTipoDeCapacitacion c) {
		String msg= "";
		try {
			MiTipoDeCapacitacion buscar = em.find(MiTipoDeCapacitacion.class, c.getIdTipoDeCapacitacion());
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
	public List<MiTipoDeCapacitacion> listar() {
		List<MiTipoDeCapacitacion> lista = null;
		try {
			Query q = em.createQuery("Select u from MiTipoDeCapacitacion u");
			lista = q.getResultList();
		} catch (Exception e) {
			System.out.println("error ejbdao listar");
			e.printStackTrace();
		}
		return lista;
	}

	@Override
	public MiTipoDeCapacitacion buscarporId(int id) {
		//int id = 0;
		MiTipoDeCapacitacion p = null;
		try {
			p = (MiTipoDeCapacitacion)em.createQuery("Select u from MiTipoDeCapacitacion u"
					+ "where u.user_id = :id")
					.setParameter("id", id)
					.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return p;
	}

}
