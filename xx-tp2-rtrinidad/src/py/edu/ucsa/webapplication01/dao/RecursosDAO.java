package py.edu.ucsa.webapplication01.dao;

import java.util.ArrayList;

import py.edu.ucsa.webapplication01.dto.RecursosDTO;

public interface RecursosDAO {

	void insertRecursos(RecursosDTO r);
	
	void actualizarRecursos(RecursosDTO r);
	
	void borrarRecursos(Long id);
	
	ArrayList<RecursosDTO> listarRecursos();
	
	RecursosDTO obtenerRecursoXId(Long id);
}
