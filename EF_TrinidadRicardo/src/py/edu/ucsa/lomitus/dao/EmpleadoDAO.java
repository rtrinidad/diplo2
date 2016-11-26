package py.edu.ucsa.lomitus.dao;

import py.edu.ucsa.lomitus.dto.EmpleadoDTO;

public interface EmpleadoDAO {

	public EmpleadoDTO autenticar(String usuario, String clave);
	
}
