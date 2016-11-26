package py.edu.ucsa.carrito.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import py.edu.ucsa.carrito.connectivity.ManejadorConexiones;
import py.edu.ucsa.carrito.dao.PersonaDAO;
import py.edu.ucsa.carrito.dto.PersonaDTO;

public class PersonaDAOImpl extends GenericDAOImpl implements PersonaDAO{

	@Override
	public List<PersonaDTO> listar() {
		List<PersonaDTO> resultado = new ArrayList<PersonaDTO>();
		Connection c = null;
		try {
			c = ManejadorConexiones.obtenerConexion("postgres");
			Statement stmt = c.createStatement();
			String query = "SELECT ruc, razon_social, password, comentarios, "
							+ "persona_juridica, contribuyente, sexo, "
							+ " actividad_economica FROM personas";
			ResultSet rs = stmt.executeQuery(query);
			
			PersonaDTO p = null;
			
			while (rs.next()) {
				p = convertirDatosAPersona(rs);
				//AGREGAMOS EL OBJETO AL ARRAY
				resultado.add(p);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			cerrarConexion(c);
		}
		return resultado;
	}

	@Override
	public PersonaDTO getByRuc(String ruc) {
		PersonaDTO persona = null;
		Connection c = null;
		try {
			c = ManejadorConexiones.obtenerConexion("postgres");
			Statement stmt = c.createStatement();
			String query = "SELECT ruc, razon_social, password, comentarios, "
							+ "persona_juridica, contribuyente, sexo, "
							+ " actividad_economica FROM personas";
			ResultSet rs = stmt.executeQuery(query);
			
			if (rs.next()) {
				persona = convertirDatosAPersona(rs);
				//AGREGAMOS EL OBJETO AL ARRAY
				return persona;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			cerrarConexion(c);
		}
		return persona;
	}

	private PersonaDTO convertirDatosAPersona(ResultSet rs) throws SQLException {
		PersonaDTO persona;
		persona = new PersonaDTO();
		persona.setRuc(rs.getString("ruc"));
		persona.setRazonSocial(rs.getString("razon_social"));
		persona.setPassword(rs.getString("password"));
		persona.setComentarios(rs.getString("comentarios"));
		persona.setPersonaJuridica(rs.getBoolean("persona_juridica"));
		persona.setContribuyente(rs.getBoolean("contribuyente"));
		persona.setSexo(rs.getString("sexo"));
		persona.setActividadEconomica(rs.getString("actividad_economica"));
		return persona;
	}

	@Override
	public void insertar(PersonaDTO p) {
		Connection c = null;
		try {
			c = ManejadorConexiones.obtenerConexion("postgres");

			PreparedStatement s = c.prepareStatement("INSERT INTO personas( "
            + "ruc, razon_social, password, comentarios, persona_juridica, contribuyente, " 
            + "sexo, actividad_economica) VALUES (?,?,?,?,?,?,?,?)");
			s.setString(1, p.getRuc());
			s.setString(2, p.getRazonSocial());
			s.setString(3, p.getPassword());
			s.setString(4, p.getComentarios());
			s.setBoolean(5, p.isPersonaJuridica());
			s.setBoolean(6, p.isContribuyente());
			s.setString(7, p.getSexo());
			s.setString(8, p.getActividadEconomica());
			int result = s.executeUpdate();
			System.out.println("FILAS AFECTADAS: " + result);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			cerrarConexion(c);
		}
	}

	@Override
	public void actualizar(PersonaDTO p) {
		Connection c = null;
		try {
			c = ManejadorConexiones.obtenerConexion("postgres");

			PreparedStatement s = c.prepareStatement("UPDATE personas "
					+"SET razon_social=?, password=?, comentarios=?, "
					+ "persona_juridica=?, contribuyente=?, sexo=?, "
					+ "actividad_economica=? WHERE ruc = ?");
			s.setString(1, p.getRazonSocial());
			s.setString(2, p.getPassword());
			s.setString(3, p.getComentarios());
			s.setBoolean(4, p.isPersonaJuridica());
			s.setBoolean(5, p.isContribuyente());
			s.setString(6, p.getSexo());
			s.setString(7, p.getActividadEconomica());
			s.setString(8, p.getRuc());
			int result = s.executeUpdate();
			System.out.println("FILAS AFECTADAS: " + result);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			cerrarConexion(c);
		}
	}

	public void eliminar(String ruc) {
		Connection c = null;
		try {
			c = ManejadorConexiones.obtenerConexion("postgres");

			PreparedStatement s = c.prepareStatement("DELETE from personas WHERE ruc=?");
			s.setString(1, ruc);
			int result = s.executeUpdate();
			System.out.println("FILAS AFECTADAS: " + result);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			cerrarConexion(c);
		}
	}

	@Override
	public PersonaDTO getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminar(Long id) {
		// TODO Auto-generated method stub
		
	}

}
