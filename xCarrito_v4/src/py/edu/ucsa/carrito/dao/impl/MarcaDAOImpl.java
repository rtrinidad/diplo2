package py.edu.ucsa.carrito.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import py.edu.ucsa.carrito.connectivity.ManejadorConexiones;
import py.edu.ucsa.carrito.dao.MarcaDAO;
import py.edu.ucsa.carrito.dto.MarcaDTO;

public class MarcaDAOImpl extends GenericDAOImpl implements MarcaDAO {

	@Override
	public List<MarcaDTO> listar() {
		List<MarcaDTO> resultado = new ArrayList<MarcaDTO>();
		Connection c = null;
		try {
			c = ManejadorConexiones.obtenerConexion("postgres");
			Statement stmt = c.createStatement();
			String query = "SELECT * FROM marcas";
			ResultSet rs = stmt.executeQuery(query);

			MarcaDTO marca = null;

			while (rs.next()) {
				marca = convertirDatosAMarca(rs);
				//AGREGAMOS EL OBJETO AL ARRAY
				resultado.add(marca);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			cerrarConexion(c);
		}
		return resultado;
	}

	private MarcaDTO convertirDatosAMarca(ResultSet rs) {
		MarcaDTO marca;
		marca = new MarcaDTO();
		try {
			marca.setId(rs.getInt("id"));
			marca.setCodigo(rs.getString("codigo"));
			marca.setDescripcion(rs.getString("descripcion"));
			marca.setFechaInsercion(rs.getDate("fecha_insercion"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return marca;
	}
	@Override
	public MarcaDTO getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertar(MarcaDTO objeto) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actualizar(MarcaDTO objeto) {
		// TODO Auto-generated method stub

	}

	@Override
	public void eliminar(Long id) {
		// TODO Auto-generated method stub

	}

}
