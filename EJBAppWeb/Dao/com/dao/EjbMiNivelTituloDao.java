package com.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.ejb.model.MiNivelTitulo;

@Stateless(name="ejbMiNivelTituloDao")
public class EjbMiNivelTituloDao implements MiNivelTituloDao {
	
	//unir con mi persistencia
	@PersistenceContext(name="persistencia")
	private EntityManager em;
	
	@Override
	public MiNivelTitulo buscar(MiNivelTitulo miniveltitulo) {
		MiNivelTitulo obj = null;
		try {
			obj = em.find(MiNivelTitulo.class, miniveltitulo.getIdNivelTitulo());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public String grabar(MiNivelTitulo miniveltitulo) {
		String msg= "";
		try {
			em.persist(miniveltitulo);
			msg="Se grabo correctamente";
		} catch (Exception e) {
			//System.out.println("ERROR DAO"+e.getMessage());
			msg="ERROR DAO OBJ NO GUARDADO"+e.getMessage();
		}
		return msg;
	}

	@Override
	public String actualizar(MiNivelTitulo c) {
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
	public String eliminar(MiNivelTitulo c) {
		String msg= "";
		try {
			MiNivelTitulo buscar = em.find(MiNivelTitulo.class, c.getIdNivelTitulo());
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
	public List<MiNivelTitulo> listar() {
		List<MiNivelTitulo> lista = null;
		try {
			Query q = em.createQuery("Select u from MiNivelTitulo u");
			lista = q.getResultList();
		} catch (Exception e) {
			System.out.println("error ejbdao listar");
			e.printStackTrace();
		}
		return lista;
	}

	@Override
	public MiNivelTitulo buscarporId(int id) {
		//int id = 0;
		MiNivelTitulo p = null;
		try {
			p = (MiNivelTitulo)em.createQuery("Select u from MiNivelTitulo u"
					+ "where u.user_id = :id")
					.setParameter("id", id)
					.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return p;
	}

}
