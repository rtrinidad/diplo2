package py.edu.ucsa.webapplication01.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import py.edu.ucsa.webapplication01.connectivity.ManejadorConexiones;
import py.edu.ucsa.webapplication01.dao.UsuarioDAO;
import py.edu.ucsa.webapplication01.dto.RolDTO;
import py.edu.ucsa.webapplication01.dto.UsuarioDTO;

public class UsuarioImpl implements UsuarioDAO{

	@Override
	public void insertUsuario(UsuarioDTO usuario) {
		Connection c;
		try {
			c = ManejadorConexiones.obtenerConexionPG();
			PreparedStatement ps = c.prepareStatement("INSERT INTO usuario(nombre, apellido, usuario, clave) values(?,?,?,?)");
			PreparedStatement ps2 = c.prepareStatement("INSERT INTO relacion_usu_rol(usuario, id_rol) values(?,?)");
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
				ps.setString(1, usuario.getNombre());
				ps.setString(2, usuario.getApellido());
				ps.setString(3, usuario.getUsuario());
				ps.setString(4, usuario.getClave());
				ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void borrarUsuario(String usuario, String clave) {
		try {
			Connection c = ManejadorConexiones.obtenerConexionPG();
			PreparedStatement ps = c.prepareStatement("DELETE usuario where usuario=? and clave=?");
			ps.setString(1, usuario);
			ps.setString(2, clave);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<UsuarioDTO> listarUsuario() {
		ArrayList<UsuarioDTO> listaUsiario = new ArrayList<UsuarioDTO>();
		Connection c = null;
		try {
			c = ManejadorConexiones.obtenerConexionPG();
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery("SELECT * from usuario");
			UsuarioDTO usuario = null;
			while (rs.next()) {
				usuario.setNombre("nombre");
				usuario.setApellido("apellido");
				usuario.setClave("clave");
				//usuario.setRoles("roles");
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
