package py.edu.ucsa.webapp01.DAO;

import java.util.ArrayList;

import py.edu.ucsa.webapp01.DTO.UsuarioDTO;

public interface UsuarioDAO {
	void insertUsuario(UsuarioDTO u);
	
	void actualizarUsuario(UsuarioDTO u);
	
	void borrarUsuario(String usuario, String clave);
	
	ArrayList<UsuarioDTO> listarUsuario();
	
	UsuarioDTO obtenerDatosUsuario(String usuario);
}
