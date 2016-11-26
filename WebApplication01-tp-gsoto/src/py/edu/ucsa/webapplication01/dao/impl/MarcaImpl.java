 package py.edu.ucsa.webapplication01.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;

import py.edu.ucsa.webapplication01.connectivity.ManejadorConexiones;
import py.edu.ucsa.webapplication01.dao.MarcaDAO;
import py.edu.ucsa.webapplication01.dto.MarcaDTO;

public class MarcaImpl implements MarcaDAO{
	@Override
	public void insertMarca(MarcaDTO m) {
		try {
			Connection c = ManejadorConexiones.obtenerConexionPG();
			PreparedStatement ps = c.prepareStatement("INSERT INTO marcas("
					+ "id, codigo, descripcion, fecha_insercion) VALUES("
					+ "?,?,?,?);");
			ps.setLong(1, m.getId());
			ps.setString(2, m.getCodigo());
			ps.setString(3, m.getDescripcion());
			if (m.getFechaInsercion() != null) {
				ps.setDate(4, new java.sql.Date(m.getFechaInsercion().getTime()));//MianClass para parsear de util.date a sql.date
			}else {
				ps.setNull(4, Types.DATE); //javatypes constantes de JAVA usando ese es un intermerdiario con las bases de datos
				}
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actualizarMarca(MarcaDTO m) {
		try {
			Connection c = ManejadorConexiones.obtenerConexionPG();
			PreparedStatement ps = c.prepareStatement("UPDATE marcas "
					+ "SET codigo = ?, descripcion = ? WHERE id = ?;");
			ps.setString(1, m.getCodigo());
			ps.setString(2, m.getDescripcion());
			ps.setLong(3, m.getId());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void borrarMarca(String codigo) {
		try {
			Connection c = ManejadorConexiones.obtenerConexionPG();
			PreparedStatement ps = c.prepareStatement("DELETE from marcas WHERE codigo = ?");
			ps.setString(1, codigo);
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<MarcaDTO> listarMarca() {
		ArrayList<MarcaDTO> listaMarcas = new ArrayList<MarcaDTO>();
		try {
			Connection c = ManejadorConexiones.obtenerConexionPG();
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery("SELECT * FROM marcas;");
			MarcaDTO marcaDTO = null;
			while (rs.next()) {
				marcaDTO = new MarcaDTO();
					marcaDTO.setId(rs.getLong("id"));
					marcaDTO.setCodigo(rs.getString("codigo"));
					marcaDTO.setDescripcion(rs.getString("descripcion"));
					marcaDTO.setFechaInsercion(rs.getDate("fecha_insercion"));
					listaMarcas.add(marcaDTO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaMarcas;
	}

}
