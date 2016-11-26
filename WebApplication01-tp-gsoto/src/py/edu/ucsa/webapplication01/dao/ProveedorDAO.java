package py.edu.ucsa.webapplication01.dao;

import java.util.ArrayList;

import py.edu.ucsa.webapplication01.dto.ProveedorDTO;

public interface ProveedorDAO {
	void insertProveedor(ProveedorDTO p);
	
	void actualizarProveedor(ProveedorDTO p);
	
	void borrarProveedor(String codigo);
	
	ArrayList<ProveedorDTO> listarProveedores();
}
