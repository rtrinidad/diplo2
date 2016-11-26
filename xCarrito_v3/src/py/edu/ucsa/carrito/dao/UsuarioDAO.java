package py.edu.ucsa.carrito.dao;

import py.edu.ucsa.carrito.dto.UsuarioDTO;

public interface UsuarioDAO {

	public UsuarioDTO autenticar(String usuario, String clave);
}
