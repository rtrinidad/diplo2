package py.edu.ucsa.lomitus.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import py.edu.ucsa.lomitus.connectivity.ManejadorConexiones;
import py.edu.ucsa.lomitus.dao.EmpleadoDAO;
import py.edu.ucsa.lomitus.dto.EmpleadoDTO;


public class EmpleadoDAOImpl implements EmpleadoDAO{

	public EmpleadoDTO autenticar(String usuario, String clave) {
		
		EmpleadoDTO emple = null;
		
		try {
			Connection c = ManejadorConexiones.obtenerConexion("postgres");
			PreparedStatement ps = c.prepareStatement("SELECT * FROM empleados e WHERE e.usuario = ? and e.clave = ? and e.tipo = ?");
			ps.setString(1, usuario);
			ps.setString(2, clave);
			ps.setString(2, "OPER");
			ResultSet rs = ps.executeQuery();
			if (rs.next()){
				emple = new EmpleadoDTO(rs.getInt("id"), rs.getString("nombre_apellido"), usuario, rs.getString("clave"), rs.getString("tipo"));
			}
			rs.close();
			ps.close();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return emple;
	}

}
