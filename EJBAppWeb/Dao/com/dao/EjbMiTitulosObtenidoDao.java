package com.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.ejb.model.MiTitulosObtenido;

@Stateless(name="ejbMiTitulosObtenidoDao")
public class EjbMiTitulosObtenidoDao implements MiTitulosObtenidoDao {
	
	//unir con mi persistencia
	@PersistenceContext(name="persistencia")
	private EntityManager em;
	
	@Override
	public MiTitulosObtenido buscar(MiTitulosObtenido mititulosobtenido) {
		MiTitulosObtenido obj = null;
		try {
			obj = em.find(MiTitulosObtenido.class, mititulosobtenido.getIdTitulosObtenidos());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public String grabar(MiTitulosObtenido mititulosobtenido) {
		String msg= "";
		try {
			em.persist(mititulosobtenido);
			msg="Se grabo correctamente";
		} catch (Exception e) {
			//System.out.println("ERROR DAO"+e.getMessage());
			msg="ERROR DAO OBJ NO GUARDADO"+e.getMessage();
		}
		return msg;
	}

	@Override
	public String actualizar(MiTitulosObtenido c) {
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
	public String eliminar(MiTitulosObtenido c) {
		String msg= "";
		try {
			MiTitulosObtenido buscar = em.find(MiTitulosObtenido.class, c.getIdTitulosObtenidos());
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
	public List<MiTitulosObtenido> listar() {
		List<MiTitulosObtenido> lista = null;
		try {
			Query q = em.createQuery("Select u from MiTitulosObtenido u");
			lista = q.getResultList();
		} catch (Exception e) {
			System.out.println("error ejbdao listar");
			e.printStackTrace();
		}
		return lista;
	}

	@Override
	public MiTitulosObtenido buscarporId(int id) {
		//int id = 0;
		MiTitulosObtenido p = null;
		try {
			p = (MiTitulosObtenido)em.createQuery("Select u from MiTitulosObtenido u where u.id=:id")
					.setParameter("id", id)
					.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return p;
	}

}
