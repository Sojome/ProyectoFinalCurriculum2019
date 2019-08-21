package com.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.ejb.model.MiReferenciasLaborale;

@Stateless(name="ejbMiReferenciasLaboraleDao")
public class EjbMiReferenciasLaboraleDao implements MiReferenciasLaboraleDao {
	
	//unir con mi persistencia
	@PersistenceContext(name="persistencia")
	private EntityManager em;
	
	@Override
	public MiReferenciasLaborale buscar(MiReferenciasLaborale mireferenciaslaborale) {
		MiReferenciasLaborale obj = null;
		try {
			obj = em.find(MiReferenciasLaborale.class, mireferenciaslaborale.getIdReferenciasLaborales());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public String grabar(MiReferenciasLaborale mireferenciaslaborale) {
		String msg= "";
		try {
			em.persist(mireferenciaslaborale);
			msg="Se grabo correctamente";
		} catch (Exception e) {
			//System.out.println("ERROR DAO"+e.getMessage());
			msg="ERROR DAO OBJ NO GUARDADO"+e.getMessage();
		}
		return msg;
	}

	@Override
	public String actualizar(MiReferenciasLaborale c) {
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
	public String eliminar(MiReferenciasLaborale c) {
		String msg= "";
		try {
			MiReferenciasLaborale buscar = em.find(MiReferenciasLaborale.class, c.getIdReferenciasLaborales());
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
	public List<MiReferenciasLaborale> listar() {
		List<MiReferenciasLaborale> lista = null;
		try {
			Query q = em.createQuery("Select u from MiReferenciasLaborale u");
			lista = q.getResultList();
		} catch (Exception e) {
			System.out.println("error ejbdao listar");
			e.printStackTrace();
		}
		return lista;
	}

	@Override
	public MiReferenciasLaborale buscarporId(int id) {
		//int id = 0;
		MiReferenciasLaborale p = null;
		try {
			p = (MiReferenciasLaborale)em.createQuery("Select u from MiReferenciasLaborale u"
					+ "where u.user_id = :id")
					.setParameter("id", id)
					.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return p;
	}

}
