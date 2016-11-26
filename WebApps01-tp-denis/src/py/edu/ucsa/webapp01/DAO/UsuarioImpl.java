package py.edu.ucsa.webapp01.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import py.edu.ucsa.webapp01.DTO.RolDTO;
import py.edu.ucsa.webapp01.DTO.UsuarioDTO;
import py.edu.ucsa.webapp01.connectivity.ManejadorConexiones;

public class UsuarioImpl implements UsuarioDAO{

	@Override
	public void insertUsuario(UsuarioDTO usuario) {
		Connection c;
		try {
			c = ManejadorConexiones.obtenerConexionPG();
			PreparedStatement ps = c.prepareStatement("INSERT INTO usuario(nombre, apellido, usuario, clave) values(?,?,?,?)");
			PreparedStatement ps2 = c.prepareStatement("INSERT INTO usuario_rol(usuario, id_rol) values(?,?)");
			ps.setString(1, usuario.getNombre());
			ps.setString(2, usuario.getApellido());
			ps.setString(3, usuario.getUsuario());
			ps.setString(4, usuario.getClave());
			ps.executeUpdate();
			for (RolDTO rol : usuario.getRoles()) {
					ps2.setString(1, usuario.getUsuario());
					ps2.setInt(2, rol.getId()); 
				}
			ps2.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace(); 
		}
		
	}

	@Override
	public void actualizarUsuario(UsuarioDTO usuario) {
		try {
			Connection c = ManejadorConexiones.obtenerConexionPG();
			PreparedStatement ps = c.prepareStatement("UPDATE usuario SET nombre = ?, apellido = ?"
					+ " where usuario = ? and clave = ? ");
			PreparedStatement ps2 = c.prepareStatement("UPDATE usuario_rol SET id_rol = ? WHERE usuario = ?");
				ps.setString(1, usuario.getNombre());
				ps.setString(2, usuario.getApellido());
				ps.setString(3, usuario.getUsuario());
				ps.setString(4, usuario.getClave());
				ps.executeUpdate();
					
				ArrayList<RolDTO> roles =  usuario.getRoles();	
					if (roles != null) {
						for (RolDTO rolDTO : roles) {
							ps2.setInt(1, rolDTO.getId());	
						}
					}
				ps2.setString(2, usuario.getUsuario());
				ps2.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void borrarUsuario(String usuario, String clave) {
		try {
			Connection c = ManejadorConexiones.obtenerConexionPG();
			PreparedStatement ps = c.prepareStatement("DELETE usuario where usuario=? and clave=?");
			PreparedStatement ps2 = c.prepareStatement("DELETE usuario_rol where usuario = ?");
			ps.setString(1, usuario);
			ps.setString(2, clave);
			ps.executeUpdate();
			ps2.setString(1, usuario);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<UsuarioDTO> listarUsuario() {
		ArrayList<UsuarioDTO> listaUsiario = new ArrayList<UsuarioDTO>();
		ArrayList<RolDTO> roles = new ArrayList<RolDTO>();
		Connection c = null;
		try {
			c = ManejadorConexiones.obtenerConexionPG();
			Statement s = c.createStatement();
			Statement s2 = c.createStatement();
			ResultSet rs = s.executeQuery("SELECT * from usuario");
		 	ResultSet rs2 = s2.executeQuery("SELECT * from usuario_rol");
			UsuarioDTO usuario = null;
			RolDTO rol = null;
			while (rs.next()) {
				usuario = new UsuarioDTO(rs.getString("usuario"), rs.getString("nombre"), rs.getString("apellido"));
					while (rs2.next()) {
					rol = new RolDTO(rs2.getInt("id") , rs2.getString("nombreRol"));
					roles.add(rol);
				}
				listaUsiario.add(usuario);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaUsiario;
	}

	@Override
	public UsuarioDTO obtenerDatosUsuario(String usuario) {
		// TODO Auto-generated method stub
		return null;
	}

}
