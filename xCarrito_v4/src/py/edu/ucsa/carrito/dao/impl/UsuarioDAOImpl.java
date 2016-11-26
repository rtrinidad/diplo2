package py.edu.ucsa.carrito.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import py.edu.ucsa.carrito.connectivity.ManejadorConexiones;
import py.edu.ucsa.carrito.dao.UsuarioDAO;
import py.edu.ucsa.carrito.dto.RolDTO;
import py.edu.ucsa.carrito.dto.UsuarioDTO;

public class UsuarioDAOImpl implements UsuarioDAO{

	public UsuarioDTO autenticar(String usuario, String clave) {
		// TODO Obtener el usuario de la BD, ademas de sus roles, y luego retornar el usuario
		UsuarioDTO usu = null;
		try {
			Connection c = ManejadorConexiones.obtenerConexion("postgres");
			PreparedStatement ps = c.prepareStatement("SELECT * FROM usuarios u WHERE u.usuario = ?");
			ps.setString(1, usuario);
			ResultSet rs = ps.executeQuery();
			if (rs.next()){
				usu = new UsuarioDTO(rs.getInt("id"), usuario, rs.getString("nombres"), rs.getString("apellidos"), null);
			}
			rs.close();
			ps.close();
			if (usu != null){
				ps = c.prepareStatement("SELECT ru.id_rol, r.nombre_rol from roles r, "
						+ "roles_usuarios ru, usuarios u WHERE r.id = ru.id_rol AND "
						+ "ru.id_usuario = u.id AND u.usuario = ?");
				ps.setString(1, usuario);
				ResultSet rsRolesUsuarios = ps.executeQuery();
				List<RolDTO> roles = new ArrayList<RolDTO>();
				RolDTO rol = null;
				while(rsRolesUsuarios.next()){
					rol = new RolDTO(rsRolesUsuarios.getInt("id_rol"), rsRolesUsuarios.getString("nombre_rol"));
					roles.add(rol);
				}
				usu.setRoles(roles);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return usu;
	}

}
