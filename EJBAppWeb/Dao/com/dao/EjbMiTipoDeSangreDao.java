package com.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.ejb.model.MiTipoDeSangre;

@Stateless(name="ejbMiTipoDeSangreDao")
public class EjbMiTipoDeSangreDao implements MiTipoDeSangreDao {
	
	//unir con mi persistencia
	@PersistenceContext(name="persistencia")
	private EntityManager em;
	
	@Override
	public MiTipoDeSangre buscar(MiTipoDeSangre mitipodesangre) {
		MiTipoDeSangre obj = null;
		try {
			obj = em.find(MiTipoDeSangre.class, mitipodesangre.getIdTipoDeSangre());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public String grabar(MiTipoDeSangre mitipodesangre) {
		String msg= "";
		try {
			em.persist(mitipodesangre);
			msg="Se grabo correctamente";
		} catch (Exception e) {
			//System.out.println("ERROR DAO"+e.getMessage());
			msg="ERROR DAO OBJ NO GUARDADO"+e.getMessage();
		}
		return msg;
	}

	@Override
	public String actualizar(MiTipoDeSangre c) {
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
	public String eliminar(MiTipoDeSangre c) {
		String msg= "";
		try {
			MiTipoDeSangre buscar = em.find(MiTipoDeSangre.class, c.getIdTipoDeSangre());
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
	public List<MiTipoDeSangre> listar() {
		List<MiTipoDeSangre> lista = null;
		try {
			Query q = em.createQuery("Select u from MiTipoDeSangre u");
			lista = q.getResultList();
		} catch (Exception e) {
			System.out.println("error ejbdao listar");
			e.printStackTrace();
		}
		return lista;
	}

	@Override
	public MiTipoDeSangre buscarporId(int id) {
		//int id = 0;
		MiTipoDeSangre p = null;
		try {
			p = (MiTipoDeSangre)em.createQuery("Select u from MiTipoDeSangre u"
					+ "where u.user_id = :id")
					.setParameter("id", id)
					.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return p;
	}

}
