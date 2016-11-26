package py.edu.ucsa.carrito.dao;

import java.util.List;

public interface CrudDAO<T> {
	List<T> listar();
	T getById(Long id);
	
	//M�todos para modificar datos de objeto(s)
	void insertar(T objeto);
	void actualizar(T objeto);
	void eliminar(Long id);
}
