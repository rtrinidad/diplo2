package py.edu.ucsa.webapp01.servlets;

import java.sql.Connection;
import java.sql.PreparedStatement;

import py.edu.ucsa.webapp01.connectivity.ManejadorConexiones;
import py.edu.ucsa.webapp01.personaDAO.PersonaDAO;
import py.edu.ucsa.webapp01.personaDAO.PersonaDTO;

public class PersonaImpl implements PersonaDAO{

	@Override
	public void insertar(PersonaDTO f) {
		// TODO Auto-generated method stub
		try {
			Connection con = ManejadorConexiones.obtenerConexionPG();
			PreparedStatement ps = con.prepareStatement("INSERT INTO Personadto("
					+ "ruc, razonsocial, comentarios, pass)"
						+ " VALUES (?, ?, ?, ?)");
			ps.setString(1, f.getRuc());
			ps.setString(2, f.getRazonSocial());
			ps.setString(3, f.getComentarios());
			ps.setString(4, f.getPass());
			ps.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
