package py.edu.ucsa.carrito.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import py.edu.ucsa.carrito.connectivity.ManejadorConexiones;
import py.edu.ucsa.carrito.dao.CategoriaDAO;
import py.edu.ucsa.carrito.dto.CategoriaDTO;
public class CategoriaDAOImpl extends GenericDAOImpl implements CategoriaDAO {

	@Override
	public List<CategoriaDTO> listar() {
		List<CategoriaDTO> resultado = new ArrayList<CategoriaDTO>();
		Connection c = null;
		try {
			c = ManejadorConexiones.obtenerConexion("postgres");
			Statement stmt = c.createStatement();
			String query = "SELECT * FROM categorias";
			ResultSet rs = stmt.executeQuery(query);

			CategoriaDTO categ = null;

			while (rs.next()) {
				categ = convertirDatosACategoria(rs);
				//AGREGAMOS EL OBJETO AL ARRAY
				resultado.add(categ);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			cerrarConexion(c);
		}
		return resultado;
	}

	private CategoriaDTO convertirDatosACategoria(ResultSet rs) {
		CategoriaDTO categoria;
		categoria = new CategoriaDTO();
		try {
			categoria.setId(rs.getInt("id"));
			categoria.setCodigo(rs.getString("codigo"));
			categoria.setDescripcion(rs.getString("descripcion"));
			categoria.setFechaInsercion(rs.getDate("fecha_insercion"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return categoria;
	}

	@Override
	public CategoriaDTO getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertar(CategoriaDTO objeto) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actualizar(CategoriaDTO objeto) {
		// TODO Auto-generated method stub

	}

	@Override
	public void eliminar(Long id) {
		// TODO Auto-generated method stub

	}

}
