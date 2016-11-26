package py.edu.ucsa.carrito.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class GenericDAOImpl {
	protected void cerrarConexion(Connection c) {
		try {
			if (c != null && !c.isClosed()){
				c.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
