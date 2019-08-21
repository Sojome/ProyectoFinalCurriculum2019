package com.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.ejb.model.MiCapacitacion;

@Stateless(name="ejbMiCapacitacionDao")
public class EjbMiCapacitacionDao implements MiCapacitacionDao {
	
	//unir con mi persistencia
	@PersistenceContext(name="persistencia")
	private EntityManager em;
	
	@Override
	public MiCapacitacion buscar(MiCapacitacion micapacitacion) {
		MiCapacitacion obj = null;
		try {
			obj = em.find(MiCapacitacion.class, micapacitacion.getIdCapacitacion());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public String grabar(MiCapacitacion micapacitacion) {
		String msg= "";
		try {
			em.persist(micapacitacion);
			msg="Se grabo correctamente";
		} catch (Exception e) {
			//System.out.println("ERROR DAO"+e.getMessage());
			msg="ERROR DAO OBJ NO GUARDADO"+e.getMessage();
		}
		return msg;
	}

	@Override
	public String actualizar(MiCapacitacion c) {
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
	public String eliminar(MiCapacitacion c) {
		String msg= "";
		try {
			MiCapacitacion buscar = em.find(MiCapacitacion.class, c.getIdCapacitacion());
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
	public List<MiCapacitacion> listar() {
		List<MiCapacitacion> lista = null;
		try {
			Query q = em.createQuery("Select u from MiCapacitacion u");
			lista = q.getResultList();
		} catch (Exception e) {
			System.out.println("error ejbdao listar");
			e.printStackTrace();
		}
		return lista;
	}

	@Override
	public MiCapacitacion buscarporId(int id) {
		//int id = 0;
		MiCapacitacion p = null;
		try {
			p = (MiCapacitacion)em.createQuery("Select u from MiCapacitacion u"
					+ "where u.user_id = :id")
					.setParameter("id", id)
					.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return p;
	}

}
