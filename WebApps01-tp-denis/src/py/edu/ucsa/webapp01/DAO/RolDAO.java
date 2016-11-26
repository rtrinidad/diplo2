package py.edu.ucsa.webapp01.DAO;

import java.util.ArrayList;

import py.edu.ucsa.webapp01.DTO.RolDTO;

public interface RolDAO {
	void insertRol(RolDTO r);
	
	void actualizarRol(RolDTO r);
	
	void borrarRol(int id);
	
	ArrayList<RolDTO> listarRoles();
	
	RolDTO obtenerRolXId(int id);
}
