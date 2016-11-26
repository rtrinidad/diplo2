package py.edu.ucsa.lomitus.dao.imp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import py.edu.ucsa.lomitus.connectivity.ManejadorConexiones;
import py.edu.ucsa.lomitus.dao.ProductoDAO;
import py.edu.ucsa.lomitus.dto.ProductoDTO;

public class ProductoDAOImpl extends GenericDAOImpl implements ProductoDAO {

	@Override
	public List<ProductoDTO> listar() {
		List<ProductoDTO> resultado = new ArrayList<ProductoDTO>();
		Connection c = null;
		try {
			c = ManejadorConexiones.obtenerConexion("postgres");
			Statement stmt = c.createStatement();
			String query = "SELECT * FROM productos";
			ResultSet rs = stmt.executeQuery(query);

			ProductoDTO prod = null;

			while (rs.next()) {
				prod = convertirDatosAProducto(rs);
				//AGREGAMOS EL OBJETO AL ARRAY
				resultado.add(prod);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			cerrarConexion(c);
		}
		return resultado;
	}

	private ProductoDTO convertirDatosAProducto(ResultSet rs) {
		ProductoDTO producto;
		producto = new ProductoDTO();
		try {
			producto.setId(rs.getLong("id"));
			producto.setDescripcion(rs.getString("descripcion"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return producto;
	}

	@Override
	public ProductoDTO getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertar(ProductoDTO objeto) {
		// TODO Auto-generated method stub
		
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
