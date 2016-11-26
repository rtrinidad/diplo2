package py.edu.ucsa.webapplication01.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;

import py.edu.ucsa.webapplication01.connectivity.ManejadorConexiones;
import py.edu.ucsa.webapplication01.dao.CategoriaDAO;
import py.edu.ucsa.webapplication01.dto.CategoriaDTO;

public class CategoriaImpl implements CategoriaDAO{

	@Override
	public void insertCategoria(CategoriaDTO c) {
		try {
			Connection con = ManejadorConexiones.obtenerConexionPG();
			PreparedStatement ps = con.prepareStatement("INSERT INTO Categorias("
					+ "id, codigo, descripcion, fecha_insercion) VALUES("
					+ "?,?,?,?);");
			ps.setLong(1, c.getId());
			ps.setString(2, c.getCodigo());
			ps.setString(3, c.getDescripcion());
			if (c.getFechaInsercion() != null) {
				ps.setDate(4, new java.sql.Date(c.getFechaInsercion().getTime()));//MianClass para parsear de util.date a sql.date
			}else {
				ps.setNull(4, Types.DATE); //javatypes constantes de JAVA usando ese es un intermerdiario con las bases de datos
				}
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actualizarCategoria(CategoriaDTO c) {
		try {
			Connection con = ManejadorConexiones.obtenerConexionPG();
			PreparedStatement ps = con.prepareStatement("UPDATE Categorias "
					+ "SET codigo = ?, descripcion = ? WHERE id = ?;");
			ps.setString(1, c.getCodigo());
			ps.setString(2, c.getDescripcion());
			ps.setLong(3, c.getId());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void borrarCategoria(String codigo) {
		try {
			Connection c = ManejadorConexiones.obtenerConexionPG();
			PreparedStatement ps = c.prepareStatement("DELETE from categorias WHERE codigo = ?");
			ps.setString(1, codigo);
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public ArrayList<CategoriaDTO> listarCategoria() {
		ArrayList<CategoriaDTO> listaCat = new ArrayList<CategoriaDTO>();
		try {
			Connection c = ManejadorConexiones.obtenerConexionPG();
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery("SELECT * FROM categorias;");
			CategoriaDTO categoria = null;
			while (rs.next()) {
					categoria = new CategoriaDTO();
					categoria.setId(rs.getLong("id"));
					categoria.setCodigo(rs.getString("codigo"));
					categoria.setDescripcion(rs.getString("descripcion"));
					categoria.setFechaInsercion(rs.getDate("fecha_insercion"));
					listaCat.add(categoria);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaCat;
	}

}
