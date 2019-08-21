package com.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.ejb.model.MiPublicacione;

@Stateless(name="ejbMiPublicacioneDao")
public class EjbMiPublicacioneDao implements MiPublicacioneDao {
	
	//unir con mi persistencia
	@PersistenceContext(name="persistencia")
	private EntityManager em;
	
	@Override
	public MiPublicacione buscar(MiPublicacione mipublicacione) {
		MiPublicacione obj = null;
		try {
			obj = em.find(MiPublicacione.class, mipublicacione.getIdPublicaciones());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public String grabar(MiPublicacione mipublicacione) {
		String msg= "";
		try {
			em.persist(mipublicacione);
			msg="Se grabo correctamente";
		} catch (Exception e) {
			//System.out.println("ERROR DAO"+e.getMessage());
			msg="ERROR DAO OBJ NO GUARDADO"+e.getMessage();
		}
		return msg;
	}

	@Override
	public String actualizar(MiPublicacione c) {
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
	public String eliminar(MiPublicacione c) {
		String msg= "";
		try {
			MiPublicacione buscar = em.find(MiPublicacione.class, c.getIdPublicaciones());
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
	public List<MiPublicacione> listar() {
		List<MiPublicacione> lista = null;
		try {
			Query q = em.createQuery("Select u from MiPublicacione u");
			lista = q.getResultList();
		} catch (Exception e) {
			System.out.println("error ejbdao listar");
			e.printStackTrace();
		}
		return lista;
	}

	@Override
	public MiPublicacione buscarporId(int id) {
		//int id = 0;
		MiPublicacione p = null;
		try {
			p = (MiPublicacione)em.createQuery("Select u from MiPublicacione u"
					+ "where u.user_id = :id")
					.setParameter("id", id)
					.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return p;
	}

}
