package com.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.ejb.model.MiDatosPersonale;

@Stateless(name="ejbMiDatosPersonaleDao")
public class EjbMiDatosPersonaleDao implements MiDatosPersonaleDao {
	
	//unir con mi persistencia
	@PersistenceContext(name="persistencia")
	private EntityManager em;
	
	@Override
	public MiDatosPersonale buscar(MiDatosPersonale midatospersonale) {
		MiDatosPersonale obj = null;
		try {
			obj = em.find(MiDatosPersonale.class, midatospersonale.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public String grabar(MiDatosPersonale midatospersonale) {
		String msg= "";
		try {
			em.persist(midatospersonale);
			msg="Se grabo correctamente";
		} catch (Exception e) {
			//System.out.println("ERROR DAO"+e.getMessage());
			msg="ERROR DAO OBJ NO GUARDADO"+e.getMessage();
		}
		return msg;
	}

	@Override
	public String actualizar(MiDatosPersonale c) {
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
	public String eliminar(MiDatosPersonale c) {
		String msg= "";
		try {
			MiDatosPersonale buscar = em.find(MiDatosPersonale.class, c.getId());
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
	public List<MiDatosPersonale> listar() {
		List<MiDatosPersonale> lista = null;
		try {
			Query q = em.createQuery("Select u from MiDatosPersonale u");
			lista = q.getResultList();
		} catch (Exception e) {
			System.out.println("error ejbdao listar");
			e.printStackTrace();
		}
		return lista;
	}

	@Override
	public MiDatosPersonale buscarporId(int id) {
		//int id = 0;
		MiDatosPersonale p = null;
		try {
			p = (MiDatosPersonale)em.createQuery("Select u from MiDatosPersonale u where u.id=:id")
					.setParameter("id", id)
					.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return p;
	}

}
