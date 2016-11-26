package py.edu.ucsa.carrito.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import py.edu.ucsa.carrito.connectivity.ManejadorConexiones;
import py.edu.ucsa.carrito.dao.ProductoDAO;
import py.edu.ucsa.carrito.dto.ProductoDTO;
import py.edu.ucsa.carrito.util.DateUtil;

public class ProductoDAOImpl extends GenericDAOImpl implements ProductoDAO {

	@Override
	public List<ProductoDTO> listar() {
		List<ProductoDTO> resultado = new ArrayList<ProductoDTO>();
		Connection c = null;
		try {
			c = ManejadorConexiones.obtenerConexion("postgres");
			Statement stmt = c.createStatement();
			String query = "SELECT id,codigo,descripcion,existencia_minima,existencia_actual, id_categoria,id_proveedor,id_marca, precio FROM productos";
			ResultSet rs = stmt.executeQuery(query);

			ProductoDTO prod = null;

			while (rs.next()) {
				prod = convertirDatosAProducto(rs);
				// AGREGAMOS EL OBJETO AL ARRAY
				resultado.add(prod);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			cerrarConexion(c);
		}
		return resultado;
	}

	private ProductoDTO convertirDatosAProducto(ResultSet rs)
			throws SQLException {
		ProductoDTO prod;
		prod = new ProductoDTO();
		prod.setId(rs.getLong("id"));
		prod.setCodigo(rs.getString("codigo"));
		prod.setDescripcion(rs.getString("descripcion"));
		prod.setCantidadEnStock(rs.getDouble("existencia_actual"));
		prod.setExistenciaMinima(rs.getDouble("existencia_minima"));
		prod.setMarca(new MarcaDAOImpl().getById(rs.getLong("id_marca")));
		prod.setCategoria(new CategoriaDAOImpl().getById(rs.getLong("id_categoria")));
		prod.setProveedor(new ProveedorDAOImpl().getById(rs.getLong("id_proveedor")));
		prod.setPrecio(rs.getDouble("precio"));
		return prod;
	}
	
	@Override
	public ProductoDTO getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertar(ProductoDTO prod) {
		Connection c = null;
		try {
			c = ManejadorConexiones.obtenerConexion("postgres");

			PreparedStatement s = c
					.prepareStatement("INSERT INTO productos( "
							+ "codigo, descripcion, fecha_insercion, existencia_actual,existencia_minima"
							+ ",id_categoria,id_proveedor,id_marca) VALUES (?,?,?,?,?,?,?,?)");
			s.setString(1, prod.getCodigo());
			s.setString(2, prod.getDescripcion());
			
			s.setTimestamp(3, DateUtil.convertirUtilDateASQLTimestamp(new Date()));
			
			s.setDouble(4, prod.getCantidadEnStock());
			s.setDouble(5, prod.getExistenciaMinima());
			if (prod.getCategoria() != null){
				s.setLong(6, prod.getCategoria().getId());				
			}else{
				s.setNull(6, Types.BIGINT);
			}
			if (prod.getProveedor() != null){
				s.setLong(7, prod.getProveedor().getId());
			}else{
				s.setNull(7, Types.BIGINT);
			}
			if (prod.getMarca() != null){
				s.setLong(8, prod.getMarca().getId());
			}else{
				s.setNull(8, Types.BIGINT);
			}
			int result = s.executeUpdate();
			System.out.println("FILAS AFECTADAS: " + result);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			cerrarConexion(c);
		}
	}

	@Override
	public void actualizar(ProductoDTO objeto) {
		// TODO Auto-generated method stub

	}

	@Override
	public void eliminar(Long id) {
		// TODO Auto-generated method stub

	}

}
