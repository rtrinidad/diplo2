package py.edu.ucsa.webapplication01.recurso;

import java.util.ArrayList;

public interface RecursosDAO {

	void insertRecursos(RecursosDTO r);
	
	void actualizarRecursos(RecursosDTO r);
	
	void borrarRecursos(Long id);
	
	ArrayList<RecursosDTO> listarRecursos();
	
	RecursosDTO obtenerRecursoXId(Long id);
}
