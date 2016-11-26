package py.edu.ucsa.carrito.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import py.edu.ucsa.carrito.connectivity.ManejadorConexiones;
import py.edu.ucsa.carrito.dao.UsuarioDAO;
import py.edu.ucsa.carrito.dto.RolDTO;
import py.edu.ucsa.carrito.dto.UsuarioDTO;

public class UsuarioDAOImpl implements UsuarioDAO{

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public UsuarioDTO autenticar(String usuario, String clave) {
		
		UsuarioDTO usu = null;
		
		try {
			Connection c = ManejadorConexiones.obtenerConexionPG();
			PreparedStatement ps = c.prepareStatement("SELECT * FROM usuarios WHERE usuario = ? AND clave = ?");
			ps.setString(1, usuario);
			ps.setString(2, clave);
			log.debug("VAMOS A EJECUTAR EL QUERY PARA AUTENTICAR AL USUARIO");
			ResultSet rs = ps.executeQuery();

			if (rs.next()){
				log.debug("OBTUVO UN USUARIO COINCIDENTE CON LOS PARAMETROS ENVIADOS");
				usu = new UsuarioDTO(rs.getInt("id"), rs.getString("usuario"), 
						rs.getString("nombres"), rs.getString("apellidos"), null);
			
				usu.setRoles(this.getRoles(c, usu.getId()));
				rs.close();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return usu;
	}

	private List<RolDTO> getRoles(Connection c, int idUsuario) {
		
		return null;
	}

}
