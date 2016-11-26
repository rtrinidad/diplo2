package py.edu.ucsa.carrito.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import py.edu.ucsa.carrito.connectivity.ManejadorConexiones;
import py.edu.ucsa.carrito.dao.ProveedorDAO;
import py.edu.ucsa.carrito.dto.ProveedorDTO;

public class ProveedorDAOImpl extends GenericDAOImpl implements ProveedorDAO {

	@Override
	public List<ProveedorDTO> listar() {
		List<ProveedorDTO> resultado = new ArrayList<ProveedorDTO>();
		Connection c = null;
		try {
			c = ManejadorConexiones.obtenerConexion("postgres");
			Statement stmt = c.createStatement();
			String query = "SELECT * FROM proveedores";
			ResultSet rs = stmt.executeQuery(query);

			ProveedorDTO prov = null;

			while (rs.next()) {
				prov = convertirDatosAProveedor(rs);
				//AGREGAMOS EL OBJETO AL ARRAY
				resultado.add(prov);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			cerrarConexion(c);
		}
		return resultado;
	}

	private ProveedorDTO convertirDatosAProveedor(ResultSet rs) {
		ProveedorDTO proveedor;
		proveedor = new ProveedorDTO();
		try {
			proveedor.setId(rs.getLong("id"));
			proveedor.setCodigo(rs.getString("codigo"));
			proveedor.setRazonSocial(rs.getString("razon_social"));
			proveedor.setFechaInsercion(rs.getDate("fecha_insercion"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return proveedor;
	}

	@Override
	public ProveedorDTO getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertar(ProveedorDTO objeto) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actualizar(ProveedorDTO objeto) {
		// TODO Auto-generated method stub

	}

	@Override
	public void eliminar(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public ProveedorDTO getByCodigo(String codigo) {
		// TODO Auto-generated method stub
		return null;
	}

}
