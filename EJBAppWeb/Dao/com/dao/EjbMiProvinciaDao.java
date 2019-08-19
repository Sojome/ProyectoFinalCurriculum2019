package com.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.ejb.model.MiProvincia;

@Stateless(name="ejbMiProvinciaDao")
public class EjbMiProvinciaDao implements MiProvinciaDao {
	
	//unir con mi persistencia
	@PersistenceContext(name="persistencia")
	private EntityManager em;
	
	@Override
	public MiProvincia buscar(MiProvincia miprovincia) {
		MiProvincia obj = null;
		try {
			obj = em.find(MiProvincia.class, miprovincia.getIdProvincia());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public String grabar(MiProvincia miprovincia) {
		String msg= "";
		try {
			em.persist(miprovincia);
			msg="Se grabo correctamente";
		} catch (Exception e) {
			//System.out.println("ERROR DAO"+e.getMessage());
			msg="ERROR DAO OBJ NO GUARDADO"+e.getMessage();
		}
		return msg;
	}

	@Override
	public String actualizar(MiProvincia p) {
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
	public String eliminar(MiProvincia p) {
		String msg= "";
		try {
			MiProvincia buscar = em.find(MiProvincia.class, p.getIdProvincia());
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
	public List<MiProvincia> listar(int id) {
		List<MiProvincia> lista = null;
		try {
			Query q = em.createQuery("Select u from MiProvincia u where u.pai.idPais=:id");
					q.setParameter("id", id);
			lista = q.getResultList();
		} catch (Exception e) {
			System.out.println("error ejbdao listar");
			e.printStackTrace();
		}
		return lista;
	}

	@Override
	public MiProvincia buscarporId(int id) {
		//int id = 0;
		MiProvincia p = null;
		try {
			p = (MiProvincia)em.createQuery("Select u from MiProvincia u"
					+ "where u.idProvincia = :id")
					.setParameter("id", id)
					.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return p;
	}

}
