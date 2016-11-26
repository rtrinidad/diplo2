package py.edu.ucsa.jdbc.connectivity.dao;

import java.util.List;

import py.edu.ucsa.jdbc.connectivity.dto.*;


public interface FuncionariosDAO {
	
	// public abstract List<FuncionarioDTO> listar(); // Todo metodo en una interface es public y abstract no es necesario ponerlo implicito
	
	List<FuncionarioDTO> listar();
	
	FuncionarioDTO obtenerFuncionarioPorCodigo (Integer codigo);
	
	void insertar (FuncionarioDTO f);  
	
	void actualizar (FuncionarioDTO f);
	
	void eliminar (Integer id);
	
	void crearTabla();

}
