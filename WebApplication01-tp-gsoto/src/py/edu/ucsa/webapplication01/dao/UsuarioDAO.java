package py.edu.ucsa.webapplication01.dao;

import java.util.ArrayList;

import py.edu.ucsa.webapplication01.dto.UsuarioDTO;

public interface UsuarioDAO {
	void insertUsuario(UsuarioDTO u);
	
	void actualizarUsuario(UsuarioDTO u);
	
	void borrarUsuario(String usuario, String clave);
	
	ArrayList<UsuarioDTO> listarUsuario();
	
	UsuarioDTO obtenerDatosUsuario(String usuario);
}
