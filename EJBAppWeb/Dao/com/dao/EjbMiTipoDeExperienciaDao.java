package com.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.ejb.model.MiTipoDeExperiencia;

@Stateless(name="ejbMiTipoDeExperienciaDao")
public class EjbMiTipoDeExperienciaDao implements MiTipoDeExperienciaDao {
	
	//unir con mi persistencia
	@PersistenceContext(name="persistencia")
	private EntityManager em;
	
	@Override
	public MiTipoDeExperiencia buscar(MiTipoDeExperiencia mitipodeexperiencia) {
		MiTipoDeExperiencia obj = null;
		try {
			obj = em.find(MiTipoDeExperiencia.class, mitipodeexperiencia.getIdTipoDeExperiencia());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public String grabar(MiTipoDeExperiencia mitipodeexperiencia) {
		String msg= "";
		try {
			em.persist(mitipodeexperiencia);
			msg="Se grabo correctamente";
		} catch (Exception e) {
			//System.out.println("ERROR DAO"+e.getMessage());
			msg="ERROR DAO OBJ NO GUARDADO"+e.getMessage();
		}
		return msg;
	}

	@Override
	public String actualizar(MiTipoDeExperiencia c) {
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
	public String eliminar(MiTipoDeExperiencia c) {
		String msg= "";
		try {
			MiTipoDeExperiencia buscar = em.find(MiTipoDeExperiencia.class, c.getIdTipoDeExperiencia());
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
	public List<MiTipoDeExperiencia> listar() {
		List<MiTipoDeExperiencia> lista = null;
		try {
			Query q = em.createQuery("Select u from MiTipoDeExperiencia u");
			lista = q.getResultList();
		} catch (Exception e) {
			System.out.println("error ejbdao listar");
			e.printStackTrace();
		}
		return lista;
	}

	@Override
	public MiTipoDeExperiencia buscarporId(int id) {
		//int id = 0;
		MiTipoDeExperiencia p = null;
		try {
			p = (MiTipoDeExperiencia)em.createQuery("Select u from MiTipoDeExperiencia u"
					+ "where u.user_id = :id")
					.setParameter("id", id)
					.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return p;
	}

}
