package py.edu.ucsa.webapplication01.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Types;
import java.util.ArrayList;

import py.edu.ucsa.webapplication01.connectivity.ManejadorConexiones;
import py.edu.ucsa.webapplication01.dao.ProductoDAO;
import py.edu.ucsa.webapplication01.dto.ProductoDTO;

public class ProductoImpl implements ProductoDAO{

	@Override
	public void insertProducto(ProductoDTO p) {
		try {
			Connection con = ManejadorConexiones.obtenerConexionPG();
			PreparedStatement ps = con.prepareStatement("INSERT INTO Productos("
					+ "id, codigo, descripcion, id_categoria, id_proveedor"
					+ " id_marca, existencia_minima, fecha_insercion, fecha_ult_modificacion) VALUES("
					+ "?,?,?,?,?,?,?,?);");
			ps.setLong(1, p.getId());
			ps.setString(2, p.getCodigo());
			ps.setString(3, p.getDescripcion());
			ps.setLong(4, p.getCategoria().getId());
			ps.setLong(5, p.getProveedor().getId());
			ps.setLong(6, p.getMarca().getId());
			ps.setDouble(7, p.getExistenciaMinima());
			if (p.getFechaInsercion() != null) {
				ps.setDate(8, new java.sql.Date(p.getFechaInsercion().getTime()));//MianClass para parsear de util.date a sql.date
			}else {
				ps.setNull(8, Types.DATE); //javatypes constantes de JAVA usando ese es un intermerdiario con las bases de datos
				}
			if (p.getFechaUltimaModificacion() != null) {
				ps.setDate(9, new java.sql.Date(p.getFechaUltimaModificacion().getTime()));//MianClass para parsear de util.date a sql.date
			}else {
				ps.setNull(9, Types.DATE); //javatypes constantes de JAVA usando ese es un intermerdiario con las bases de datos
				}
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void actualizarProducto(ProductoDTO p) {
		try {
			Connection c = ManejadorConexiones.obtenerConexionPG();
			PreparedStatement ps = c.prepareStatement("UPDATE Productos "
					+ "SET codigo = ?, descripcion = ?, id_categoria = ?, id_proveedor = ?, "
					+ " id_marca = ?, existencia_actual = ? WHERE id = ?;");
			ps.setString(1, p.getCodigo());
			ps.setString(2, p.getDescripcion());
			ps.setLong(3, p.getMarca().getId());
			ps.setLong(4, p.getProveedor().getId());
			
			ps.setLong(7, p.getId());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void borrarProducto(String codigo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<ProductoDTO> listarProducto() {
		// TODO Auto-generated method stub
		return null;
	}

}
