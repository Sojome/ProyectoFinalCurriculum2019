package com.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.ejb.model.MiExperienciaLaboral;

@Stateless(name="ejbMiExperienciaLaboralDao")
public class EjbMiExperienciaLaboralDao implements MiExperienciaLaboralDao {
	
	//unir con mi persistencia
	@PersistenceContext(name="persistencia")
	private EntityManager em;
	
	@Override
	public MiExperienciaLaboral buscar(MiExperienciaLaboral miexperiencialaboral) {
		MiExperienciaLaboral obj = null;
		try {
			obj = em.find(MiExperienciaLaboral.class, miexperiencialaboral.getIdExperienciaLaboral());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public String grabar(MiExperienciaLaboral miexperiencialaboral) {
		String msg= "";
		try {
			em.persist(miexperiencialaboral);
			msg="Se grabo correctamente";
		} catch (Exception e) {
			//System.out.println("ERROR DAO"+e.getMessage());
			msg="ERROR DAO OBJ NO GUARDADO"+e.getMessage();
		}
		return msg;
	}

	@Override
	public String actualizar(MiExperienciaLaboral c) {
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
	public String eliminar(MiExperienciaLaboral c) {
		String msg= "";
		try {
			MiExperienciaLaboral buscar = em.find(MiExperienciaLaboral.class, c.getIdExperienciaLaboral());
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
	public List<MiExperienciaLaboral> listar() {
		List<MiExperienciaLaboral> lista = null;
		try {
			Query q = em.createQuery("Select u from MiExperienciaLaboral u");
			lista = q.getResultList();
		} catch (Exception e) {
			System.out.println("error ejbdao listar");
			e.printStackTrace();
		}
		return lista;
	}

	@Override
	public MiExperienciaLaboral buscarporId(int id) {
		//int id = 0;
		MiExperienciaLaboral p = null;
		try {
			p = (MiExperienciaLaboral)em.createQuery("Select u from MiExperienciaLaboral u"
					+ "where u.user_id = :id")
					.setParameter("id", id)
					.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return p;
	}

}
