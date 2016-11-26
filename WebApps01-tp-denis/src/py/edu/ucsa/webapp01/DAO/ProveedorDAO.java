package py.edu.ucsa.webapp01.DAO;

import java.util.ArrayList;

import py.edu.ucsa.webapp01.DTO.ProveedorDTO;

public interface ProveedorDAO {
	void insertProveedor(ProveedorDTO p);
	
	void actualizarProveedor(ProveedorDTO p);
	
	void borrarProveedor(String codigo);
	
	ArrayList<ProveedorDTO> listarProveedores();
	
	ProveedorDTO obtenerProveedorXCodigo(String cod);
}
