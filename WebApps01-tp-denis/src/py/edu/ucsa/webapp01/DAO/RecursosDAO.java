package py.edu.ucsa.webapp01.DAO;

import java.util.ArrayList;

import py.edu.ucsa.webapp01.DTO.RecursosDTO;

public interface RecursosDAO {

	void insertRecursos(RecursosDTO r);
	
	void actualizarRecursos(RecursosDTO r);
	
	void borrarRecursos(Long id);
	
	ArrayList<RecursosDTO> listarRecursos();
	
	RecursosDTO obtenerRecursoXId(Long id);
}
