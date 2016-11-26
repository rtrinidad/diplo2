package py.edu.ucsa.webapp01.DAO;

import java.util.ArrayList;

import py.edu.ucsa.webapp01.DTO.CategoriaDTO;

public interface CategoriaDAO {
	void insertCategoria(CategoriaDTO c);
	
	void actualizarCategoria(CategoriaDTO c);
	
	void borrarCategoria(String codigo);
	
	ArrayList<CategoriaDTO> listarCategoria();
	
	CategoriaDTO obtenerCategoriaXCodigo(String cod);
}
