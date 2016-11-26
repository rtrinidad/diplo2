package py.edu.ucsa.lomitus.dao.imp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import py.edu.ucsa.lomitus.connectivity.ManejadorConexiones;
import py.edu.ucsa.lomitus.dao.ClienteDAO;
import py.edu.ucsa.lomitus.dto.ClienteDTO;

public class ClienteDAOImpl extends GenericDAOImpl implements ClienteDAO {

	@Override
	public List<ClienteDTO> listar() {
		List<ClienteDTO> resultado = new ArrayList<ClienteDTO>();
		Connection c = null;
		try {
			c = ManejadorConexiones.obtenerConexion("postgres");
			Statement stmt = c.createStatement();
			String query = "SELECT * FROM clientes";
			ResultSet rs = stmt.executeQuery(query);

			ClienteDTO cli = null;

			while (rs.next()) {
				cli = convertirDatosAProveedor(rs);
				//AGREGAMOS EL OBJETO AL ARRAY
				resultado.add(cli);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			cerrarConexion(c);
		}
		return resultado;
	}

	private ClienteDTO convertirDatosAProveedor(ResultSet rs) {
		ClienteDTO cliente;
		cliente = new ClienteDTO();
		try {
			cliente.setId(rs.getLong("id"));
			cliente.setNombre(rs.getString("nombre"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cliente;
	}

	@Override
	public ClienteDTO getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertar(ClienteDTO objeto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizar(ClienteDTO objeto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ClienteDTO getByCodigo(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
