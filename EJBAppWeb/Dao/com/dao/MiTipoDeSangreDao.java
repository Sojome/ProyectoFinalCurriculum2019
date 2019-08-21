package com.dao;

import java.util.List;

import javax.ejb.Local;

import com.ejb.model.MiTipoDeSangre;
@Local
public interface MiTipoDeSangreDao {
	//metodos para el crud
	public MiTipoDeSangre buscar(MiTipoDeSangre mitipodesangre);
	public String grabar(MiTipoDeSangre mitipodesangre);
	public String actualizar(MiTipoDeSangre c);
	public String eliminar(MiTipoDeSangre c);
	public List<MiTipoDeSangre> listar();
	public MiTipoDeSangre buscarporId(int id);
}
