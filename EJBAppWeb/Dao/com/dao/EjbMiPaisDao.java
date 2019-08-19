package com.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.ejb.model.MiPais;

@Stateless(name="ejbMiPaisDao")
public class EjbMiPaisDao implements MiPaisDao {
	
	//unir con mi persistencia
	@PersistenceContext(name="persistencia")
	private EntityManager em;
	
	@Override
	public MiPais buscar(MiPais mipais) {
		MiPais obj = null;
		try {
			obj = em.find(MiPais.class, mipais.getIdPais());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public String grabar(MiPais mipais) {
		String msg= "";
		try {
			em.persist(mipais);
			msg="Se grabo correctamente";
		} catch (Exception e) {
			//System.out.println("ERROR DAO"+e.getMessage());
			msg="ERROR DAO OBJ NO GUARDADO"+e.getMessage();
		}
		return msg;
	}

	@Override
	public String actualizar(MiPais p) {
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
	public String eliminar(MiPais p) {
		String msg= "";
		try {
			MiPais buscar = em.find(MiPais.class, p.getIdPais());
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
	public List<MiPais> listar() {
		List<MiPais> lista = null;
		try {
			Query q = em.createQuery("SELECT m FROM MiPais m");
			lista = q.getResultList();
		} catch (Exception e) {
			System.out.println("error ejbdao listar");
			e.printStackTrace();
		}
		return lista;
	}

	@Override
	public MiPais buscarporId(int id) {
		//int id = 0;
		MiPais p = null;
		try {
			p = (MiPais)em.createQuery("Select u from MiPais u where u.idPais = :id")
					.setParameter("id", id)
					.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return p;
	}

}
