package com.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.ejb.model.Provincia;

@Stateless(name="ejbProvinciaDao")
public class EjbProvinciaDao implements ProvinciaDao {
	
	//unir con mi persistencia
	@PersistenceContext(name="persistencia")
	private EntityManager em;
	
	@Override
	public Provincia buscar(Provincia provincia) {
		Provincia obj = null;
		try {
			obj = em.find(Provincia.class, provincia.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public String grabar(Provincia provincia) {
		String msg= "";
		try {
			em.persist(provincia);
			msg="Se grabo correctamente";
		} catch (Exception e) {
			//System.out.println("ERROR DAO"+e.getMessage());
			msg="ERROR DAO OBJ NO GUARDADO"+e.getMessage();
		}
		return msg;
	}

	@Override
	public String actualizar(Provincia p) {
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
	public String eliminar(Provincia p) {
		String msg= "";
		try {
			Provincia buscar = em.find(Provincia.class, p.getId());
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
	public List<Provincia> listar(int id) {
		List<Provincia> lista = null;
		try {
			Query q = em.createQuery("Select u from Provincia u where u.thPai.id=:id");
					q.setParameter("id", id);
			lista = q.getResultList();
		} catch (Exception e) {
			System.out.println("error ejbdao listar");
			e.printStackTrace();
		}
		return lista;
	}

	@Override
	public Provincia buscarporId(int id) {
		//int id = 0;
		Provincia p = null;
		try {
			p = (Provincia)em.createQuery("Select u from Provincia u"
					+ "where u.user_id = :id")
					.setParameter("id", id)
					.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return p;
	}

}
