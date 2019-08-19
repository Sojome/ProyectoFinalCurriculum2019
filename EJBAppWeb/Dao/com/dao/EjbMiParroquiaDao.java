package com.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.ejb.model.MiParroquia;

@Stateless(name="ejbMiParroquiaDao")
public class EjbMiParroquiaDao implements MiParroquiaDao {
	
	//unir con mi persistencia
	@PersistenceContext(name="persistencia")
	private EntityManager em;
	
	@Override
	public MiParroquia buscar(MiParroquia miparroquia) {
		MiParroquia obj = null;
		try {
			obj = em.find(MiParroquia.class, miparroquia.getIdParroquia());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public String grabar(MiParroquia miparroquia) {
		String msg= "";
		try {
			em.persist(miparroquia);
			msg="Se grabo correctamente";
		} catch (Exception e) {
			//System.out.println("ERROR DAO"+e.getMessage());
			msg="ERROR DAO OBJ NO GUARDADO"+e.getMessage();
		}
		return msg;
	}

	@Override
	public String actualizar(MiParroquia p) {
		String msg= "";
		try {
			em.merge(p);
			msg="Se actualizo correctamente";
		} catch (Exception e) {
			//System.out.println("ERROR DAO"+e.getMessage());
			msg="ERROR DAO OBJ NO GUARDADO"+e.getMessage();
		}
		return msg;
	}

	@Override
	public String eliminar(MiParroquia p) {
		String msg= "";
		try {
			MiParroquia buscar = em.find(MiParroquia.class, p.getIdParroquia());
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
	public List<MiParroquia> listar(int id) {
		List<MiParroquia> lista = null;
		try {
			Query q = em.createQuery("Select u from MiParroquia u where u.canton.idCanton=:id");
			q.setParameter("id", id);
			lista = q.getResultList();
		} catch (Exception e) {
			System.out.println("error ejbdao listar");
			e.printStackTrace();
		}
		return lista;
	}

	@Override
	public MiParroquia buscarporId(int id) {
		//int id = 0;
		MiParroquia p = null;
		try {
			p = (MiParroquia)em.createQuery("Select u from MiParroquia u"
					+ "where u.idParroquia = :id")
					.setParameter("id", id)
					.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return p;
	}

}
