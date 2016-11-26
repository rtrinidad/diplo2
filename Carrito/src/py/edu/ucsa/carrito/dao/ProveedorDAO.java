package py.edu.ucsa.carrito.dao;

import py.edu.ucsa.carrito.dto.ProveedorDTO;

public interface ProveedorDAO extends CrudDAO<ProveedorDTO>{
	//M�todos para obtener provedor 
	ProveedorDTO getByCodigo(String codigo);
}
