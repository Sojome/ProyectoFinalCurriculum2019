package com.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.ejb.model.MiCanton;

@Stateless(name="ejbMiCantonDao")
public class EjbMiCantonDao implements MiCantonDao {
	
	//unir con mi persistencia
	@PersistenceContext(name="persistencia")
	private EntityManager em;
	
	@Override
	public MiCanton buscar(MiCanton canton) {
		MiCanton obj = null;
		try {
			obj = em.find(MiCanton.class, canton.getIdCanton());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public String grabar(MiCanton canton) {
		String msg= "";
		try {
			em.persist(canton);
			msg="Se grabo correctamente";
		} catch (Exception e) {
			//System.out.println("ERROR DAO"+e.getMessage());
			msg="ERROR DAO OBJ NO GUARDADO"+e.getMessage();
		}
		return msg;
	}

	@Override
	public String actualizar(MiCanton c) {
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
	public String eliminar(MiCanton c) {
		String msg= "";
		try {
			MiCanton buscar = em.find(MiCanton.class, c.getIdCanton());
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
	public List<MiCanton> listar(int id) {
		List<MiCanton> lista = null;
		try {
			Query q = em.createQuery("Select u from MiCanton u where u.provincia.idProvincia=:id");
			q.setParameter("id", id);
			lista = q.getResultList();
		} catch (Exception e) {
			System.out.println("error ejbdao listar");
			e.printStackTrace();
		}
		return lista;
	}

	@Override
	public MiCanton buscarporId(int id) {
		//int id = 0;
		MiCanton p = null;
		try {
			p = (MiCanton)em.createQuery("Select u from MiCanton u where u.idMiCanton=:id")
					.setParameter("id", id)
					.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return p;
	}

}
