package com.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.ejb.model.Parroquia;

@Stateless(name="ejbParroquiaDao")
public class EjbParroquiaDao implements ParroquiaDao {
	
	//unir con mi persistencia
	@PersistenceContext(name="persistencia")
	private EntityManager em;
	
	@Override
	public Parroquia buscar(Parroquia parroquia) {
		Parroquia obj = null;
		try {
			obj = em.find(Parroquia.class, parroquia.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public String grabar(Parroquia parroquia) {
		String msg= "";
		try {
			em.persist(parroquia);
			msg="Se grabo correctamente";
		} catch (Exception e) {
			//System.out.println("ERROR DAO"+e.getMessage());
			msg="ERROR DAO OBJ NO GUARDADO"+e.getMessage();
		}
		return msg;
	}

	@Override
	public String actualizar(Parroquia p) {
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
	public String eliminar(Parroquia p) {
		String msg= "";
		try {
			Parroquia buscar = em.find(Parroquia.class, p.getId());
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
	public List<Parroquia> listar(int id) {
		List<Parroquia> lista = null;
		try {
			Query q = em.createQuery("Select u from Parroquia u where u.thCanton.id=:id");
			q.setParameter("id", id);
			lista = q.getResultList();
		} catch (Exception e) {
			System.out.println("error ejbdao listar");
			e.printStackTrace();
		}
		return lista;
	}

	@Override
	public Parroquia buscarporId(int id) {
		//int id = 0;
		Parroquia p = null;
		try {
			p = (Parroquia)em.createQuery("Select u from Parroquia u"
					+ "where u.user_id = :id")
					.setParameter("id", id)
					.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return p;
	}

}
