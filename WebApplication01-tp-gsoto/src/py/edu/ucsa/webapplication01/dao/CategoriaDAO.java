package py.edu.ucsa.webapplication01.dao;

import java.util.ArrayList;

import py.edu.ucsa.webapplication01.dto.CategoriaDTO;

public interface CategoriaDAO {
	void insertCategoria(CategoriaDTO c);
	
	void actualizarCategoria(CategoriaDTO c);
	
	void borrarCategoria(String codigo);
	
	ArrayList<CategoriaDTO> listarCategoria();
}
