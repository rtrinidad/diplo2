package py.edu.ucsa.lomitus.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import py.edu.ucsa.lomitus.connectivity.ManejadorConexiones;
import py.edu.ucsa.lomitus.dao.PedidoDAO;
import py.edu.ucsa.lomitus.dto.PedidoDTO;
import py.edu.ucsa.lomitus.util.DateUtil;

public class PedidoDAOImpl extends GenericDAOImpl implements PedidoDAO {

	@Override
	public List<PedidoDTO> listar() {
		List<PedidoDTO> resultado = new ArrayList<PedidoDTO>();
		Connection c = null;
		try {
			c = ManejadorConexiones.obtenerConexion("postgres");
			Statement stmt = c.createStatement();
			String query = "SELECT id, id_producto, id_cliente, cantidad, estado FROM pedidos";
			ResultSet rs = stmt.executeQuery(query);

			PedidoDTO ped = null;

			while (rs.next()) {
				ped = convertirDatosAPedido(rs);
				//IMPRIMOS EL OBJETO A SER AGREGADO EN EL ARRAY
				System.out.println("Pedido Id: " + ped.getId());
				System.out.println("Pedido Producto: " + ped.getProducto().getDescripcion());
				System.out.println("Pedido Cantidad: " + ped.getCantidad());
				System.out.println("Pedido Estado: " + ped.getEstado());
				System.out.println("Pedido Cliente: " + ped.getCliente().getNombre());
				
				// AGREGAMOS EL OBJETO AL ARRAY
				resultado.add(ped);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			cerrarConexion(c);
		}
		return resultado;
	}

	private PedidoDTO convertirDatosAPedido(ResultSet rs)
			throws SQLException {
		PedidoDTO ped;
		ped = new PedidoDTO();
		ped.setId(rs.getLong("id"));
		ped.setCantidad(rs.getInt("cantidad"));
		ped.setEstado(rs.getString("estado"));
		ped.setProducto(new ProductoDAOImpl().getById(rs.getLong("id_producto")));
		ped.setCliente(new ClienteDAOImpl().getById(rs.getLong("id_cliente")));
		return ped;
		
	}
	

	
	@Override
	public PedidoDTO getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertar(PedidoDTO ped) {
		Connection c = null;
		try {
			c = ManejadorConexiones.obtenerConexion("postgres");

			PreparedStatement s = c
					.prepareStatement("INSERT INTO pedidos(id_producto, id_cliente, cantidad, fecha_pedido) VALUES (?, ?, ?, ?)");
			s.setLong(1, ped.getProducto().getId());
			s.setLong(2, ped.getCliente().getId());
			s.setInt(3, ped.getCantidad());			
			s.setTimestamp(4, DateUtil.convertirUtilDateASQLTimestamp(new Date()));
			
			int result = s.executeUpdate();
			System.out.println("FILAS INSERTADAS: " + result);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			cerrarConexion(c);
		}
	}

	@Override
	public void actualizar(PedidoDTO ped) {
		
		Connection c = null;
		try {
			c = ManejadorConexiones.obtenerConexion("postgres");

			PreparedStatement s = c
					.prepareStatement("UPDATE pedidos SET estado = ? WHERE id = ?");
			s.setString(1, "ENTREGADO");
			s.setLong(2, ped.getId());
			
			int result = s.executeUpdate();
			System.out.println("FILAS ACTUALIZADAS: " + result);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			cerrarConexion(c);
		}

		
	}

	@Override
	public void eliminar(Long id) {
		// TODO Auto-generated method stub
		
	}



}
