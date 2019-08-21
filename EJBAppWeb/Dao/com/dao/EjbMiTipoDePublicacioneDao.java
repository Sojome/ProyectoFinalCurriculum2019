package com.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.ejb.model.MiTipoDePublicacione;

@Stateless(name="ejbMiTipoDePublicacioneDao")
public class EjbMiTipoDePublicacioneDao implements MiTipoDePublicacioneDao {
	
	//unir con mi persistencia
	@PersistenceContext(name="persistencia")
	private EntityManager em;
	
	@Override
	public MiTipoDePublicacione buscar(MiTipoDePublicacione mitipodepublicacione) {
		MiTipoDePublicacione obj = null;
		try {
			obj = em.find(MiTipoDePublicacione.class, mitipodepublicacione.getIdTipoDePublicacion());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public String grabar(MiTipoDePublicacione mitipodepublicacione) {
		String msg= "";
		try {
			em.persist(mitipodepublicacione);
			msg="Se grabo correctamente";
		} catch (Exception e) {
			//System.out.println("ERROR DAO"+e.getMessage());
			msg="ERROR DAO OBJ NO GUARDADO"+e.getMessage();
		}
		return msg;
	}

	@Override
	public String actualizar(MiTipoDePublicacione c) {
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
	public String eliminar(MiTipoDePublicacione c) {
		String msg= "";
		try {
			MiTipoDePublicacione buscar = em.find(MiTipoDePublicacione.class, c.getIdTipoDePublicacion());
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
	public List<MiTipoDePublicacione> listar() {
		List<MiTipoDePublicacione> lista = null;
		try {
			Query q = em.createQuery("Select u from MiTipoDePublicacione u");
			lista = q.getResultList();
		} catch (Exception e) {
			System.out.println("error ejbdao listar");
			e.printStackTrace();
		}
		return lista;
	}

	@Override
	public MiTipoDePublicacione buscarporId(int id) {
		//int id = 0;
		MiTipoDePublicacione p = null;
		try {
			p = (MiTipoDePublicacione)em.createQuery("Select u from MiTipoDePublicacione u"
					+ "where u.user_id = :id")
					.setParameter("id", id)
					.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return p;
	}

}
