package py.edu.ucsa.lomitus.dao;

import java.util.List;

public interface CrudDAO<T> {
	List<T> listar();
	T getById(Long id);
	
	//Métodos para modificar datos de objeto(s)
	void insertar(T objeto);
	void actualizar(T objeto);
	void eliminar(Long id);
}
