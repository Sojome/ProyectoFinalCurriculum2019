package com.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.ejb.model.MiNacionalidad;

@Stateless(name="ejbMiNacionalidadDao")
public class EjbMiNacionalidadDao implements MiNacionalidadDao {
	
	//unir con mi persistencia
	@PersistenceContext(name="persistencia")
	private EntityManager em;
	
	@Override
	public MiNacionalidad buscar(MiNacionalidad minacionalidad) {
		MiNacionalidad obj = null;
		try {
			obj = em.find(MiNacionalidad.class, minacionalidad.getIdNacionalidad());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public String grabar(MiNacionalidad minacionalidad) {
		String msg= "";
		try {
			em.persist(minacionalidad);
			msg="Se grabo correctamente";
		} catch (Exception e) {
			//System.out.println("ERROR DAO"+e.getMessage());
			msg="ERROR DAO OBJ NO GUARDADO"+e.getMessage();
		}
		return msg;
	}

	@Override
	public String actualizar(MiNacionalidad c) {
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
	public String eliminar(MiNacionalidad c) {
		String msg= "";
		try {
			MiNacionalidad buscar = em.find(MiNacionalidad.class, c.getIdNacionalidad());
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
	public List<MiNacionalidad> listar(int id) {
		List<MiNacionalidad> lista = null;
		try {
			Query q = em.createQuery("Select u from MiNacionalidad u where u.pai.idPais=:id");
			q.setParameter("id", id);
			lista = q.getResultList();
		} catch (Exception e) {
			System.out.println("error ejbdao listar");
			e.printStackTrace();
		}
		return lista;
	}

	@Override
	public MiNacionalidad buscarporId(int id) {
		//int id = 0;
		MiNacionalidad p = null;
		try {
			p = (MiNacionalidad)em.createQuery("Select u from MiNacionalidad u where u.idMiNacionalidad=:id")
					.setParameter("id", id)
					.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return p;
	}

}
