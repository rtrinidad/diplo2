package py.edu.ucsa.webapplication01.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;

import py.edu.ucsa.webapplication01.connectivity.ManejadorConexiones;
import py.edu.ucsa.webapplication01.dao.ProveedorDAO;
import py.edu.ucsa.webapplication01.dto.ProveedorDTO;

public class ProveedorImpl implements ProveedorDAO{

	@Override
	public void insertProveedor(ProveedorDTO p) {
		try {
			Connection c = ManejadorConexiones.obtenerConexionPG();
			PreparedStatement ps = c.prepareStatement("INSERT INTO proveedores("
					+ "id, codigo, razon_social, fecha_insercion) VALUES("
					+ "?,?,?,?);");
			ps.setLong(1, p.getId());
			ps.setString(2, p.getCodigo());
			ps.setString(3, p.getRazonSocial());
			if (p.getFechaInsercion() != null) {
				ps.setDate(4, new java.sql.Date(p.getFechaInsercion().getTime()));//MianClass para parsear de util.date a sql.date
			}else {
				ps.setNull(4, Types.DATE); //javatypes constantes de JAVA usando ese es un intermerdiario con las bases de datos
				}
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void actualizarProveedor(ProveedorDTO p) {
		try {
			Connection c = ManejadorConexiones.obtenerConexionPG();
			PreparedStatement ps = c.prepareStatement("UPDATE proveedores "
					+ "SET codigo = ?, razon_social = ? WHERE id = ?;");
			ps.setString(1, p.getCodigo());
			ps.setString(2, p.getRazonSocial ());
			ps.setLong(3, p.getId());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void borrarProveedor(String codigo) {
		try {
			Connection c = ManejadorConexiones.obtenerConexionPG();
			PreparedStatement ps = c.prepareStatement("DELETE from proveedores WHERE codigo = ?");
			ps.setString(1, codigo);
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public ArrayList<ProveedorDTO> listarProveedores() {
		ArrayList<ProveedorDTO> listaProveedores = new ArrayList<ProveedorDTO>();
		try {
			Connection c = ManejadorConexiones.obtenerConexionPG();
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery("SELECT * FROM proveedores;");
			ProveedorDTO proveedorDTO = null;
			while (rs.next()) {
				proveedorDTO = new ProveedorDTO();
				proveedorDTO.setId(rs.getLong("id"));
				proveedorDTO.setCodigo(rs.getString("codigo"));
				proveedorDTO.setRazonSocial(rs.getString("razon_social"));
				proveedorDTO.setFechaInsercion(rs.getDate("fecha_insercion"));
				listaProveedores.add(proveedorDTO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaProveedores;
	}

}
