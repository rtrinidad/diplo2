package py.edu.ucsa.webapp01.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;

import py.edu.ucsa.webapp01.DTO.ProductoDTO;
import py.edu.ucsa.webapp01.connectivity.ManejadorConexiones;

public class ProductoImpl implements ProductoDAO{

	@Override
	public void insertProducto(ProductoDTO p) {
		try {
			Connection con = ManejadorConexiones.obtenerConexionPG();
			PreparedStatement ps = con.prepareStatement("INSERT INTO Productos("
					+ "id, codigo, descripcion, id_categoria, id_proveedor"
					+ " id_marca, existencia_actual, existencia_minima, fecha_insercion, fecha_ult_modificacion) VALUES("
					+ "?,?,?,?,?,?,?,?);");
			ps.setLong(1, p.getId());
			ps.setString(2, p.getCodigo());
			ps.setString(3, p.getDescripcion());
			ps.setLong(4, p.getCategoria().getId());
			ps.setLong(5, p.getProveedor().getId());
			ps.setLong(6, p.getMarca().getId());
			ps.setDouble(7, p.getExistenciaActual());
			ps.setDouble(8, p.getExistenciaMinima());
			if (p.getFechaInsercion() != null) {
				ps.setDate(9, new java.sql.Date(p.getFechaInsercion().getTime()));//MianClass para parsear de util.date a sql.date
			}else {
				ps.setNull(9, Types.DATE); //javatypes constantes de JAVA usando ese es un intermerdiario con las bases de datos
				}
			if (p.getFechaUltimaModificacion() != null) {
				ps.setDate(10, new java.sql.Date(p.getFechaUltimaModificacion().getTime()));//MianClass para parsear de util.date a sql.date
			}else {
				ps.setNull(10, Types.DATE); //javatypes constantes de JAVA usando ese es un intermerdiario con las bases de datos
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
					+ " id_marca = ?, existencia_actual = ?, existencia_minima = ? WHERE id = ?;");
			ps.setString(1, p.getCodigo());
			ps.setString(2, p.getDescripcion());
			ps.setLong(3, p.getCategoria().getId());
			ps.setLong(4, p.getProveedor().getId());
			ps.setLong(5, p.getMarca().getId());
			ps.setDouble(6, p.getExistenciaActual());
			ps.setDouble(7, p.getExistenciaMinima());
			ps.setLong(8, p.getId());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void borrarProducto(String codigo) {
		try {
			Connection c = ManejadorConexiones.obtenerConexionPG();
			PreparedStatement ps = c.prepareStatement("DELETE from Productos WHERE codigo = ?");
			ps.setString(1, codigo);
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public ArrayList<ProductoDTO> listarProducto() { 
		ArrayList<ProductoDTO> listaProductos = new ArrayList<ProductoDTO>();
		try {
			Connection c = ManejadorConexiones.obtenerConexionPG();
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery("SELECT * FROM productos;");
			ProductoDTO producto = null;
			CategoriaDAO categoria = null;
			ProveedorDAO proveedor = null;
			MarcaDAO marca = null;
			while (rs.next()) {
				producto = new ProductoDTO();
				categoria = new CategoriaImpl();
				proveedor = new ProveedorImpl();
				marca = new MarcaImpl();
					producto.setId(rs.getLong("id"));
					producto.setCodigo(rs.getString("codigo"));
					producto.setDescripcion(rs.getString("descripcion"));
					producto.setCategoria(categoria.obtenerCategoriaXCodigo(rs.getString("id_categoria")));
					producto.setProveedor(proveedor.obtenerProveedorXCodigo(rs.getString("id_proveedor")));
					producto.setMarca(marca.obtenerMarcaXCodigo(rs.getString("id_marca")));
					producto.setExistenciaActual(rs.getDouble("existencia_actual"));
					producto.setExistenciaMinima(rs.getDouble("existencia_minima"));
					producto.setFechaInsercion(rs.getDate("fecha_insercion"));
					producto.setFechaUltimaModificacion(rs.getDate("fecha_ult_modificacion"));
					listaProductos.add(producto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaProductos;
	}

	@Override
	public ProductoDTO obtenerProductoXCodigo(String cod) {
		ProductoDTO producto = null;
		try {
			producto = new ProductoDTO();
			Connection c = ManejadorConexiones.obtenerConexionPG();
			Statement s = c.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = s.executeQuery("Select * from productos");
			CategoriaDAO categoria = null;
			ProveedorDAO proveedor = null;
			MarcaDAO marca = null;
			while(rs.next()){
				if (rs.getString("codigo") == cod) {
					int fila = rs.getRow();
					rs.absolute(fila);
					categoria = new CategoriaImpl();
					proveedor = new ProveedorImpl();
					marca = new MarcaImpl();
						producto.setId(rs.getLong("id"));
						producto.setCodigo(rs.getString("codigo"));
						producto.setDescripcion(rs.getString("descripcion")); 
						producto.setCategoria(categoria.obtenerCategoriaXCodigo(rs.getString("id_categoria")));
						producto.setProveedor(proveedor.obtenerProveedorXCodigo(rs.getString("id_proveedor")));
						producto.setMarca(marca.obtenerMarcaXCodigo(rs.getString("id_marca")));
						producto.setExistenciaActual(rs.getDouble("existencia_actual"));
						producto.setExistenciaMinima(rs.getDouble("existencia_minima"));
						producto.setFechaInsercion(rs.getDate("fecha_insercion"));
						producto.setFechaUltimaModificacion(rs.getDate("fecha_ult_modificacion"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return producto;
	}

}
