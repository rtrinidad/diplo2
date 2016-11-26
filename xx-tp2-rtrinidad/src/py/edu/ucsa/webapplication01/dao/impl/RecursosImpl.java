package py.edu.ucsa.webapplication01.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import py.edu.ucsa.webapplication01.connectivity.ManejadorConexiones;
import py.edu.ucsa.webapplication01.dao.RecursosDAO;
import py.edu.ucsa.webapplication01.dto.RecursosDTO;

public class RecursosImpl implements RecursosDAO{

	@Override
	public void insertRecursos(RecursosDTO r) {
		try {
			Connection c = ManejadorConexiones.obtenerConexionPG();
			PreparedStatement ps = c.prepareStatement("INSERT INTO recursos("
					+ "id, codigo, descripcion, habilitado, fecha_insercion) VALUES("
					+ "?,?,?,?,?);");
			ps.setLong(1, r.getId());
		
			ps.setString(3, r.getDescripcion());
			ps.setBoolean(4, r.isHabilitado());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void actualizarRecursos(RecursosDTO r) {
		try {
			Connection c = ManejadorConexiones.obtenerConexionPG();
				PreparedStatement ps = c.prepareStatement("UPDATE recursos "
						+ "SET codigo = ?, descripcion = ?, habilitado = ? WHERE id = ?;");
			ps.setString(2, r.getDescripcion());
			ps.setBoolean(3, r.isHabilitado());
			ps.setLong(4, r.getId());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void borrarRecursos(Long id) {
		try {
			Connection c = ManejadorConexiones.obtenerConexionPG();
			PreparedStatement ps = c.prepareStatement("DELETE from recursos WHERE id = ?");
			ps.setLong(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<RecursosDTO> listarRecursos() {
		ArrayList<RecursosDTO> listaRecursos = new ArrayList<RecursosDTO>();
		try {
			Connection c = ManejadorConexiones.obtenerConexionPG();
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery("SELECT * FROM recursos;");
			RecursosDTO recurso = null;
			while (rs.next()) {
				recurso = new RecursosDTO();
				recurso.setId(rs.getLong("id"));				
				recurso.setDescripcion(rs.getString("descripcion"));
				recurso.setHabilitado(rs.getBoolean("habilitado"));			
				listaRecursos.add(recurso);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaRecursos;
	}

	@Override
	public RecursosDTO obtenerRecursoXId(Long id) {
		RecursosDTO recurso = null;
		try {
			recurso = new RecursosDTO();
			Connection c = ManejadorConexiones.obtenerConexionPG();
			Statement s = c.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = s.executeQuery("Select * from recursos");
			while(rs.next()){
				if(rs.getLong("id") == id){
					int fila = rs.getRow();
					rs.absolute(fila);
					recurso.setId(rs.getLong("id"));				
					recurso.setDescripcion(rs.getString("descripcion"));
					recurso.setHabilitado(rs.getBoolean("habilitado"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return recurso;
	}

}
