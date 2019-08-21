package com.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.ejb.model.MiEstadoCivil;

@Stateless(name="ejbMiEstadoCivilDao")
public class EjbMiEstadoCivilDao implements MiEstadoCivilDao {
	
	//unir con mi persistencia
	@PersistenceContext(name="persistencia")
	private EntityManager em;
	
	@Override
	public MiEstadoCivil buscar(MiEstadoCivil miestadocivil) {
		MiEstadoCivil obj = null;
		try {
			obj = em.find(MiEstadoCivil.class, miestadocivil.getIdEstadoCivil());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public String grabar(MiEstadoCivil miestadocivil) {
		String msg= "";
		try {
			em.persist(miestadocivil);
			msg="Se grabo correctamente";
		} catch (Exception e) {
			//System.out.println("ERROR DAO"+e.getMessage());
			msg="ERROR DAO OBJ NO GUARDADO"+e.getMessage();
		}
		return msg;
	}

	@Override
	public String actualizar(MiEstadoCivil c) {
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
	public String eliminar(MiEstadoCivil c) {
		String msg= "";
		try {
			MiEstadoCivil buscar = em.find(MiEstadoCivil.class, c.getIdEstadoCivil());
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
	public List<MiEstadoCivil> listar() {
		List<MiEstadoCivil> lista = null;
		try {
			Query q = em.createQuery("Select u from MiEstadoCivil u");
			lista = q.getResultList();
		} catch (Exception e) {
			System.out.println("error ejbdao listar");
			e.printStackTrace();
		}
		return lista;
	}

	@Override
	public MiEstadoCivil buscarporId(int id) {
		//int id = 0;
		MiEstadoCivil p = null;
		try {
			p = (MiEstadoCivil)em.createQuery("Select u from MiEstadoCivil u"
					+ "where u.user_id = :id")
					.setParameter("id", id)
					.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return p;
	}

}
