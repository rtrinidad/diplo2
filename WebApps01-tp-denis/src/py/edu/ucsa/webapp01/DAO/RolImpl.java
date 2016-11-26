package py.edu.ucsa.webapp01.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import py.edu.ucsa.webapp01.DTO.RolDTO;
import py.edu.ucsa.webapp01.connectivity.ManejadorConexiones;

public class RolImpl implements RolDAO{

	@Override
	public void insertRol(RolDTO r) {
		try {
			Connection c = ManejadorConexiones.obtenerConexionPG();
			PreparedStatement ps = c.prepareStatement("INSERT INTO rol("
					+ "id, nombreRol) VALUES("
					+ "?,?);");
			ps.setLong(1, r.getId());
			ps.setString(2, r.getNombreRol());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void actualizarRol(RolDTO r) {
		try {
			Connection c = ManejadorConexiones.obtenerConexionPG();
				PreparedStatement ps = c.prepareStatement("UPDATE rol "
						+ "SET nombreRol = ? WHERE id = ?;");
			ps.setString(1, r.getNombreRol());
			ps.setInt(2, r.getId());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void borrarRol(int id) {
		try {
			Connection c = ManejadorConexiones.obtenerConexionPG();
			PreparedStatement ps = c.prepareStatement("DELETE from rol WHERE id = ?");
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<RolDTO> listarRoles() {
		ArrayList<RolDTO> listaRoles= new ArrayList<RolDTO>();
		try {
			Connection c = ManejadorConexiones.obtenerConexionPG();
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery("SELECT * FROM rol;");
			RolDTO rol = null;
			while (rs.next()) {
				rol = new RolDTO(rs.getInt("id"), rs.getString("codigo"));
				listaRoles.add(rol);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaRoles;
	}

	@Override
	public RolDTO obtenerRolXId(int id) {
			RolDTO rol = null;
			try {
				
				Connection c = ManejadorConexiones.obtenerConexionPG();
				Statement s = c.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
				ResultSet rs = s.executeQuery("Select * from marca");
				while(rs.next()){
					if(rs.getInt("id") == id){
						int fila = rs.getRow();
						rs.absolute(fila);
						rol = new RolDTO(id, rs.getString("nombrerol"));
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		return rol;
	}

}
